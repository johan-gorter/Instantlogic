package org.instantlogic.designer.placetemplate;


public abstract class AbstractRemoveFragmentTemplatePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final RemoveFragmentTemplatePlaceTemplate INSTANCE = new RemoveFragmentTemplatePlaceTemplate();

	@Override
	public String getId() {
		return "PlaceTemplateDesign_RemoveFragmentTemplate";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
		null;
	
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE,
	};

	@Override
	public org.instantlogic.fabric.model.Entity[] getParameters() {
		return PARAMETERS;
	}
	
	@Override
	public org.instantlogic.interaction.page.FragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
    @Override
    public String getName() {
        return "RemoveFragmentTemplate";
    }
	
    @Override
    public String getTechnicalName() {
        return "RemoveFragmentTemplate";
    }
}