package org.instantlogic.interaction.util;

import org.instantlogic.interaction.flow.FlowNodeBase;

public class UnhandledOccurrenceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnhandledOccurrenceException(FlowNodeBase lastNode, FlowEventOccurrence lastOccurrence) {
		super("Event occurrence "+lastOccurrence.getEvent().getName()+" was not handled at node "+lastNode.getName()+" or below");
	}
}
