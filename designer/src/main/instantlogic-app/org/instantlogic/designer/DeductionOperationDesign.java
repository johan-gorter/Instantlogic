/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
	
	public static final DeductionOperationDesign attribute;
	public static final DeductionOperationDesign cast;
	public static final DeductionOperationDesign constant;
	public static final DeductionOperationDesign custom;
	public static final DeductionOperationDesign equals;
	public static final DeductionOperationDesign first;
	public static final DeductionOperationDesign hasValue;
	public static final DeductionOperationDesign negation;
	public static final DeductionOperationDesign reverseRelation;
	public static final DeductionOperationDesign selectedInstance;
	public static final DeductionOperationDesign sum;
	
	static {
	  // Phase 1
	  attribute = addStaticInstance("attribute", new DeductionOperationDesign());
	  cast = addStaticInstance("cast", new DeductionOperationDesign());
	  constant = addStaticInstance("constant", new DeductionOperationDesign());
	  custom = addStaticInstance("custom", new DeductionOperationDesign());
	  equals = addStaticInstance("equals", new DeductionOperationDesign());
	  first = addStaticInstance("first", new DeductionOperationDesign());
	  hasValue = addStaticInstance("hasValue", new DeductionOperationDesign());
	  negation = addStaticInstance("negation", new DeductionOperationDesign());
	  reverseRelation = addStaticInstance("reverseRelation", new DeductionOperationDesign());
	  selectedInstance = addStaticInstance("selectedInstance", new DeductionOperationDesign());
	  sum = addStaticInstance("sum", new DeductionOperationDesign());
	  // Phase 2
      attribute.setJavaClassName("org.instantlogic.fabric.deduction.AttributeDeduction");
      attribute.setName("attribute");
      attribute.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.attributeInstance);
      attribute.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.attribute);
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Attribute")));
      cast.setJavaClassName("org.instantlogic.fabric.deduction.CastInstanceDeduction");
      cast.setName("cast");
      cast.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.castInstance);
      cast.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.castToEntity);
	  cast.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Cast")));
      constant.setJavaClassName("org.instantlogic.fabric.deduction.ConstantDeduction");
      constant.setName("constant");
      constant.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.constantValue);
	  constant.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Constant")));
      custom.setJavaClassName("org.instantlogic.fabric.deduction.CustomDeduction");
      custom.setName("custom");
	  custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Custom")));
      equals.setJavaClassName("org.instantlogic.fabric.deduction.EqualsDeduction");
      equals.setName("equals");
      equals.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.equalsOperands);
	  equals.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Equals")));
	  first.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("First")));
      hasValue.setJavaClassName("org.instantlogic.fabric.deduction.HasValueDeduction");
      hasValue.setName("hasValue");
      hasValue.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.hasValueInput);
	  hasValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Has value")));
      negation.setJavaClassName("org.instantlogic.fabric.deduction.NegationDeduction");
      negation.setName("negation");
      negation.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.negationInput);
	  negation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Negation")));
      reverseRelation.setJavaClassName("org.instantlogic.fabric.deduction.ReverseRelationDeduction");
      reverseRelation.setName("reverseRelation");
      reverseRelation.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.reverseRelationToInstance);
	  reverseRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Reverse relation")));
      selectedInstance.setJavaClassName("org.instantlogic.fabric.deduction.SelectedInstanceDeduction");
      selectedInstance.setName("selectedInstance");
      selectedInstance.addToParameters(org.instantlogic.designer.DeductionOperationParameterDesign.selectedInstanceEntity);
	  selectedInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Selected instance")));
      sum.setJavaClassName("org.instantlogic.fabric.deduction.SumDeduction");
      sum.setName("sum");
      sum.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.sumOperands);
	  sum.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Sum")));
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
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationInputDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionOperationDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationInputDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationInputDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionOperationDesign addToInputs(DeductionOperationInputDesign item) {
		inputs.addValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign addToInputs(DeductionOperationInputDesign item, int index) {
		inputs.insertValue(item, index);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromInputs(DeductionOperationInputDesign item) {
		inputs.removeValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromInputs(int index) {
		inputs.removeValue(index);
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
	

	
	private final org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationParameterDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.DeductionOperationDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionOperationDesign, DeductionOperationParameterDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationParameterDesign> getParameters() {
		return parameters.getValue();
	}
	
	public DeductionOperationDesign addToParameters(DeductionOperationParameterDesign item) {
		parameters.addValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign addToParameters(DeductionOperationParameterDesign item, int index) {
		parameters.insertValue(item, index);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromParameters(DeductionOperationParameterDesign item) {
		parameters.removeValue(item);
		return (DeductionOperationDesign)this;
	}
	
	public DeductionOperationDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (DeductionOperationDesign)this;
	}
	

	// Reverse relations

}
