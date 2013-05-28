package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class StaticInstanceDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StaticInstanceDesign> {

	public static final StaticInstanceDesignEntity INSTANCE = new StaticInstanceDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> description;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> values;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> valueOfStaticInstances;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $description
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"Relationdesign__002c", "description", INSTANCE, "description", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		description = $description;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> $values
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign>(
				"Relationdesign__002d", "values", INSTANCE, "values", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		values = $values;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Relationdesign__000f", "entity", INSTANCE, "entity", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		entity = $entity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> $valueOfStaticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign>(
				"Relationdesign__002e", "valueOfStaticInstances", INSTANCE, "valueOfStaticInstances", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		valueOfStaticInstances = $valueOfStaticInstances;
		
		// Phase 2

		$description.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$description.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$description.owner = true;
		$values.valueClass = org.instantlogic.designer.StaticInstanceValueDesign.class;
		$values.to = org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
		$values.owner = true;
		$values.multivalue = true;

		$entity.reverse = true;
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.staticInstances);
		$valueOfStaticInstances.reverse = true;
		$valueOfStaticInstances.valueClass = org.instantlogic.designer.StaticInstanceValueDesign.class;
		$valueOfStaticInstances.to = org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
		$valueOfStaticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.relationValue);
		$valueOfStaticInstances.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.StaticInstanceDesign createInstance() {
		return new org.instantlogic.designer.StaticInstanceDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.StaticInstanceDesign> getInstanceClass() {
		return org.instantlogic.designer.StaticInstanceDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Entitydesign__000d";
	}
	
	@Override
	public String getName() {
		return "StaticInstanceDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		description,
		values,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		entity,
		valueOfStaticInstances,
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
	public java.util.Map<String, org.instantlogic.designer.StaticInstanceDesign> getStaticInstances() {
		return org.instantlogic.designer.StaticInstanceDesign.getStaticStaticInstanceDesignInstances();
	}
}
