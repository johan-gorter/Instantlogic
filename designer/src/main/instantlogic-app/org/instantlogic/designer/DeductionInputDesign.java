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
public class DeductionInputDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DeductionInputDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionInputDesign>();
	
	public static java.util.Map<String, DeductionInputDesign> getStaticDeductionInputDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionInputDesign addStaticInstance(String name, DeductionInputDesign instance) {
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
		return org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionInputDesign, DeductionDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionInputDesign, DeductionDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionInputDesign addToInputs(DeductionDesign item) {
		inputs.addValue(item);
		return (DeductionInputDesign)this;
	}
	
	public DeductionInputDesign addToInputs(DeductionDesign item, int index) {
		inputs.insertValue(item, index);
		return (DeductionInputDesign)this;
	}
	
	public DeductionInputDesign removeFromInputs(DeductionDesign item) {
		inputs.removeValue(item);
		return (DeductionInputDesign)this;
	}
	
	public DeductionInputDesign removeFromInputs(int index) {
		inputs.removeValue(index);
		return (DeductionInputDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionInputDesign, DeductionOperationInputDesign> operationInput
		= createRelationValue(org.instantlogic.designer.entity.DeductionInputDesignEntity.operationInput);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionInputDesign, DeductionOperationInputDesign> getOperationInputRelationValue() {
		return operationInput;
	}

	public org.instantlogic.designer.DeductionOperationInputDesign getOperationInput() {
		return operationInput.getValue();
	}
	
	public DeductionInputDesign setOperationInput(org.instantlogic.designer.DeductionOperationInputDesign newValue) {
		operationInput.setValue(newValue);
		return (DeductionInputDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionInputDesign, DeductionDesign> deduction
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionInputDesignEntity.deduction);

	public org.instantlogic.fabric.value.RelationValue<DeductionInputDesign, DeductionDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionDesign getDeduction() {
		return deduction.getValue();
	}

    public DeductionInputDesign setDeduction(org.instantlogic.designer.DeductionDesign newValue) {
        deduction.setValue(newValue);
        return (DeductionInputDesign)this;
    }


}
