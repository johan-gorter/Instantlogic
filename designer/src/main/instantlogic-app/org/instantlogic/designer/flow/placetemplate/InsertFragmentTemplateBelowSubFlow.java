package org.instantlogic.designer.flow.placetemplate;

public class InsertFragmentTemplateBelowSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final InsertFragmentTemplateBelowSubFlow INSTANCE = new InsertFragmentTemplateBelowSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.impl.SimpleFlow getFlow() {
		return org.instantlogic.designer.flow.InsertFragmentTemplateBelowFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "InsertFragmentTemplateBelow";
	}
}
