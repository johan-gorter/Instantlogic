package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class SelectedInstanceDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SelectedInstanceDeductionDesign> {

	public static final SelectedInstanceDeductionDesignEntity INSTANCE = new SelectedInstanceDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.SelectedInstanceDeductionDesign createInstance() {
		return new org.instantlogic.designer.SelectedInstanceDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SelectedInstanceDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.SelectedInstanceDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "SelectedInstanceDeductionDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SelectedInstanceDeductionDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> ofEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SelectedInstanceDeductionDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"ofEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SelectedInstanceDeductionDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.SelectedInstanceDeductionDesign instance) {
				return instance.getOfEntityRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		ofEntity,
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
	public java.util.Map<String, org.instantlogic.designer.SelectedInstanceDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.SelectedInstanceDeductionDesign.getStaticSelectedInstanceDeductionDesignInstances();
	}
}
