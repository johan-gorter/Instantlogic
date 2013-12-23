package org.instantlogic.designer.placetemplate;


public abstract class AbstractAddEntityPlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AddEntityPlaceTemplate INSTANCE = new AddEntityPlaceTemplate();

	@Override
	public String getId() {
		return "DuawItvIweblklgr_b0aa3f45_9878";
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
        return "AddEntity";
    }
	
    @Override
    public String getTechnicalName() {
        return "AddEntity";
    }
}