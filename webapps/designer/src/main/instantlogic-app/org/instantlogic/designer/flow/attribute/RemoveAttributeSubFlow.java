package org.instantlogic.designer.flow.attribute;

public class RemoveAttributeSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final RemoveAttributeSubFlow INSTANCE = new RemoveAttributeSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.RemoveAttributeFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "RemoveAttribute";
	}
}
