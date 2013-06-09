package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class EntityFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final EntityFlow INSTANCE = new EntityFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.entity.AddAttributeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.entity.EntityDetailsPlaceTemplate.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.entity.EntityDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AddAttributeEvent.INSTANCE,
			org.instantlogic.designer.flow.entity.AddAttributeSubFlow.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Entity";
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
