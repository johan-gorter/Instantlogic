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
	
	public static final DataCategoryDesign text;
	public static final DataCategoryDesign number;
	public static final DataCategoryDesign dateTime;
	public static final DataCategoryDesign _boolean;
	public static final DataCategoryDesign entity;
	public static final DataCategoryDesign custom;
	
	static {
	   text = addStaticInstance("text", new DataCategoryDesign());
	   text.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Text")));
	   number = addStaticInstance("number", new DataCategoryDesign());
	   number.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Number")));
	   dateTime = addStaticInstance("dateTime", new DataCategoryDesign());
	   dateTime.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Date/Time")));
	   _boolean = addStaticInstance("boolean", new DataCategoryDesign());
	   _boolean.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Yes-No")));
	   entity = addStaticInstance("entity", new DataCategoryDesign());
	   entity.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Entity")));
	   custom = addStaticInstance("custom", new DataCategoryDesign());
	   custom.getMetadata().setStaticDescription(new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate("Custom")));
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}
