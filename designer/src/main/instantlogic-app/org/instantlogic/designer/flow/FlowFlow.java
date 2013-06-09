

package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class FlowFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final FlowFlow INSTANCE = new FlowFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.flow.FlowDetailsPlaceTemplate.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.flow.FlowDetailsPlaceTemplate.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Flow";
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
