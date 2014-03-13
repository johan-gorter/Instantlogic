package org.instantlogic.designer.placetemplate;


public class EntitiesGraphPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final EntitiesGraphPlaceTemplate INSTANCE = new EntitiesGraphPlaceTemplate();

	@Override
	public String getId() {
		return "ZkwstEslpagmkgie_3a519474_df20";
	}
	
	
	private static org.instantlogic.interaction.page.FragmentTemplate CONTENT = 
        new org.instantlogic.interaction.page.FragmentTemplate("IIkahqi_mmbfmfAp_70d4ae1f_8637", "Page")        
            .addChild("mainContent",
                new org.instantlogic.interaction.page.FragmentTemplate("graph1", "Block")      
                    .addCustomFilter(new org.instantlogic.designer.element.EntitiesGraphElement())        
            );
	
	
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
        return "EntitiesGraph";
    }
	
    @Override
    public String getTechnicalName() {
        return "EntitiesGraph";
    }
}