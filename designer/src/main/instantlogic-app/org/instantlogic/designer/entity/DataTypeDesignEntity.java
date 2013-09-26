package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DataTypeDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DataTypeDesign> {

	public static final DataTypeDesignEntity INSTANCE = new DataTypeDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction d0 = new org.instantlogic.designer.deduction.DataTypeJavaClassNameDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.designer.deduction.DataTypeMultivalueDeduction d0 = new org.instantlogic.designer.deduction.DataTypeMultivalueDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DataTypeDesignEntity.multiLine);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction5() {
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction6() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
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


	private static org.instantlogic.fabric.deduction.Deduction createDeduction9() {
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
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> ordered; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> javaClassName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> formatted; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> wholeNumber; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> multiLine; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> exactRounding; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> percentage; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> dataCategory;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entity;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attribute;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> forEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> dataTypeOnDeductionOperationInputDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> reverseRelation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> dataTypeOnDeductionDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> outputDataTypeOnDeductionOperationDesign;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $ordered
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"AytzwoOeruagwhac_bf61609c_7ead", "ordered", INSTANCE, java.lang.Boolean.class, "ordered", org.instantlogic.designer.DataTypeDesign.class);
		ordered = $ordered;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.String, java.lang.String>(
				"BnzjvOgawifwglAA_15ec75a8_7c22", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DataTypeDesign.class);
		javaClassName = $javaClassName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"ErtkeoIpxaezc_ox_e5b9dd85_e197", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DataTypeDesign.class);
		multivalue = $multivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $formatted
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"GI_eicuUaaatmi_m_18f7a5fc_959c", "formatted", INSTANCE, java.lang.Boolean.class, "formatted", org.instantlogic.designer.DataTypeDesign.class);
		formatted = $formatted;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $wholeNumber
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"QguswuoghydtmozE_bda1646a_8805", "wholeNumber", INSTANCE, java.lang.Boolean.class, "wholeNumber", org.instantlogic.designer.DataTypeDesign.class);
		wholeNumber = $wholeNumber;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $multiLine
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"ZbcUIamxdIfyAghr_3f0b7e2a_c03c", "multiLine", INSTANCE, java.lang.Boolean.class, "multiLine", org.instantlogic.designer.DataTypeDesign.class);
		multiLine = $multiLine;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $exactRounding
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"iultyOvUAuahseyO_9ea7e556_fd4a", "exactRounding", INSTANCE, java.lang.Boolean.class, "exactRounding", org.instantlogic.designer.DataTypeDesign.class);
		exactRounding = $exactRounding;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean> $percentage
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DataTypeDesign, java.lang.Boolean, java.lang.Boolean>(
				"umyqfAEojIbjq_ls_12230de5_7164", "percentage", INSTANCE, java.lang.Boolean.class, "percentage", org.instantlogic.designer.DataTypeDesign.class);
		percentage = $percentage;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign> $dataCategory
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataCategoryDesign, org.instantlogic.designer.DataCategoryDesign>(
				"HlxAieAgiybdIgyr_afb6f13f_b418", "dataCategory", INSTANCE, "dataCategory", org.instantlogic.designer.DataTypeDesign.class);
		dataCategory = $dataCategory;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"imUpelkddadhIofg_fe5dc10f_03bf", "entity", INSTANCE, "entity", org.instantlogic.designer.DataTypeDesign.class);
		entity = $entity;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attribute
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"Cfgkbltf_ygymabi_fcc1992d_b927", "attribute", INSTANCE, "attribute", org.instantlogic.designer.DataTypeDesign.class);
		attribute = $attribute;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $forEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"OierzzcUIecoUcag_d77c30c4_29b3", "forEntity", INSTANCE, "forEntity", org.instantlogic.designer.DataTypeDesign.class);
		forEntity = $forEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> $dataTypeOnDeductionOperationInputDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign>(
				"Sbz_uhIiAmcyuaou_5ab7f140_072f", "dataTypeOnDeductionOperationInputDesign", INSTANCE, "dataTypeOnDeductionOperationInputDesign", org.instantlogic.designer.DataTypeDesign.class);
		dataTypeOnDeductionOperationInputDesign = $dataTypeOnDeductionOperationInputDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign> $reverseRelation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.RelationDesign, org.instantlogic.designer.RelationDesign>(
				"SgxvIqUobmbsefzn_ddc7b0e8_f626", "reverseRelation", INSTANCE, "reverseRelation", org.instantlogic.designer.DataTypeDesign.class);
		reverseRelation = $reverseRelation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $dataTypeOnDeductionDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"U_sAOulygIcpmemz_743f5b32_1394", "dataTypeOnDeductionDesign", INSTANCE, "dataTypeOnDeductionDesign", org.instantlogic.designer.DataTypeDesign.class);
		dataTypeOnDeductionDesign = $dataTypeOnDeductionDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> $outputDataTypeOnDeductionOperationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DataTypeDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign>(
				"iqkrtwejkeezgkft_43a6739c_4b18", "outputDataTypeOnDeductionOperationDesign", INSTANCE, "outputDataTypeOnDeductionOperationDesign", org.instantlogic.designer.DataTypeDesign.class);
		outputDataTypeOnDeductionOperationDesign = $outputDataTypeOnDeductionOperationDesign;
		
		// Phase 2
		$ordered.dataType.put("category", "boolean");
		$ordered.relevance = createDeduction0();
		$javaClassName.dataType.put("category", "text");
		$javaClassName._default = createDeduction1();
		$multivalue.dataType.put("category", "boolean");
		$multivalue.rule = createDeduction2();
		$multivalue._default = createDeduction3();
		$formatted.dataType.put("category", "boolean");
		$formatted.relevance = createDeduction4();
		$wholeNumber.dataType.put("category", "boolean");
		$wholeNumber.relevance = createDeduction5();
		$wholeNumber._default = createDeduction6();
		$multiLine.dataType.put("category", "boolean");
		$multiLine.relevance = createDeduction7();
		$exactRounding.dataType.put("category", "boolean");
		$exactRounding.relevance = createDeduction8();
		$percentage.dataType.put("category", "boolean");
		$percentage.relevance = createDeduction9();

		$dataCategory.valueClass = org.instantlogic.designer.DataCategoryDesign.class;
		$dataCategory.to = org.instantlogic.designer.entity.DataCategoryDesignEntity.INSTANCE;
		$dataCategory.setReverseRelation(org.instantlogic.designer.entity.DataCategoryDesignEntity.dataCategoryOnDataTypeDesign);
		$dataCategory.rule = createDeduction10();
		$dataCategory.options = (org.instantlogic.fabric.deduction.Deduction)createDeduction11();
		$dataCategory.validations = new org.instantlogic.fabric.model.Validation[] {
			org.instantlogic.designer.validation.DataTypeDesignDataCategoryRequiredValidation.INSTANCE,
		};
		$entity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.entityOnDataTypeDesign);
		$entity.readOnly = true;
		$entity.rule = createDeduction12();

		$attribute.reverse = true;
		$attribute.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attribute.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attribute.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.dataType);
		$forEntity.reverse = true;
		$forEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$forEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$forEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.dataType);
		$dataTypeOnDeductionOperationInputDesign.reverse = true;
		$dataTypeOnDeductionOperationInputDesign.valueClass = org.instantlogic.designer.DeductionOperationInputDesign.class;
		$dataTypeOnDeductionOperationInputDesign.to = org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
		$dataTypeOnDeductionOperationInputDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.dataType);
		$dataTypeOnDeductionOperationInputDesign.multivalue = true;
		$reverseRelation.reverse = true;
		$reverseRelation.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelation.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelation.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.reverseDataType);
		$dataTypeOnDeductionDesign.reverse = true;
		$dataTypeOnDeductionDesign.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$dataTypeOnDeductionDesign.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$dataTypeOnDeductionDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.dataType);
		$dataTypeOnDeductionDesign.multivalue = true;
		$outputDataTypeOnDeductionOperationDesign.reverse = true;
		$outputDataTypeOnDeductionOperationDesign.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$outputDataTypeOnDeductionOperationDesign.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$outputDataTypeOnDeductionOperationDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.outputDataType);
		$outputDataTypeOnDeductionOperationDesign.multivalue = true;
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
		return "ahadzIieeebpwfOp_08374d46_09f1";
	}
	
	@Override
	public String getName() {
		return "DataTypeDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		ordered,
		javaClassName,
		multivalue,
		formatted,
		wholeNumber,
		multiLine,
		exactRounding,
		percentage,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataCategory,
		entity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attribute,
		forEntity,
		dataTypeOnDeductionOperationInputDesign,
		reverseRelation,
		dataTypeOnDeductionDesign,
		outputDataTypeOnDeductionOperationDesign,
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
