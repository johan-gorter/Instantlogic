package org.instantlogic.designer.flow.flownode;

public class FlowNodeChoiceSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final FlowNodeChoiceSubFlow INSTANCE = new FlowNodeChoiceSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.FlowNodeChoiceFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "FlowNodeChoice";
	}
}
