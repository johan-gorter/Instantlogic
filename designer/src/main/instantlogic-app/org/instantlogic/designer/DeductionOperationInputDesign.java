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
	
	public static final DeductionOperationInputDesign reverseRelationToInstance;
	public static final DeductionOperationInputDesign titleOfInstance;
	public static final DeductionOperationInputDesign sumOperands;
	public static final DeductionOperationInputDesign attributeInstance;
	public static final DeductionOperationInputDesign idOfInstance;
	public static final DeductionOperationInputDesign ifTrueValue;
	public static final DeductionOperationInputDesign ifFalseValue;
	public static final DeductionOperationInputDesign concatenateStrings;
	public static final DeductionOperationInputDesign equalsOperands;
	public static final DeductionOperationInputDesign ifCondition;
	public static final DeductionOperationInputDesign negationInput;
	public static final DeductionOperationInputDesign castInstance;
	public static final DeductionOperationInputDesign hasValueInput;
	
	static {
	  // Phase 1
	  reverseRelationToInstance = addStaticInstance("reverseRelationToInstance", new DeductionOperationInputDesign());
	  titleOfInstance = addStaticInstance("titleOfInstance", new DeductionOperationInputDesign());
	  sumOperands = addStaticInstance("sumOperands", new DeductionOperationInputDesign());
	  attributeInstance = addStaticInstance("attributeInstance", new DeductionOperationInputDesign());
	  idOfInstance = addStaticInstance("idOfInstance", new DeductionOperationInputDesign());
	  ifTrueValue = addStaticInstance("ifTrueValue", new DeductionOperationInputDesign());
	  ifFalseValue = addStaticInstance("ifFalseValue", new DeductionOperationInputDesign());
	  concatenateStrings = addStaticInstance("concatenateStrings", new DeductionOperationInputDesign());
	  equalsOperands = addStaticInstance("equalsOperands", new DeductionOperationInputDesign());
	  ifCondition = addStaticInstance("ifCondition", new DeductionOperationInputDesign());
	  negationInput = addStaticInstance("negationInput", new DeductionOperationInputDesign());
	  castInstance = addStaticInstance("castInstance", new DeductionOperationInputDesign());
	  hasValueInput = addStaticInstance("hasValueInput", new DeductionOperationInputDesign());
	  // Phase 2
      reverseRelationToInstance.setName("toInstance");
	  reverseRelationToInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("To instance").getTextTemplate());
      titleOfInstance.setName("titleOfInstance");
	  titleOfInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Title of instance").getTextTemplate());
      sumOperands.setMultivalue(true);
      sumOperands.setMultivalue(true);
      sumOperands.setName("operands");
	  sumOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Operands").getTextTemplate());
      attributeInstance.setName("instance");
	  attributeInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Instance").getTextTemplate());
      idOfInstance.setName("idOfInstance");
	  idOfInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Id of instance").getTextTemplate());
      ifTrueValue.setName("trueValue");
      ifTrueValue.setDiagramPosition("primary");
	  ifTrueValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("trueValue").getTextTemplate());
      ifFalseValue.setDiagramPosition("secondary");
      ifFalseValue.setName("falseValue");
	  ifFalseValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("falseValue").getTextTemplate());
      concatenateStrings.setName("strings");
      concatenateStrings.setMultivalue(true);
	  concatenateStrings.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Strings").getTextTemplate());
      equalsOperands.setName("operands");
      equalsOperands.setMultivalue(true);
	  equalsOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Operands").getTextTemplate());
      ifCondition.setName("condition");
      ifCondition.setDiagramPosition("control");
	  ifCondition.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Condition").getTextTemplate());
      negationInput.setName("input");
	  negationInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Input").getTextTemplate());
      castInstance.setName("instance");
	  castInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Instance").getTextTemplate());
      hasValueInput.setName("input");
	  hasValueInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Input").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionOperationInputDesign, java.lang.String> diagramPosition
		= createAttributeValue(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.diagramPosition);
	
	public java.lang.String getDiagramPosition() {
		return diagramPosition.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionOperationInputDesign, java.lang.String> getDiagramPositionAttributeValue() {
		return diagramPosition;
	}

	public DeductionOperationInputDesign setDiagramPosition(java.lang.String newValue) {
		diagramPosition.setValue(newValue);
		return (DeductionOperationInputDesign)this;
	}
	
	
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
