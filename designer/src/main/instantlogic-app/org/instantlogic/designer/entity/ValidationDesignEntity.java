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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> displayWith;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> message;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $displayWith
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"HillbOAfliarm_Ev_194c9770_d628", "displayWith", INSTANCE, "displayWith", org.instantlogic.designer.AbstractValidationDesign.class);
		displayWith = $displayWith;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $rule
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"UEqzesjgfqgcydrp_7b9fdb0c_e4ab", "rule", INSTANCE, "rule", org.instantlogic.designer.AbstractValidationDesign.class);
		rule = $rule;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $message
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"WpEmxltcAqeakfzb_78ddef7b_1c80", "message", INSTANCE, "message", org.instantlogic.designer.AbstractValidationDesign.class);
		message = $message;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"ixvgrxb_wigmwjtm_caa6ffc3_53d8", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.AbstractValidationDesign.class);
		forEntity = $forEntity;
		
		// Phase 2

		$displayWith.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$displayWith.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$displayWith.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.validations);
		$displayWith.multivalue = true;
		$rule.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$rule.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$rule.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleForValidation);
		$rule.owner = true;
		$rule.autoCreate = true;
		$message.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$message.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$message.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.messageOfValidation);
		$message.owner = true;

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
		return "IldEj_Axzuehmhek_1a059ec0_cf02";
	}
	
	@Override
	public String getName() {
		return "ValidationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		displayWith,
		rule,
		message,
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
