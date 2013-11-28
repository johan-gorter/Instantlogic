package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class PlaceParameterDesign extends Design { 

	private static final java.util.Map<String, PlaceParameterDesign> _staticInstances = new java.util.LinkedHashMap<String, PlaceParameterDesign>();
	
	public static java.util.Map<String, PlaceParameterDesign> getStaticPlaceParameterDesignInstances() {
		return _staticInstances;
	}
	
	private static PlaceParameterDesign addStaticInstance(String name, PlaceParameterDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.PlaceParameterDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceParameterDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.PlaceParameterDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceParameterDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	
	public PlaceParameterDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
		return (PlaceParameterDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceParameterDesign, PlaceTemplateDesign> placeTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.PlaceParameterDesignEntity.placeTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<PlaceParameterDesign, PlaceTemplateDesign> getPlaceTemplateDesignRelationValue() {
		return placeTemplateDesign;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getPlaceTemplateDesign() {
		return placeTemplateDesign.getValue();
	}

    public PlaceParameterDesign setPlaceTemplateDesign(org.instantlogic.designer.PlaceTemplateDesign newValue) {
        placeTemplateDesign.setValue(newValue);
        return (PlaceParameterDesign)this;
    }


}
