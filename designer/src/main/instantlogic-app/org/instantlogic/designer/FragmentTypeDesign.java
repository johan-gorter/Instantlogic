package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class FragmentTypeDesign extends Design { 

	private static final java.util.Map<String, FragmentTypeDesign> _staticInstances = new java.util.LinkedHashMap<String, FragmentTypeDesign>();
	
	public static java.util.Map<String, FragmentTypeDesign> getStaticFragmentTypeDesignInstances() {
		return _staticInstances;
	}
	
	private static FragmentTypeDesign addStaticInstance(String name, FragmentTypeDesign instance) {
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
		return org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValueList<FragmentTypeDesign, java.lang.String> fragmentFilters
		= createAttributeValueList(org.instantlogic.designer.entity.FragmentTypeDesignEntity.fragmentFilters);
	
	public org.instantlogic.fabric.value.ValueList<java.lang.String> getFragmentFilters() {
		return fragmentFilters.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValueList<FragmentTypeDesign, java.lang.String> getFragmentFiltersAttributeValue() {
		return fragmentFilters;
	}

	public FragmentTypeDesign addToFragmentFilters(java.lang.String item) {
		fragmentFilters.addValue(item);
		return (FragmentTypeDesign)this;
	}
	
	public FragmentTypeDesign addToFragmentFilters(java.lang.String item, int index) {
		fragmentFilters.insertValue(item, index);
		return (FragmentTypeDesign)this;
	}
	
	public FragmentTypeDesign removeFromFragmentFilters(java.lang.String item) {
		fragmentFilters.removeValue(item);
		return (FragmentTypeDesign)this;
	}
	
	public FragmentTypeDesign removeFromFragmentFilters(int index) {
		fragmentFilters.removeValue(index);
		return (FragmentTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<FragmentTypeDesign, java.lang.Boolean> hasAttribute
		= createAttributeValue(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasAttribute);
	
	public java.lang.Boolean getHasAttribute() {
		return hasAttribute.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FragmentTypeDesign, java.lang.Boolean> getHasAttributeAttributeValue() {
		return hasAttribute;
	}

	public FragmentTypeDesign setHasAttribute(java.lang.Boolean newValue) {
		hasAttribute.setValue(newValue);
		return (FragmentTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<FragmentTypeDesign, java.lang.Boolean> hasEvent
		= createAttributeValue(org.instantlogic.designer.entity.FragmentTypeDesignEntity.hasEvent);
	
	public java.lang.Boolean getHasEvent() {
		return hasEvent.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FragmentTypeDesign, java.lang.Boolean> getHasEventAttributeValue() {
		return hasEvent;
	}

	public FragmentTypeDesign setHasEvent(java.lang.Boolean newValue) {
		hasEvent.setValue(newValue);
		return (FragmentTypeDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTypeDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentTypeDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<FragmentTypeDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public FragmentTypeDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (FragmentTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTypeDesign, FragmentTemplateDesign> usages
		= createReverseRelationValues(org.instantlogic.designer.entity.FragmentTypeDesignEntity.usages);

	public org.instantlogic.fabric.value.RelationValues<FragmentTypeDesign, FragmentTemplateDesign> getUsagesRelationValue() {
		return usages;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign> getUsages() {
		return usages.getValue();
	}

    public FragmentTypeDesign addToUsages(FragmentTemplateDesign item) {
        usages.addValue(item);
        return (FragmentTypeDesign)this;
    }

    public FragmentTypeDesign removeFromUsages(FragmentTemplateDesign item) {
        usages.removeValue(item);
        return (FragmentTypeDesign)this;
    }


}
