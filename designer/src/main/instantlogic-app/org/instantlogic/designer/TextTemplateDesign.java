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
public class TextTemplateDesign extends Design { 

	private static final java.util.Map<String, TextTemplateDesign> _staticInstances = new java.util.LinkedHashMap<String, TextTemplateDesign>();
	
	public static java.util.Map<String, TextTemplateDesign> getStaticTextTemplateDesignInstances() {
		return _staticInstances;
	}
	
	private static TextTemplateDesign addStaticInstance(String name, TextTemplateDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<TextTemplateDesign, StringTemplateDesign> untranslated
		= createRelationValues(org.instantlogic.designer.entity.TextTemplateDesignEntity.untranslated);
		
	public org.instantlogic.fabric.value.RelationValues<TextTemplateDesign, StringTemplateDesign> getUntranslatedRelationValue() {
		return untranslated;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.StringTemplateDesign> getUntranslated() {
		return untranslated.getValue();
	}
	
	public TextTemplateDesign addToUntranslated(StringTemplateDesign item) {
		untranslated.addValue(item);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign addToUntranslated(StringTemplateDesign item, int index) {
		untranslated.insertValue(item, index);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign removeFromUntranslated(StringTemplateDesign item) {
		untranslated.removeValue(item);
		return (TextTemplateDesign)this;
	}
	
	public TextTemplateDesign removeFromUntranslated(int index) {
		untranslated.removeValue(index);
		return (TextTemplateDesign)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, ValidationDesign> messageOfValidation
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.messageOfValidation);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, ValidationDesign> getMessageOfValidationRelationValue() {
		return messageOfValidation;
	}

	public org.instantlogic.designer.ValidationDesign getMessageOfValidation() {
		return messageOfValidation.getValue();
	}

    public TextTemplateDesign setMessageOfValidation(org.instantlogic.designer.ValidationDesign newValue) {
        messageOfValidation.setValue(newValue);
        return (TextTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, EntityDesign> titleOfEntity
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfEntity);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, EntityDesign> getTitleOfEntityRelationValue() {
		return titleOfEntity;
	}

	public org.instantlogic.designer.EntityDesign getTitleOfEntity() {
		return titleOfEntity.getValue();
	}

    public TextTemplateDesign setTitleOfEntity(org.instantlogic.designer.EntityDesign newValue) {
        titleOfEntity.setValue(newValue);
        return (TextTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, PlaceTemplateDesign> titleOfPlaceTemplate
		= createReverseRelationValue(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfPlaceTemplate);

	public org.instantlogic.fabric.value.RelationValue<TextTemplateDesign, PlaceTemplateDesign> getTitleOfPlaceTemplateRelationValue() {
		return titleOfPlaceTemplate;
	}

	public org.instantlogic.designer.PlaceTemplateDesign getTitleOfPlaceTemplate() {
		return titleOfPlaceTemplate.getValue();
	}

    public TextTemplateDesign setTitleOfPlaceTemplate(org.instantlogic.designer.PlaceTemplateDesign newValue) {
        titleOfPlaceTemplate.setValue(newValue);
        return (TextTemplateDesign)this;
    }


}
