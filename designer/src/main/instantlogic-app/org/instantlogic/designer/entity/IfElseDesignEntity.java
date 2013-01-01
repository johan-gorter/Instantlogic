package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class IfElseDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.IfElseDesign> {

	public static final IfElseDesignEntity INSTANCE = new IfElseDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
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

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> condition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"condition", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.IfElseDesign instance) {
				return instance.getConditionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> elseChildren
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
			"elseChildren", INSTANCE, org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE, org.instantlogic.designer.ElementDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign> get(
					org.instantlogic.designer.IfElseDesign instance) {
				return instance.getElseChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign> ifChildren
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.IfElseDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.ElementDesign>, org.instantlogic.designer.ElementDesign>(
			"ifChildren", INSTANCE, org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE, org.instantlogic.designer.ElementDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.ElementDesign> get(
					org.instantlogic.designer.IfElseDesign instance) {
				return instance.getIfChildrenRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations

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
