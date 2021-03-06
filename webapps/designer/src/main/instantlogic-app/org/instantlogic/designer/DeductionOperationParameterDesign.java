package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DeductionOperationParameterDesign extends Design { 

	private static final java.util.Map<String, DeductionOperationParameterDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionOperationParameterDesign>();
	
	public static java.util.Map<String, DeductionOperationParameterDesign> getStaticDeductionOperationParameterDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionOperationParameterDesign addStaticInstance(String name, DeductionOperationParameterDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DeductionOperationParameterDesign attribute;
	public static final DeductionOperationParameterDesign castToEntity;
	public static final DeductionOperationParameterDesign constantValue;
	public static final DeductionOperationParameterDesign reverseRelationRelation;
	public static final DeductionOperationParameterDesign selectedInstanceEntity;
	
	static {
	  // Phase 1
	  attribute = addStaticInstance("attribute", new DeductionOperationParameterDesign());
	  castToEntity = addStaticInstance("castToEntity", new DeductionOperationParameterDesign());
	  constantValue = addStaticInstance("constantValue", new DeductionOperationParameterDesign());
	  reverseRelationRelation = addStaticInstance("reverseRelationRelation", new DeductionOperationParameterDesign());
	  selectedInstanceEntity = addStaticInstance("selectedInstanceEntity", new DeductionOperationParameterDesign());
	  // Phase 2
      attribute.setName("attribute");
      attribute.setValueClass("org.instantlogic.fabric.model.Attribute");
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Attribute").getTextTemplate());
      castToEntity.setName("toEntity");
      castToEntity.setValueClass("org.instantlogic.fabric.model.Entity");
	  castToEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("To entity").getTextTemplate());
      constantValue.setName("value");
      constantValue.setValueClass("java.lang.Object");
	  constantValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate());
      reverseRelationRelation.setValueClass("org.instantlogic.fabric.model.Relation");
      reverseRelationRelation.setName("relation");
	  reverseRelationRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Relation").getTextTemplate());
      selectedInstanceEntity.setName("ofEntity");
      selectedInstanceEntity.setValueClass("org.instantlogic.fabric.model.Entity");
	  selectedInstanceEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Of entity").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionOperationParameterDesign, java.lang.String> valueClass
		= createAttributeValue(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.valueClass);
	
	public java.lang.String getValueClass() {
		return valueClass.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionOperationParameterDesign, java.lang.String> getValueClassAttributeValue() {
		return valueClass;
	}

	public DeductionOperationParameterDesign setValueClass(java.lang.String newValue) {
		valueClass.setValue(newValue);
		return (DeductionOperationParameterDesign)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionOperationParameterDesign, DeductionParameterDesign> operationParameterOnDeductionParameterDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operationParameterOnDeductionParameterDesign);

	public org.instantlogic.fabric.value.RelationValues<DeductionOperationParameterDesign, DeductionParameterDesign> getOperationParameterOnDeductionParameterDesignRelationValue() {
		return operationParameterOnDeductionParameterDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign> getOperationParameterOnDeductionParameterDesign() {
		return operationParameterOnDeductionParameterDesign.getValue();
	}

    public DeductionOperationParameterDesign addToOperationParameterOnDeductionParameterDesign(DeductionParameterDesign item) {
        operationParameterOnDeductionParameterDesign.addValue(item);
        return (DeductionOperationParameterDesign)this;
    }

    public DeductionOperationParameterDesign removeFromOperationParameterOnDeductionParameterDesign(DeductionParameterDesign item) {
        operationParameterOnDeductionParameterDesign.removeValue(item);
        return (DeductionOperationParameterDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionOperationParameterDesign, DeductionOperationDesign> operation
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operation);

	public org.instantlogic.fabric.value.RelationValue<DeductionOperationParameterDesign, DeductionOperationDesign> getOperationRelationValue() {
		return operation;
	}

	public org.instantlogic.designer.DeductionOperationDesign getOperation() {
		return operation.getValue();
	}

    public DeductionOperationParameterDesign setOperation(org.instantlogic.designer.DeductionOperationDesign newValue) {
        operation.setValue(newValue);
        return (DeductionOperationParameterDesign)this;
    }


}
