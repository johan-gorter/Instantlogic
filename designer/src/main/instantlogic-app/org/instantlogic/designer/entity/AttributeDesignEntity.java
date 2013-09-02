package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class AttributeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.AttributeDesign> {

	public static final AttributeDesignEntity INSTANCE = new AttributeDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	private static final org.instantlogic.fabric.model.Entity<?>[] EXTENSIONS;
	 
	@Override
	public org.instantlogic.fabric.model.Entity[] extensions() {
		return EXTENSIONS;
	}
	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(true);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.designer.deduction.AttributeBelongsToDeduction d0 = new org.instantlogic.designer.deduction.AttributeBelongsToDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasDefault; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasRelevance; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> writeable; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasRule; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> question;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> relevance;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> _default;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> belongsToEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> explanation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> attributeOf;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasDefault
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"CqE_uwlabecmobiw_341b0465_4d5a", "hasDefault", INSTANCE, java.lang.Boolean.class, "hasDefault", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasDefault = $hasDefault;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasRelevance
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Tol_neobnacoglkz_84992008_f3d2", "hasRelevance", INSTANCE, java.lang.Boolean.class, "hasRelevance", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasRelevance = $hasRelevance;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $writeable
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Wuialkilpydpsmm_831461f7_b9a0", "writeable", INSTANCE, java.lang.Boolean.class, "writeable", org.instantlogic.designer.AbstractAttributeDesign.class);
		writeable = $writeable;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasRule
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"odgvrndnqucnccgl_09e6110d_d9b8", "hasRule", INSTANCE, java.lang.Boolean.class, "hasRule", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasRule = $hasRule;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $question
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"Prrocmccli_cumyu_86597e18_0889", "question", INSTANCE, "question", org.instantlogic.designer.AbstractAttributeDesign.class);
		question = $question;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"RpAdptjIqmafyevk_5f3cf7f0_731a", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractAttributeDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $relevance
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"XbjrfrbeoebEekee_22a6a3ca_d426", "relevance", INSTANCE, "relevance", org.instantlogic.designer.AbstractAttributeDesign.class);
		relevance = $relevance;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $_default
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"XeucAopevme_odea_f54b3839_ce03", "default", INSTANCE, "_default", org.instantlogic.designer.AbstractAttributeDesign.class);
		_default = $_default;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $belongsToEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"YpelItmmraelwbkz_c5199f7b_2f0b", "belongsToEntity", INSTANCE, "belongsToEntity", org.instantlogic.designer.AbstractAttributeDesign.class);
		belongsToEntity = $belongsToEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $explanation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"ZnoelkrluueiaoEk_fe682742_8f86", "explanation", INSTANCE, "explanation", org.instantlogic.designer.AbstractAttributeDesign.class);
		explanation = $explanation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $rule
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"osUk_pzOAmdswhaf_c589fac4_64d5", "rule", INSTANCE, "rule", org.instantlogic.designer.AbstractAttributeDesign.class);
		rule = $rule;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"DErgrsEwcIcrm_za_a246511a_8ed8", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractAttributeDesign.class);
		validations = $validations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $attributeOf
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RvnEchnctugjmexn_41245aaf_ce88", "attributeOf", INSTANCE, "attributeOf", org.instantlogic.designer.AbstractAttributeDesign.class);
		attributeOf = $attributeOf;
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE
		};
		$hasDefault.dataType.put("category", "boolean");
		$hasRelevance.dataType.put("category", "boolean");
		$hasRelevance._default = createDeduction0();
		$writeable.dataType.put("category", "boolean");
		$writeable._default = createDeduction1();
		$hasRule.dataType.put("category", "boolean");
		$hasRule._default = createDeduction2();

		$question.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$question.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$question.owner = true;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.attribute);
		$dataType.owner = true;
		$dataType.autoCreate = true;
		$relevance.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$relevance.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$relevance.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);
		$relevance.owner = true;
		$_default.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$_default.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$_default.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);
		$_default.owner = true;
		$belongsToEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$belongsToEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$belongsToEntity.readOnly = true;
		$belongsToEntity.rule = createDeduction3();
		$explanation.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$explanation.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$explanation.owner = true;
		$rule.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$rule.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$rule.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);
		$rule.owner = true;

		$validations.reverse = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.displayWith);
		$validations.multivalue = true;
		$attributeOf.reverse = true;
		$attributeOf.valueClass = org.instantlogic.designer.EntityDesign.class;
		$attributeOf.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$attributeOf.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
	}

	@Override
	public org.instantlogic.designer.AttributeDesign createInstance() {
		return new org.instantlogic.designer.AttributeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.AttributeDesign> getInstanceClass() {
		return org.instantlogic.designer.AttributeDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "MosnzezbrIbnukia_30f942eb_c7c7";
	}
	
	@Override
	public String getName() {
		return "AttributeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		hasDefault,
		hasRelevance,
		writeable,
		hasRule,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		question,
		dataType,
		relevance,
		_default,
		belongsToEntity,
		explanation,
		rule,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		validations,
		attributeOf,
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
	public java.util.Map<String, org.instantlogic.designer.AttributeDesign> getStaticInstances() {
		return org.instantlogic.designer.AttributeDesign.getStaticAttributeDesignInstances();
	}
}
