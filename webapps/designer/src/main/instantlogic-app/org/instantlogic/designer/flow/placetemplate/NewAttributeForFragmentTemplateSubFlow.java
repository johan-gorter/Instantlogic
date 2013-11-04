package org.instantlogic.designer.flow.placetemplate;

public class NewAttributeForFragmentTemplateSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final NewAttributeForFragmentTemplateSubFlow INSTANCE = new NewAttributeForFragmentTemplateSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.NewAttributeForFragmentTemplateFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "NewAttributeForFragmentTemplate";
	}
}
