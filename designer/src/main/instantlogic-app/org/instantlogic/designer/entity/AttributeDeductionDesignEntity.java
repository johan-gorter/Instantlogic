package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class AttributeDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.AttributeDeductionDesign> {

	public static final AttributeDeductionDesignEntity INSTANCE = new AttributeDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.AttributeDeductionDesign createInstance() {
		return new org.instantlogic.designer.AttributeDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.AttributeDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.AttributeDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "AttributeDeductionDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDeductionDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDeductionDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attribute", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.AttributeDeductionDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.AttributeDeductionDesign instance) {
				return instance.getAttributeRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
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
	public java.util.Map<String, org.instantlogic.designer.AttributeDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.AttributeDeductionDesign.getStaticAttributeDeductionDesignInstances();
	}
}
