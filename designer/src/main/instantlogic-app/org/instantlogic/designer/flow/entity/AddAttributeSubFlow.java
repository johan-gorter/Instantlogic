package org.instantlogic.designer.flow.entity;

public class AddAttributeSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final AddAttributeSubFlow INSTANCE = new AddAttributeSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.AddAttributeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "AddAttribute";
	}
}
