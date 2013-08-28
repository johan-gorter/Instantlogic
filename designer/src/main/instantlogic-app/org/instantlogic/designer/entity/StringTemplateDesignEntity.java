package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class StringTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StringTemplateDesign> {

	public static final StringTemplateDesignEntity INSTANCE = new StringTemplateDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.StringTemplateDesign, java.lang.String, java.lang.String> constantText; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> untranslatedInTemplate;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StringTemplateDesign, java.lang.String, java.lang.String> $constantText
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StringTemplateDesign, java.lang.String, java.lang.String>(
				"LhlEbs__xmarmhxm_ff80fca1_41b6", "constantText", INSTANCE, java.lang.String.class, "constantText", org.instantlogic.designer.StringTemplateDesign.class);
		constantText = $constantText;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"WjUoxEkvOIcuodEi_3541f472_d7ca", "deduction", INSTANCE, "deduction", org.instantlogic.designer.StringTemplateDesign.class);
		deduction = $deduction;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $untranslatedInTemplate
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"DpknUbpuIabiukmh_9a3a5a8f_7bc9", "untranslatedInTemplate", INSTANCE, "untranslatedInTemplate", org.instantlogic.designer.StringTemplateDesign.class);
		untranslatedInTemplate = $untranslatedInTemplate;
		
		// Phase 2
		$constantText.dataType.put("category", "text");

		$deduction.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$deduction.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$deduction.owner = true;
		$deduction.autoCreate = true;

		$untranslatedInTemplate.reverse = true;
		$untranslatedInTemplate.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$untranslatedInTemplate.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$untranslatedInTemplate.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.untranslated);
	}

	@Override
	public org.instantlogic.designer.StringTemplateDesign createInstance() {
		return new org.instantlogic.designer.StringTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.StringTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.StringTemplateDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "LsyymuezgqdjggUc_94cbd6b3_c7be";
	}
	
	@Override
	public String getName() {
		return "StringTemplateDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		constantText,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deduction,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		untranslatedInTemplate,
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
	public java.util.Map<String, org.instantlogic.designer.StringTemplateDesign> getStaticInstances() {
		return org.instantlogic.designer.StringTemplateDesign.getStaticStringTemplateDesignInstances();
	}
}
