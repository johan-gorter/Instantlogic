package org.instantlogic.designer.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class MainFlow extends org.instantlogic.interaction.flow.impl.SimpleFlow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.DeductionSchemeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.WelcomePlaceTemplate.INSTANCE,
		org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.FlowNodeSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.PlaceTemplateSubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.AddEntitySubFlow.INSTANCE,
		org.instantlogic.designer.flow.main.AttributeSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.HomeEvent.INSTANCE,
			org.instantlogic.designer.flow.main.WelcomePlaceTemplate.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.DeductionSchemeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.DeductionSchemeSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AttributeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.AttributeSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.PlaceTemplateDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.PlaceTemplateSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowNodeDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowNodeSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.EntityDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.EntitySubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.FlowDetailsEvent.INSTANCE,
			org.instantlogic.designer.flow.main.FlowSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.designer.event.AddEntityEvent.INSTANCE,
			org.instantlogic.designer.flow.main.AddEntitySubFlow.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};
	
	@Override
	public String getName() {
		return "Main";
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
