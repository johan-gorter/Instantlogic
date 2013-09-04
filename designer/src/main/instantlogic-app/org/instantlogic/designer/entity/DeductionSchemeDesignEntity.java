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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> ruleOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> ruleForValidation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> defaultOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> optionsOfRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> selectionElement;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $deductions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"DpdsAO_q_qgdomxa_341a72b1_d948", "deductions", INSTANCE, "deductions", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductions = $deductions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $output
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"KxffjmOqdmgsUaxw_b3fd5747_200c", "output", INSTANCE, "output", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		output = $output;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $selectedDeduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"extwOdngdiaoibzk_f2ee3ce9_2910", "selectedDeduction", INSTANCE, "selectedDeduction", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectedDeduction = $selectedDeduction;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $ruleOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"DIyxjhvyUiapm_Ej_5a8deb35_1a9b", "ruleOfAttribute", INSTANCE, "ruleOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleOfAttribute = $ruleOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $ruleForValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"KwugibpIpu_tsbce_6ed447d7_54f0", "ruleForValidation", INSTANCE, "ruleForValidation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleForValidation = $ruleForValidation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $defaultOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"SvzAmkji_qfAsfij_90fc2f5f_41b4", "defaultOfAttribute", INSTANCE, "defaultOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		defaultOfAttribute = $defaultOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $optionsOfRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"WueqelfImI_qycth_bd225860_25f4", "optionsOfRelation", INSTANCE, "optionsOfRelation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		optionsOfRelation = $optionsOfRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $relevanceOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"XuvhwfxscefIildd_a1dace46_0cd7", "relevanceOfAttribute", INSTANCE, "relevanceOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		relevanceOfAttribute = $relevanceOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $selectionElement
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"irdznvIyayfryhxv_0f177f9b_ae96", "selectionElement", INSTANCE, "selectionElement", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectionElement = $selectionElement;
		
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

		$ruleOfAttribute.reverse = true;
		$ruleOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$ruleOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$ruleOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
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
		$relevanceOfAttribute.reverse = true;
		$relevanceOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$relevanceOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$relevanceOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
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
		return "ItUIAayvoia_qoge_95002bb1_78c0";
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
		ruleOfAttribute,
		ruleForValidation,
		defaultOfAttribute,
		optionsOfRelation,
		relevanceOfAttribute,
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
