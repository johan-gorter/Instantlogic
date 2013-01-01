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
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DataTypeDesign> dataType
		= createReadOnlyRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.dataType);
		
	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DeductionDesign, DataTypeDesign> getDataTypeRelationValue() {
		return dataType;
	}

	public org.instantlogic.designer.DataTypeDesign getDataType() {
		return dataType.getValue();
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> inputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> getInputsRelationValue() {
		return inputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getInputs() {
		return inputs.getValue();
	}
	
	public DeductionDesign addToInputs(DeductionDesign item) {
		inputs.addValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign addToInputs(DeductionDesign item, int index) {
		inputs.insertValue(item, index);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(DeductionDesign item) {
		inputs.removeValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromInputs(int index) {
		inputs.removeValue(index);
		return (DeductionDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> outputs
		= createReverseRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);

	public org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionDesign> getOutputsRelationValue() {
		return outputs;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getOutputs() {
		return outputs.getValue();
	}

    public DeductionDesign addToOutputs(DeductionDesign item) {
        outputs.addValue(item);
        return (DeductionDesign)this;
    }

    public DeductionDesign removeFromOutputs(DeductionDesign item) {
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
