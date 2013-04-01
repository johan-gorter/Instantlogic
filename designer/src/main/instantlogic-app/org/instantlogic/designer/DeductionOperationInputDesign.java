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
	
	public static final DeductionOperationInputDesign attributeInstance;
	public static final DeductionOperationInputDesign castInstance;
	public static final DeductionOperationInputDesign equalsOperands;
	public static final DeductionOperationInputDesign hasValueInput;
	public static final DeductionOperationInputDesign negationInput;
	public static final DeductionOperationInputDesign reverseRelationToInstance;
	public static final DeductionOperationInputDesign sumOperands;
	
	static {
	  // Phase 1
	  attributeInstance = addStaticInstance("attributeInstance", new DeductionOperationInputDesign());
	  castInstance = addStaticInstance("castInstance", new DeductionOperationInputDesign());
	  equalsOperands = addStaticInstance("equalsOperands", new DeductionOperationInputDesign());
	  hasValueInput = addStaticInstance("hasValueInput", new DeductionOperationInputDesign());
	  negationInput = addStaticInstance("negationInput", new DeductionOperationInputDesign());
	  reverseRelationToInstance = addStaticInstance("reverseRelationToInstance", new DeductionOperationInputDesign());
	  sumOperands = addStaticInstance("sumOperands", new DeductionOperationInputDesign());
	  // Phase 2
      attributeInstance.setName("instance");
	  attributeInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Instance")));
      castInstance.setName("instance");
	  castInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Instance")));
      equalsOperands.setName("operands");
      equalsOperands.setMultivalue(true);
	  equalsOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Operands")));
      hasValueInput.setName("input");
	  hasValueInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Input")));
      negationInput.setName("input");
	  negationInput.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Input")));
      reverseRelationToInstance.setName("toInstance");
	  reverseRelationToInstance.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("To instance")));
      sumOperands.setName("operands");
      sumOperands.setMultivalue(true);
	  sumOperands.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Operands")));
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
