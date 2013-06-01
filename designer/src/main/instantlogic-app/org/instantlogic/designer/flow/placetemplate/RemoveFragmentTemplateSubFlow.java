package org.instantlogic.designer.flow.placetemplate;

public class RemoveFragmentTemplateSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final RemoveFragmentTemplateSubFlow INSTANCE = new RemoveFragmentTemplateSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.RemoveFragmentTemplateFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "RemoveFragmentTemplate";
	}
}
