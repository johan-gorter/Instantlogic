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
public abstract class AbstractDeductionDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionDesign>();
	
	public static java.util.Map<String, DeductionDesign> getStaticDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionDesign addStaticInstance(String name, DeductionDesign instance) {
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
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionDesign, DataTypeDesign> dataType
		= createRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.dataType);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionDesign, DataTypeDesign> getDataTypeRelationValue() {
		return dataType;
	}

	public org.instantlogic.designer.DataTypeDesign getDataType() {
		return dataType.getValue();
	}
	
	public DeductionDesign setDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		dataType.setValue(newValue);
		return (DeductionDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionInputDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionInputDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionDesign addToInputs(DeductionInputDesign item) {
		inputs.addValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign addToInputs(DeductionInputDesign item, int index) {
		inputs.insertValue(item, index);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(DeductionInputDesign item) {
		inputs.removeValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(int index) {
		inputs.removeValue(index);
		return (DeductionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionOperationDesign> operation
		= createRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.operation);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionOperationDesign> getOperationRelationValue() {
		return operation;
	}

	public org.instantlogic.designer.DeductionOperationDesign getOperation() {
		return operation.getValue();
	}
	
	public DeductionDesign setOperation(org.instantlogic.designer.DeductionOperationDesign newValue) {
		operation.setValue(newValue);
		return (DeductionDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionParameterDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionParameterDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionParameterDesign> getParameters() {
		return parameters.getValue();
	}
	
	public DeductionDesign addToParameters(DeductionParameterDesign item) {
		parameters.addValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign addToParameters(DeductionParameterDesign item, int index) {
		parameters.insertValue(item, index);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromParameters(DeductionParameterDesign item) {
		parameters.removeValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (DeductionDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionInputDesign> outputs
		= createReverseRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);

	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionInputDesign> getOutputsRelationValue() {
		return outputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign> getOutputs() {
		return outputs.getValue();
	}

    public DeductionDesign addToOutputs(DeductionInputDesign item) {
        outputs.addValue(item);
        return (DeductionDesign)this;
    }

    public DeductionDesign removeFromOutputs(DeductionInputDesign item) {
        outputs.removeValue(item);
        return (DeductionDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionSchemeDesign> scheme
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);

	public org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionSchemeDesign> getSchemeRelationValue() {
		return scheme;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getScheme() {
		return scheme.getValue();
	}

    public DeductionDesign setScheme(org.instantlogic.designer.DeductionSchemeDesign newValue) {
        scheme.setValue(newValue);
        return (DeductionDesign)this;
    }


}
