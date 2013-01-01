package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class ConstantDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, ConstantDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, ConstantDeductionDesign>();
	
	public static java.util.Map<String, ConstantDeductionDesign> getStaticConstantDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static ConstantDeductionDesign addStaticInstance(String name, ConstantDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ConstantDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ConstantDeductionDesign, java.lang.Object> value
		= createAttributeValue(org.instantlogic.designer.entity.ConstantDeductionDesignEntity.value);
	
	public java.lang.Object getValue() {
		return value.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ConstantDeductionDesign, java.lang.Object> getValueAttributeValue() {
		return value;
	}

	public ConstantDeductionDesign setValue(java.lang.Object newValue) {
		value.setValue(newValue);
		return (ConstantDeductionDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<ConstantDeductionDesign, DataTypeDesign> constantDataType
		= createRelationValue(org.instantlogic.designer.entity.ConstantDeductionDesignEntity.constantDataType);
		
	public org.instantlogic.fabric.value.RelationValue<ConstantDeductionDesign, DataTypeDesign> getConstantDataTypeRelationValue() {
		return constantDataType;
	}

	public org.instantlogic.designer.DataTypeDesign getConstantDataType() {
		return constantDataType.getValue();
	}
	
	public ConstantDeductionDesign setConstantDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		constantDataType.setValue(newValue);
		return (ConstantDeductionDesign)this;
	}
	
	public org.instantlogic.designer.DataTypeDesign newConstantDataType() {
		org.instantlogic.designer.DataTypeDesign newValue = new org.instantlogic.designer.DataTypeDesign(); 
		constantDataType.setValue(newValue);
		return newValue;
	}


	// Reverse relations

}
