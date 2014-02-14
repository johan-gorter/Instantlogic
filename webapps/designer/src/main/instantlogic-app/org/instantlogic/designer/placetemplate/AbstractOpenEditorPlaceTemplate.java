package org.instantlogic.designer.placetemplate;


public abstract class AbstractOpenEditorPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final OpenEditorPlaceTemplate INSTANCE = new OpenEditorPlaceTemplate();

	@Override
	public String getId() {
		return "PlaceTemplateDesign_OpenEditor";
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
        return "OpenEditor";
    }
	
    @Override
    public String getTechnicalName() {
        return "OpenEditor";
    }
}