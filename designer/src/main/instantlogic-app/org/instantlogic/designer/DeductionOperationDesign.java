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
	  hasValue = addStaticInstance("hasValue", new DeductionOperationDesign());
	  negation = addStaticInstance("negation", new DeductionOperationDesign());
	  reverseRelation = addStaticInstance("reverseRelation", new DeductionOperationDesign());
	  selectedInstance = addStaticInstance("selectedInstance", new DeductionOperationDesign());
	  sum = addStaticInstance("sum", new DeductionOperationDesign());
	  // Phase 2
      attribute.addToInputs(org.instantlogic.designer.DeductionOperationInputDesign.attributeInstance);
	  attribute.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Attribute")));
	  cast.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Cast")));
	  constant.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Constant")));
	  custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Custom")));
	  equals.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Equals")));
	  hasValue.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Has value")));
	  negation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Negation")));
	  reverseRelation.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Reverse relation")));
	  selectedInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Selected instance")));
	  sum.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Sum")));
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
	}

	// Attributes
	
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
	


	// Reverse relations

}
