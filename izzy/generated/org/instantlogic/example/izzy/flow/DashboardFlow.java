package org.instantlogic.example.izzy.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class DashboardFlow extends org.instantlogic.interaction.flow.Flow {

	public static final DashboardFlow INSTANCE = new DashboardFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.example.izzy.flow.dashboard.DashboardPlaceTemplate.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.DashboardEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.dashboard.DashboardPlaceTemplate.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.example.izzy.entity.UserEntity.INSTANCE,
	};
	
	@Override
	public String getName() {
		return "dashboard";
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
