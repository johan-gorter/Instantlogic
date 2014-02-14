package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class IfElseDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.IfElseDesign> {

	public static final IfElseDesignEntity INSTANCE = new IfElseDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> condition;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> elseChild;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> ifChild;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $condition
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_condition", "condition", INSTANCE, "condition", org.instantlogic.designer.IfElseDesign.class);
		condition = $condition;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $elseChild
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"RelationDesign_elseChild", "elseChild", INSTANCE, "elseChild", org.instantlogic.designer.IfElseDesign.class);
		elseChild = $elseChild;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign> $ifChild
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign, org.instantlogic.designer.ElementDesign>(
				"RelationDesign_ifChild", "ifChild", INSTANCE, "ifChild", org.instantlogic.designer.IfElseDesign.class);
		ifChild = $ifChild;
		// Reverse relations
		
		// Phase 2

		$condition.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$condition.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$condition.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.conditionOnIfElseDesign);
		$condition.owner = true;
		$condition.autoCreate = true;
		$elseChild.valueClass = org.instantlogic.designer.ElementDesign.class;
		$elseChild.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$elseChild.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.elseChildOnIfElseDesign);
		$elseChild.owner = true;
		$ifChild.valueClass = org.instantlogic.designer.ElementDesign.class;
		$ifChild.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$ifChild.setReverseRelation(org.instantlogic.designer.entity.ElementDesignEntity.ifChildOnIfElseDesign);
		$ifChild.owner = true;

	}

	@Override
	public org.instantlogic.designer.IfElseDesign createInstance() {
		return new org.instantlogic.designer.IfElseDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.IfElseDesign> getInstanceClass() {
		return org.instantlogic.designer.IfElseDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_IfElseDesign";
	}
	
	@Override
	public String getName() {
		return "IfElseDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		condition,
		elseChild,
		ifChild,
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
	public java.util.Map<String, org.instantlogic.designer.IfElseDesign> getStaticInstances() {
		return org.instantlogic.designer.IfElseDesign.getStaticIfElseDesignInstances();
	}
}
