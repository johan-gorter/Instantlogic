package org.instantlogic.designer.placetemplate;


public abstract class AbstractRemoveAttributePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final RemoveAttributePlaceTemplate INSTANCE = new RemoveAttributePlaceTemplate();

	@Override
	public String getId() {
		return "AzzvOUtdhybpqarn_79bf310d_cb02";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
		null;
	
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
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
        return "RemoveAttribute";
    }
	
    @Override
    public String getTechnicalName() {
        return "RemoveAttribute";
    }
}