package org.instantlogic.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpContentCompressor;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.File;

public class InstantlogicPipelineFactory extends ChannelInitializer<SocketChannel> {

	private final TravelersManagement travelersManagement;
	private final File staticRoot;
	
	public InstantlogicPipelineFactory(TravelersManagement travelersManagement, File staticRoot) {
		this.travelersManagement = travelersManagement;
		this.staticRoot = staticRoot;
	}


	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ch.pipeline().addLast("decoder", new HttpRequestDecoder());
		ch.pipeline().addLast("aggregator", new HttpObjectAggregator(1048576));
		ch.pipeline().addLast("encoder", new HttpResponseEncoder());
		ch.pipeline().addLast("deflater", new HttpContentCompressor());
		ch.pipeline().addLast("handler", new InstantlogicRequestHandler(travelersManagement, staticRoot));
	}
}
