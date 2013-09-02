package org.instantlogic.engine.agent;

import java.util.List;
import java.util.Map;

import org.instantlogic.engine.message.ChangeMessage;
import org.instantlogic.engine.message.PresenceMessage;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.message.SubmitMessage;
import org.instantlogic.engine.util.FragmentQuery;
import org.instantlogic.engine.util.FragmentQuery.Selector;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

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
				} else if (nextElement==null) {
					nextElement = element; // set nextElement to the first element
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
		if (element!=null) {
			focussedElementId = (String) element.get("id");
			return new PresenceMessage("setFocus", null, element.get("id"));
		} else {
			// Do not focus anything (when the last element was reached for example)
			focussedElementId = null;
			return new PresenceMessage("setFocus", null, null);
		}
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
			String text = ((String)element.get("text"));
			if (text!=null && text.toLowerCase().contains("delete") && Math.random()<0.8) {
				setFocus(nextElement);
				return; // Rethink before doing a delete
			}
			sendMessages(new SubmitMessage((String) element.get("id")));
		}
	}

	@SuppressWarnings("rawtypes")
	protected JsonElement provideValue(Map<String, Object> focussedElement) {
		Object[] options = (Object[]) focussedElement.get("options");
		if (options!=null) {
			int index = (int)(Math.random()*options.length);
			Map option = (Map) options[index];
			return new JsonPrimitive((String)option.get("id"));
		}
		Map dataType = (Map)focussedElement.get("dataType");
		if (dataType!=null) {
			String category = (String)dataType.get("category");
			if (category!=null) {
				switch (category) {
				case "text" :
					boolean multiLine = (Boolean.TRUE == dataType.get("multiLine"));
					String currentValue = (String)focussedElement.get("value");
					return new JsonPrimitive(provideText(multiLine, currentValue));
				}
			}
		}
		// TODO: number etc...
		return null;
	}

	protected String provideText(boolean multiLine, String currentValue) {
		return "X";
	}
}
