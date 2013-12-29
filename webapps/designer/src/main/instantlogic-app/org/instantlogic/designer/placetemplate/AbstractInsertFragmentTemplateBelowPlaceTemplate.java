package org.instantlogic.designer.placetemplate;


public abstract class AbstractInsertFragmentTemplateBelowPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final InsertFragmentTemplateBelowPlaceTemplate INSTANCE = new InsertFragmentTemplateBelowPlaceTemplate();

	@Override
	public String getId() {
		return "uzyaAtkthicteiOb_f3664684_1a40";
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
        return "InsertFragmentTemplateBelow";
    }
	
    @Override
    public String getTechnicalName() {
        return "InsertFragmentTemplateBelow";
    }
}