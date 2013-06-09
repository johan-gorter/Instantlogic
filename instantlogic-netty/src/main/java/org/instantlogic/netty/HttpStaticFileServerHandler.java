

package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static org.jboss.netty.handler.codec.http.HttpHeaders.setContentLength;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpMethod.GET;
import static org.jboss.netty.handler.codec.http.HttpMethod.POST;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.activation.MimetypesFileTypeMap;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelFutureProgressListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.DefaultFileRegion;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.FileRegion;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.codec.frame.TooLongFrameException;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.ssl.SslHandler;
import org.jboss.netty.handler.stream.ChunkedFile;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple handler that serves incoming HTTP requests to send their respective
 * HTTP responses.
 * 
 * Largely copied from netty example
 */
public class HttpStaticFileServerHandler extends SimpleChannelUpstreamHandler {

	private static final Logger logger = LoggerFactory.getLogger(HttpStaticFileServerHandler.class);
    private static final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
	
	private boolean sendingError = false;
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		HttpRequest request = (HttpRequest) e.getMessage();
		if (request.getMethod() != GET) {
			if (request.getMethod() == POST) {
				handlePost(ctx, e, request);
				return;
			}
			sendError(ctx, METHOD_NOT_ALLOWED);
			return;
		}

		ChannelFuture writeFuture;
		String uri = sanitizeUri(request.getUri());
		if (uri == null) {
			sendError(ctx, FORBIDDEN);
			return;
		}
        String contentType = fileTypeMap.getContentType(uri);
		if (uri.startsWith("/webjars")) {
	        InputStream is;
	        try {
	            is = this.getClass().getResourceAsStream("/META-INF/resources" + uri);
	            if (is == null) {
	    			sendError(ctx, NOT_FOUND);
	    			return;
	            }
	            final int maxSize = 512 * 1024;
	            ByteArrayOutputStream out = new ByteArrayOutputStream(maxSize);
	            byte[] bytes = new byte[maxSize];
	            while (true) {
	                int r = is.read(bytes);
	                if (r == -1) break;
	                out.write(bytes, 0, r);
	            }
	            ChannelBuffer cb = ChannelBuffers.copiedBuffer(out.toByteArray());
	            out.close();
	            is.close();

	            DefaultHttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
	            response.setHeader(HttpHeaders.Names.CONTENT_TYPE, contentType);
	            setContentLength(response, cb.readableBytes());

	            response.setContent(cb);
	            writeFuture = e.getChannel().write(response);
	        } catch (IOException ex) {
				sendError(ctx, INTERNAL_SERVER_ERROR);
				return;
	        }
		} else {
			String path = new File(".").getAbsolutePath() + ("/src/main/webroot/" + uri).replace('/', File.separatorChar);
			
			File file = new File(path);
			if (file.isHidden() || !file.exists()) {
				sendError(ctx, NOT_FOUND);
				return;
			}
			if (!file.isFile()) {
				sendError(ctx, FORBIDDEN);
				return;
			}
			RandomAccessFile raf;
			try {
				raf = new RandomAccessFile(file, "r");
			} catch (FileNotFoundException fnfe) {
				sendError(ctx, NOT_FOUND);
				return;
			}
			long fileLength = raf.length();
	
			HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
			response.setHeader(CONTENT_TYPE, contentType+"; charset=UTF-8");
			setContentLength(response, fileLength);
			Channel ch = e.getChannel();
	
			// Write the initial line and the header.
			ch.write(response);
	
			// Write the content.
			if (ch.getPipeline().get(SslHandler.class) != null) {
				// Cannot use zero-copy with HTTPS.
				writeFuture = ch.write(new ChunkedFile(raf, 0, fileLength, 8192));
			} else {
				// No encryption - use zero-copy.
				final FileRegion region = new DefaultFileRegion(raf.getChannel(), 0, fileLength);
				writeFuture = ch.write(region);
				writeFuture.addListener(new ChannelFutureProgressListener() {
					public void operationComplete(ChannelFuture future) {
						region.releaseExternalResources();
					}
	
					public void operationProgressed(ChannelFuture future, long amount, long current, long total) {
						//System.out.printf("%s: %d / %d (+%d)%n", path, current, total, amount);
					}
				});
			}
		}

		// Decide whether to close the connection or not.
		if (!isKeepAlive(request)) {
			// Close the connection when the whole content is written out.
			writeFuture.addListener(ChannelFutureListener.CLOSE);
		}
	}

	protected void handlePost(ChannelHandlerContext ctx, MessageEvent e, HttpRequest request) throws Exception {
		sendError(ctx, METHOD_NOT_ALLOWED);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		Channel ch = e.getChannel();
		Throwable cause = e.getCause();
		logger.error("Exception caught", cause);
		if (sendingError || e.getCause() instanceof IOException) return;

		if (cause instanceof TooLongFrameException) {
			sendError(ctx, BAD_REQUEST);
			return;
		}

		if (ch.isOpen()) {
			sendError(ctx, INTERNAL_SERVER_ERROR);
		}
	}

	private String sanitizeUri(String uri) {
		// Decode the path.
		try {
			uri = URLDecoder.decode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new Error();
		}

		int index = uri.indexOf('?');
		if (index>=0) {
			uri = uri.substring(0, index);
		}

		// Simplistic dumb security check.
		// You will have to do something serious in the production environment.
		if (uri.contains("\\") || uri.contains("/.") || uri.contains("./") || uri.startsWith(".") || uri.endsWith(".")) {
			return null;
		}
		return uri;
	}

	protected void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
		sendingError = true;
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);
		response.setHeader(CONTENT_TYPE, "text/plain; charset=UTF-8");
		response.setContent(ChannelBuffers.copiedBuffer("Failure: " + status.toString() + "\r\n", CharsetUtil.UTF_8));

		// Close the connection as soon as the error message is sent.
		ctx.getChannel().write(response).addListener(ChannelFutureListener.CLOSE);
	}
}
