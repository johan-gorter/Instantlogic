package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class SharedElementDefinitionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedElementDefinitionDesign> {

	public static final SharedElementDefinitionDesignEntity INSTANCE = new SharedElementDefinitionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> fragment;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign> usages;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $fragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"Relationdesign__003e", "fragment", INSTANCE, "fragment", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		fragment = $fragment;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"Relationdesign__000a", "application", INSTANCE, "application", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign> $usages
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign>(
				"Relationdesign__004e", "usages", INSTANCE, "usages", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		usages = $usages;
		
		// Phase 2

		$fragment.valueClass = org.instantlogic.designer.ElementDesign.class;
		$fragment.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$fragment.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.partOfSharedElementDefinition);
		$fragment.owner = true;

		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedElements);
		$usages.reverse = true;
		$usages.valueClass = org.instantlogic.designer.SharedElementDesign.class;
		$usages.to = org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
		$usages.setReverseRelation(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		$usages.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.SharedElementDefinitionDesign createInstance() {
		return new org.instantlogic.designer.SharedElementDefinitionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedElementDefinitionDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedElementDefinitionDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Entitydesign__0007";
	}
	
	@Override
	public String getName() {
		return "SharedElementDefinitionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragment,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		application,
		usages,
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
	public java.util.Map<String, org.instantlogic.designer.SharedElementDefinitionDesign> getStaticInstances() {
		return org.instantlogic.designer.SharedElementDefinitionDesign.getStaticSharedElementDefinitionDesignInstances();
	}
}
