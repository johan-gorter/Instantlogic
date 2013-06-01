package org.instantlogic.designer.flow.main;

public class AttributeSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final AttributeSubFlow INSTANCE = new AttributeSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.AttributeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Attribute";
	}
}
