

package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class StaticInstanceValueDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, StaticInstanceValueDesign> _staticInstances = new java.util.LinkedHashMap<String, StaticInstanceValueDesign>();
	
	public static java.util.Map<String, StaticInstanceValueDesign> getStaticStaticInstanceValueDesignInstances() {
		return _staticInstances;
	}
	
	private static StaticInstanceValueDesign addStaticInstance(String name, StaticInstanceValueDesign instance) {
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
		return org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<StaticInstanceValueDesign, java.lang.Object> value
		= createAttributeValue(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.value);
	
	public java.lang.Object getValue() {
		return value.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<StaticInstanceValueDesign, java.lang.Object> getValueAttributeValue() {
		return value;
	}

	public StaticInstanceValueDesign setValue(java.lang.Object newValue) {
		value.setValue(newValue);
		return (StaticInstanceValueDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, AttributeDesign> attribute
		= createRelationValue(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.attribute);
		
	public org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}
	
	public StaticInstanceValueDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
		attribute.setValue(newValue);
		return (StaticInstanceValueDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, StaticInstanceDesign> relationValue
		= createRelationValue(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.relationValue);
		
	public org.instantlogic.fabric.value.RelationValue<StaticInstanceValueDesign, StaticInstanceDesign> getRelationValueRelationValue() {
		return relationValue;
	}

	public org.instantlogic.designer.StaticInstanceDesign getRelationValue() {
		return relationValue.getValue();
	}
	
	public StaticInstanceValueDesign setRelationValue(org.instantlogic.designer.StaticInstanceDesign newValue) {
		relationValue.setValue(newValue);
		return (StaticInstanceValueDesign)this;
	}
	


	// Reverse relations

}
