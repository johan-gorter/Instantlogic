package org.instantlogic.interaction.flow.impl;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

/**
 * A simple flow that does some processing and exits immediately when entered
 */
public abstract class ProcessingFlow extends Flow {

	@Override
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		return null;
	}

	@Override
	public FlowEvent findEvent(String eventName) {
		return null;
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, Flow thisOrWrapper,
			String current, Iterator<String> moreCoordinates,
			Instance caseInstance) {
		throw new UnsupportedOperationException();
	}

	@Override
	public FlowEventOccurrence step(FlowNodeBase currentNode,
			FlowEventOccurrence occurrence, FlowContext flowContext) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		return "ProcessingFlow";
	}

}
