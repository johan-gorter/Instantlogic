package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ValidationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ValidationDesign> {

	public static final ValidationDesignEntity INSTANCE = new ValidationDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> message;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> displayWith;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $message
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"LaEhkwuxbadvknAg_b305c4bd_7f33", "message", INSTANCE, "message", org.instantlogic.designer.AbstractValidationDesign.class);
		message = $message;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $displayWith
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"ZmrviIOehybteoxt_72b29235_2f5d", "displayWith", INSTANCE, "displayWith", org.instantlogic.designer.AbstractValidationDesign.class);
		displayWith = $displayWith;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $rule
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"axgUzmcguugpyjtO_69067e50_16e7", "rule", INSTANCE, "rule", org.instantlogic.designer.AbstractValidationDesign.class);
		rule = $rule;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Udbn_E_i_ifpenAt_7aecdc14_25b5", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.AbstractValidationDesign.class);
		forEntity = $forEntity;
		
		// Phase 2

		$message.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$message.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$message.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.messageOfValidation);
		$message.owner = true;
		$displayWith.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$displayWith.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$displayWith.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.validations);
		$displayWith.multivalue = true;
		$rule.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$rule.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$rule.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleForValidation);
		$rule.owner = true;
		$rule.autoCreate = true;

		$forEntity.reverse = true;
		$forEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$forEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$forEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.validations);
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
	public String getUniqueId() {
		return "HyotfIAiceeacncq_a2aa33c5_da3e";
	}
	
	@Override
	public String getName() {
		return "ValidationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		message,
		displayWith,
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
