package org.instantlogic.interaction.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.FlowEvent;

// TODO: Rename to FlowEvent
public class FlowEventOccurrence {

	private FlowEvent event;
	
	private Instance[] parameters;
	
	public FlowEventOccurrence(FlowEvent event, Instance... parameters) {
		this.event = event;
		this.parameters = parameters;
	}

	public FlowEvent getEvent() {
		return event;
	}

	public Instance[] getParameters() {
		return parameters;
	}
}
