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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> values;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> description;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> valueOfStaticInstances;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> $values
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign>(
				"JUdUsjbUjydUaaxc_b7f93ef9_6820", "values", INSTANCE, "values", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		values = $values;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $description
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"JylxboacgybrUfzi_d4aafabe_e7e0", "description", INSTANCE, "description", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		description = $description;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"ihyhrsEuyIgwuoeU_b26a8d7e_7d53", "entity", INSTANCE, "entity", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		entity = $entity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> $valueOfStaticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign>(
				"oviujuhfuq_lsljp_88e8e610_df16", "valueOfStaticInstances", INSTANCE, "valueOfStaticInstances", org.instantlogic.designer.AbstractStaticInstanceDesign.class);
		valueOfStaticInstances = $valueOfStaticInstances;
		
		// Phase 2

		$values.valueClass = org.instantlogic.designer.StaticInstanceValueDesign.class;
		$values.to = org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
		$values.owner = true;
		$values.multivalue = true;
		$description.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$description.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$description.owner = true;

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
		return "YxghhhaksufriiIu_891eae76_d2d2";
	}
	
	@Override
	public String getName() {
		return "StaticInstanceDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		values,
		description,
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
