package org.instantlogic.designer.flow;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.impl.SimpleFlow;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

public class DataExplorerFlow extends SimpleFlow {

	private final CaseAdministration caseAdministration;

	public DataExplorerFlow(CaseAdministration caseAdministration) {
		this.caseAdministration = caseAdministration;
	}
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		return super.enter(occurrence, context);
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		return super.createFlowStack(parentStack, current, moreCoordinates, caseInstance);
	}
	
	@Override
	public FlowNodeBase[] getNodes() {
		return null;
	}

	@Override
	public FlowEdge[] getEdges() {
		return null;
	}

	@Override
	public Entity<? extends Instance>[] getParameters() {
		return null;
	}

	@Override
	public String getName() {
		return "DataExplorer";
	}
}
