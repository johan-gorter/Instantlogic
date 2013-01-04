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
public abstract class AbstractValidationDesign extends Design { 

	private static final java.util.Map<String, ValidationDesign> _staticInstances = new java.util.LinkedHashMap<String, ValidationDesign>();
	
	public static java.util.Map<String, ValidationDesign> getStaticValidationDesignInstances() {
		return _staticInstances;
	}
	
	private static ValidationDesign addStaticInstance(String name, ValidationDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<ValidationDesign, AttributeDesign> displayWith
		= createRelationValues(org.instantlogic.designer.entity.ValidationDesignEntity.displayWith);
		
	public org.instantlogic.fabric.value.RelationValues<ValidationDesign, AttributeDesign> getDisplayWithRelationValue() {
		return displayWith;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.AttributeDesign> getDisplayWith() {
		return displayWith.getValue();
	}
	
	public ValidationDesign addToDisplayWith(AttributeDesign item) {
		displayWith.addValue(item);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign addToDisplayWith(AttributeDesign item, int index) {
		displayWith.insertValue(item, index);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign removeFromDisplayWith(AttributeDesign item) {
		displayWith.removeValue(item);
		return (ValidationDesign)this;
	}
	
	public ValidationDesign removeFromDisplayWith(int index) {
		displayWith.removeValue(index);
		return (ValidationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, TextTemplateDesign> message
		= createRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.message);
		
	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, TextTemplateDesign> getMessageRelationValue() {
		return message;
	}

	public org.instantlogic.designer.TextTemplateDesign getMessage() {
		return message.getValue();
	}
	
	public ValidationDesign setMessage(org.instantlogic.designer.TextTemplateDesign newValue) {
		message.setValue(newValue);
		return (ValidationDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newMessage() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		message.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, DeductionSchemeDesign> rule
		= createRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.rule);
		
	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, DeductionSchemeDesign> getRuleRelationValue() {
		return rule;
	}

	public org.instantlogic.designer.DeductionSchemeDesign getRule() {
		return rule.getValue();
	}
	
	public ValidationDesign setRule(org.instantlogic.designer.DeductionSchemeDesign newValue) {
		rule.setValue(newValue);
		return (ValidationDesign)this;
	}
	
	public org.instantlogic.designer.DeductionSchemeDesign newRule() {
		org.instantlogic.designer.DeductionSchemeDesign newValue = new org.instantlogic.designer.DeductionSchemeDesign(); 
		rule.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<ValidationDesign, EntityDesign> forEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);

	public org.instantlogic.fabric.value.RelationValue<ValidationDesign, EntityDesign> getForEntityRelationValue() {
		return forEntity;
	}

	public org.instantlogic.designer.EntityDesign getForEntity() {
		return forEntity.getValue();
	}

    public ValidationDesign setForEntity(org.instantlogic.designer.EntityDesign newValue) {
        forEntity.setValue(newValue);
        return (ValidationDesign)this;
    }


}
