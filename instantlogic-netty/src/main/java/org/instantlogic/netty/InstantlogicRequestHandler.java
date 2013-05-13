/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.List;
import java.util.Map;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantlogicRequestHandler extends HttpStaticFileServerHandler implements ChannelHandler {

	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);
	
	private final TravelersManagement travelersManagement;
	
	public InstantlogicRequestHandler(TravelersManagement travelersManagement) {
		this.travelersManagement = travelersManagement;
	}

	@Override
	protected void handlePost(ChannelHandlerContext ctx, MessageEvent e, HttpRequest request) throws Exception {
		if (HttpHeaders.is100ContinueExpected(request)) {
			send100Continue(e);
		}
		
		QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
		Map<String, List<String>> params = queryStringDecoder.getParameters();
		
		List<String> travelerIds = params.get("travelerId");
		if (travelerIds==null || travelerIds.size()!=1) {
			throw new Exception("No travelerId queryString parameter");
		}
		String travelerId = travelerIds.get(0);
		
		List<String> applications = params.get("application");
		if (applications==null || applications.size()!=1) {
			throw new Exception("No application queryString parameter");
		}
		String applicationName = applications.get(0);

		List<String> cases = params.get("case");
		if (cases==null || cases.size()!=1) {
			throw new Exception("No case queryString parameter");
		}
		String caseId = cases.get(0);
		
		NettyTraveler nettyTraveler = travelersManagement.getOrCreate(travelerId, applicationName, caseId);
		
		nettyTraveler.verifyIncomingAuthentication(request);

		logger.debug("Incoming request from traveler {}-{} for application {}, case {}", new Object[]{ nettyTraveler.getTravelerInfo().getAuthenticatedUsername(), travelerId, applicationName, caseId});
		
		ChannelBuffer content = request.getContent();
		if (content.readable()) {
			nettyTraveler.handleIncomingMessages(content.toString(CharsetUtil.UTF_8));
		}
		
		nettyTraveler.parkRequest(e);
	}

	private void send100Continue(MessageEvent e) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
		e.getChannel().write(response);
	}
}
