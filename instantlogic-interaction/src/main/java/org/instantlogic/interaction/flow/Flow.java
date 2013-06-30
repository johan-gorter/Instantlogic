package org.instantlogic.interaction.flow;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Concept;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

//TODO: Rename to FlowTemplate
public abstract class Flow extends Concept {

	public abstract PlaceTemplate getPage(String[] path, int pathIndex);

	public abstract FlowEvent findEvent(String eventName);
	
	public abstract FlowStack createFlowStack(FlowStack parentStack, Flow thisOrWrapper, String current, Iterator<String> moreCoordinates, Instance caseInstance);

	public abstract FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context);

	// Step to the next point in the flow. Updates context and results in the next trigger
	// returns null if a page has been reached.
	public abstract FlowEventOccurrence step(FlowNodeBase currentNode, FlowEventOccurrence occurrence, FlowContext flowContext);

}
