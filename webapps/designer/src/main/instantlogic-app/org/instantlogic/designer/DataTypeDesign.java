package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DataTypeDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DataTypeDesign> _staticInstances = new java.util.LinkedHashMap<String, DataTypeDesign>();
	
	public static java.util.Map<String, DataTypeDesign> getStaticDataTypeDesignInstances() {
		return _staticInstances;
	}
	
	private static DataTypeDesign addStaticInstance(String name, DataTypeDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DataTypeDesign text;
	public static final DataTypeDesign _boolean;
	
	static {
	  // Phase 1
	  text = addStaticInstance("text", new DataTypeDesign());
	  _boolean = addStaticInstance("boolean", new DataTypeDesign());
	  // Phase 2
      text.setDataCategory(org.instantlogic.designer.DataCategoryDesign.text);
	  text.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Text").getTextTemplate());
      _boolean.setDataCategory(org.instantlogic.designer.DataCategoryDesign._boolean);
	  _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Boolean").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> ordered
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.ordered);
	
	public java.lang.Boolean getOrdered() {
		return ordered.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getOrderedAttributeValue() {
		return ordered;
	}

	public DataTypeDesign setOrdered(java.lang.Boolean newValue) {
		ordered.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.String> javaClassName
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.javaClassName);
	
	public java.lang.String getJavaClassName() {
		return javaClassName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.String> getJavaClassNameAttributeValue() {
		return javaClassName;
	}

	public DataTypeDesign setJavaClassName(java.lang.String newValue) {
		javaClassName.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> multivalue
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.multivalue);
	
	public java.lang.Boolean getMultivalue() {
		return multivalue.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getMultivalueAttributeValue() {
		return multivalue;
	}

	public DataTypeDesign setMultivalue(java.lang.Boolean newValue) {
		multivalue.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> formatted
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.formatted);
	
	public java.lang.Boolean getFormatted() {
		return formatted.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getFormattedAttributeValue() {
		return formatted;
	}

	public DataTypeDesign setFormatted(java.lang.Boolean newValue) {
		formatted.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> wholeNumber
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber);
	
	public java.lang.Boolean getWholeNumber() {
		return wholeNumber.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getWholeNumberAttributeValue() {
		return wholeNumber;
	}

	public DataTypeDesign setWholeNumber(java.lang.Boolean newValue) {
		wholeNumber.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> multiLine
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
	
	public java.lang.Boolean getMultiLine() {
		return multiLine.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getMultiLineAttributeValue() {
		return multiLine;
	}

	public DataTypeDesign setMultiLine(java.lang.Boolean newValue) {
		multiLine.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> exactRounding
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.exactRounding);
	
	public java.lang.Boolean getExactRounding() {
		return exactRounding.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getExactRoundingAttributeValue() {
		return exactRounding;
	}

	public DataTypeDesign setExactRounding(java.lang.Boolean newValue) {
		exactRounding.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> percentage
		= createAttributeValue(org.instantlogic.designer.entity.DataTypeDesignEntity.percentage);
	
	public java.lang.Boolean getPercentage() {
		return percentage.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<DataTypeDesign, java.lang.Boolean> getPercentageAttributeValue() {
		return percentage;
	}

	public DataTypeDesign setPercentage(java.lang.Boolean newValue) {
		percentage.setValue(newValue);
		return (DataTypeDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, DataCategoryDesign> dataCategory
		= createRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		
	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, DataCategoryDesign> getDataCategoryRelationValue() {
		return dataCategory;
	}

	public org.instantlogic.designer.DataCategoryDesign getDataCategory() {
		return dataCategory.getValue();
	}
	
	public DataTypeDesign setDataCategory(org.instantlogic.designer.DataCategoryDesign newValue) {
		dataCategory.setValue(newValue);
		return (DataTypeDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<DataTypeDesign, EntityDesign> entity
		= createReadOnlyRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.entity);
		
	public org.instantlogic.fabric.value.ReadOnlyRelationValue<DataTypeDesign, EntityDesign> getEntityRelationValue() {
		return entity;
	}

	public org.instantlogic.designer.EntityDesign getEntity() {
		return entity.getValue();
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, AttributeDesign> attribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.attribute);

	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, AttributeDesign> getAttributeRelationValue() {
		return attribute;
	}

	public org.instantlogic.designer.AttributeDesign getAttribute() {
		return attribute.getValue();
	}

    public DataTypeDesign setAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        attribute.setValue(newValue);
        return (DataTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, EntityDesign> forEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.forEntity);

	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, EntityDesign> getForEntityRelationValue() {
		return forEntity;
	}

	public org.instantlogic.designer.EntityDesign getForEntity() {
		return forEntity.getValue();
	}

    public DataTypeDesign setForEntity(org.instantlogic.designer.EntityDesign newValue) {
        forEntity.setValue(newValue);
        return (DataTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionOperationInputDesign> dataTypeOnDeductionOperationInputDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.DataTypeDesignEntity.dataTypeOnDeductionOperationInputDesign);

	public org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionOperationInputDesign> getDataTypeOnDeductionOperationInputDesignRelationValue() {
		return dataTypeOnDeductionOperationInputDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign> getDataTypeOnDeductionOperationInputDesign() {
		return dataTypeOnDeductionOperationInputDesign.getValue();
	}

    public DataTypeDesign addToDataTypeOnDeductionOperationInputDesign(DeductionOperationInputDesign item) {
        dataTypeOnDeductionOperationInputDesign.addValue(item);
        return (DataTypeDesign)this;
    }

    public DataTypeDesign removeFromDataTypeOnDeductionOperationInputDesign(DeductionOperationInputDesign item) {
        dataTypeOnDeductionOperationInputDesign.removeValue(item);
        return (DataTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DataTypeDesign, RelationDesign> reverseRelation
		= createReverseRelationValue(org.instantlogic.designer.entity.DataTypeDesignEntity.reverseRelation);

	public org.instantlogic.fabric.value.RelationValue<DataTypeDesign, RelationDesign> getReverseRelationRelationValue() {
		return reverseRelation;
	}

	public org.instantlogic.designer.RelationDesign getReverseRelation() {
		return reverseRelation.getValue();
	}

    public DataTypeDesign setReverseRelation(org.instantlogic.designer.RelationDesign newValue) {
        reverseRelation.setValue(newValue);
        return (DataTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionDesign> dataTypeOnDeductionDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.DataTypeDesignEntity.dataTypeOnDeductionDesign);

	public org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionDesign> getDataTypeOnDeductionDesignRelationValue() {
		return dataTypeOnDeductionDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign> getDataTypeOnDeductionDesign() {
		return dataTypeOnDeductionDesign.getValue();
	}

    public DataTypeDesign addToDataTypeOnDeductionDesign(DeductionDesign item) {
        dataTypeOnDeductionDesign.addValue(item);
        return (DataTypeDesign)this;
    }

    public DataTypeDesign removeFromDataTypeOnDeductionDesign(DeductionDesign item) {
        dataTypeOnDeductionDesign.removeValue(item);
        return (DataTypeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionOperationDesign> outputDataTypeOnDeductionOperationDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.DataTypeDesignEntity.outputDataTypeOnDeductionOperationDesign);

	public org.instantlogic.fabric.value.RelationValues<DataTypeDesign, DeductionOperationDesign> getOutputDataTypeOnDeductionOperationDesignRelationValue() {
		return outputDataTypeOnDeductionOperationDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign> getOutputDataTypeOnDeductionOperationDesign() {
		return outputDataTypeOnDeductionOperationDesign.getValue();
	}

    public DataTypeDesign addToOutputDataTypeOnDeductionOperationDesign(DeductionOperationDesign item) {
        outputDataTypeOnDeductionOperationDesign.addValue(item);
        return (DataTypeDesign)this;
    }

    public DataTypeDesign removeFromOutputDataTypeOnDeductionOperationDesign(DeductionOperationDesign item) {
        outputDataTypeOnDeductionOperationDesign.removeValue(item);
        return (DataTypeDesign)this;
    }


}
