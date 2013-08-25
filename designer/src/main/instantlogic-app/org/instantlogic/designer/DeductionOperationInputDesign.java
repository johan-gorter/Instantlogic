package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DeductionOperationInputDesign extends Design { 

	private static final java.util.Map<String, DeductionOperationInputDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionOperationInputDesign>();
	
	public static java.util.Map<String, DeductionOperationInputDesign> getStaticDeductionOperationInputDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionOperationInputDesign addStaticInstance(String name, DeductionOperationInputDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DeductionOperationInputDesign idOfInstance;
	public static final DeductionOperationInputDesign attributeInstance;
	public static final DeductionOperationInputDesign negationInput;
	public static final DeductionOperationInputDesign ifCondition;
	public static final DeductionOperationInputDesign concatenateStrings;
	public static final DeductionOperationInputDesign hasValueInput;
	public static final DeductionOperationInputDesign sumOperands;
	public static final DeductionOperationInputDesign equalsOperands;
	public static final DeductionOperationInputDesign titleOfInstance;
	public static final DeductionOperationInputDesign castInstance;
	public static final DeductionOperationInputDesign ifTrueValue;
	public static final DeductionOperationInputDesign reverseRelationToInstance;
	public static final DeductionOperationInputDesign ifFalseValue;
	
	static {
	  // Phase 1
	  idOfInstance = addStaticInstance("idOfInstance", new DeductionOperationInputDesign());
	  attributeInstance = addStaticInstance("attributeInstance", new DeductionOperationInputDesign());
	  negationInput = addStaticInstance("negationInput", new DeductionOperationInputDesign());
	  ifCondition = addStaticInstance("ifCondition", new DeductionOperationInputDesign());
	  concatenateStrings = addStaticInstance("concatenateStrings", new DeductionOperationInputDesign());
	  hasValueInput = addStaticInstance("hasValueInput", new DeductionOperationInputDesign());
	  sumOperands = addStaticInstance("sumOperands", new DeductionOperationInputDesign());
	  equalsOperands = addStaticInstance("equalsOperands", new DeductionOperationInputDesign());
	  titleOfInstance = addStaticInstance("titleOfInstance", new DeductionOperationInputDesign());
	  castInstance = addStaticInstance("castInstance", new DeductionOperationInputDesign());
	  ifTrueValue = addStaticInstance("ifTrueValue", new DeductionOperationInputDesign());
	  reverseRelationToInstance = addStaticInstance("reverseRelationToInstance", new DeductionOperationInputDesign());
	  ifFalseValue = addStaticInstance("ifFalseValue", new DeductionOperationInputDesign());
	  // Phase 2
      idOfInstance.setName("idOfInstance");
	  idOfInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Id of instance").getTextTemplate());
      attributeInstance.setName("instance");
	  attributeInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Instance").getTextTemplate());
      negationInput.setName("input");
	  negationInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Input").getTextTemplate());
      ifCondition.setName("condition");
	  ifCondition.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Condition").getTextTemplate());
      concatenateStrings.setMultivalue(true);
      concatenateStrings.setName("strings");
	  concatenateStrings.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Strings").getTextTemplate());
      hasValueInput.setName("input");
	  hasValueInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Input").getTextTemplate());
      sumOperands.setMultivalue(true);
      sumOperands.setName("operands");
      sumOperands.setMultivalue(true);
	  sumOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Operands").getTextTemplate());
      equalsOperands.setName("operands");
      equalsOperands.setMultivalue(true);
	  equalsOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Operands").getTextTemplate());
      titleOfInstance.setName("titleOfInstance");
	  titleOfInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Title of instance").getTextTemplate());
      castInstance.setName("instance");
	  castInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Instance").getTextTemplate());
      ifTrueValue.setName("trueValue");
	  ifTrueValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("trueValue").getTextTemplate());
      reverseRelationToInstance.setName("toInstance");
	  reverseRelationToInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("To instance").getTextTemplate());
      ifFalseValue.setName("falseValue");
	  ifFalseValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("falseValue").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionOperationInputDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionOperationInputDesign, java.lang.Boolean> getMultivalueAttributeValue() {
		return multivalue;
	}

	public DeductionOperationInputDesign setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
		return (DeductionOperationInputDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionOperationInputDesign, DataTypeDesign> dataType
		= createRelationValue(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.dataType);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionOperationInputDesign, DataTypeDesign> getDataTypeRelationValue() {
		return dataType;
	}

	public org.instantlogic.designer.DataTypeDesign getDataType() {
		return dataType.getValue();
	}
	
	public DeductionOperationInputDesign setDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		dataType.setValue(newValue);
		return (DeductionOperationInputDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionOperationInputDesign, DeductionOperationDesign> operation
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.operation);

	public org.instantlogic.fabric.value.RelationValue<DeductionOperationInputDesign, DeductionOperationDesign> getOperationRelationValue() {
		return operation;
	}

	public org.instantlogic.designer.DeductionOperationDesign getOperation() {
		return operation.getValue();
	}

    public DeductionOperationInputDesign setOperation(org.instantlogic.designer.DeductionOperationDesign newValue) {
        operation.setValue(newValue);
        return (DeductionOperationInputDesign)this;
    }


}
