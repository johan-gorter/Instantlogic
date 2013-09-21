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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign> usages;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $fragment
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"NyjbOopxlqdjqdfy_f24ef5c3_5e7e", "fragment", INSTANCE, "fragment", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		fragment = $fragment;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign> $usages
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDesign>, org.instantlogic.designer.SharedElementDesign>(
				"IsqdexyixuejsnjA_5b3cc86b_ce70", "usages", INSTANCE, "usages", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		usages = $usages;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"KgOhdOkosmbugbxt_e6600f56_a112", "application", INSTANCE, "application", org.instantlogic.designer.AbstractSharedElementDefinitionDesign.class);
		application = $application;
		
		// Phase 2

		$fragment.valueClass = org.instantlogic.designer.ElementDesign.class;
		$fragment.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$fragment.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.partOfSharedElementDefinition);
		$fragment.owner = true;

		$usages.reverse = true;
		$usages.valueClass = org.instantlogic.designer.SharedElementDesign.class;
		$usages.to = org.instantlogic.designer.entity.SharedElementDesignEntity.INSTANCE;
		$usages.setReverseRelation(org.instantlogic.designer.entity.SharedElementDesignEntity.definition);
		$usages.multivalue = true;
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedElements);
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
		return "TAwgersunqemsddA_2ba7f94e_a934";
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
		usages,
		application,
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
