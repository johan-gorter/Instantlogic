package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataTypeDesign> {

	public static final DataTypeDesignEntity INSTANCE = new DataTypeDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.DataTypeMultivalueDeduction d0 = new org.instantlogic.designer.deduction.DataTypeMultivalueDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction d0 = new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.ConstantDeduction d1 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d1.setValue(org.instantlogic.designer.DataCategoryDesign.number);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d2 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d2.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d3 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d3.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.addToOperands(d2);
		    d0.addToOperands(d1);
		    d2.setInstance(d3);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.ConstantDeduction d1 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d1.setValue(org.instantlogic.designer.DataCategoryDesign.number);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d2 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d2.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d3 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d3.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.addToOperands(d2);
		    d0.addToOperands(d1);
		    d2.setInstance(d3);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.ConstantDeduction d1 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d1.setValue(false);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d2 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d2.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d3 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d3.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.addToOperands(d2);
		    d0.addToOperands(d1);
		    d2.setInstance(d3);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.ConstantDeduction d1 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d1.setValue(org.instantlogic.designer.DataCategoryDesign.text);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d2 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d2.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d3 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d3.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.addToOperands(d2);
		    d0.addToOperands(d1);
		    d2.setInstance(d3);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction8() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
		  	org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction d0 = new org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction10() {
		  	org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction d0 = new org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction11() {
		  	org.instantlogic.designer.deduction.DataTypeEntityDeduction d0 = new org.instantlogic.designer.deduction.DataTypeEntityDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> dataCategory;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> reverseRelation;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__000f", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DataTypeDesign.class);
		multivalue = $multivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
				"Attributedesign__0010", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DataTypeDesign.class);
		javaClassName = $javaClassName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $percentage
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0011", "percentage", INSTANCE, java.lang.Boolean.class, "percentage", org.instantlogic.designer.DataTypeDesign.class);
		percentage = $percentage;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $wholeNumber
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0012", "wholeNumber", INSTANCE, java.lang.Boolean.class, "wholeNumber", org.instantlogic.designer.DataTypeDesign.class);
		wholeNumber = $wholeNumber;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $exactRounding
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0013", "exactRounding", INSTANCE, java.lang.Boolean.class, "exactRounding", org.instantlogic.designer.DataTypeDesign.class);
		exactRounding = $exactRounding;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multiLine
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0014", "multiLine", INSTANCE, java.lang.Boolean.class, "multiLine", org.instantlogic.designer.DataTypeDesign.class);
		multiLine = $multiLine;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $formatted
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Attributedesign__0015", "formatted", INSTANCE, java.lang.Boolean.class, "formatted", org.instantlogic.designer.DataTypeDesign.class);
		formatted = $formatted;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> $dataCategory
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
				"Relationdesign__001c", "dataCategory", INSTANCE, "dataCategory", org.instantlogic.designer.DataTypeDesign.class);
		dataCategory = $dataCategory;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Relationdesign__001d", "entity", INSTANCE, "entity", org.instantlogic.designer.DataTypeDesign.class);
		entity = $entity;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Relationdesign__0010", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.DataTypeDesign.class);
		forEntity = $forEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Relationdesign__0025", "attribute", INSTANCE, "attribute", org.instantlogic.designer.DataTypeDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $reverseRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"Relationdesign__0031", "reverseRelation", INSTANCE, "reverseRelation", org.instantlogic.designer.DataTypeDesign.class);
		reverseRelation = $reverseRelation;
		
		// Phase 2
		$multivalue.dataType.put("category", "boolean");
		$multivalue.rule = createDeduction0();
		$multivalue._default = createDeduction1();
		$javaClassName.dataType.put("category", "text");
		$javaClassName._default = createDeduction2();
		$percentage.dataType.put("category", "boolean");
		$percentage.relevance = createDeduction3();
		$wholeNumber.dataType.put("category", "boolean");
		$wholeNumber.relevance = createDeduction4();
		$wholeNumber._default = createDeduction5();
		$exactRounding.dataType.put("category", "boolean");
		$exactRounding.relevance = createDeduction6();
		$multiLine.dataType.put("category", "boolean");
		$multiLine.relevance = createDeduction7();
		$formatted.dataType.put("category", "boolean");
		$formatted.relevance = createDeduction8();

		$dataCategory.valueClass = org.instantlogic.designer.DataCategoryDesign.class;
		$dataCategory.to = org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
		$dataCategory.rule = createDeduction9();
		$dataCategory.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction10();
		$dataCategory.validations = new org.instantlogic.fabric.model.Validation[] {
			org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
		};
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.readOnly = true;
		$entity.rule = createDeduction11();

		$forEntity.reverse = true;
		$forEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$forEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$forEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.dataType);
		$attribute.reverse = true;
		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
		$reverseRelation.reverse = true;
		$reverseRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType);
	}

	@Override
	public org.instantlogic.designer.DataTypeDesign createInstance() {
		return new org.instantlogic.designer.DataTypeDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DataTypeDesign> getInstanceClass() {
		return org.instantlogic.designer.DataTypeDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Entitydesign__000e";
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		multivalue,
		javaClassName,
		percentage,
		wholeNumber,
		exactRounding,
		multiLine,
		formatted,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategory,
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		forEntity,
		attribute,
		reverseRelation,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
		org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
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
	public java.util.Map<String, org.instantlogic.designer.DataTypeDesign> getStaticInstances() {
		return org.instantlogic.designer.DataTypeDesign.getStaticDataTypeDesignInstances();
	}
}
