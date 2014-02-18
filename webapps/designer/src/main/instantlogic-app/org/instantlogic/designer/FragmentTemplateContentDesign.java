package org.instantlogic.designer;

@SuppressWarnings({"rawtypes","unused"})
public class FragmentTemplateContentDesign extends PropertyDesign { 

	private static final java.util.Map<String, FragmentTemplateContentDesign> _staticInstances = new java.util.LinkedHashMap<String, FragmentTemplateContentDesign>();
	
	public static java.util.Map<String, FragmentTemplateContentDesign> getStaticFragmentTemplateContentDesignInstances() {
		return _staticInstances;
	}
	
	private static FragmentTemplateContentDesign addStaticInstance(String name, FragmentTemplateContentDesign instance) {
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
		return org.instantlogic.designer.entity.FragmentTemplateContentDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateContentDesign, FragmentTemplateDesign> fragmentTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateContentDesignEntity.fragmentTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateContentDesign, FragmentTemplateDesign> getFragmentTemplateDesignRelationValue() {
		return fragmentTemplateDesign;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragmentTemplateDesign() {
		return fragmentTemplateDesign.getValue();
	}

    public FragmentTemplateContentDesign setFragmentTemplateDesign(org.instantlogic.designer.FragmentTemplateDesign newValue) {
        fragmentTemplateDesign.setValue(newValue);
        return (FragmentTemplateContentDesign)this;
    }


}
