package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionSchemeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionSchemeDesign> {

	public static final DeductionSchemeDesignEntity INSTANCE = new DeductionSchemeDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> output;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> deductions;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> selectionElement;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> defaultOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> relevanceOfAttribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> ruleForValidation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> optionsOfRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> ruleOfAttribute;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $output
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"Ghqobkzzqmf_yhfI_481f1b81_0c4b", "output", INSTANCE, "output", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		output = $output;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $deductions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"aAhbtglvII_vi_ta_f97c0003_74b7", "deductions", INSTANCE, "deductions", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		deductions = $deductions;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign> $selectionElement
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.SelectionDesign, org.instantlogic.designer.SelectionDesign>(
				"HcnrOwwmvI_nikfr_31280285_9c5b", "selectionElement", INSTANCE, "selectionElement", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		selectionElement = $selectionElement;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $defaultOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"JxptAEjsEifqumly_69d14e58_dcec", "defaultOfAttribute", INSTANCE, "defaultOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		defaultOfAttribute = $defaultOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $relevanceOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"OsbIOItcfIaeI_aA_f47fd643_93db", "relevanceOfAttribute", INSTANCE, "relevanceOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		relevanceOfAttribute = $relevanceOfAttribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $ruleForValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"OuhrnxAhgqg_akOn_f3b11cc5_c0e3", "ruleForValidation", INSTANCE, "ruleForValidation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleForValidation = $ruleForValidation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $optionsOfRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"VlzmUrsqnIa_oovg_68d76ba8_b669", "optionsOfRelation", INSTANCE, "optionsOfRelation", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		optionsOfRelation = $optionsOfRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $ruleOfAttribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"oEiEsIluxmfmahfa_6cee92b0_945d", "ruleOfAttribute", INSTANCE, "ruleOfAttribute", org.instantlogic.designer.AbstractDeductionSchemeDesign.class);
		ruleOfAttribute = $ruleOfAttribute;
		
		// Phase 2

		$output.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$output.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$output.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.outputOfScheme);
		$deductions.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deductions.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deductions.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.scheme);
		$deductions.owner = true;
		$deductions.multivalue = true;

		$selectionElement.reverse = true;
		$selectionElement.valueClass = org.instantlogic.designer.SelectionDesign.class;
		$selectionElement.to = org.instantlogic.designer.entity.SelectionDesignEntity.INSTANCE;
		$selectionElement.setReverseRelation(org.instantlogic.designer.entity.SelectionDesignEntity.selection);
		$defaultOfAttribute.reverse = true;
		$defaultOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$defaultOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$defaultOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity._default);
		$relevanceOfAttribute.reverse = true;
		$relevanceOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$relevanceOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$relevanceOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.relevance);
		$ruleForValidation.reverse = true;
		$ruleForValidation.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$ruleForValidation.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$ruleForValidation.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.rule);
		$optionsOfRelation.reverse = true;
		$optionsOfRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$optionsOfRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$optionsOfRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.options);
		$ruleOfAttribute.reverse = true;
		$ruleOfAttribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$ruleOfAttribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$ruleOfAttribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.rule);
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
		return "EniqzUlweIgrimtg_feb213c1_8960";
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
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		selectionElement,
		defaultOfAttribute,
		relevanceOfAttribute,
		ruleForValidation,
		optionsOfRelation,
		ruleOfAttribute,
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
