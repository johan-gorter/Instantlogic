package org.instantlogic.designer.dataexplorer;

import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class ExploreStaticInstancesEvent extends FlowEvent {

	public static ExploreStaticInstancesEvent INSTANCE = new ExploreStaticInstancesEvent();
	
	private ExploreStaticInstancesEvent() {
	}

	@Override
	public FlowEventOccurrence createOccurrence(SubmitContext context) {
		return new FlowEventOccurrence(this);
	}

	@Override
	public String getName() {
		return "ExploreStaticInstances";
	}

}
