package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractFragmentTemplateDesign extends ElementDesign { 

	private static final java.util.Map<String, FragmentTemplateDesign> _staticInstances = new java.util.LinkedHashMap<String, FragmentTemplateDesign>();
	
	public static java.util.Map<String, FragmentTemplateDesign> getStaticFragmentTemplateDesignInstances() {
		return _staticInstances;
	}
	
	private static FragmentTemplateDesign addStaticInstance(String name, FragmentTemplateDesign instance) {
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
		return org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> fragmentTypeName
		= createAttributeValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentTypeName);
	
	public java.lang.String getFragmentTypeName() {
		return fragmentTypeName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<FragmentTemplateDesign, java.lang.String> getFragmentTypeNameAttributeValue() {
		return fragmentTypeName;
	}

	public FragmentTemplateDesign setFragmentTypeName(java.lang.String newValue) {
		fragmentTypeName.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValues<FragmentTemplateDesign, java.lang.String> styleNames
		= createAttributeValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.styleNames);
	
	public org.instantlogic.fabric.value.Values<java.lang.String> getStyleNames() {
		return styleNames.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValues<FragmentTemplateDesign, java.lang.String> getStyleNamesAttributeValue() {
		return styleNames;
	}

	public FragmentTemplateDesign addToStyleNames(java.lang.String item) {
		styleNames.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromStyleNames(java.lang.String item) {
		styleNames.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.AttributeValueList<FragmentTemplateDesign, java.lang.String> fragmentFilters
		= createAttributeValueList(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.fragmentFilters);
	
	public org.instantlogic.fabric.value.ValueList<java.lang.String> getFragmentFilters() {
		return fragmentFilters.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValueList<FragmentTemplateDesign, java.lang.String> getFragmentFiltersAttributeValue() {
		return fragmentFilters;
	}

	public FragmentTemplateDesign addToFragmentFilters(java.lang.String item) {
		fragmentFilters.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromFragmentFilters(java.lang.String item) {
		fragmentFilters.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign addToFragmentFilters(java.lang.String item, int index) {
		fragmentFilters.insertValue(item, index);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromFragmentFilters(int index) {
		fragmentFilters.removeValue(index);
		return (FragmentTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public FragmentTemplateDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, FragmentTypeDesign> type
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.type);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, FragmentTypeDesign> getTypeRelationValue() {
		return type;
	}

	public org.instantlogic.designer.FragmentTypeDesign getType() {
		return type.getValue();
	}
	
	public FragmentTemplateDesign setType(org.instantlogic.designer.FragmentTypeDesign newValue) {
		type.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, PropertyDesign> properties
		= createRelationValues(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.properties);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentTemplateDesign, PropertyDesign> getPropertiesRelationValue() {
		return properties;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.PropertyDesign> getProperties() {
		return properties.getValue();
	}
	
	public FragmentTemplateDesign addToProperties(PropertyDesign item) {
		properties.addValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	public FragmentTemplateDesign removeFromProperties(PropertyDesign item) {
		properties.removeValue(item);
		return (FragmentTemplateDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EntityDesign> entity
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	
	public FragmentTemplateDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
		entity.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EventDesign> event
		= createRelationValue(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.event);
		
	public org.instantlogic.fabric.value.RelationValue<FragmentTemplateDesign, EventDesign> getEventRelationValue() {
		return event;
	}

	public org.instantlogic.designer.EventDesign getEvent() {
		return event.getValue();
	}
	
	public FragmentTemplateDesign setEvent(org.instantlogic.designer.EventDesign newValue) {
		event.setValue(newValue);
		return (FragmentTemplateDesign)this;
	}
	


	// Reverse relations

}
