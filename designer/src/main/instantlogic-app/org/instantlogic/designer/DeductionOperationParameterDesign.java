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
	
	public static final DeductionOperationParameterDesign selectedInstanceEntity;
	public static final DeductionOperationParameterDesign constantValue;
	public static final DeductionOperationParameterDesign reverseRelationRelation;
	public static final DeductionOperationParameterDesign attribute;
	public static final DeductionOperationParameterDesign castToEntity;
	
	static {
	  // Phase 1
	  selectedInstanceEntity = addStaticInstance("selectedInstanceEntity", new DeductionOperationParameterDesign());
	  constantValue = addStaticInstance("constantValue", new DeductionOperationParameterDesign());
	  reverseRelationRelation = addStaticInstance("reverseRelationRelation", new DeductionOperationParameterDesign());
	  attribute = addStaticInstance("attribute", new DeductionOperationParameterDesign());
	  castToEntity = addStaticInstance("castToEntity", new DeductionOperationParameterDesign());
	  // Phase 2
      selectedInstanceEntity.setName("ofEntity");
      selectedInstanceEntity.setValueClass("org.instantlogic.fabric.model.Entity");
	  selectedInstanceEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Of entity").getTextTemplate());
      constantValue.setValueClass("java.lang.Object");
      constantValue.setName("value");
	  constantValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Value").getTextTemplate());
      reverseRelationRelation.setValueClass("org.instantlogic.fabric.model.Relation");
      reverseRelationRelation.setName("relation");
	  reverseRelationRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Relation").getTextTemplate());
      attribute.setName("attribute");
      attribute.setValueClass("org.instantlogic.fabric.model.Attribute");
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Attribute").getTextTemplate());
      castToEntity.setValueClass("org.instantlogic.fabric.model.Entity");
      castToEntity.setName("toEntity");
	  castToEntity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("To entity").getTextTemplate());
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
