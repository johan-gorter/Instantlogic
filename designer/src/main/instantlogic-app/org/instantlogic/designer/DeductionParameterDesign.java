package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DeductionParameterDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DeductionParameterDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionParameterDesign>();
	
	public static java.util.Map<String, DeductionParameterDesign> getStaticDeductionParameterDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionParameterDesign addStaticInstance(String name, DeductionParameterDesign instance) {
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
		return org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DeductionParameterDesign, java.lang.Object> value
		= createAttributeValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.value);
	
	public java.lang.Object getValue() {
		return value.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DeductionParameterDesign, java.lang.Object> getValueAttributeValue() {
		return value;
	}

	public DeductionParameterDesign setValue(java.lang.Object newValue) {
		value.setValue(newValue);
		return (DeductionParameterDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<DeductionParameterDesign, java.lang.String> valueDescription
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.valueDescription);
	
	public java.lang.String getValueDescription() {
		return valueDescription.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<DeductionParameterDesign, java.lang.String> getValueDescriptionAttributeValue() {
		return valueDescription;
	}

	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, AttributeDesign> attributeValue
		= createRelationValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.attributeValue);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, AttributeDesign> getAttributeValueRelationValue() {
		return attributeValue;
	}

	public org.instantlogic.designer.AttributeDesign getAttributeValue() {
		return attributeValue.getValue();
	}
	
	public DeductionParameterDesign setAttributeValue(org.instantlogic.designer.AttributeDesign newValue) {
		attributeValue.setValue(newValue);
		return (DeductionParameterDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, EntityDesign> entityValue
		= createRelationValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.entityValue);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, EntityDesign> getEntityValueRelationValue() {
		return entityValue;
	}

	public org.instantlogic.designer.EntityDesign getEntityValue() {
		return entityValue.getValue();
	}
	
	public DeductionParameterDesign setEntityValue(org.instantlogic.designer.EntityDesign newValue) {
		entityValue.setValue(newValue);
		return (DeductionParameterDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, StaticInstanceDesign> staticInstanceValue
		= createRelationValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.staticInstanceValue);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, StaticInstanceDesign> getStaticInstanceValueRelationValue() {
		return staticInstanceValue;
	}

	public org.instantlogic.designer.StaticInstanceDesign getStaticInstanceValue() {
		return staticInstanceValue.getValue();
	}
	
	public DeductionParameterDesign setStaticInstanceValue(org.instantlogic.designer.StaticInstanceDesign newValue) {
		staticInstanceValue.setValue(newValue);
		return (DeductionParameterDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, DeductionOperationParameterDesign> operationParameter
		= createRelationValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.operationParameter);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, DeductionOperationParameterDesign> getOperationParameterRelationValue() {
		return operationParameter;
	}

	public org.instantlogic.designer.DeductionOperationParameterDesign getOperationParameter() {
		return operationParameter.getValue();
	}
	
	public DeductionParameterDesign setOperationParameter(org.instantlogic.designer.DeductionOperationParameterDesign newValue) {
		operationParameter.setValue(newValue);
		return (DeductionParameterDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, DeductionDesign> deduction
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionParameterDesignEntity.deduction);

	public org.instantlogic.fabric.value.RelationValue<DeductionParameterDesign, DeductionDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionDesign getDeduction() {
		return deduction.getValue();
	}

    public DeductionParameterDesign setDeduction(org.instantlogic.designer.DeductionDesign newValue) {
        deduction.setValue(newValue);
        return (DeductionParameterDesign)this;
    }


}
