package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class EntityDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EntityDesign> {

	public static final EntityDesignEntity INSTANCE = new EntityDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> staticInstances;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> belongsToEntityOnAttributeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> caseEntityOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> entityOnDataTypeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> entityValueOnDeductionParameterDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> entityOnFragmentTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceParameterDesign> placeParameter;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> parametersOnEventDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> parametersOnFlowDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $attributes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"RelationDesign_attributes", "attributes", INSTANCE, "attributes", org.instantlogic.designer.AbstractEntityDesign.class);
		attributes = $attributes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"RelationDesign_dataType_3", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractEntityDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $extendsFrom
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_extendsFrom", "extendsFrom", INSTANCE, "extendsFrom", org.instantlogic.designer.AbstractEntityDesign.class);
		extendsFrom = $extendsFrom;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $relations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"RelationDesign_relations", "relations", INSTANCE, "relations", org.instantlogic.designer.AbstractEntityDesign.class);
		relations = $relations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> $staticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
				"RelationDesign_staticInstances", "staticInstances", INSTANCE, "staticInstances", org.instantlogic.designer.AbstractEntityDesign.class);
		staticInstances = $staticInstances;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"RelationDesign_title", "title", INSTANCE, "title", org.instantlogic.designer.AbstractEntityDesign.class);
		title = $title;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"RelationDesign_validations", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractEntityDesign.class);
		validations = $validations;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $belongsToEntityOnAttributeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"RelationDesign_belongsToEntity", "belongsToEntityOnAttributeDesign", INSTANCE, "belongsToEntityOnAttributeDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		belongsToEntityOnAttributeDesign = $belongsToEntityOnAttributeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $caseEntityOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_caseEntity", "caseEntityOnApplicationDesign", INSTANCE, "caseEntityOnApplicationDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		caseEntityOnApplicationDesign = $caseEntityOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_entities", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEntityDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $entityOnDataTypeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"RelationDesign_entity", "entityOnDataTypeDesign", INSTANCE, "entityOnDataTypeDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityOnDataTypeDesign = $entityOnDataTypeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $entityValueOnDeductionParameterDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"RelationDesign_entityValue", "entityValueOnDeductionParameterDesign", INSTANCE, "entityValueOnDeductionParameterDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityValueOnDeductionParameterDesign = $entityValueOnDeductionParameterDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $entityOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"RelationDesign_entity_1", "entityOnFragmentTemplateDesign", INSTANCE, "entityOnFragmentTemplateDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityOnFragmentTemplateDesign = $entityOnFragmentTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceParameterDesign> $placeParameter
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.PlaceParameterDesign, org.instantlogic.designer.PlaceParameterDesign>(
				"RelationDesign_entity_2", "placeParameter", INSTANCE, "placeParameter", org.instantlogic.designer.AbstractEntityDesign.class);
		placeParameter = $placeParameter;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $extensions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_extendsFrom", "extensions", INSTANCE, "extensions", org.instantlogic.designer.AbstractEntityDesign.class);
		extensions = $extensions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> $parametersOnEventDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
				"RelationDesign_parameters_2", "parametersOnEventDesign", INSTANCE, "parametersOnEventDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		parametersOnEventDesign = $parametersOnEventDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> $parametersOnFlowDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
				"RelationDesign_parameters_3", "parametersOnFlowDesign", INSTANCE, "parametersOnFlowDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		parametersOnFlowDesign = $parametersOnFlowDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $reverseRelations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"RelationDesign_to", "reverseRelations", INSTANCE, "reverseRelations", org.instantlogic.designer.AbstractEntityDesign.class);
		reverseRelations = $reverseRelations;
		
		// Phase 2

		$attributes.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributes.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attributes.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeOf);
		$attributes.owner = true;
		$attributes.multivalue = true;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.forEntity);
		$dataType.owner = true;
		$dataType.autoCreate = true;
		$extendsFrom.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extendsFrom.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extendsFrom.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extensions);
		$relations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$relations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$relations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.from);
		$relations.owner = true;
		$relations.multivalue = true;
		$staticInstances.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstances.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);
		$staticInstances.owner = true;
		$staticInstances.multivalue = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfEntity);
		$title.owner = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);
		$validations.owner = true;
		$validations.multivalue = true;

		$belongsToEntityOnAttributeDesign.reverse = true;
		$belongsToEntityOnAttributeDesign.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$belongsToEntityOnAttributeDesign.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$belongsToEntityOnAttributeDesign.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);
		$belongsToEntityOnAttributeDesign.multivalue = true;
		$caseEntityOnApplicationDesign.reverse = true;
		$caseEntityOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$caseEntityOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$caseEntityOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity);
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		$entityOnDataTypeDesign.reverse = true;
		$entityOnDataTypeDesign.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$entityOnDataTypeDesign.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$entityOnDataTypeDesign.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.entity);
		$entityValueOnDeductionParameterDesign.reverse = true;
		$entityValueOnDeductionParameterDesign.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$entityValueOnDeductionParameterDesign.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$entityValueOnDeductionParameterDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.entityValue);
		$entityValueOnDeductionParameterDesign.multivalue = true;
		$entityOnFragmentTemplateDesign.reverse = true;
		$entityOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$entityOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$entityOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		$entityOnFragmentTemplateDesign.multivalue = true;
		$placeParameter.reverse = true;
		$placeParameter.valueClass = org.instantlogic.designer.PlaceParameterDesign.class;
		$placeParameter.to = org.instantlogic.designer.entity.PlaceParameterDesignEntity.INSTANCE;
		$placeParameter.setReverseRelation(org.instantlogic.designer.entity.PlaceParameterDesignEntity.entity);
		$extensions.reverse = true;
		$extensions.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extensions.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extensions.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		$extensions.multivalue = true;
		$parametersOnEventDesign.reverse = true;
		$parametersOnEventDesign.valueClass = org.instantlogic.designer.EventDesign.class;
		$parametersOnEventDesign.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$parametersOnEventDesign.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		$parametersOnEventDesign.multivalue = true;
		$parametersOnFlowDesign.reverse = true;
		$parametersOnFlowDesign.valueClass = org.instantlogic.designer.FlowDesign.class;
		$parametersOnFlowDesign.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$parametersOnFlowDesign.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		$parametersOnFlowDesign.multivalue = true;
		$reverseRelations.reverse = true;
		$reverseRelations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.to);
		$reverseRelations.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.EntityDesign createInstance() {
		return new org.instantlogic.designer.EntityDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EntityDesign> getInstanceClass() {
		return org.instantlogic.designer.EntityDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_EntityDesign";
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributes,
		dataType,
		extendsFrom,
		relations,
		staticInstances,
		title,
		validations,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		belongsToEntityOnAttributeDesign,
		caseEntityOnApplicationDesign,
		application,
		entityOnDataTypeDesign,
		entityValueOnDeductionParameterDesign,
		entityOnFragmentTemplateDesign,
		placeParameter,
		extensions,
		parametersOnEventDesign,
		parametersOnFlowDesign,
		reverseRelations,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.designer.EntityDesign> getStaticInstances() {
		return org.instantlogic.designer.EntityDesign.getStaticEntityDesignInstances();
	}
}
