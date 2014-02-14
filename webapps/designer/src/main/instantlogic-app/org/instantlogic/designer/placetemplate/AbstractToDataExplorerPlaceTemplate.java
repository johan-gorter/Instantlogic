package org.instantlogic.designer.placetemplate;


public abstract class AbstractToDataExplorerPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final ToDataExplorerPlaceTemplate INSTANCE = new ToDataExplorerPlaceTemplate();

	@Override
	public String getId() {
		return "PlaceTemplateDesign_ToDataExplorer";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
		null;
	
	
	private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
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
        return "ToDataExplorer";
    }
	
    @Override
    public String getTechnicalName() {
        return "ToDataExplorer";
    }
}