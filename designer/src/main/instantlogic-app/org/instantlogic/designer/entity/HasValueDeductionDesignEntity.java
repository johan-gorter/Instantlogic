package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class HasValueDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.HasValueDeductionDesign> {

	public static final HasValueDeductionDesignEntity INSTANCE = new HasValueDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.HasValueDeductionDesign createInstance() {
		return new org.instantlogic.designer.HasValueDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.HasValueDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.HasValueDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "HasValueDeductionDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	public java.util.Map<String, org.instantlogic.designer.HasValueDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.HasValueDeductionDesign.getStaticHasValueDeductionDesignInstances();
	}
}
