package org.instantlogic.interaction.util;

import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;

// TODO: Rename to Place
public class FlowEventOccurrence {

	@Deprecated
	private FlowEvent event;
	
	private Instance[] parameters;
	
	private PlaceTemplate destination;
	
	public FlowEventOccurrence(PlaceTemplate destination, Instance[] placeParameters) {
		this.destination = destination;
		this.parameters = parameters;
	}

	public PlaceTemplate getDestination() {
		return destination;
	}

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
