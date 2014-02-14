package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class TextTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TextTemplateDesign> {

	public static final TextTemplateDesignEntity INSTANCE = new TextTemplateDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign> untranslated;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> descriptionOnStaticInstanceDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> explanationOnAttributeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> messageOfValidation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> questionOnAttributeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> textOnPropertyDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> titleOfPlaceTemplate;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> titleOfEntity;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign> $untranslated
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign>(
				"RelationDesign_untranslated", "untranslated", INSTANCE, "untranslated", org.instantlogic.designer.TextTemplateDesign.class);
		untranslated = $untranslated;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> $descriptionOnStaticInstanceDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
				"RelationDesign_description", "descriptionOnStaticInstanceDesign", INSTANCE, "descriptionOnStaticInstanceDesign", org.instantlogic.designer.TextTemplateDesign.class);
		descriptionOnStaticInstanceDesign = $descriptionOnStaticInstanceDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $explanationOnAttributeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"RelationDesign_explanation", "explanationOnAttributeDesign", INSTANCE, "explanationOnAttributeDesign", org.instantlogic.designer.TextTemplateDesign.class);
		explanationOnAttributeDesign = $explanationOnAttributeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $messageOfValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"RelationDesign_message", "messageOfValidation", INSTANCE, "messageOfValidation", org.instantlogic.designer.TextTemplateDesign.class);
		messageOfValidation = $messageOfValidation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $questionOnAttributeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"RelationDesign_question", "questionOnAttributeDesign", INSTANCE, "questionOnAttributeDesign", org.instantlogic.designer.TextTemplateDesign.class);
		questionOnAttributeDesign = $questionOnAttributeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign> $textOnPropertyDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PropertyDesign, org.instantlogic.designer.PropertyDesign>(
				"RelationDesign_text", "textOnPropertyDesign", INSTANCE, "textOnPropertyDesign", org.instantlogic.designer.TextTemplateDesign.class);
		textOnPropertyDesign = $textOnPropertyDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $titleOfPlaceTemplate
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"RelationDesign_title", "titleOfPlaceTemplate", INSTANCE, "titleOfPlaceTemplate", org.instantlogic.designer.TextTemplateDesign.class);
		titleOfPlaceTemplate = $titleOfPlaceTemplate;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $titleOfEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_title_1", "titleOfEntity", INSTANCE, "titleOfEntity", org.instantlogic.designer.TextTemplateDesign.class);
		titleOfEntity = $titleOfEntity;
		
		// Phase 2

		$untranslated.valueClass = org.instantlogic.designer.StringTemplateDesign.class;
		$untranslated.to = org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
		$untranslated.setReverseRelation(org.instantlogic.designer.entity.StringTemplateDesignEntity.untranslatedInTemplate);
		$untranslated.owner = true;
		$untranslated.multivalue = true;
		$untranslated.ordered = true;

		$descriptionOnStaticInstanceDesign.reverse = true;
		$descriptionOnStaticInstanceDesign.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$descriptionOnStaticInstanceDesign.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$descriptionOnStaticInstanceDesign.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.description);
		$explanationOnAttributeDesign.reverse = true;
		$explanationOnAttributeDesign.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$explanationOnAttributeDesign.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$explanationOnAttributeDesign.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.explanation);
		$messageOfValidation.reverse = true;
		$messageOfValidation.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$messageOfValidation.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$messageOfValidation.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.message);
		$questionOnAttributeDesign.reverse = true;
		$questionOnAttributeDesign.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$questionOnAttributeDesign.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$questionOnAttributeDesign.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.question);
		$textOnPropertyDesign.reverse = true;
		$textOnPropertyDesign.valueClass = org.instantlogic.designer.PropertyDesign.class;
		$textOnPropertyDesign.to = org.instantlogic.designer.entity.PropertyDesignEntity.INSTANCE;
		$textOnPropertyDesign.setReverseRelation(org.instantlogic.designer.entity.PropertyDesignEntity.text);
		$titleOfPlaceTemplate.reverse = true;
		$titleOfPlaceTemplate.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$titleOfPlaceTemplate.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$titleOfPlaceTemplate.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.title);
		$titleOfEntity.reverse = true;
		$titleOfEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$titleOfEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$titleOfEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.title);
	}

	@Override
	public org.instantlogic.designer.TextTemplateDesign createInstance() {
		return new org.instantlogic.designer.TextTemplateDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.TextTemplateDesign> getInstanceClass() {
		return org.instantlogic.designer.TextTemplateDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "EntityDesign_TextTemplateDesign";
	}
	
	@Override
	public String getName() {
		return "TextTemplateDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		untranslated,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		descriptionOnStaticInstanceDesign,
		explanationOnAttributeDesign,
		messageOfValidation,
		questionOnAttributeDesign,
		textOnPropertyDesign,
		titleOfPlaceTemplate,
		titleOfEntity,
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
	public java.util.Map<String, org.instantlogic.designer.TextTemplateDesign> getStaticInstances() {
		return org.instantlogic.designer.TextTemplateDesign.getStaticTextTemplateDesignInstances();
	}
}
