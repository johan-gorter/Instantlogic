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
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValueList<TextTemplateDesign, StringTemplateDesign> untranslated
		= createRelationValueList(org.instantlogic.designer.entity.TextTemplateDesignEntity.untranslated);
		
	public org.instantlogic.fabric.value.RelationValueList<TextTemplateDesign, StringTemplateDesign> getUntranslatedRelationValue() {
		return untranslated;
	}

	public org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign> getUntranslated() {
		return untranslated.getValue();
	}
	
	public TextTemplateDesign addToUntranslated(StringTemplateDesign item) {
		untranslated.addValue(item);
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

	public TextTemplateDesign addToUntranslated(StringTemplateDesign item, int index) {
		untranslated.insertValue(item, index);
		return (TextTemplateDesign)this;
	}	
	

	// Reverse relations
	
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
