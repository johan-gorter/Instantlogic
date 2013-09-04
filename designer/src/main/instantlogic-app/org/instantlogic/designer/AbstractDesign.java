package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Design> _staticInstances = new java.util.LinkedHashMap<String, Design>();
	
	public static java.util.Map<String, Design> getStaticDesignInstances() {
		return _staticInstances;
	}
	
	private static Design addStaticInstance(String name, Design instance) {
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
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> technicalName
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.DesignEntity.technicalName);
	
	public java.lang.String getTechnicalName() {
		return technicalName.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> getTechnicalNameAttributeValue() {
		return technicalName;
	}

	
	private final org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> javaIdentifier
		= createReadOnlyAttributeValue(org.instantlogic.designer.entity.DesignEntity.javaIdentifier);
	
	public java.lang.String getJavaIdentifier() {
		return javaIdentifier.getValue();
	}

	public org.instantlogic.fabric.value.ReadOnlyAttributeValue<Design, java.lang.String> getJavaIdentifierAttributeValue() {
		return javaIdentifier;
	}

	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.Boolean> getIsCustomizedAttributeValue() {
		return isCustomized;
	}

	public Design setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
		return (Design)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.DesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Design, java.lang.String> getNameAttributeValue() {
		return name;
	}

	public Design setName(java.lang.String newValue) {
		name.setValue(newValue);
		return (Design)this;
	}
	
	
	// Relations

	// Reverse relations

}
