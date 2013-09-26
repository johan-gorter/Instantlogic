package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractDeductionSchemeDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, DeductionSchemeDesign> _staticInstances = new java.util.LinkedHashMap<String, DeductionSchemeDesign>();
	
	public static java.util.Map<String, DeductionSchemeDesign> getStaticDeductionSchemeDesignInstances() {
		return _staticInstances;
	}
	
	private static DeductionSchemeDesign addStaticInstance(String name, DeductionSchemeDesign instance) {
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
		return org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> output
		= createRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> getOutputRelationValue() {
		return output;
	}

	public org.instantlogic.designer.DeductionDesign getOutput() {
		return output.getValue();
	}
	
	public DeductionSchemeDesign setOutput(org.instantlogic.designer.DeductionDesign newValue) {
		output.setValue(newValue);
		return (DeductionSchemeDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> deductions
		= createRelationValues(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> getDeductionsRelationValue() {
		return deductions;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign> getDeductions() {
		return deductions.getValue();
	}
	
	public DeductionSchemeDesign addToDeductions(DeductionDesign item) {
		deductions.addValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign removeFromDeductions(DeductionDesign item) {
		deductions.removeValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> selectedDeduction
		= createRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectedDeduction);
		
	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, DeductionDesign> getSelectedDeductionRelationValue() {
		return selectedDeduction;
	}

	public org.instantlogic.designer.DeductionDesign getSelectedDeduction() {
		return selectedDeduction.getValue();
	}
	
	public DeductionSchemeDesign setSelectedDeduction(org.instantlogic.designer.DeductionDesign newValue) {
		selectedDeduction.setValue(newValue);
		return (DeductionSchemeDesign)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> relevanceOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getRelevanceOfAttributeRelationValue() {
		return relevanceOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRelevanceOfAttribute() {
		return relevanceOfAttribute.getValue();
	}

    public DeductionSchemeDesign setRelevanceOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        relevanceOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, RelationDesign> optionsOfRelation
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.optionsOfRelation);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, RelationDesign> getOptionsOfRelationRelationValue() {
		return optionsOfRelation;
	}

	public org.instantlogic.designer.RelationDesign getOptionsOfRelation() {
		return optionsOfRelation.getValue();
	}

    public DeductionSchemeDesign setOptionsOfRelation(org.instantlogic.designer.RelationDesign newValue) {
        optionsOfRelation.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> ruleOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getRuleOfAttributeRelationValue() {
		return ruleOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getRuleOfAttribute() {
		return ruleOfAttribute.getValue();
	}

    public DeductionSchemeDesign setRuleOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        ruleOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> defaultOfAttribute
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, AttributeDesign> getDefaultOfAttributeRelationValue() {
		return defaultOfAttribute;
	}

	public org.instantlogic.designer.AttributeDesign getDefaultOfAttribute() {
		return defaultOfAttribute.getValue();
	}

    public DeductionSchemeDesign setDefaultOfAttribute(org.instantlogic.designer.AttributeDesign newValue) {
        defaultOfAttribute.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, ValidationDesign> ruleForValidation
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleForValidation);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, ValidationDesign> getRuleForValidationRelationValue() {
		return ruleForValidation;
	}

	public org.instantlogic.designer.ValidationDesign getRuleForValidation() {
		return ruleForValidation.getValue();
	}

    public DeductionSchemeDesign setRuleForValidation(org.instantlogic.designer.ValidationDesign newValue) {
        ruleForValidation.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, PropertyDesign> valueOnPropertyDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.valueOnPropertyDesign);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, PropertyDesign> getValueOnPropertyDesignRelationValue() {
		return valueOnPropertyDesign;
	}

	public org.instantlogic.designer.PropertyDesign getValueOnPropertyDesign() {
		return valueOnPropertyDesign.getValue();
	}

    public DeductionSchemeDesign setValueOnPropertyDesign(org.instantlogic.designer.PropertyDesign newValue) {
        valueOnPropertyDesign.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, IfElseDesign> conditionOnIfElseDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.conditionOnIfElseDesign);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, IfElseDesign> getConditionOnIfElseDesignRelationValue() {
		return conditionOnIfElseDesign;
	}

	public org.instantlogic.designer.IfElseDesign getConditionOnIfElseDesign() {
		return conditionOnIfElseDesign.getValue();
	}

    public DeductionSchemeDesign setConditionOnIfElseDesign(org.instantlogic.designer.IfElseDesign newValue) {
        conditionOnIfElseDesign.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, StringTemplateDesign> deductionOnStringTemplateDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductionOnStringTemplateDesign);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, StringTemplateDesign> getDeductionOnStringTemplateDesignRelationValue() {
		return deductionOnStringTemplateDesign;
	}

	public org.instantlogic.designer.StringTemplateDesign getDeductionOnStringTemplateDesign() {
		return deductionOnStringTemplateDesign.getValue();
	}

    public DeductionSchemeDesign setDeductionOnStringTemplateDesign(org.instantlogic.designer.StringTemplateDesign newValue) {
        deductionOnStringTemplateDesign.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, SelectionDesign> selectionElement
		= createReverseRelationValue(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectionElement);

	public org.instantlogic.fabric.value.RelationValue<DeductionSchemeDesign, SelectionDesign> getSelectionElementRelationValue() {
		return selectionElement;
	}

	public org.instantlogic.designer.SelectionDesign getSelectionElement() {
		return selectionElement.getValue();
	}

    public DeductionSchemeDesign setSelectionElement(org.instantlogic.designer.SelectionDesign newValue) {
        selectionElement.setValue(newValue);
        return (DeductionSchemeDesign)this;
    }


}
