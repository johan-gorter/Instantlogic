package org.instantlogic.designer.flow.placetemplate;

public class OpenEditorSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final OpenEditorSubFlow INSTANCE = new OpenEditorSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.OpenEditorFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "OpenEditor";
	}
}
