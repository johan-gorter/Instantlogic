package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractValidationDesign extends Design { 

	private static final java.util.Map<String, ValidationDesign> _staticInstances = new java.util.LinkedHashMap<String, ValidationDesign>();
	
	public static java.util.Map<String, ValidationDesign> getStaticValidationDesignInstances() {
		return _staticInstances;
	}
	
	private static ValidationDesign addStaticInstance(String name, ValidationDesign instance) {
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
		return org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, TextTemplateDesign> message
		= createRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.message);
		
	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, TextTemplateDesign> getMessageRelationValue() {
		return message;
	}

	public org.instantlogic.designer.TextTemplateDesign getMessage() {
		return message.getValue();
	}
	
	public ValidationDesign setMessage(org.instantlogic.designer.TextTemplateDesign newValue) {
		message.setValue(newValue);
		return (ValidationDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newMessage() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		message.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, DeductionSchemeDesign> rule
		= createRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.rule);
		
	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, DeductionSchemeDesign> getRuleRelationValue() {
		return rule;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRule() {
		return rule.getValue();
	}
	
	public ValidationDesign setRule(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		rule.setValue(newValue);
		return (ValidationDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newRule() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		rule.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValueList<ValidationDesign, AttributeDesign> displayWith
		= createRelationValueList(org.instantlogic.designer.entity.ValidationDesignEntity.displayWith);
		
	public org.instantlogic.fabric.value.RelationValueList<ValidationDesign, AttributeDesign> getDisplayWithRelationValue() {
		return displayWith;
	}

	public org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.AttributeDesign> getDisplayWith() {
		return displayWith.getValue();
	}
	
	public ValidationDesign addToDisplayWith(AttributeDesign item) {
		displayWith.addValue(item);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign addToDisplayWith(AttributeDesign item, int index) {
		displayWith.insertValue(item, index);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign removeFromDisplayWith(AttributeDesign item) {
		displayWith.removeValue(item);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign removeFromDisplayWith(int index) {
		displayWith.removeValue(index);
		return (ValidationDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, EntityDesign> forEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);

	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, EntityDesign> getForEntityRelationValue() {
		return forEntity;
	}

	public org.instantlogic.designer.EntityDesign getForEntity() {
		return forEntity.getValue();
	}

    public ValidationDesign setForEntity(org.instantlogic.designer.EntityDesign newValue) {
        forEntity.setValue(newValue);
        return (ValidationDesign)this;
    }


}
