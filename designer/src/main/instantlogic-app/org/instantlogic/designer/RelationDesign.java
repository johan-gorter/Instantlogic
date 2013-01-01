package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class RelationDesign extends AttributeDesign { 

	private static final java.util.Map<String, RelationDesign> _staticInstances = new java.util.LinkedHashMap<String, RelationDesign>();
	
	public static java.util.Map<String, RelationDesign> getStaticRelationDesignInstances() {
		return _staticInstances;
	}
	
	private static RelationDesign addStaticInstance(String name, RelationDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> autoCreate
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.autoCreate);
	
	public java.lang.Boolean getAutoCreate() {
		return autoCreate.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getAutoCreateAttributeValue() {
		return autoCreate;
	}

	public RelationDesign setAutoCreate(java.lang.Boolean newValue) {
		autoCreate.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> hasOptions
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.hasOptions);
	
	public java.lang.Boolean getHasOptions() {
		return hasOptions.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getHasOptionsAttributeValue() {
		return hasOptions;
	}

	public RelationDesign setHasOptions(java.lang.Boolean newValue) {
		hasOptions.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> owner
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.owner);
	
	public java.lang.Boolean getOwner() {
		return owner.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getOwnerAttributeValue() {
		return owner;
	}

	public RelationDesign setOwner(java.lang.Boolean newValue) {
		owner.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<RelationDesign, java.lang.String> reverseJavaIdentifier
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseJavaIdentifier);
	
	public java.lang.String getReverseJavaIdentifier() {
		return reverseJavaIdentifier.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<RelationDesign, java.lang.String> getReverseJavaIdentifierAttributeValue() {
		return reverseJavaIdentifier;
	}

	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> reverseMultivalue
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseMultivalue);
	
	public java.lang.Boolean getReverseMultivalue() {
		return reverseMultivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.Boolean> getReverseMultivalueAttributeValue() {
		return reverseMultivalue;
	}

	public RelationDesign setReverseMultivalue(java.lang.Boolean newValue) {
		reverseMultivalue.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> reverseName
		= createAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseName);
	
	public java.lang.String getReverseName() {
		return reverseName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<RelationDesign, java.lang.String> getReverseNameAttributeValue() {
		return reverseName;
	}

	public RelationDesign setReverseName(java.lang.String newValue) {
		reverseName.setValue(newValue);
		return (RelationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<RelationDesign, java.lang.String> reverseTechnicalName
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseTechnicalName);
	
	public java.lang.String getReverseTechnicalName() {
		return reverseTechnicalName.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<RelationDesign, java.lang.String> getReverseTechnicalNameAttributeValue() {
		return reverseTechnicalName;
	}

	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, DeductionSchemeDesign> options
		= createRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.options);
		
	public org.instantlogic.fabric.value.RelationValue<RelationDesign, DeductionSchemeDesign> getOptionsRelationValue() {
		return options;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getOptions() {
		return options.getValue();
	}
	
	public RelationDesign setOptions(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		options.setValue(newValue);
		return (RelationDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newOptions() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		options.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, DataTypeDesign> reverseDataType
		= createRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType);
		
	public org.instantlogic.fabric.value.RelationValue<RelationDesign, DataTypeDesign> getReverseDataTypeRelationValue() {
		return reverseDataType;
	}

	public org.instantlogic.designer.DataTypeDesign getReverseDataType() {
		return reverseDataType.getValue();
	}
	
	public RelationDesign setReverseDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		reverseDataType.setValue(newValue);
		return (RelationDesign)this;
	}
	
	public org.instantlogic.designer.DataTypeDesign newReverseDataType() {
		org.instantlogic.designer.DataTypeDesign newValue = new org.instantlogic.designer.DataTypeDesign(); 
		reverseDataType.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> to
		= createRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.to);
		
	public org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> getToRelationValue() {
		return to;
	}

	public org.instantlogic.designer.EntityDesign getTo() {
		return to.getValue();
	}
	
	public RelationDesign setTo(org.instantlogic.designer.EntityDesign newValue) {
		to.setValue(newValue);
		return (RelationDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> from
		= createReverseRelationValue(org.instantlogic.designer.entity.RelationDesignEntity.from);

	public org.instantlogic.fabric.value.RelationValue<RelationDesign, EntityDesign> getFromRelationValue() {
		return from;
	}

	public org.instantlogic.designer.EntityDesign getFrom() {
		return from.getValue();
	}

    public RelationDesign setFrom(org.instantlogic.designer.EntityDesign newValue) {
        from.setValue(newValue);
        return (RelationDesign)this;
    }


}
