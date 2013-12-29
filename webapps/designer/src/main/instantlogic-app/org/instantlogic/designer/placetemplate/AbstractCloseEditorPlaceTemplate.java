package org.instantlogic.designer.placetemplate;


public abstract class AbstractCloseEditorPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final CloseEditorPlaceTemplate INSTANCE = new CloseEditorPlaceTemplate();

	@Override
	public String getId() {
		return "GtAksIEagi_sskzz_66b9bde6_5bb9";
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
        return "CloseEditor";
    }
	
    @Override
    public String getTechnicalName() {
        return "CloseEditor";
    }
}