package org.instantlogic.example.izzy.flow;

@SuppressWarnings({"unchecked","rawtypes"})
public class MainFlow extends org.instantlogic.interaction.flow.Flow {

	public static final MainFlow INSTANCE = new MainFlow();
	
	private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
		org.instantlogic.example.izzy.flow.main.NotLoggedInPlaceTemplate.INSTANCE,
		org.instantlogic.example.izzy.flow.main.IssueSubFlow.INSTANCE,
		org.instantlogic.example.izzy.flow.main.CreateIssueSubFlow.INSTANCE,
		org.instantlogic.example.izzy.flow.main.SelectDashboardSubFlow.INSTANCE,
		org.instantlogic.example.izzy.flow.main.DashboardSubFlow.INSTANCE,
	};
	
	private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.main.IssueSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.CreateIssueEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.main.CreateIssueSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.HomeEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.main.SelectDashboardSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.DashboardEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.main.DashboardSubFlow.INSTANCE
		),
		new org.instantlogic.interaction.flow.FlowEdge(
			null, 
			org.instantlogic.example.izzy.event.NotLoggedInEvent.INSTANCE,
			org.instantlogic.example.izzy.flow.main.NotLoggedInPlaceTemplate.INSTANCE
		),
	};
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
	};
	
	@Override
	public String getName() {
		return "main";
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
