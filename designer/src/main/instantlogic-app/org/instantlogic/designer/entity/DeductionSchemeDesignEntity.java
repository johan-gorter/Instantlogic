package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionSchemeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionSchemeDesign> {

	public static final DeductionSchemeDesignEntity INSTANCE = new DeductionSchemeDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> output;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> deductions;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> selectedDeduction;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> optionsOfRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> ruleOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> defaultOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> ruleForValidation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> valueOnPropertyDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> conditionOnIfElseDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign> deductionOnStringTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> selectionElement;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $output
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"Ackmlqfxhu_wweir_c3ff75f8_f2d4", "output", INSTANCE, "output", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		output = $output;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $deductions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"CcayAqvfiIadIaf_4569b6c0_adaf", "deductions", INSTANCE, "deductions", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductions = $deductions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $selectedDeduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"HnnEbgdOgmfIqkgt_412b0536_3e68", "selectedDeduction", INSTANCE, "selectedDeduction", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectedDeduction = $selectedDeduction;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $relevanceOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Aegxlqdatuchmb_r_5ecc26af_0f3a", "relevanceOfAttribute", INSTANCE, "relevanceOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		relevanceOfAttribute = $relevanceOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $optionsOfRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"DItyjpmvtyd_qdUI_f27b03e5_28a8", "optionsOfRelation", INSTANCE, "optionsOfRelation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		optionsOfRelation = $optionsOfRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $ruleOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Het_qocxtqaAoaqu_b8bd7998_4d80", "ruleOfAttribute", INSTANCE, "ruleOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleOfAttribute = $ruleOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $defaultOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"TmzvIweEEIaIacea_2d3b051f_07e6", "defaultOfAttribute", INSTANCE, "defaultOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		defaultOfAttribute = $defaultOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $ruleForValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"UEqzesjgfqgcydrp_7b9fdb0c_e4ab", "ruleForValidation", INSTANCE, "ruleForValidation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleForValidation = $ruleForValidation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> $valueOnPropertyDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
				"XybfkfbzzqaiIiEa_fb451075_c2ad", "valueOnPropertyDesign", INSTANCE, "valueOnPropertyDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		valueOnPropertyDesign = $valueOnPropertyDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> $conditionOnIfElseDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign>(
				"eUfvAipOiabywmOi_ff5e1aab_baa7", "conditionOnIfElseDesign", INSTANCE, "conditionOnIfElseDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		conditionOnIfElseDesign = $conditionOnIfElseDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign> $deductionOnStringTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign>(
				"edwvuUneda_pccfo_348511ed_2565", "deductionOnStringTemplateDesign", INSTANCE, "deductionOnStringTemplateDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductionOnStringTemplateDesign = $deductionOnStringTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $selectionElement
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"upksAfiynactkksn_c38a64d4_997e", "selectionElement", INSTANCE, "selectionElement", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectionElement = $selectionElement;
		
		// Phase 2

		$output.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$output.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$output.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.outputOfScheme);
		$deductions.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deductions.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deductions.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);
		$deductions.owner = true;
		$deductions.multivalue = true;
		$selectedDeduction.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$selectedDeduction.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$selectedDeduction.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.selectionInScheme);

		$relevanceOfAttribute.reverse = true;
		$relevanceOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$relevanceOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$relevanceOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		$optionsOfRelation.reverse = true;
		$optionsOfRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$optionsOfRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$optionsOfRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.options);
		$ruleOfAttribute.reverse = true;
		$ruleOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$ruleOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$ruleOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		$defaultOfAttribute.reverse = true;
		$defaultOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$defaultOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$defaultOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		$ruleForValidation.reverse = true;
		$ruleForValidation.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$ruleForValidation.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$ruleForValidation.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.rule);
		$valueOnPropertyDesign.reverse = true;
		$valueOnPropertyDesign.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$valueOnPropertyDesign.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$valueOnPropertyDesign.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.value);
		$conditionOnIfElseDesign.reverse = true;
		$conditionOnIfElseDesign.valueClass = org.instantlogic.designer.IfElseDesign.class;
		$conditionOnIfElseDesign.to = org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE;
		$conditionOnIfElseDesign.setReverseRelation(org.instantlogic.designer.entity.IfElseDesignEntity.condition);
		$deductionOnStringTemplateDesign.reverse = true;
		$deductionOnStringTemplateDesign.valueClass = org.instantlogic.designer.StringTemplateDesign.class;
		$deductionOnStringTemplateDesign.to = org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
		$deductionOnStringTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.StringTemplateDesignEntity.deduction);
		$selectionElement.reverse = true;
		$selectionElement.valueClass = org.instantlogic.designer.SelectionDesign.class;
		$selectionElement.to = org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
		$selectionElement.setReverseRelation(org.instantlogic.designer.entity.SelectionDesignEntity.selection);
	}

	@Override
	public org.instantlogic.designer.DeductionSchemeDesign createInstance() {
		return new org.instantlogic.designer.DeductionSchemeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionSchemeDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionSchemeDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "JsOcAEm_euefqbcc_3b6b23cf_50b5";
	}
	
	@Override
	public String getName() {
		return "DeductionSchemeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		output,
		deductions,
		selectedDeduction,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		relevanceOfAttribute,
		optionsOfRelation,
		ruleOfAttribute,
		defaultOfAttribute,
		ruleForValidation,
		valueOnPropertyDesign,
		conditionOnIfElseDesign,
		deductionOnStringTemplateDesign,
		selectionElement,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionSchemeDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionSchemeDesign.getStaticDeductionSchemeDesignInstances();
	}
}
