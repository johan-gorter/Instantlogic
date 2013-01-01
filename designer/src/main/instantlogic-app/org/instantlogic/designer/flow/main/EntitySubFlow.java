package org.instantlogic.designer.flow.main;

public class EntitySubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final EntitySubFlow INSTANCE = new EntitySubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.EntityFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "Entity";
	}
}
