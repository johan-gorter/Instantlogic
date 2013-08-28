package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DeductionOperationDesign extends Design { 

	private static final java.util.Map<String, DeductionOperationDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionOperationDesign>();
	
	public static java.util.Map<String, DeductionOperationDesign> getStaticDeductionOperationDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionOperationDesign addStaticInstance(String name, DeductionOperationDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DeductionOperationDesign cast;
	public static final DeductionOperationDesign reverseRelation;
	public static final DeductionOperationDesign equals;
	public static final DeductionOperationDesign hasValue;
	public static final DeductionOperationDesign first;
	public static final DeductionOperationDesign concatenate;
	public static final DeductionOperationDesign negation;
	public static final DeductionOperationDesign _if;
	public static final DeductionOperationDesign attribute;
	public static final DeductionOperationDesign constant;
	public static final DeductionOperationDesign selectedInstance;
	public static final DeductionOperationDesign sum;
	public static final DeductionOperationDesign id;
	public static final DeductionOperationDesign custom;
	
	static {
	  // Phase 1
	  cast = addStaticInstance("cast", new DeductionOperationDesign());
	  reverseRelation = addStaticInstance("reverseRelation", new DeductionOperationDesign());
	  equals = addStaticInstance("equals", new DeductionOperationDesign());
	  hasValue = addStaticInstance("hasValue", new DeductionOperationDesign());
	  first = addStaticInstance("first", new DeductionOperationDesign());
	  concatenate = addStaticInstance("concatenate", new DeductionOperationDesign());
	  negation = addStaticInstance("negation", new DeductionOperationDesign());
	  _if = addStaticInstance("if", new DeductionOperationDesign());
	  attribute = addStaticInstance("attribute", new DeductionOperationDesign());
	  constant = addStaticInstance("constant", new DeductionOperationDesign());
	  selectedInstance = addStaticInstance("selectedInstance", new DeductionOperationDesign());
	  sum = addStaticInstance("sum", new DeductionOperationDesign());
	  id = addStaticInstance("id", new DeductionOperationDesign());
	  custom = addStaticInstance("custom", new DeductionOperationDesign());
	  // Phase 2
      cast.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.castToEntity);
      cast.setName("cast");
      cast.setJavaClassName("org.instantlogic.fabric.deduction.CastInstanceDeduction");
      cast.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.castInstance);
	  cast.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Cast").getTextTemplate());
      reverseRelation.setJavaClassName("org.instantlogic.fabric.deduction.ReverseRelationDeduction");
      reverseRelation.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.reverseRelationToInstance);
      reverseRelation.setName("reverseRelation");
	  reverseRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Reverse relation").getTextTemplate());
      equals.setName("equals");
      equals.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.equalsOperands);
      equals.setJavaClassName("org.instantlogic.fabric.deduction.EqualsDeduction");
	  equals.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Equals").getTextTemplate());
      hasValue.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.hasValueInput);
      hasValue.setJavaClassName("org.instantlogic.fabric.deduction.HasValueDeduction");
      hasValue.setName("hasValue");
	  hasValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Has value").getTextTemplate());
	  first.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("First").getTextTemplate());
      concatenate.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.concatenateStrings);
      concatenate.setJavaClassName("org.instantlogic.fabric.deduction.ConcatenateDeduction");
      concatenate.setName("concatenate");
	  concatenate.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Concatenate").getTextTemplate());
      negation.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.negationInput);
      negation.setJavaClassName("org.instantlogic.fabric.deduction.NegationDeduction");
      negation.setName("negation");
	  negation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Negation").getTextTemplate());
      _if.setName("if");
      _if.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.ifCondition);
      _if.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.ifTrueValue);
      _if.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.ifFalseValue);
      _if.setJavaClassName("org.instantlogic.fabric.deduction.IfDeduction");
	  _if.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("If").getTextTemplate());
      attribute.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.attribute);
      attribute.setJavaClassName("org.instantlogic.fabric.deduction.AttributeDeduction");
      attribute.setName("attribute");
      attribute.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.attributeInstance);
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Attribute").getTextTemplate());
      constant.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.constantValue);
      constant.setName("constant");
      constant.setJavaClassName("org.instantlogic.fabric.deduction.ConstantDeduction");
	  constant.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Constant").getTextTemplate());
      selectedInstance.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.selectedInstanceEntity);
      selectedInstance.setJavaClassName("org.instantlogic.fabric.deduction.SelectedInstanceDeduction");
      selectedInstance.setName("selectedInstance");
	  selectedInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Selected instance").getTextTemplate());
      sum.setName("sum");
      sum.setJavaClassName("org.instantlogic.fabric.deduction.SumDeduction");
      sum.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.sumOperands);
	  sum.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Sum").getTextTemplate());
      id.setName("id");
      id.setJavaClassName("org.instantlogic.fabric.deduction.IdDeduction");
      id.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.idOfInstance);
	  id.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Id").getTextTemplate());
      custom.setName("custom");
      custom.setJavaClassName("org.instantlogic.fabric.deduction.CustomDeduction");
	  custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Custom").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionOperationDesign, java.lang.String> javaClassName
		= createAttributeValue(org.instantlogic.designer.entity.DeductionOperationDesignEntity.javaClassName);
	
	public java.lang.String getJavaClassName() {
		return javaClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionOperationDesign, java.lang.String> getJavaClassNameAttributeValue() {
		return javaClassName;
	}

	public DeductionOperationDesign setJavaClassName(java.lang.String newValue) {
		javaClassName.setValue(newValue);
		return (DeductionOperationDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationParameterDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.DeductionOperationDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationParameterDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign> getParameters() {
		return parameters.getValue();
	}
	
	public DeductionOperationDesign addToParameters(DeductionOperationParameterDesign item) {
		parameters.addValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromParameters(DeductionOperationParameterDesign item) {
		parameters.removeValue(item);
		return (DeductionOperationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionOperationDesign, DataTypeDesign> outputDataType
		= createRelationValue(org.instantlogic.designer.entity.DeductionOperationDesignEntity.outputDataType);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionOperationDesign, DataTypeDesign> getOutputDataTypeRelationValue() {
		return outputDataType;
	}

	public org.instantlogic.designer.DataTypeDesign getOutputDataType() {
		return outputDataType.getValue();
	}
	
	public DeductionOperationDesign setOutputDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		outputDataType.setValue(newValue);
		return (DeductionOperationDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationInputDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionOperationDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationInputDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionOperationDesign addToInputs(DeductionOperationInputDesign item) {
		inputs.addValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromInputs(DeductionOperationInputDesign item) {
		inputs.removeValue(item);
		return (DeductionOperationDesign)this;
	}
	
	

	// Reverse relations

}
