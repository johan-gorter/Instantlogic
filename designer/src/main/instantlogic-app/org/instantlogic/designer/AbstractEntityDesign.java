package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractEntityDesign extends Design { 

	private static final java.util.Map<String, EntityDesign> _staticInstances = new java.util.LinkedHashMap<String, EntityDesign>();
	
	public static java.util.Map<String, EntityDesign> getStaticEntityDesignInstances() {
		return _staticInstances;
	}
	
	private static EntityDesign addStaticInstance(String name, EntityDesign instance) {
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
		return org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, TextTemplateDesign> title
		= createRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.title);
		
	public org.instantlogic.fabric.value.RelationValue<EntityDesign, TextTemplateDesign> getTitleRelationValue() {
		return title;
	}

	public org.instantlogic.designer.TextTemplateDesign getTitle() {
		return title.getValue();
	}
	
	public EntityDesign setTitle(org.instantlogic.designer.TextTemplateDesign newValue) {
		title.setValue(newValue);
		return (EntityDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newTitle() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		title.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> relations
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.relations);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getRelationsRelationValue() {
		return relations;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign> getRelations() {
		return relations.getValue();
	}
	
	public EntityDesign addToRelations(RelationDesign item) {
		relations.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromRelations(RelationDesign item) {
		relations.removeValue(item);
		return (EntityDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, DataTypeDesign> dataType
		= createRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.dataType);
		
	public org.instantlogic.fabric.value.RelationValue<EntityDesign, DataTypeDesign> getDataTypeRelationValue() {
		return dataType;
	}

	public org.instantlogic.designer.DataTypeDesign getDataType() {
		return dataType.getValue();
	}
	
	public EntityDesign setDataType(org.instantlogic.designer.DataTypeDesign newValue) {
		dataType.setValue(newValue);
		return (EntityDesign)this;
	}
	
	public org.instantlogic.designer.DataTypeDesign newDataType() {
		org.instantlogic.designer.DataTypeDesign newValue = new org.instantlogic.designer.DataTypeDesign(); 
		dataType.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> attributes
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, AttributeDesign> getAttributesRelationValue() {
		return attributes;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign> getAttributes() {
		return attributes.getValue();
	}
	
	public EntityDesign addToAttributes(AttributeDesign item) {
		attributes.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromAttributes(AttributeDesign item) {
		attributes.removeValue(item);
		return (EntityDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> extendsFrom
		= createRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		
	public org.instantlogic.fabric.value.RelationValue<EntityDesign, EntityDesign> getExtendsFromRelationValue() {
		return extendsFrom;
	}

	public org.instantlogic.designer.EntityDesign getExtendsFrom() {
		return extendsFrom.getValue();
	}
	
	public EntityDesign setExtendsFrom(org.instantlogic.designer.EntityDesign newValue) {
		extendsFrom.setValue(newValue);
		return (EntityDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, StaticInstanceDesign> staticInstances
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.staticInstances);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, StaticInstanceDesign> getStaticInstancesRelationValue() {
		return staticInstances;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign> getStaticInstances() {
		return staticInstances.getValue();
	}
	
	public EntityDesign addToStaticInstances(StaticInstanceDesign item) {
		staticInstances.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromStaticInstances(StaticInstanceDesign item) {
		staticInstances.removeValue(item);
		return (EntityDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, ValidationDesign> validations
		= createRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.validations);
		
	public org.instantlogic.fabric.value.RelationValues<EntityDesign, ValidationDesign> getValidationsRelationValue() {
		return validations;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign> getValidations() {
		return validations.getValue();
	}
	
	public EntityDesign addToValidations(ValidationDesign item) {
		validations.addValue(item);
		return (EntityDesign)this;
	}
	
	public EntityDesign removeFromValidations(ValidationDesign item) {
		validations.removeValue(item);
		return (EntityDesign)this;
	}
	
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> reverseRelations
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.reverseRelations);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, RelationDesign> getReverseRelationsRelationValue() {
		return reverseRelations;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign> getReverseRelations() {
		return reverseRelations.getValue();
	}

    public EntityDesign addToReverseRelations(RelationDesign item) {
        reverseRelations.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromReverseRelations(RelationDesign item) {
        reverseRelations.removeValue(item);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EntityDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<EntityDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public EntityDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (EntityDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EntityDesign, EntityDesign> extensions
		= createReverseRelationValues(org.instantlogic.designer.entity.EntityDesignEntity.extensions);

	public org.instantlogic.fabric.value.RelationValues<EntityDesign, EntityDesign> getExtensionsRelationValue() {
		return extensions;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign> getExtensions() {
		return extensions.getValue();
	}

    public EntityDesign addToExtensions(EntityDesign item) {
        extensions.addValue(item);
        return (EntityDesign)this;
    }

    public EntityDesign removeFromExtensions(EntityDesign item) {
        extensions.removeValue(item);
        return (EntityDesign)this;
    }


}
