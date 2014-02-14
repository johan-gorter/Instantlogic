package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class FragmentTemplateValueDesign extends PropertyDesign { 

	private static final java.util.Map<String, FragmentTemplateValueDesign> _staticInstances = new java.util.LinkedHashMap<String, FragmentTemplateValueDesign>();
	
	public static java.util.Map<String, FragmentTemplateValueDesign> getStaticFragmentTemplateValueDesignInstances() {
		return _staticInstances;
	}
	
	private static FragmentTemplateValueDesign addStaticInstance(String name, FragmentTemplateValueDesign instance) {
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
		return org.instantlogic.designer.entity.FragmentTemplateValueDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateValueDesign, FragmentTemplateDesign> valuesOnFragmentTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateValueDesignEntity.valuesOnFragmentTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateValueDesign, FragmentTemplateDesign> getValuesOnFragmentTemplateDesignRelationValue() {
		return valuesOnFragmentTemplateDesign;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getValuesOnFragmentTemplateDesign() {
		return valuesOnFragmentTemplateDesign.getValue();
	}

    public FragmentTemplateValueDesign setValuesOnFragmentTemplateDesign(org.instantlogic.designer.FragmentTemplateDesign newValue) {
        valuesOnFragmentTemplateDesign.setValue(newValue);
        return (FragmentTemplateValueDesign)this;
    }


}
