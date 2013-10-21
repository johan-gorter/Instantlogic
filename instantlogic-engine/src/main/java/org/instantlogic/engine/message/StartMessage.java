package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(StartMessage.class);
	private final String location;
	private final String event;
	
	public StartMessage(String location, String event) {
		this.location= location;
		this.event = event;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		FlowEventOccurrence eventOccurrence;
		FlowContext flowContext = FlowContext.create(application.getMainFlow(), location, theCase, presence.getCaseName(), traveler.getTravelerInfo());
		if (event!=null) {
			String[] components = event.split("/");
			Instance[] instances = new Instance[components.length-1];
			for (int i=1;i<components.length;i++) {
				instances[i-1] = theCase.getMetadata().getCaseAdministration().getInstanceByUniqueId(components[i]);
			}
			FlowEvent event = flowContext.getFlowStack().findEvent(components[0]);
			eventOccurrence = new FlowEventOccurrence(event, instances);
		} else {
			logger.info("Traveler {}-{} starting", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
			if (application.getStartEvent()==null) {
				throw new RuntimeException("There is no start event is defined");
			}
			eventOccurrence = new FlowEventOccurrence(application.getStartEvent());
		}
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getPresence().enter(traveler, flowContext.getFlowStack().toPath());
	}

	@Override
	public String toString() {
		return "StartMessage [location=" + location + ", event=" + event + "]";
	}
}
