package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class SharedElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedElementDesign> {

	public static final SharedElementDesignEntity INSTANCE = new SharedElementDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> definition;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> $definition
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"SmosiyIxhadbcnzr_4bd5d76e_4d11", "definition", INSTANCE, "definition", org.instantlogic.designer.SharedElementDesign.class);
		definition = $definition;
		// Reverse relations
		
		// Phase 2

		$definition.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$definition.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$definition.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.usages);

	}

	@Override
	public org.instantlogic.designer.SharedElementDesign createInstance() {
		return new org.instantlogic.designer.SharedElementDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedElementDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedElementDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "CgiguctAzuaEUojE_938a5aa7_b543";
	}
	
	@Override
	public String getName() {
		return "SharedElementDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		definition,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	public java.util.Map<String, org.instantlogic.designer.SharedElementDesign> getStaticInstances() {
		return org.instantlogic.designer.SharedElementDesign.getStaticSharedElementDesignInstances();
	}
}
