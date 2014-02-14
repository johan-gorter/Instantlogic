package org.instantlogic.designer.placetemplate;


public abstract class AbstractDeleteEntityPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final DeleteEntityPlaceTemplate INSTANCE = new DeleteEntityPlaceTemplate();

	@Override
	public String getId() {
		return "PlaceTemplateDesign_DeleteEntity";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
		null;
	
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
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
        return "DeleteEntity";
    }
	
    @Override
    public String getTechnicalName() {
        return "DeleteEntity";
    }
}