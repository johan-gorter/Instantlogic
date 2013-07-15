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
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, org.instantlogic.designer.util.diagram.Point2d> diagramPosition
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.diagramPosition);
	
	public org.instantlogic.designer.util.diagram.Point2d getDiagramPosition() {
		return diagramPosition.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, org.instantlogic.designer.util.diagram.Point2d> getDiagramPositionAttributeValue() {
		return diagramPosition;
	}

	public DeductionDesign setDiagramPosition(org.instantlogic.designer.util.diagram.Point2d newValue) {
		diagramPosition.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Double> diagramWidth
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.diagramWidth);
	
	public java.lang.Double getDiagramWidth() {
		return diagramWidth.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Double> getDiagramWidthAttributeValue() {
		return diagramWidth;
	}

	public DeductionDesign setDiagramWidth(java.lang.Double newValue) {
		diagramWidth.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Double> diagramHeight
		= createAttributeValue(org.instantlogic.designer.entity.DeductionDesignEntity.diagramHeight);
	
	public java.lang.Double getDiagramHeight() {
		return diagramHeight.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionDesign, java.lang.Double> getDiagramHeightAttributeValue() {
		return diagramHeight;
	}

	public DeductionDesign setDiagramHeight(java.lang.Double newValue) {
		diagramHeight.setValue(newValue);
		return (DeductionDesign)this;
	}
	
	
	// Relations
	
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
	
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionDesign, DeductionInputDesign> outputs
		= createRelationValues(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);
		
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
	
	public DeductionDesign addToOutputs(DeductionInputDesign item, int index) {
		outputs.insertValue(item, index);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromOutputs(DeductionInputDesign item) {
		outputs.removeValue(item);
		return (DeductionDesign)this;
	}
	
	public DeductionDesign removeFromOutputs(int index) {
		outputs.removeValue(index);
		return (DeductionDesign)this;
	}
	

	// Reverse relations
	
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

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionSchemeDesign> outputOfScheme
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionDesignEntity.outputOfScheme);

	public org.instantlogic.fabric.value.RelationValue<DeductionDesign, DeductionSchemeDesign> getOutputOfSchemeRelationValue() {
		return outputOfScheme;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getOutputOfScheme() {
		return outputOfScheme.getValue();
	}

    public DeductionDesign setOutputOfScheme(org.instantlogic.designer.DeductionSchemeDesign newValue) {
        outputOfScheme.setValue(newValue);
        return (DeductionDesign)this;
    }


}
