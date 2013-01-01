package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractStaticInstanceDesign extends Design { 

	private static final java.util.Map<String, StaticInstanceDesign> _staticInstances = new java.util.LinkedHashMap<String, StaticInstanceDesign>();
	
	public static java.util.Map<String, StaticInstanceDesign> getStaticStaticInstanceDesignInstances() {
		return _staticInstances;
	}
	
	private static StaticInstanceDesign addStaticInstance(String name, StaticInstanceDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, TextTemplateDesign> description
		= createRelationValue(org.instantlogic.designer.entity.StaticInstanceDesignEntity.description);
		
	public org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, TextTemplateDesign> getDescriptionRelationValue() {
		return description;
	}

	public org.instantlogic.designer.TextTemplateDesign getDescription() {
		return description.getValue();
	}
	
	public StaticInstanceDesign setDescription(org.instantlogic.designer.TextTemplateDesign newValue) {
		description.setValue(newValue);
		return (StaticInstanceDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newDescription() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		description.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<StaticInstanceDesign, StaticInstanceValueDesign> values
		= createRelationValues(org.instantlogic.designer.entity.StaticInstanceDesignEntity.values);
		
	public org.instantlogic.fabric.value.RelationValues<StaticInstanceDesign, StaticInstanceValueDesign> getValuesRelationValue() {
		return values;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign> getValues() {
		return values.getValue();
	}
	
	public StaticInstanceDesign addToValues(StaticInstanceValueDesign item) {
		values.addValue(item);
		return (StaticInstanceDesign)this;
	}
	
	public StaticInstanceDesign addToValues(StaticInstanceValueDesign item, int index) {
		values.insertValue(item, index);
		return (StaticInstanceDesign)this;
	}
	
	public StaticInstanceDesign removeFromValues(StaticInstanceValueDesign item) {
		values.removeValue(item);
		return (StaticInstanceDesign)this;
	}
	
	public StaticInstanceDesign removeFromValues(int index) {
		values.removeValue(index);
		return (StaticInstanceDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, EntityDesign> entity
		= createReverseRelationValue(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);

	public org.instantlogic.fabric.value.RelationValue<StaticInstanceDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}

    public StaticInstanceDesign setEntity(org.instantlogic.designer.EntityDesign newValue) {
        entity.setValue(newValue);
        return (StaticInstanceDesign)this;
    }


}
