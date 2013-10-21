package org.instantlogic.designer.dataexplorer;

import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;

// Wraps another application and adds the DataExplorer flows
public class ApplicationWithDataExplorer extends ApplicationWrapper {

	private final FlowWithDataExplorer mainFlow;

	public ApplicationWithDataExplorer(Application delegate) {
		super(delegate);
		mainFlow = new FlowWithDataExplorer(delegate.getMainFlow(), delegate);
	}

	public Flow getMainFlow() {
		return mainFlow;
	}
	
	@Override
	public FlowEvent getStartEvent() {
		FlowEvent startEvent = super.getStartEvent();
		if (startEvent==null) {
			return ExploreDataEvent.INSTANCE;
		}
		return startEvent;
	}
}
