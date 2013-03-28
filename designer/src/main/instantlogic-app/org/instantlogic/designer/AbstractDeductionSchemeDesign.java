/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
	
	private final org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> deductions
		= createRelationValues(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		
	public org.instantlogic.fabric.value.RelationValues<DeductionSchemeDesign, DeductionDesign> getDeductionsRelationValue() {
		return deductions;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign> getDeductions() {
		return deductions.getValue();
	}
	
	public DeductionSchemeDesign addToDeductions(DeductionDesign item) {
		deductions.addValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign addToDeductions(DeductionDesign item, int index) {
		deductions.insertValue(item, index);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign removeFromDeductions(DeductionDesign item) {
		deductions.removeValue(item);
		return (DeductionSchemeDesign)this;
	}
	
	public DeductionSchemeDesign removeFromDeductions(int index) {
		deductions.removeValue(index);
		return (DeductionSchemeDesign)this;
	}
	
	
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
	


	// Reverse relations
	
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
