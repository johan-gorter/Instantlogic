package org.instantlogic.netty;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.FORBIDDEN;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.netty.handler.codec.http.HttpResponseStatus.METHOD_NOT_ALLOWED;
import static io.netty.handler.codec.http.HttpResponseStatus.NOT_FOUND;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.activation.MimetypesFileTypeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple handler that serves incoming HTTP requests to send their respective
 * HTTP responses.
 * 
 * Largely copied from netty example
 */
public class HttpStaticFileServerHandler extends SimpleChannelInboundHandler<Object> {

	private static final Logger logger = LoggerFactory
			.getLogger(HttpStaticFileServerHandler.class);
	private static final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
	private File root;

	public HttpStaticFileServerHandler(File root) {
		this.root = root;
	}

	private boolean sendingError = false;

	@Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
        }
    }
	
	public void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request)
			throws Exception {
		if (!request.getDecoderResult().isSuccess()) {
			sendError(ctx, BAD_REQUEST);
			return;
		}
		if (request.getMethod() != GET) {
			if (request.getMethod() == POST) {
				handlePost(ctx, request);
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
					if (r == -1)
						break;
					out.write(bytes, 0, r);
				}
				out.close();
				is.close();
				FullHttpResponse response = new DefaultFullHttpResponse(
						HTTP_1_1, HttpResponseStatus.OK,
						Unpooled.copiedBuffer(out.toByteArray()));
				response.headers().add(HttpHeaders.Names.CONTENT_TYPE,
						contentType);
				ctx.writeAndFlush(response).addListener(
						ChannelFutureListener.CLOSE);
				// Decide whether to close the connection or not.
				if (!isKeepAlive(request)) {
					// Close the connection when the whole content is written
					// out.
					response.headers().set(HttpHeaders.Names.CONNECTION,
							HttpHeaders.Values.KEEP_ALIVE);
				}

			} catch (IOException ex) {
				sendError(ctx, INTERNAL_SERVER_ERROR);
				return;
			}
		} else {
			String path = (root.getAbsolutePath() + uri).replace('/', File.separatorChar);

			File file = new File(path);
			if (file.isHidden() || !file.exists()) {
				sendError(ctx, NOT_FOUND);
				return;
			}
			if (!file.isFile()) {
				sendError(ctx, FORBIDDEN);
				return;
			}
			int fileLength = (int)file.length();
			byte[] bytes;
			try (FileInputStream in = new FileInputStream(file)) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				bytes = new byte[(int)file.length()];
				while (true) {
					int r = in.read(bytes);
					if (r == -1)
						break;
					out.write(bytes, 0, r);
				}
				out.close();
				in.close();
				bytes = out.toByteArray();
			}

			HttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.copiedBuffer(bytes));
			response.headers().add(CONTENT_TYPE, contentType + "; charset=UTF-8");
			setContentLength(response, fileLength);

			// Write the initial line and the header.
			ctx.writeAndFlush(response);

			if (!isKeepAlive(request)) {
				// Close the connection when the whole content is written out.
				response.headers().set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
			}
		}
		ChannelFuture lastContentFuture = ctx
				.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
	}

	protected void handlePost(ChannelHandlerContext ctx, FullHttpRequest request)
			throws Exception {
		sendError(ctx, METHOD_NOT_ALLOWED);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		logger.error("Exception caught", cause);
		if (sendingError || cause instanceof IOException)
			return;

		if (cause instanceof TooLongFrameException) {
			sendError(ctx, BAD_REQUEST);
			return;
		}

		if (ctx.channel().isActive()) {
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
		if (index >= 0) {
			uri = uri.substring(0, index);
		}

		// Simplistic dumb security check.
		// You will have to do something serious in the production environment.
		if (uri.contains("\\") || uri.contains("/.") || uri.contains("./")
				|| uri.startsWith(".") || uri.endsWith(".")) {
			return null;
		}
		return uri;
	}

	private static void sendError(ChannelHandlerContext ctx,
			HttpResponseStatus status) {
		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
				status, Unpooled.copiedBuffer("Failure: " + status + "\r\n",
						CharsetUtil.UTF_8));
		response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");

		// Close the connection as soon as the error message is sent.
		ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
	}
}
