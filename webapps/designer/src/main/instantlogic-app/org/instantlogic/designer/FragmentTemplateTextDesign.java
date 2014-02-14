package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class FragmentTemplateTextDesign extends PropertyDesign { 

	private static final java.util.Map<String, FragmentTemplateTextDesign> _staticInstances = new java.util.LinkedHashMap<String, FragmentTemplateTextDesign>();
	
	public static java.util.Map<String, FragmentTemplateTextDesign> getStaticFragmentTemplateTextDesignInstances() {
		return _staticInstances;
	}
	
	private static FragmentTemplateTextDesign addStaticInstance(String name, FragmentTemplateTextDesign instance) {
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
		return org.instantlogic.designer.entity.FragmentTemplateTextDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateTextDesign, FragmentTemplateDesign> fragmentTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTemplateTextDesignEntity.fragmentTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateTextDesign, FragmentTemplateDesign> getFragmentTemplateDesignRelationValue() {
		return fragmentTemplateDesign;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragmentTemplateDesign() {
		return fragmentTemplateDesign.getValue();
	}

    public FragmentTemplateTextDesign setFragmentTemplateDesign(org.instantlogic.designer.FragmentTemplateDesign newValue) {
        fragmentTemplateDesign.setValue(newValue);
        return (FragmentTemplateTextDesign)this;
    }


}
