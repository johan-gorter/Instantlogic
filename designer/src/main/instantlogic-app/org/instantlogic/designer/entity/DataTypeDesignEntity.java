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
		    d3.setValue(org.instantlogic.designer.DataCategoryDesign.text);
		    d0.addToOperands(d3);
		    d0.addToOperands(d1);
		    d1.setInstance(d2);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
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
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction d0 = new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction7() {
		  	org.instantlogic.designer.deduction.DataTypeMultivalueDeduction d0 = new org.instantlogic.designer.deduction.DataTypeMultivalueDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction8() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> ordered; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> dataCategory;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> reverseRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multiLine
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"FgcypxgxfugAqlAw_187b8d4c_db50", "multiLine", INSTANCE, java.lang.Boolean.class, "multiLine", org.instantlogic.designer.DataTypeDesign.class);
		multiLine = $multiLine;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $percentage
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"IOdxrm_Ecaepy_qk_ad0197c1_eba3", "percentage", INSTANCE, java.lang.Boolean.class, "percentage", org.instantlogic.designer.DataTypeDesign.class);
		percentage = $percentage;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $ordered
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"PvsjryvOtyaAihAa_97f57a1c_0c4b", "ordered", INSTANCE, java.lang.Boolean.class, "ordered", org.instantlogic.designer.DataTypeDesign.class);
		ordered = $ordered;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $wholeNumber
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"Qhnow_swAedOyacA_e3fa033b_9bf5", "wholeNumber", INSTANCE, java.lang.Boolean.class, "wholeNumber", org.instantlogic.designer.DataTypeDesign.class);
		wholeNumber = $wholeNumber;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $formatted
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"QvgUjpdduygIcdpI_db62fa4e_efbe", "formatted", INSTANCE, java.lang.Boolean.class, "formatted", org.instantlogic.designer.DataTypeDesign.class);
		formatted = $formatted;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
				"UtpUr_wuhabnAfbO_baf0a98b_58ef", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DataTypeDesign.class);
		javaClassName = $javaClassName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"WAbIxpgjpufmoijs_f5e73eca_e107", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DataTypeDesign.class);
		multivalue = $multivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $exactRounding
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"ZUqt_Ay_rIcoUhtf_6336625d_d678", "exactRounding", INSTANCE, java.lang.Boolean.class, "exactRounding", org.instantlogic.designer.DataTypeDesign.class);
		exactRounding = $exactRounding;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> $dataCategory
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
				"OrwjfcsmaqbwmbAt_7785acc8_b81c", "dataCategory", INSTANCE, "dataCategory", org.instantlogic.designer.DataTypeDesign.class);
		dataCategory = $dataCategory;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"TrbpcmrwOIbAImov_040d1f91_2e9f", "entity", INSTANCE, "entity", org.instantlogic.designer.DataTypeDesign.class);
		entity = $entity;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"IremjucUsqfIuoik_e1504952_08ed", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.DataTypeDesign.class);
		forEntity = $forEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $reverseRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"YuOeqgAoIIcyIfec_259c8e8b_839a", "reverseRelation", INSTANCE, "reverseRelation", org.instantlogic.designer.DataTypeDesign.class);
		reverseRelation = $reverseRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"uuEEosAqnya_whrd_8cfc8eb2_8bce", "attribute", INSTANCE, "attribute", org.instantlogic.designer.DataTypeDesign.class);
		attribute = $attribute;
		
		// Phase 2
		$multiLine.dataType.put("category", "boolean");
		$multiLine.relevance = createDeduction0();
		$percentage.dataType.put("category", "boolean");
		$percentage.relevance = createDeduction1();
		$ordered.dataType.put("category", "boolean");
		$ordered.relevance = createDeduction2();
		$wholeNumber.dataType.put("category", "boolean");
		$wholeNumber.relevance = createDeduction3();
		$wholeNumber._default = createDeduction4();
		$formatted.dataType.put("category", "boolean");
		$formatted.relevance = createDeduction5();
		$javaClassName.dataType.put("category", "text");
		$javaClassName._default = createDeduction6();
		$multivalue.dataType.put("category", "boolean");
		$multivalue.rule = createDeduction7();
		$multivalue._default = createDeduction8();
		$exactRounding.dataType.put("category", "boolean");
		$exactRounding.relevance = createDeduction9();

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
		$reverseRelation.reverse = true;
		$reverseRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType);
		$attribute.reverse = true;
		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
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
		return "WavqqUEogIeww_gq_00c228b6_81b2";
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		multiLine,
		percentage,
		ordered,
		wholeNumber,
		formatted,
		javaClassName,
		multivalue,
		exactRounding,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategory,
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		forEntity,
		reverseRelation,
		attribute,
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
