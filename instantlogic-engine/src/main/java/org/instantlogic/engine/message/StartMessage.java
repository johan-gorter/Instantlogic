package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(StartMessage.class);
	private final String location;
	
	public StartMessage(String location) {
		this.location= location;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		FlowEventOccurrence eventOccurrence;
		FlowContext flowContext = FlowContext.create(application, location, theCase, presence.getCaseName(), traveler.getTravelerInfo());
		if (location!=null) {
			logger.info("Traveler {}-{} starting at {}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId(), location});
			eventOccurrence = flowContext.getPage().enter(flowContext);		
		} else {
			logger.info("Traveler {}-{} starting", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
			if (application.getStartPlace()!=null) {
				eventOccurrence = new FlowEventOccurrence(application.getStartPlace());
			} else {
				throw new RuntimeException("No start place was defined");
			}
		}
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getPresence().enter(traveler, flowContext.toPath());
	}

	@Override
	public String toString() {
		return "StartMessage [location=" + location + "]";
	}
}
