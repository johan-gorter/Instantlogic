package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DestinationDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DestinationDesign> _staticInstances = new java.util.LinkedHashMap<String, DestinationDesign>();
	
	public static java.util.Map<String, DestinationDesign> getStaticDestinationDesignInstances() {
		return _staticInstances;
	}
	
	private static DestinationDesign addStaticInstance(String name, DestinationDesign instance) {
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
		return org.instantlogic.designer.entity.DestinationDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DestinationDesign, PlaceTemplateDesign> PlaceTemplate
		= createRelationValue(org.instantlogic.designer.entity.DestinationDesignEntity.PlaceTemplate);
		
	public org.instantlogic.fabric.value.RelationValue<DestinationDesign, PlaceTemplateDesign> getPlaceTemplateRelationValue() {
		return PlaceTemplate;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getPlaceTemplate() {
		return PlaceTemplate.getValue();
	}
	
	public DestinationDesign setPlaceTemplate(org.instantlogic.designer.PlaceTemplateDesign newValue) {
		PlaceTemplate.setValue(newValue);
		return (DestinationDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DestinationDesign, FragmentTemplateDesign> destinationOnFragmentTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.DestinationDesignEntity.destinationOnFragmentTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<DestinationDesign, FragmentTemplateDesign> getDestinationOnFragmentTemplateDesignRelationValue() {
		return destinationOnFragmentTemplateDesign;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getDestinationOnFragmentTemplateDesign() {
		return destinationOnFragmentTemplateDesign.getValue();
	}

    public DestinationDesign setDestinationOnFragmentTemplateDesign(org.instantlogic.designer.FragmentTemplateDesign newValue) {
        destinationOnFragmentTemplateDesign.setValue(newValue);
        return (DestinationDesign)this;
    }


}
