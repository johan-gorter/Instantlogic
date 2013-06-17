package org.instantlogic.designer.flow.main;

public class FlowNodeSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final FlowNodeSubFlow INSTANCE = new FlowNodeSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.FlowNodeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "FlowNode";
	}
}
