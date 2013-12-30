package org.instantlogic.designer.placetemplate;


public abstract class AbstractNewAttributeForFragmentTemplatePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final NewAttributeForFragmentTemplatePlaceTemplate INSTANCE = new NewAttributeForFragmentTemplatePlaceTemplate();

	@Override
	public String getId() {
		return "Rm_hIIlrkqabynde_d78afa6e_d33b";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
		null;
	
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
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
        return "NewAttributeForFragmentTemplate";
    }
	
    @Override
    public String getTechnicalName() {
        return "NewAttributeForFragmentTemplate";
    }
}