package org.instantlogic.engine.agent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.engine.message.LeaveMessage;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.interaction.util.TravelerInfo;

public class Agent implements TravelerProxy {

	public class AgentState {
		
		public final Update place;
		public final Update presence;

		public AgentState(Update lastPlace, Update lastPresence) {
			this.place = lastPlace;
			this.presence = lastPresence;
		}
		
		public boolean isInitialized() {
			return place!=null && presence!=null;
		}
		
		public boolean isInError() {
			return place.getExceptionMessage()!=null && !"error".equals(place.getRootFragment().get("pageType"));
		}
	};
	
	private final TravelerInfo travelerInfo;
	
	private volatile Update lastPlace;
	private volatile Update lastPresence;

	private CaseProcessor caseProcessor;
	
	public Agent(TravelerInfo travelerInfo) {
		this.travelerInfo = travelerInfo;
	}
	
	public void start(CaseProcessor caseProcessor) {
		this.caseProcessor = caseProcessor;
		caseProcessor.processMessagesAndSendUpdates(this, Collections.singletonList((Message)new StartMessage(null)));
	}
	
	public void exit() {
		sendMessages(new LeaveMessage());
		lastPlace = null;
		lastPresence = null;
	}
	
	public AgentState readState() {
		return new AgentState(lastPlace, lastPresence);
	}
	
	public void sendMessages(Message... messages) {
		caseProcessor.processMessagesAndSendUpdates(this, Arrays.asList(messages));
	}

	@Override
	public TravelerInfo getTravelerInfo() {
		return travelerInfo;
	}

	@Override
	public synchronized void sendUpdates(List<Update> messages) {
		for (Update update : messages) {
			if ("place".equals(update.getName())) {
				lastPlace = update;
			} else if ("presence".equals(update.getName())) {
				lastPresence = update;
			}
		}
	}
}
