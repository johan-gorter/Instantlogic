package org.instantlogic.netty;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.Cookie;
import io.netty.handler.codec.http.CookieDecoder;
import io.netty.handler.codec.http.DefaultCookie;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.ServerCookieEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.engine.message.ChangeMessage;
import org.instantlogic.engine.message.LeaveMessage;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.message.PresenceMessage;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.message.StopMessage;
import org.instantlogic.engine.message.SubmitMessage;
import org.instantlogic.engine.message.SubscribeMessage;
import org.instantlogic.engine.message.UnsubscribeMessage;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * A traveler usually has one open parked request. When another comes in, the first one is released.
 */
public class NettyTraveler implements TravelerProxy {

  static class ParkedEntry {

    ChannelHandlerContext ctx;
    FullHttpRequest request;

    public ParkedEntry(ChannelHandlerContext ctx, FullHttpRequest request) {
      this.ctx = ctx;
      this.request = request;
    }
  }

  enum State {

    ACTIVE, MAY_BE_OBANDONED, REMOVED
  }

  private static final Logger logger = LoggerFactory.getLogger(NettyTraveler.class);

  public static final Gson gson = new GsonBuilder()
          .setPrettyPrinting()
          .registerTypeHierarchyAdapter(Values.class, new org.instantlogic.engine.util.ValuesAdapter())
          .create();

  private final TravelerInfo travelerInfo;
  private final CaseProcessor caseProcessor;
  private final TravelersManagement travelersManagement;

  private List<ParkedEntry> parkedRequests = new ArrayList<ParkedEntry>();
  private List<Update> updatesWaiting = new ArrayList<Update>();
  private State state = State.ACTIVE;

  private ChannelHandlerContext websocket = null;

  private ChannelFutureListener channelClosed = new ChannelFutureListener() {
    @Override
    public void operationComplete(ChannelFuture future) throws Exception {
      removeParkedRequestForChannel(future.channel());
    }
  };

  NettyTraveler(String travelerId, CaseProcessor caseProcessor, TravelersManagement travelersManagement) {
    travelerInfo = new TravelerInfo(travelerId);
    this.caseProcessor = caseProcessor;
    this.travelersManagement = travelersManagement;
  }

  /**
   * Sends a message to this traveler
   *
   * @param update the message to send
   */
  public synchronized void sendMessage(Update update) {
    updatesWaiting.add(update);
    deliverMessagesIfPossible();
  }

  public synchronized void check() {
    if (state == State.MAY_BE_OBANDONED) {
      state = State.REMOVED;
      logger.info("Removing traveler {}", travelerInfo.getTravelerId());
      travelersManagement.removeTraveler(travelerInfo.getTravelerId());
      this.caseProcessor.processMessagesAndSendUpdates(this, Collections.singletonList((Message) new LeaveMessage()));
    }
    if (state == State.ACTIVE && parkedRequests.size() == 0 && websocket == null) {
      state = State.MAY_BE_OBANDONED;
    }
  }

  public synchronized void handleIncomingMessages(String messagesText) {
    JsonArray jsonMessages = (JsonArray) new JsonParser().parse(messagesText);
    List<Message> messages = new ArrayList<Message>(jsonMessages.size());
    for (JsonElement message : jsonMessages) {
      String messageName = message.getAsJsonObject().get("message").getAsString();
      logger.debug("Handling {} message from traveler {}-{}", new Object[]{messageName, travelerInfo.getAuthenticatedUsername(), travelerInfo.getTravelerId()});
      if ("change".equals(messageName)) {
        String placeElementId = message.getAsJsonObject().get("id").getAsString();
        JsonElement value = null;
        if (message.getAsJsonObject().has("value")) {
          value = message.getAsJsonObject().get("value");
        }
        messages.add(new ChangeMessage(placeElementId, value));
      } else if ("submit".equals(messageName)) {
        String placeElementId = message.getAsJsonObject().get("id").getAsString();
        messages.add(new SubmitMessage(placeElementId));
      } else if ("stop".equals(messageName)) {
        messages.add(new StopMessage());
      } else if ("start".equals(messageName)) {
        String location = null;
        JsonElement locationElement = message.getAsJsonObject().get("location");
        if (locationElement != null && !locationElement.isJsonNull()) {
          location = locationElement.getAsString();
        }
        messages.add(new StartMessage(location));
      } else if ("leave".equals(messageName)) {
        messages.add(new LeaveMessage());
      } else if ("subscribe".equals(messageName)) {
        JsonElement location = message.getAsJsonObject().get("location");
        messages.add(new SubscribeMessage(location.getAsString()));
      } else if ("unsubscribe".equals(messageName)) {
        JsonElement location = message.getAsJsonObject().get("location");
        messages.add(new UnsubscribeMessage(location.getAsString()));
      } else if ("presence".equals(messageName)) {
        String command = message.getAsJsonObject().get("command").getAsString();
        String id = null;
        Object value = null;
        if (message.getAsJsonObject().has("id")) {
          id = message.getAsJsonObject().get("id").getAsString();
        }
        if (message.getAsJsonObject().has("value")) {
          value = getPrimitiveValue(message.getAsJsonObject().get("value").getAsJsonPrimitive());
        }
        messages.add(new PresenceMessage(command, id, value));
      }
    }
    this.caseProcessor.processMessagesAndSendUpdates(this, messages); // Will also queue updates
  }

