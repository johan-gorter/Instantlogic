package org.instantlogic.interaction.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.PlaceTemplate;

// TODO: Rename to Place
public class FlowEventOccurrence {

	private Instance[] parameters;
	
	private PlaceTemplate destination;
	
	public FlowEventOccurrence(PlaceTemplate destination, Instance... placeParameters) {
		this.destination = destination;
		this.parameters = placeParameters;
	}

	public PlaceTemplate getDestination() {
		return destination;
	}

	public Instance[] getParameters() {
		return parameters;
	}
}
