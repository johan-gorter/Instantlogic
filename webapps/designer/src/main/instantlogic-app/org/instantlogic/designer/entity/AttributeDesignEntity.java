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
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(true);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.designer.deduction.AttributeBelongsToDeduction d0 = new org.instantlogic.designer.deduction.AttributeBelongsToDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasDefault; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasRelevance; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> hasRule; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> writeable; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> belongsToEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> _default;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> explanation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> question;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> relevance;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> rule;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> attributeOnFragmentTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> attributeValueOnDeductionParameterDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> attributeOnStaticInstanceValueDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> attributeOf;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasDefault
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasDefault", "hasDefault", INSTANCE, java.lang.Boolean.class, "hasDefault", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasDefault = $hasDefault;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasRelevance
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasRelevance", "hasRelevance", INSTANCE, java.lang.Boolean.class, "hasRelevance", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasRelevance = $hasRelevance;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $hasRule
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_hasRule", "hasRule", INSTANCE, java.lang.Boolean.class, "hasRule", org.instantlogic.designer.AbstractAttributeDesign.class);
		hasRule = $hasRule;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean> $writeable
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.AttributeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AttributeDesign_writeable", "writeable", INSTANCE, java.lang.Boolean.class, "writeable", org.instantlogic.designer.AbstractAttributeDesign.class);
		writeable = $writeable;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $belongsToEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_belongsToEntity", "belongsToEntity", INSTANCE, "belongsToEntity", org.instantlogic.designer.AbstractAttributeDesign.class);
		belongsToEntity = $belongsToEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"RelationDesign_dataType", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractAttributeDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $_default
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_default", "default", INSTANCE, "_default", org.instantlogic.designer.AbstractAttributeDesign.class);
		_default = $_default;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $explanation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"RelationDesign_explanation", "explanation", INSTANCE, "explanation", org.instantlogic.designer.AbstractAttributeDesign.class);
		explanation = $explanation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $question
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"RelationDesign_question", "question", INSTANCE, "question", org.instantlogic.designer.AbstractAttributeDesign.class);
		question = $question;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $relevance
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_relevance", "relevance", INSTANCE, "relevance", org.instantlogic.designer.AbstractAttributeDesign.class);
		relevance = $relevance;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $rule
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"RelationDesign_rule", "rule", INSTANCE, "rule", org.instantlogic.designer.AbstractAttributeDesign.class);
		rule = $rule;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $attributeOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"reverse-RelationDesign_attribute", "attributeOnFragmentTemplateDesign", INSTANCE, "attributeOnFragmentTemplateDesign", org.instantlogic.designer.AbstractAttributeDesign.class);
		attributeOnFragmentTemplateDesign = $attributeOnFragmentTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $attributeValueOnDeductionParameterDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"reverse-RelationDesign_attributeValue", "attributeValueOnDeductionParameterDesign", INSTANCE, "attributeValueOnDeductionParameterDesign", org.instantlogic.designer.AbstractAttributeDesign.class);
		attributeValueOnDeductionParameterDesign = $attributeValueOnDeductionParameterDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign> $attributeOnStaticInstanceValueDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceValueDesign>, org.instantlogic.designer.StaticInstanceValueDesign>(
				"reverse-RelationDesign_attribute_1", "attributeOnStaticInstanceValueDesign", INSTANCE, "attributeOnStaticInstanceValueDesign", org.instantlogic.designer.AbstractAttributeDesign.class);
		attributeOnStaticInstanceValueDesign = $attributeOnStaticInstanceValueDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $attributeOf
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"reverse-RelationDesign_attributes", "attributeOf", INSTANCE, "attributeOf", org.instantlogic.designer.AbstractAttributeDesign.class);
		attributeOf = $attributeOf;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.AttributeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"reverse-RelationDesign_displayWith", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractAttributeDesign.class);
		validations = $validations;
		
		// Phase 2
		EXTENSIONS = new org.instantlogic.fabric.model.Entity<?>[] {
			org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE
		};
		$hasDefault.dataType.put("category", "boolean");
		$hasRelevance.dataType.put("category", "boolean");
		$hasRelevance._default = createDeduction0();
		$hasRule.dataType.put("category", "boolean");
		$hasRule._default = createDeduction1();
		$writeable.dataType.put("category", "boolean");
		$writeable._default = createDeduction2();

		$belongsToEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$belongsToEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$belongsToEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.belongsToEntityOnAttributeDesign);
		$belongsToEntity.readOnly = true;
		$belongsToEntity.rule = createDeduction3();
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.attribute);
		$dataType.owner = true;
		$dataType.autoCreate = true;
		$_default.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$_default.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$_default.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.defaultOfAttribute);
		$_default.owner = true;
		$explanation.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$explanation.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$explanation.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.explanationOnAttributeDesign);
		$explanation.owner = true;
		$question.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$question.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$question.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.questionOnAttributeDesign);
		$question.owner = true;
		$relevance.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$relevance.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$relevance.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.relevanceOfAttribute);
		$relevance.owner = true;
		$rule.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$rule.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$rule.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.ruleOfAttribute);
		$rule.owner = true;

		$attributeOnFragmentTemplateDesign.reverse = true;
		$attributeOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$attributeOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$attributeOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.attribute);
		$attributeOnFragmentTemplateDesign.multivalue = true;
		$attributeValueOnDeductionParameterDesign.reverse = true;
		$attributeValueOnDeductionParameterDesign.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$attributeValueOnDeductionParameterDesign.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$attributeValueOnDeductionParameterDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.attributeValue);
		$attributeValueOnDeductionParameterDesign.multivalue = true;
		$attributeOnStaticInstanceValueDesign.reverse = true;
		$attributeOnStaticInstanceValueDesign.valueClass = org.instantlogic.designer.StaticInstanceValueDesign.class;
		$attributeOnStaticInstanceValueDesign.to = org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.INSTANCE;
		$attributeOnStaticInstanceValueDesign.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceValueDesignEntity.attribute);
		$attributeOnStaticInstanceValueDesign.multivalue = true;
		$attributeOf.reverse = true;
		$attributeOf.valueClass = org.instantlogic.designer.EntityDesign.class;
		$attributeOf.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$attributeOf.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.attributes);
		$validations.reverse = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.displayWith);
		$validations.multivalue = true;
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
		return "EntityDesign_AttributeDesign";
	}
	
	@Override
	public String getName() {
		return "AttributeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		hasDefault,
		hasRelevance,
		hasRule,
		writeable,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		belongsToEntity,
		dataType,
		_default,
		explanation,
		question,
		relevance,
		rule,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributeOnFragmentTemplateDesign,
		attributeValueOnDeductionParameterDesign,
		attributeOnStaticInstanceValueDesign,
		attributeOf,
		validations,
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
