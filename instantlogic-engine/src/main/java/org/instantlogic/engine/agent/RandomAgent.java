package org.instantlogic.engine.agent;

import java.util.List;
import java.util.Map;

import org.instantlogic.engine.message.ChangeMessage;
import org.instantlogic.engine.message.LeaveMessage;
import org.instantlogic.engine.message.PresenceMessage;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.message.SubmitMessage;
import org.instantlogic.engine.util.FragmentQuery;
import org.instantlogic.engine.util.FragmentQuery.Selector;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomAgent extends Agent {

	private static final Logger logger = LoggerFactory.getLogger(RandomAgent.class);
	private static final Selector INTERACTIVE_ELEMENTS = new Selector() {
		
		@Override
		public boolean matches(Map<String, Object> fragment) {
			String type = (String)fragment.get("type");
			return type=="Link" || type=="Button" || type=="Input";
		}
	};
	
	protected String focussedElementId;

	public RandomAgent(String username) {
		this(username, username+"1");
	}

	public RandomAgent(String username, String travelerId) {
		super(new TravelerInfo(travelerId, username));
	}
	
	public void step() {
		AgentState state = readState();
		if (!state.isInitialized()) return;
		if (state.isInError()) {
			logger.info("Agent in error");
			sendMessages(new StartMessage(null,  null)); // Start over
			return;
		}
		List<Map<String, Object>> interactiveElements = FragmentQuery.findAll(state.place.getRootFragment(), INTERACTIVE_ELEMENTS);
		if (interactiveElements.size()==0) {
			logger.info("Agent stuck");
			sendMessages(new StartMessage(null,  null)); // Start over
			return;
		}
		Map<String, Object> focussedElement = null;
		Map<String, Object> nextElement = null;
		if (focussedElementId!=null) {
			for (Map<String, Object> element : interactiveElements) {
				if (focussedElement!=null) {
					nextElement = element;
					break;
				}
				if (focussedElementId.equals(element.get("id"))) {
					focussedElement = element;
				}
			}
		}
		if (focussedElement==null) {
			focussedElementId = null;
		}
		doRandomAction(interactiveElements, focussedElement, nextElement);
	}
	
	protected PresenceMessage setFocus(Map<String, Object> element) {
		focussedElementId = (String) element.get("id");
		return new PresenceMessage("setFocus", null, element.get("id"));
	}
	

	protected void doRandomAction(List<Map<String, Object>> interactiveElements, Map<String, Object> focussedElement, Map<String, Object> nextElement) {
		if (focussedElement!=null) {
			if (Math.random()<0.75) {
				sendMessages(
					new ChangeMessage((String)focussedElement.get("id"), provideValue(focussedElement)), 
					setFocus(nextElement)
				);
				return;
			} else if (Math.random()<0.8) {
				sendMessages(setFocus(nextElement));
				return;
			}
		}
		Map<String, Object> element = interactiveElements.get((int)Math.floor(Math.random()*interactiveElements.size()));
		if ("Input".equals(element.get("type"))) {
			setFocus(element);
		} else {
			sendMessages(new SubmitMessage((String) element.get("id")));
		}
	}

	protected Object provideValue(Map<String, Object> focussedElement) {
		return "1";
	}
}
