package org.instantlogic.designer.event;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class DataEvent extends AbstractDataEvent {

	@Override
	public String getName() {
		return "ExploreData"; // This will trigger the built in DataExplorer flow
	}
	
	@Override
	public FlowEventOccurrence createOccurrence(SubmitContext context) {
		Instance selectedInstance = context.getSelectedInstance(null);
		return new FlowEventOccurrence(this, selectedInstance);
	}
}
