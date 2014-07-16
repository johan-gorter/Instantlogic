package org.instantlogic.netty;

import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import io.netty.util.CharsetUtil;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantlogicRequestHandler extends HttpStaticFileServerHandler implements ChannelHandler {

  private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);

  private final TravelersManagement travelersManagement;

  private WebSocketServerHandshaker handshaker;
  private NettyTraveler nettyTraveler;

  public InstantlogicRequestHandler(TravelersManagement travelersManagement, File staticRoot) {
    super(staticRoot);
    this.travelersManagement = travelersManagement;
  }

  @Override
  public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
    if (msg instanceof FullHttpRequest) {
      handleHttpRequest(ctx, (FullHttpRequest) msg);
    } else if (msg instanceof WebSocketFrame) {
      handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }
  }

  private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
    // Check for closing frame
    if (frame instanceof CloseWebSocketFrame) {
      handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
      return;
    }
    if (frame instanceof PingWebSocketFrame) {
      ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
      return;
    }
    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
    }

    // Send the uppercase string back.
    String request = ((TextWebSocketFrame) frame).text();
    nettyTraveler.registerWebsocket(ctx);
    nettyTraveler.handleIncomingMessages(request);
  }

  @Override
  public void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
    if ("/api".equals(request.getUri().substring(0, 4))) {

      getOrCreateTraveler(request);

      // Handshake
      WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
              getWebSocketLocation(request), null, false);
      handshaker = wsFactory.newHandshaker(request);
      if (handshaker == null) {
        WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
      } else {
        handshaker.handshake(ctx.channel(), request);
      }
    } else {
      super.handleHttpRequest(ctx, request);
    }
  }

  private static String getWebSocketLocation(FullHttpRequest req) {
    String location = req.headers().get(HttpHeaders.Names.HOST) + "/api";
    return "ws://" + location;
  }

  private void getOrCreateTraveler(FullHttpRequest request) throws Exception {
    QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
    Map<String, List<String>> params = queryStringDecoder.parameters();

    List<String> travelerIds = params.get("travelerId");
    if (travelerIds == null || travelerIds.size() != 1) {
      throw new Exception("No travelerId queryString parameter");
    }
    String travelerId = travelerIds.get(0);

    List<String> applications = params.get("application");
    if (applications == null || applications.size() != 1) {
      throw new Exception("No application queryString parameter");
    }
    String applicationName = applications.get(0).toLowerCase();

    List<String> cases = params.get("case");
    if (cases == null || cases.size() != 1) {
      throw new Exception("No case queryString parameter");
    }
    String caseId = cases.get(0).toLowerCase();

    nettyTraveler = travelersManagement.getOrCreate(travelerId, applicationName, caseId);

    nettyTraveler.verifyIncomingAuthentication(request);

    logger.debug("Incoming request from traveler {}-{} for application {}, case {}", new Object[]{
      nettyTraveler.getTravelerInfo().getAuthenticatedUsername(), travelerId, applicationName, caseId});
  }

  @Override
  protected void handlePost(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
    if (HttpHeaders.is100ContinueExpected(request)) {
      send100Continue(ctx);
    }

    getOrCreateTraveler(request);

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
}
