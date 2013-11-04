package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class ExploreDataEvent extends FlowEvent {

	public static ExploreDataEvent INSTANCE = new ExploreDataEvent();
	
	private ExploreDataEvent() {
	}

	@Override
	public FlowEventOccurrence createOccurrence(SubmitContext context) {
		Instance selectedInstance = context.getSelectedInstance(null);
		return new FlowEventOccurrence(this, selectedInstance);
	}

	@Override
	public String getName() {
		return "ExploreData";
	}

}
