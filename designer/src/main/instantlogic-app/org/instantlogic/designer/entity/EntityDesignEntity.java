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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> staticInstances;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"GysxEOvdsyatihac_039d50ba_afb7", "title", INSTANCE, "title", org.instantlogic.designer.AbstractEntityDesign.class);
		title = $title;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $relations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"JgrgsgAUUycIunpc_2f3d752d_52ac", "relations", INSTANCE, "relations", org.instantlogic.designer.AbstractEntityDesign.class);
		relations = $relations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"KUftnaUAAqbjegtl_d2f2d3da_1ef2", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractEntityDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $attributes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"KovqcaUkAqgsIlEq_a4d9bb04_681d", "attributes", INSTANCE, "attributes", org.instantlogic.designer.AbstractEntityDesign.class);
		attributes = $attributes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $extendsFrom
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"_geibayxwidvolhu_8addda02_7af2", "extendsFrom", INSTANCE, "extendsFrom", org.instantlogic.designer.AbstractEntityDesign.class);
		extendsFrom = $extendsFrom;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> $staticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
				"ihyhrsEuyIgwuoeU_b26a8d7e_7d53", "staticInstances", INSTANCE, "staticInstances", org.instantlogic.designer.AbstractEntityDesign.class);
		staticInstances = $staticInstances;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"ikjrzrrgOeacuarp_cfb4fdd0_2c2b", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractEntityDesign.class);
		validations = $validations;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $reverseRelations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"LAjOzeri_IdduicO_530cb88c_127d", "reverseRelations", INSTANCE, "reverseRelations", org.instantlogic.designer.AbstractEntityDesign.class);
		reverseRelations = $reverseRelations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"WlIeEsnbEe_zgmfv_a20436ff_3938", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEntityDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $extensions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"_geibayxwidvolhu_8addda02_7af2", "extensions", INSTANCE, "extensions", org.instantlogic.designer.AbstractEntityDesign.class);
		extensions = $extensions;
		
		// Phase 2

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
		$extendsFrom.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extendsFrom.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extendsFrom.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extensions);
		$staticInstances.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstances.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);
		$staticInstances.owner = true;
		$staticInstances.multivalue = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);
		$validations.owner = true;
		$validations.multivalue = true;

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
		return "JrsykqiqIiaqyavb_d079eaa9_f1da";
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		title,
		relations,
		dataType,
		attributes,
		extendsFrom,
		staticInstances,
		validations,
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
