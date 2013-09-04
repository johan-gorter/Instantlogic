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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> $staticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
				"CtAncfIEOabimazp_d4b1647c_377b", "staticInstances", INSTANCE, "staticInstances", org.instantlogic.designer.AbstractEntityDesign.class);
		staticInstances = $staticInstances;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $extendsFrom
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"DIibpUxpsiflgloE_10da9246_36ee", "extendsFrom", INSTANCE, "extendsFrom", org.instantlogic.designer.AbstractEntityDesign.class);
		extendsFrom = $extendsFrom;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $relations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"DdfInmI_di_qIkIo_d5b5913b_d430", "relations", INSTANCE, "relations", org.instantlogic.designer.AbstractEntityDesign.class);
		relations = $relations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"HpypuOmrligksfrx_3fd91719_c3a7", "title", INSTANCE, "title", org.instantlogic.designer.AbstractEntityDesign.class);
		title = $title;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"IremjucUsqfIuoik_e1504952_08ed", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractEntityDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $attributes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"OfaAmjliem_yokxd_98f7415e_7e33", "attributes", INSTANCE, "attributes", org.instantlogic.designer.AbstractEntityDesign.class);
		attributes = $attributes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"u_tajsezsydIUdUz_42c3ed1f_6e56", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractEntityDesign.class);
		validations = $validations;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"AsIqa_zyrqcoaejU_a5f178ac_90e2", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEntityDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $extensions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"DIibpUxpsiflgloE_10da9246_36ee", "extensions", INSTANCE, "extensions", org.instantlogic.designer.AbstractEntityDesign.class);
		extensions = $extensions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $reverseRelations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"icoygmzcuIcUIk_p_8301e2aa_9ec1", "reverseRelations", INSTANCE, "reverseRelations", org.instantlogic.designer.AbstractEntityDesign.class);
		reverseRelations = $reverseRelations;
		
		// Phase 2

		$staticInstances.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstances.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);
		$staticInstances.owner = true;
		$staticInstances.multivalue = true;
		$extendsFrom.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extendsFrom.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extendsFrom.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extensions);
		$relations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$relations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$relations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.from);
		$relations.owner = true;
		$relations.multivalue = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfEntity);
		$title.owner = true;
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

		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		$extensions.reverse = true;
		$extensions.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extensions.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extensions.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		$extensions.multivalue = true;
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
		return "MplUqnvmpu_aicyu_a49f99a3_d70b";
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		staticInstances,
		extendsFrom,
		relations,
		title,
		dataType,
		attributes,
		validations,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		extensions,
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
