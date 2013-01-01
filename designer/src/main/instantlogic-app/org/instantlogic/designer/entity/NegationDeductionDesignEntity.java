package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class NegationDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.NegationDeductionDesign> {

	public static final NegationDeductionDesignEntity INSTANCE = new NegationDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.NegationDeductionDesign createInstance() {
		return new org.instantlogic.designer.NegationDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.NegationDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.NegationDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "NegationDeductionDesign";
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
	public java.util.Map<String, org.instantlogic.designer.NegationDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.NegationDeductionDesign.getStaticNegationDeductionDesignInstances();
	}
}
