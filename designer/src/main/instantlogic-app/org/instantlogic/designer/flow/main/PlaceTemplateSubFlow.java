package org.instantlogic.designer.flow.main;

public class PlaceTemplateSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final PlaceTemplateSubFlow INSTANCE = new PlaceTemplateSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.designer.flow.PlaceTemplateFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "PlaceTemplate";
	}
}
