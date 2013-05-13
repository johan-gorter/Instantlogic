package org.instantlogic.netty;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.EngineManager;
import org.instantlogic.engine.manager.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

public class TravelersManagement {

	private static final Logger logger = LoggerFactory.getLogger(NettyTraveler.class);

	private final EngineManager engineManager;

	public TravelersManagement(EngineManager engineManager) {
		this.engineManager = engineManager;
	}

	private final Map<String, NettyTraveler> nettyTravelers = new ConcurrentHashMap<String, NettyTraveler>();

	public void broadcast(Update message) {
		logger.info("broadcasting to all {} travelers", nettyTravelers.size());
		for (NettyTraveler nettyTraveler : nettyTravelers.values()) {
			nettyTraveler.sendMessage(message);
		}
	}
	
	public synchronized NettyTraveler getOrCreate(String travelerId, String applicationName, String caseId) {
		NettyTraveler result = nettyTravelers.get(travelerId);
		if (result==null) {
			logger.info("Registering new traveler {}", travelerId);
			CaseProcessor caseProcessor = engineManager.getCaseProcessor(applicationName, caseId);
			result = new NettyTraveler(travelerId, caseProcessor, this);
			nettyTravelers.put(travelerId, result);
		}
		return result;
	}
	
	public void sweep() {
		for(NettyTraveler nettyTraveler : nettyTravelers.values()) {
			nettyTraveler.check();
		}
	}

	public void removeTraveler(String travelerId) {
		nettyTravelers.remove(travelerId);
	}
}
