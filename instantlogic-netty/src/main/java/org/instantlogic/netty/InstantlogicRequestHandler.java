package org.instantlogic.netty;

import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.CharsetUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantlogicRequestHandler extends HttpStaticFileServerHandler implements ChannelHandler {

	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);
	
	private final TravelersManagement travelersManagement;
	
	public InstantlogicRequestHandler(TravelersManagement travelersManagement, File staticRoot) {
		super(staticRoot);
		this.travelersManagement = travelersManagement;
	}

	@Override
	protected void handlePost(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
		if (HttpHeaders.is100ContinueExpected(request)) {
			send100Continue(ctx);
		}
		
		QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
		Map<String, List<String>> params = queryStringDecoder.parameters();
		
		List<String> travelerIds = params.get("travelerId");
		if (travelerIds==null || travelerIds.size()!=1) {
			throw new Exception("No travelerId queryString parameter");
		}
		String travelerId = travelerIds.get(0);
		
		List<String> applications = params.get("application");
		if (applications==null || applications.size()!=1) {
			throw new Exception("No application queryString parameter");
		}
		String applicationName = applications.get(0).toLowerCase();

		List<String> cases = params.get("case");
		if (cases==null || cases.size()!=1) {
			throw new Exception("No case queryString parameter");
		}
		String caseId = cases.get(0).toLowerCase();
		
		NettyTraveler nettyTraveler = travelersManagement.getOrCreate(travelerId, applicationName, caseId);
		
		nettyTraveler.verifyIncomingAuthentication(request);

		logger.debug("Incoming request from traveler {}-{} for application {}, case {}", new Object[]{ nettyTraveler.getTravelerInfo().getAuthenticatedUsername(), travelerId, applicationName, caseId});
		
		ByteBuf content = request.content();
		if (content.isReadable()) {
			nettyTraveler.handleIncomingMessages(content.toString(CharsetUtil.UTF_8));
		}
		
		nettyTraveler.parkRequest(ctx, request);
	}

	private void send100Continue(ChannelHandlerContext ctx) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
		ctx.writeAndFlush(response);
	}

	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
