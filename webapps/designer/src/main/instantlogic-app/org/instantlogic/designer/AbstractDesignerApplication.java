package org.instantlogic.designer;

public abstract class AbstractDesignerApplication extends org.instantlogic.interaction.Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected AbstractDesignerApplication() {
	}
	
	@Override
	public org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> getCaseEntity() {
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}




	@Override
	public org.instantlogic.interaction.flow.PlaceTemplate getStartPlace() {
		return org.instantlogic.designer.placetemplate.WelcomePlaceTemplate.INSTANCE;
	}


	
	private static final org.instantlogic.interaction.flow.PlaceTemplate[] PLACE_TEMPLATES = new org.instantlogic.interaction.flow.PlaceTemplate[]{
		org.instantlogic.designer.placetemplate.AddAttributePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.AddEntityPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.AttributeDetailsPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.CloseEditorPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.DeductionSchemePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.DeleteEntityPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.EntityDetailsPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.InsertFragmentTemplateBelowPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.NewAttributeForFragmentTemplatePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.OpenEditorPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.PlaceTemplateDetailsPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.RemoveAttributePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.RemoveFragmentTemplatePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.ToDataExplorerPlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.WelcomePlaceTemplate.INSTANCE,
		org.instantlogic.designer.placetemplate.EntitiesGraphPlaceTemplate.INSTANCE,
	};
	
	@Override
	public org.instantlogic.interaction.flow.PlaceTemplate[] getPlaceTemplates() {
		return PLACE_TEMPLATES;
	}

    private static final String[] THEME_NAMES = new String[]{"designer", "margin"};	
	@Override
	public String[] getThemeNames() {
		return THEME_NAMES;
	}
	
	@Override
	public String getName() {
		return "Designer";
	}
}
