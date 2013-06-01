package org.instantlogic.designer.flow.main;

public class AddEntitySubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final AddEntitySubFlow INSTANCE = new AddEntitySubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.AddEntityFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "AddEntity";
	}
}
