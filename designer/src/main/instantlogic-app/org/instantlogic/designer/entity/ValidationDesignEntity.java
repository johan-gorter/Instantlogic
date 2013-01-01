package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ValidationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ValidationDesign> {

	public static final ValidationDesignEntity INSTANCE = new ValidationDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.ValidationDesign createInstance() {
		return new org.instantlogic.designer.ValidationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ValidationDesign> getInstanceClass() {
		return org.instantlogic.designer.ValidationDesign.class;
	}
	
	@Override
	public String getName() {
		return "ValidationDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> displayWith
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
			"displayWith", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			org.instantlogic.designer.entity.AttributeDesignEntity.validations
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.ValidationDesign instance) {
				return instance.getDisplayWithRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> message
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
			"message", INSTANCE, org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE, org.instantlogic.designer.TextTemplateDesign.class, 
			org.instantlogic.designer.entity.TextTemplateDesignEntity.messageOfValidation
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign> get(
					org.instantlogic.designer.ValidationDesign instance) {
				return instance.getMessageRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"rule", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleForValidation
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.ValidationDesign instance) {
				return instance.getRuleRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"forEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, org.instantlogic.designer.entity.EntityDesignEntity.validations
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ValidationDesign instance) {
				return instance.getForEntityRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		displayWith,
		message,
		rule,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		forEntity,
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
	public java.util.Map<String, org.instantlogic.designer.ValidationDesign> getStaticInstances() {
		return org.instantlogic.designer.ValidationDesign.getStaticValidationDesignInstances();
	}
}
