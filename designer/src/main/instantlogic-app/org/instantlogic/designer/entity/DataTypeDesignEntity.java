package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataTypeDesign> {

	public static final DataTypeDesignEntity INSTANCE = new DataTypeDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.dataCategory);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.ConstantDeduction d3 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d3.setValue(org.instantlogic.designer.DataCategoryDesign.number);
		    d0.addToOperands(d3);
		    d0.addToOperands(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.ConstantDeduction d1 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d1.setValue(true);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d2 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d2.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.multivalue);
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.EqualsDeduction d0 = new org.instantlogic.fabric.deduction.EqualsDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.wholeNumber);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.ConstantDeduction d3 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d3.setValue(false);
		    d0.addToOperands(d3);
		    d0.addToOperands(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.designer.deduction.DataTypeMultivalueDeduction d0 = new org.instantlogic.designer.deduction.DataTypeMultivalueDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
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
		  	org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction d0 = new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction10() {
		  	org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction d0 = new org.instantlogic.designer.deduction.DataTypeDataCategoryDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction11() {
		  	org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction d0 = new org.instantlogic.designer.deduction.DataTypeDataCategoryOptionsDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction12() {
		  	org.instantlogic.designer.deduction.DataTypeEntityDeduction d0 = new org.instantlogic.designer.deduction.DataTypeEntityDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> ordered; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName; 
	
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
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $wholeNumber
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"GoOwca_nkebakiUn_5e5bc50f_b0c0", "wholeNumber", INSTANCE, java.lang.Boolean.class, "wholeNumber", org.instantlogic.designer.DataTypeDesign.class);
		wholeNumber = $wholeNumber;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $percentage
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"HbitdpzwnacbIowg_ce9b2629_9771", "percentage", INSTANCE, java.lang.Boolean.class, "percentage", org.instantlogic.designer.DataTypeDesign.class);
		percentage = $percentage;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $ordered
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"MenU_znwoybAyoOq_29a4531f_9836", "ordered", INSTANCE, java.lang.Boolean.class, "ordered", org.instantlogic.designer.DataTypeDesign.class);
		ordered = $ordered;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multiLine
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"MrImgtrpgydayn_v_ccbbb5c3_6f36", "multiLine", INSTANCE, java.lang.Boolean.class, "multiLine", org.instantlogic.designer.DataTypeDesign.class);
		multiLine = $multiLine;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $exactRounding
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Ovrmkhpdwafduenj_9dfb4bfb_b88e", "exactRounding", INSTANCE, java.lang.Boolean.class, "exactRounding", org.instantlogic.designer.DataTypeDesign.class);
		exactRounding = $exactRounding;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"UeOpyofadugaaazd_dd28f3c2_d270", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DataTypeDesign.class);
		multivalue = $multivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $formatted
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"_lIunwoeOmacsikU_8ba90850_7044", "formatted", INSTANCE, java.lang.Boolean.class, "formatted", org.instantlogic.designer.DataTypeDesign.class);
		formatted = $formatted;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
				"euOjfjvpUeeEcbsy_3beb3514_a3bc", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DataTypeDesign.class);
		javaClassName = $javaClassName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> $dataCategory
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
				"BeExeiUOzqdjonws_b3a8d620_c1d2", "dataCategory", INSTANCE, "dataCategory", org.instantlogic.designer.DataTypeDesign.class);
		dataCategory = $dataCategory;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"IzpzrhsnfIbfwexU_ade87338_be1b", "entity", INSTANCE, "entity", org.instantlogic.designer.DataTypeDesign.class);
		entity = $entity;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"MgEeErUlhagmeols_170be936_c826", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.DataTypeDesign.class);
		forEntity = $forEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"OejceUbdkmfuwfjm_06ca3f5c_db28", "attribute", INSTANCE, "attribute", org.instantlogic.designer.DataTypeDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $reverseRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"amOfisyAsigck_hy_ac0dbf69_4387", "reverseRelation", INSTANCE, "reverseRelation", org.instantlogic.designer.DataTypeDesign.class);
		reverseRelation = $reverseRelation;
		
		// Phase 2
		$wholeNumber.dataType.put("category", "boolean");
		$wholeNumber.relevance = createDeduction0();
		$wholeNumber._default = createDeduction1();
		$percentage.dataType.put("category", "boolean");
		$percentage.relevance = createDeduction2();
		$ordered.dataType.put("category", "boolean");
		$ordered.relevance = createDeduction3();
		$multiLine.dataType.put("category", "boolean");
		$multiLine.relevance = createDeduction4();
		$exactRounding.dataType.put("category", "boolean");
		$exactRounding.relevance = createDeduction5();
		$multivalue.dataType.put("category", "boolean");
		$multivalue.rule = createDeduction6();
		$multivalue._default = createDeduction7();
		$formatted.dataType.put("category", "boolean");
		$formatted.relevance = createDeduction8();
		$javaClassName.dataType.put("category", "text");
		$javaClassName._default = createDeduction9();

		$dataCategory.valueClass = org.instantlogic.designer.DataCategoryDesign.class;
		$dataCategory.to = org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
		$dataCategory.rule = createDeduction10();
		$dataCategory.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction11();
		$dataCategory.validations = new org.instantlogic.fabric.model.Validation[] {
			org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
		};
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.readOnly = true;
		$entity.rule = createDeduction12();

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
		return "FbldigwtEifzsbgr_4564bda3_f603";
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		wholeNumber,
		percentage,
		ordered,
		multiLine,
		exactRounding,
		multivalue,
		formatted,
		javaClassName,
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
