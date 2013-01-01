package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class StringTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.StringTemplateDesign> {

	public static final StringTemplateDesignEntity INSTANCE = new StringTemplateDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.StringTemplateDesign createInstance() {
		return new org.instantlogic.designer.StringTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.StringTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.StringTemplateDesign.class;
	}
	
	@Override
	public String getName() {
		return "StringTemplateDesign";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.StringTemplateDesign, java.lang.String, java.lang.String> constantText 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.StringTemplateDesign, java.lang.String, java.lang.String>(
			"constantText", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.StringTemplateDesign, java.lang.String> get(org.instantlogic.designer.StringTemplateDesign instance) {
				return instance.getConstantTextAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE, org.instantlogic.designer.DeductionSchemeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.DeductionSchemeDesign> get(
					org.instantlogic.designer.StringTemplateDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> untranslatedInTemplate
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
			"untranslatedInTemplate", INSTANCE, org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE, org.instantlogic.designer.TextTemplateDesign.class, org.instantlogic.designer.entity.TextTemplateDesignEntity.untranslated
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.StringTemplateDesign, org.instantlogic.designer.TextTemplateDesign> get(
					org.instantlogic.designer.StringTemplateDesign instance) {
				return instance.getUntranslatedInTemplateRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

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
