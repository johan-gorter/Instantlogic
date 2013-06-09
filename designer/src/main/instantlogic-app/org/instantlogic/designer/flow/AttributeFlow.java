

package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class AttributeFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final AttributeFlow INSTANCE = new AttributeFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.attribute.AttributeDetailsPlaceTemplate.INSTANCE,
		org.instantlogic.designer.flow.attribute.RemoveAttributeSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.attribute.AttributeDetailsPlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.RemoveAttributeEvent.INSTANCE,
			org.instantlogic.designer.flow.attribute.RemoveAttributeSubFlow.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "Attribute";
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