  private Object getPrimitiveValue(JsonPrimitive jsonPrimitive) {
    if (jsonPrimitive.isBoolean()) {
      return jsonPrimitive.getAsBoolean();
    }
    if (jsonPrimitive.isNumber()) {
      return jsonPrimitive.getAsNumber();
    }
    return jsonPrimitive.getAsString();
  }

  public synchronized void registerWebsocket(ChannelHandlerContext ctx) {
    websocket = ctx;
  }

  public synchronized void parkRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
    if (state == State.REMOVED) {
      logger.error("Rare race condition");
      throw new RuntimeException("This traveler was removed");
    }
    state = State.ACTIVE;
    ctx.channel().closeFuture().addListener(channelClosed);
    parkedRequests.add(new ParkedEntry(ctx, request));
    if (parkedRequests.size() > 1 || updatesWaiting.size() > 0) {
      sendResponseMessages(parkedRequests.remove(0));
    }
  }

  private void deliverMessagesIfPossible() {
    if (parkedRequests.size() > 0) {
      sendResponseMessages(parkedRequests.remove(0));
    } else if (websocket != null) {
      String message = gson.toJson(updatesWaiting);
      websocket.channel().writeAndFlush(new TextWebSocketFrame(message));
      updatesWaiting = new ArrayList<Update>();
    }
  }

  /**
   * The parked request is returned carrying the messages waiting.
   *
   * @param event
   */
  private void sendResponseMessages(ParkedEntry entry) {
    boolean keepAlive = isKeepAlive(entry.request);

    // Build the response object.
    DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.copiedBuffer(gson.toJson(updatesWaiting), CharsetUtil.UTF_8));
    logger.debug("Sending {} messages to traveler {}", updatesWaiting.size(), travelerInfo.getTravelerId());

    updatesWaiting = new ArrayList<Update>();

    response.headers().add(CONTENT_TYPE, "text/plain; charset=UTF-8");
    handleOutgoingAuthentication(entry.request, response, travelerInfo.getAuthenticatedUsername());
    if (keepAlive) {
      // Add 'Content-Length' header only for a keep-alive connection.
      response.headers().add(CONTENT_LENGTH, response.content().readableBytes());
    }

    // Write the response.
    ChannelFuture future = entry.ctx.channel().writeAndFlush(response);

    // Close the non-keep-alive connection after the write operation is done.
    if (!keepAlive) {
      future.addListener(ChannelFutureListener.CLOSE);
    }
  }

  synchronized void removeParkedRequestForChannel(Channel channel) {
    for (int i = 0; i < parkedRequests.size(); i++) {
      if (parkedRequests.get(i).ctx.channel() == channel) {
        parkedRequests.remove(i);
        logger.debug("A channel for traveler {} was closed by the client", travelerInfo.getTravelerId());
        return;
      }
    }
  }

  @Override
  public String toString() {
    return "Traveler " + travelerInfo.getTravelerId();
  }

  @Override
  public TravelerInfo getTravelerInfo() {
    return travelerInfo;
  }

  @Override
  public synchronized void sendUpdates(List<Update> newUpdates) {
    // Remove old updates with the same name
    Iterator<Update> updatesWaitingIterator = updatesWaiting.iterator();
    while (updatesWaitingIterator.hasNext()) {
      Update update = updatesWaitingIterator.next();
      for (Update newUpdate : newUpdates) {
        if (update.getName().equals(newUpdate.getName())) {
          updatesWaitingIterator.remove();
        }
      }
    }
    for (Update update : newUpdates) {
      this.updatesWaiting.add(update);
    }
    deliverMessagesIfPossible();
  }

  public void verifyIncomingAuthentication(HttpRequest request) {
    String username = readAuthentication(request);
    if (username == null) {
      if (travelerInfo.getAuthenticatedUsername() != null) {
        throw new RuntimeException("AuthenticatedUsername disappeared");
      }
    } else {
      if (travelerInfo.getAuthenticatedUsername() == null) {
        travelerInfo.setAuthenticatedUsername(username);
      } else if (username.equals(travelerInfo.getAuthenticatedUsername())) {
        return;
      } else {
        throw new RuntimeException("Traveler switched authenticatedUsername");
      }
    }
  }

  // This is obviously only intended to be used in demonstrations, there is no real security!
  private void handleOutgoingAuthentication(HttpRequest request, HttpResponse response, String authenticatedUsername) {
    if (authenticatedUsername != null && !authenticatedUsername.equals(readAuthentication(request))) {
      DefaultCookie cookie = new DefaultCookie("who-am-i", travelerInfo.getAuthenticatedUsername());
      cookie.setHttpOnly(true);
      cookie.setMaxAge(60 * 60 * 24 * 365);
      response.headers().add("Set-Cookie", ServerCookieEncoder.encode(cookie));
    } else if (authenticatedUsername == null && readAuthentication(request) != null) {
      DefaultCookie cookie = new DefaultCookie("who-am-i", "deleteme");
      cookie.setHttpOnly(true);
      cookie.setMaxAge(0);
      response.headers().add("Set-Cookie", ServerCookieEncoder.encode(cookie));
    }
  }

  private String readAuthentication(HttpRequest request) {
    String requestCookie = request.headers().get("Cookie");
    if (requestCookie == null) {
      return null;
    }
    Set<Cookie> cookies = CookieDecoder.decode(requestCookie);
    for (Cookie cookie : cookies) {
      if ("who-am-i".equals(cookie.getName())) {
        return cookie.getValue();
      }
    }
    return null;
  }
}
