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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> elseChildren;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> ifChildren;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $condition
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"condition", INSTANCE, "condition", org.instantlogic.designer.IfElseDesign.class);
		condition = $condition;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> $elseChildren
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
				"elseChildren", INSTANCE, "elseChildren", org.instantlogic.designer.IfElseDesign.class);
		elseChildren = $elseChildren;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> $ifChildren
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
				"ifChildren", INSTANCE, "ifChildren", org.instantlogic.designer.IfElseDesign.class);
		ifChildren = $ifChildren;
		// Reverse relations
		
		// Phase 2

		$condition.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$condition.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$condition.owner = true;
		$condition.autoCreate = true;
		$elseChildren.valueClass = org.instantlogic.designer.ElementDesign.class;
		$elseChildren.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$elseChildren.owner = true;
		$elseChildren.multivalue = true;
		$ifChildren.valueClass = org.instantlogic.designer.ElementDesign.class;
		$ifChildren.to = org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
		$ifChildren.owner = true;
		$ifChildren.multivalue = true;

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
	public String getName() {
		return "IfElseDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		condition,
		elseChildren,
		ifChildren,
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
