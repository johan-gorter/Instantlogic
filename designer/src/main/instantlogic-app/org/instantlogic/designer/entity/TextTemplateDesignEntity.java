package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class TextTemplateDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.TextTemplateDesign> {

	public static final TextTemplateDesignEntity INSTANCE = new TextTemplateDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign> untranslated;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> titleOfPlaceTemplate;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> titleOfEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> messageOfValidation;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign> $untranslated
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.StringTemplateDesign>, org.instantlogic.designer.StringTemplateDesign>(
				"EzgvwEuiUefeqlal_e3c178a1_0598", "untranslated", INSTANCE, "untranslated", org.instantlogic.designer.TextTemplateDesign.class);
		untranslated = $untranslated;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign> $titleOfPlaceTemplate
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign, org.instantlogic.designer.PlaceTemplateDesign>(
				"AvpbiAevkec_Agb_e679a2c7_f99b", "titleOfPlaceTemplate", INSTANCE, "titleOfPlaceTemplate", org.instantlogic.designer.TextTemplateDesign.class);
		titleOfPlaceTemplate = $titleOfPlaceTemplate;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $titleOfEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"TmufkvuicieUgbzy_89a9ca3b_7f20", "titleOfEntity", INSTANCE, "titleOfEntity", org.instantlogic.designer.TextTemplateDesign.class);
		titleOfEntity = $titleOfEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign> $messageOfValidation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.ValidationDesign, org.instantlogic.designer.ValidationDesign>(
				"WsAxEjcmEibwebil_de6f34a9_4ed1", "messageOfValidation", INSTANCE, "messageOfValidation", org.instantlogic.designer.TextTemplateDesign.class);
		messageOfValidation = $messageOfValidation;
		
		// Phase 2

		$untranslated.valueClass = org.instantlogic.designer.StringTemplateDesign.class;
		$untranslated.to = org.instantlogic.designer.entity.StringTemplateDesignEntity.INSTANCE;
		$untranslated.setReverseRelation(org.instantlogic.designer.entity.StringTemplateDesignEntity.untranslatedInTemplate);
		$untranslated.owner = true;
		$untranslated.multivalue = true;
		$untranslated.ordered = true;

		$titleOfPlaceTemplate.reverse = true;
		$titleOfPlaceTemplate.valueClass = org.instantlogic.designer.PlaceTemplateDesign.class;
		$titleOfPlaceTemplate.to = org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
		$titleOfPlaceTemplate.setReverseRelation(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.title);
		$titleOfEntity.reverse = true;
		$titleOfEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$titleOfEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$titleOfEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.title);
		$messageOfValidation.reverse = true;
		$messageOfValidation.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$messageOfValidation.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$messageOfValidation.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.message);
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
		return "VphlOOtIbqaiwlgu_a04137b0_ca21";
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
		titleOfPlaceTemplate,
		titleOfEntity,
		messageOfValidation,
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
