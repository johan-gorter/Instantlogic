package org.instantlogic.designer.flow.placetemplate;

public class CloseEditorSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final CloseEditorSubFlow INSTANCE = new CloseEditorSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.CloseEditorFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "CloseEditor";
	}
}
