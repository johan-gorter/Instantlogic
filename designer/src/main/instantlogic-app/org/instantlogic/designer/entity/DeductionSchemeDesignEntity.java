package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionSchemeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionSchemeDesign> {

	public static final DeductionSchemeDesignEntity INSTANCE = new DeductionSchemeDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> deductions;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> output;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> selectedDeduction;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> ruleOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> selectionElement;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> ruleForValidation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> defaultOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> optionsOfRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign> deductionOnStringTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> conditionOnIfElseDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> valueOnPropertyDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $deductions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"RvjhloIvEuakccsz_0cb75616_3b19", "deductions", INSTANCE, "deductions", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductions = $deductions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $output
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"VeegvqxwuIe_Idbw_665e6e27_5436", "output", INSTANCE, "output", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		output = $output;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $selectedDeduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"axnxsouwpefgm_lq_275f8592_dc66", "selectedDeduction", INSTANCE, "selectedDeduction", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectedDeduction = $selectedDeduction;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $relevanceOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"BlufAmhgyqdIabkg_bf4ae4da_654d", "relevanceOfAttribute", INSTANCE, "relevanceOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		relevanceOfAttribute = $relevanceOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $ruleOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"CIxghOvfgyakahsI_c7d3f57f_1c10", "ruleOfAttribute", INSTANCE, "ruleOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleOfAttribute = $ruleOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $selectionElement
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"EdAze_vvOua_mmbw_b80a723d_6672", "selectionElement", INSTANCE, "selectionElement", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectionElement = $selectionElement;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $ruleForValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"GoxjvvUyiubEmdwU_47c6f130_754b", "ruleForValidation", INSTANCE, "ruleForValidation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleForValidation = $ruleForValidation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $defaultOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Np_rntzwhmgtqati_72687c4e_4757", "defaultOfAttribute", INSTANCE, "defaultOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		defaultOfAttribute = $defaultOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $optionsOfRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"Qqbzprbzcmcssjog_4003d116_d46e", "optionsOfRelation", INSTANCE, "optionsOfRelation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		optionsOfRelation = $optionsOfRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign> $deductionOnStringTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.StringTemplateDesign>(
				"VylgObgxpu_pkbIq_d373636f_36e2", "deductionOnStringTemplateDesign", INSTANCE, "deductionOnStringTemplateDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductionOnStringTemplateDesign = $deductionOnStringTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign> $conditionOnIfElseDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.IfElseDesign, org.instantlogic.designer.IfElseDesign>(
				"WfgucqgdcyeluiEt_6fe4ba41_3c33", "conditionOnIfElseDesign", INSTANCE, "conditionOnIfElseDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		conditionOnIfElseDesign = $conditionOnIfElseDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> $valueOnPropertyDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
				"usdUurondyasUjat_c05cc746_336a", "valueOnPropertyDesign", INSTANCE, "valueOnPropertyDesign", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		valueOnPropertyDesign = $valueOnPropertyDesign;
		
		// Phase 2

		$deductions.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deductions.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deductions.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);
		$deductions.owner = true;
		$deductions.multivalue = true;
		$output.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$output.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$output.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.outputOfScheme);
		$selectedDeduction.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$selectedDeduction.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$selectedDeduction.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.selectionInScheme);

		$relevanceOfAttribute.reverse = true;
		$relevanceOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$relevanceOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$relevanceOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		$ruleOfAttribute.reverse = true;
		$ruleOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$ruleOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$ruleOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
		$selectionElement.reverse = true;
		$selectionElement.valueClass = org.instantlogic.designer.SelectionDesign.class;
		$selectionElement.to = org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
		$selectionElement.setReverseRelation(org.instantlogic.designer.entity.SelectionDesignEntity.selection);
		$ruleForValidation.reverse = true;
		$ruleForValidation.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$ruleForValidation.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$ruleForValidation.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.rule);
		$defaultOfAttribute.reverse = true;
		$defaultOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$defaultOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$defaultOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		$optionsOfRelation.reverse = true;
		$optionsOfRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$optionsOfRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$optionsOfRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.options);
		$deductionOnStringTemplateDesign.reverse = true;
		$deductionOnStringTemplateDesign.valueClass = org.instantlogic.designer.StringTemplateDesign.class;
		$deductionOnStringTemplateDesign.to = org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
		$deductionOnStringTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.StringTemplateDesignEntity.deduction);
		$conditionOnIfElseDesign.reverse = true;
		$conditionOnIfElseDesign.valueClass = org.instantlogic.designer.IfElseDesign.class;
		$conditionOnIfElseDesign.to = org.instantlogic.designer.entity.IfElseDesignEntity.INSTANCE;
		$conditionOnIfElseDesign.setReverseRelation(org.instantlogic.designer.entity.IfElseDesignEntity.condition);
		$valueOnPropertyDesign.reverse = true;
		$valueOnPropertyDesign.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$valueOnPropertyDesign.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$valueOnPropertyDesign.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.value);
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
		return "utvwmqEOdmfzeatq_8cdd26e6_36d0";
	}
	
	@Override
	public String getName() {
		return "DeductionSchemeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deductions,
		output,
		selectedDeduction,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		relevanceOfAttribute,
		ruleOfAttribute,
		selectionElement,
		ruleForValidation,
		defaultOfAttribute,
		optionsOfRelation,
		deductionOnStringTemplateDesign,
		conditionOnIfElseDesign,
		valueOnPropertyDesign,
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
