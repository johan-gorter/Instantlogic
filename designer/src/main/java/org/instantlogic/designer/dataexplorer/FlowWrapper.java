package org.instantlogic.designer.dataexplorer;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

public class FlowWrapper extends Flow {
	
	private final Flow delegate;

	public FlowWrapper(Flow delegate) {
		this.delegate = delegate;
	}

	@Override
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		return delegate.getPage(path, pathIndex);
	}

	@Override
	public FlowEvent findEvent(String eventName) {
		return delegate.findEvent(eventName);
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		return delegate.createFlowStack(parentStack, current, moreCoordinates, caseInstance);
	}

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		return delegate.enter(occurrence, context);
	}

	@Override
	public FlowEventOccurrence step(FlowNodeBase currentNode, FlowEventOccurrence occurrence, FlowContext flowContext) {
		return delegate.step(currentNode, occurrence, flowContext);
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	
}
