package org.instantlogic.designer.flow.main;

public class FlowSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final FlowSubFlow INSTANCE = new FlowSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.FlowFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Flow";
	}
}
