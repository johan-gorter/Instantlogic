package org.instantlogic.designer.placetemplate;


public abstract class AbstractAddAttributePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

	public static final AddAttributePlaceTemplate INSTANCE = new AddAttributePlaceTemplate();

	@Override
	public String getId() {
		return "FpzUsfyyqmcdsbAz_3257fd06_3294";
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
        return "AddAttribute";
    }
	
    @Override
    public String getTechnicalName() {
        return "AddAttribute";
    }
}