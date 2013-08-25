package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractAttributeDesign extends Design { 

	private static final java.util.Map<String, AttributeDesign> _staticInstances = new java.util.LinkedHashMap<String, AttributeDesign>();
	
	public static java.util.Map<String, AttributeDesign> getStaticAttributeDesignInstances() {
		return _staticInstances;
	}
	
	private static AttributeDesign addStaticInstance(String name, AttributeDesign instance) {
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
		return org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> hasDefault
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.hasDefault);
	
	public java.lang.Boolean getHasDefault() {
		return hasDefault.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getHasDefaultAttributeValue() {
		return hasDefault;
	}

	public AttributeDesign setHasDefault(java.lang.Boolean newValue) {
		hasDefault.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> hasRelevance
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.hasRelevance);
	
	public java.lang.Boolean getHasRelevance() {
		return hasRelevance.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getHasRelevanceAttributeValue() {
		return hasRelevance;
	}

	public AttributeDesign setHasRelevance(java.lang.Boolean newValue) {
		hasRelevance.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> writeable
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.writeable);
	
	public java.lang.Boolean getWriteable() {
		return writeable.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getWriteableAttributeValue() {
		return writeable;
	}

	public AttributeDesign setWriteable(java.lang.Boolean newValue) {
		writeable.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> hasRule
		= createAttributeValue(org.instantlogic.designer.entity.AttributeDesignEntity.hasRule);
	
	public java.lang.Boolean getHasRule() {
		return hasRule.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<AttributeDesign, java.lang.Boolean> getHasRuleAttributeValue() {
		return hasRule;
	}

	public AttributeDesign setHasRule(java.lang.Boolean newValue) {
		hasRule.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> _default
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getDefaultRelationValue() {
		return _default;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDefault() {
		return _default.getValue();
	}
	
	public AttributeDesign setDefault(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		_default.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newDefault() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		_default.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> question
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.question);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> getQuestionRelationValue() {
		return question;
	}

	public org.instantlogic.designer.TextTemplateDesign getQuestion() {
		return question.getValue();
	}
	
	public AttributeDesign setQuestion(org.instantlogic.designer.TextTemplateDesign newValue) {
		question.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newQuestion() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		question.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> relevance
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRelevanceRelationValue() {
		return relevance;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRelevance() {
		return relevance.getValue();
	}
	
	public AttributeDesign setRelevance(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		relevance.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newRelevance() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		relevance.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> explanation
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.explanation);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, TextTemplateDesign> getExplanationRelationValue() {
		return explanation;
	}

	public org.instantlogic.designer.TextTemplateDesign getExplanation() {
		return explanation.getValue();
	}
	
	public AttributeDesign setExplanation(org.instantlogic.designer.TextTemplateDesign newValue) {
		explanation.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newExplanation() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		explanation.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> belongsToEntity
		= createReadOnlyRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);
		
	public org.instantlogic.fabric.value.ReadOnlyRelationValue<AttributeDesign, EntityDesign> getBelongsToEntityRelationValue() {
		return belongsToEntity;
	}

	public org.instantlogic.designer.EntityDesign getBelongsToEntity() {
		return belongsToEntity.getValue();
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> rule
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DeductionSchemeDesign> getRuleRelationValue() {
		return rule;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRule() {
		return rule.getValue();
	}
	
	public AttributeDesign setRule(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		rule.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newRule() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		rule.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, DataTypeDesign> dataType
		= createRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
		
	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, DataTypeDesign> getDataTypeRelationValue() {
		return dataType;
	}

	public org.instantlogic.designer.DataTypeDesign getDataType() {
		return dataType.getValue();
	}
	
	public AttributeDesign setDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		dataType.setValue(newValue);
		return (AttributeDesign)this;
	}
	
	public org.instantlogic.designer.DataTypeDesign newDataType() {
		org.instantlogic.designer.DataTypeDesign newValue = new org.instantlogic.designer.DataTypeDesign(); 
		dataType.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<AttributeDesign, ValidationDesign> validations
		= createReverseRelationValues(org.instantlogic.designer.entity.AttributeDesignEntity.validations);

	public org.instantlogic.fabric.value.RelationValues<AttributeDesign, ValidationDesign> getValidationsRelationValue() {
		return validations;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign> getValidations() {
		return validations.getValue();
	}

    public AttributeDesign addToValidations(ValidationDesign item) {
        validations.addValue(item);
        return (AttributeDesign)this;
    }

    public AttributeDesign removeFromValidations(ValidationDesign item) {
        validations.removeValue(item);
        return (AttributeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<AttributeDesign, EntityDesign> attributeOf
		= createReverseRelationValue(org.instantlogic.designer.entity.AttributeDesignEntity.attributeOf);

	public org.instantlogic.fabric.value.RelationValue<AttributeDesign, EntityDesign> getAttributeOfRelationValue() {
		return attributeOf;
	}

	public org.instantlogic.designer.EntityDesign getAttributeOf() {
		return attributeOf.getValue();
	}

    public AttributeDesign setAttributeOf(org.instantlogic.designer.EntityDesign newValue) {
        attributeOf.setValue(newValue);
        return (AttributeDesign)this;
    }


}
