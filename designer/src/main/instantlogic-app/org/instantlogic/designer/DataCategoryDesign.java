package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class DataCategoryDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DataCategoryDesign> _staticInstances = new java.util.LinkedHashMap<String, DataCategoryDesign>();
	
	public static java.util.Map<String, DataCategoryDesign> getStaticDataCategoryDesignInstances() {
		return _staticInstances;
	}
	
	private static DataCategoryDesign addStaticInstance(String name, DataCategoryDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	public static final DataCategoryDesign entity;
	public static final DataCategoryDesign _boolean;
	public static final DataCategoryDesign number;
	public static final DataCategoryDesign custom;
	public static final DataCategoryDesign dateTime;
	public static final DataCategoryDesign text;
	
	static {
	  // Phase 1
	  entity = addStaticInstance("entity", new DataCategoryDesign());
	  _boolean = addStaticInstance("boolean", new DataCategoryDesign());
	  number = addStaticInstance("number", new DataCategoryDesign());
	  custom = addStaticInstance("custom", new DataCategoryDesign());
	  dateTime = addStaticInstance("dateTime", new DataCategoryDesign());
	  text = addStaticInstance("text", new DataCategoryDesign());
	  // Phase 2
	  entity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Entity").getTextTemplate());
	  _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Yes-No").getTextTemplate());
	  number.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Number").getTextTemplate());
	  custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Custom").getTextTemplate());
	  dateTime.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Date/Time").getTextTemplate());
	  text.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add("Text").getTextTemplate());
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DataCategoryDesign, DataTypeDesign> dataCategoryOnDataTypeDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.DataCategoryDesignEntity.dataCategoryOnDataTypeDesign);

	public org.instantlogic.fabric.value.RelationValue<DataCategoryDesign, DataTypeDesign> getDataCategoryOnDataTypeDesignRelationValue() {
		return dataCategoryOnDataTypeDesign;
	}

	public org.instantlogic.designer.DataTypeDesign getDataCategoryOnDataTypeDesign() {
		return dataCategoryOnDataTypeDesign.getValue();
	}

    public DataCategoryDesign setDataCategoryOnDataTypeDesign(org.instantlogic.designer.DataTypeDesign newValue) {
        dataCategoryOnDataTypeDesign.setValue(newValue);
        return (DataCategoryDesign)this;
    }


}
