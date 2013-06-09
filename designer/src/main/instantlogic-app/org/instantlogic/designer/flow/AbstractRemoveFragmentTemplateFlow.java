package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public abstract class AbstractRemoveFragmentTemplateFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final RemoveFragmentTemplateFlow INSTANCE = new RemoveFragmentTemplateFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "RemoveFragmentTemplate";
	}

	@Override
	public org.instantlogic.interaction.flow.FlowNodeBase[] getNodes() {
		return NODES;
	}

	@Override
	public org.instantlogic.interaction.flow.FlowEdge[] getEdges() {
		return EDGES;
	}

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
}
