package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class StringTemplateDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, StringTemplateDesign> _staticInstances = new java.util.LinkedHashMap<String, StringTemplateDesign>();
	
	public static java.util.Map<String, StringTemplateDesign> getStaticStringTemplateDesignInstances() {
		return _staticInstances;
	}
	
	private static StringTemplateDesign addStaticInstance(String name, StringTemplateDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<StringTemplateDesign, java.lang.String> constantText
		= createAttributeValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.constantText);
	
	public java.lang.String getConstantText() {
		return constantText.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<StringTemplateDesign, java.lang.String> getConstantTextAttributeValue() {
		return constantText;
	}

	public StringTemplateDesign setConstantText(java.lang.String newValue) {
		constantText.setValue(newValue);
		return (StringTemplateDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, DeductionSchemeDesign> deduction
		= createRelationValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.deduction);
		
	public org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, DeductionSchemeDesign> getDeductionRelationValue() {
		return deduction;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getDeduction() {
		return deduction.getValue();
	}
	
	public StringTemplateDesign setDeduction(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		deduction.setValue(newValue);
		return (StringTemplateDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newDeduction() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		deduction.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, TextTemplateDesign> untranslatedInTemplate
		= createReverseRelationValue(org.instantlogic.designer.entity.StringTemplateDesignEntity.untranslatedInTemplate);

	public org.instantlogic.fabric.value.RelationValue<StringTemplateDesign, TextTemplateDesign> getUntranslatedInTemplateRelationValue() {
		return untranslatedInTemplate;
	}

	public org.instantlogic.designer.TextTemplateDesign getUntranslatedInTemplate() {
		return untranslatedInTemplate.getValue();
	}

    public StringTemplateDesign setUntranslatedInTemplate(org.instantlogic.designer.TextTemplateDesign newValue) {
        untranslatedInTemplate.setValue(newValue);
        return (StringTemplateDesign)this;
    }


}
