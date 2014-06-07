package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class PropertyDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, PropertyDesign> _staticInstances = new java.util.LinkedHashMap<String, PropertyDesign>();
	
	public static java.util.Map<String, PropertyDesign> getStaticPropertyDesignInstances() {
		return _staticInstances;
	}
	
	private static PropertyDesign addStaticInstance(String name, PropertyDesign instance) {
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
		return org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.Boolean> collapsed
		= createAttributeValue(org.instantlogic.designer.entity.PropertyDesignEntity.collapsed);
	
	public java.lang.Boolean getCollapsed() {
		return collapsed.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.Boolean> getCollapsedAttributeValue() {
		return collapsed;
	}

	public PropertyDesign setCollapsed(java.lang.Boolean newValue) {
		collapsed.setValue(newValue);
		return (PropertyDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> propertyName
		= createAttributeValue(org.instantlogic.designer.entity.PropertyDesignEntity.propertyName);
	
	public java.lang.String getPropertyName() {
		return propertyName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<PropertyDesign, java.lang.String> getPropertyNameAttributeValue() {
		return propertyName;
	}

	public PropertyDesign setPropertyName(java.lang.String newValue) {
		propertyName.setValue(newValue);
		return (PropertyDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValueList<PropertyDesign, ElementDesign> children
		= createRelationValueList(org.instantlogic.designer.entity.PropertyDesignEntity.children);
		
	public org.instantlogic.fabric.value.RelationValueList<PropertyDesign, ElementDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.ElementDesign> getChildren() {
		return children.getValue();
	}
	
	public PropertyDesign addToChildren(ElementDesign item) {
		children.addValue(item);
		return (PropertyDesign)this;
	}
	
	public PropertyDesign removeFromChildren(ElementDesign item) {
		children.removeValue(item);
		return (PropertyDesign)this;
	}
	
	public PropertyDesign removeFromChildren(int index) {
		children.removeValue(index);
		return (PropertyDesign)this;
	}

	public PropertyDesign addToChildren(ElementDesign item, int index) {
		children.insertValue(item, index);
		return (PropertyDesign)this;
	}	
	
	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextTemplateDesign> text
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.text);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, TextTemplateDesign> getTextRelationValue() {
		return text;
	}

	public org.instantlogic.designer.TextTemplateDesign getText() {
		return text.getValue();
	}
	
	public PropertyDesign setText(org.instantlogic.designer.TextTemplateDesign newValue) {
		text.setValue(newValue);
		return (PropertyDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newText() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		text.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> value
		= createRelationValue(org.instantlogic.designer.entity.PropertyDesignEntity.value);
		
	public org.instantlogic.fabric.value.RelationValue<PropertyDesign, DeductionSchemeDesign> getValueRelationValue() {
		return value;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getValue() {
		return value.getValue();
	}
	
	public PropertyDesign setValue(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		value.setValue(newValue);
		return (PropertyDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newValue() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		value.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
