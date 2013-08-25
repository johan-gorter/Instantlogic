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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> staticInstances;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> $staticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
				"Gjgyarkhdae_sdlz_003bb797_1c11", "staticInstances", INSTANCE, "staticInstances", org.instantlogic.designer.AbstractEntityDesign.class);
		staticInstances = $staticInstances;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"MsfmyAfArqeImaAe_2aa47dfa_248e", "title", INSTANCE, "title", org.instantlogic.designer.AbstractEntityDesign.class);
		title = $title;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $relations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"PrtvvfaflqcrmdhA_ae43bb22_b8b9", "relations", INSTANCE, "relations", org.instantlogic.designer.AbstractEntityDesign.class);
		relations = $relations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"UkaotletgIcAqiyj_8aa58744_5d0f", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractEntityDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $attributes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"_qcAAftnwme_A_cf_3b589392_668f", "attributes", INSTANCE, "attributes", org.instantlogic.designer.AbstractEntityDesign.class);
		attributes = $attributes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"_shrgfrEzIfIugw_5b9324d1_461b", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractEntityDesign.class);
		validations = $validations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $extendsFrom
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"acrgzwbfsIdxiddd_7f5fa057_5119", "extendsFrom", INSTANCE, "extendsFrom", org.instantlogic.designer.AbstractEntityDesign.class);
		extendsFrom = $extendsFrom;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $reverseRelations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"Ehf_jgcqAucEuiju_3a797a59_d916", "reverseRelations", INSTANCE, "reverseRelations", org.instantlogic.designer.AbstractEntityDesign.class);
		reverseRelations = $reverseRelations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"SlafUuEkay_OynAr_08afa352_5e84", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEntityDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $extensions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"acrgzwbfsIdxiddd_7f5fa057_5119", "extensions", INSTANCE, "extensions", org.instantlogic.designer.AbstractEntityDesign.class);
		extensions = $extensions;
		
		// Phase 2

		$staticInstances.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstances.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);
		$staticInstances.owner = true;
		$staticInstances.multivalue = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfEntity);
		$title.owner = true;
		$relations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$relations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$relations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.from);
		$relations.owner = true;
		$relations.multivalue = true;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.forEntity);
		$dataType.owner = true;
		$dataType.autoCreate = true;
		$attributes.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributes.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attributes.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeOf);
		$attributes.owner = true;
		$attributes.multivalue = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);
		$validations.owner = true;
		$validations.multivalue = true;
		$extendsFrom.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extendsFrom.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extendsFrom.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extensions);

		$reverseRelations.reverse = true;
		$reverseRelations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.to);
		$reverseRelations.multivalue = true;
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		$extensions.reverse = true;
		$extensions.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extensions.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extensions.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		$extensions.multivalue = true;
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
		return "LUEueuggpaehI_xb_0396539a_aced";
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		staticInstances,
		title,
		relations,
		dataType,
		attributes,
		validations,
		extendsFrom,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		reverseRelations,
		application,
		extensions,
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
