package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionParameterDesign> {

	public static final DeductionParameterDesignEntity INSTANCE = new DeductionParameterDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.DeductionParameterValueDescriptionRuleDeduction d0 = new org.instantlogic.designer.deduction.DeductionParameterValueDescriptionRuleDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> value; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String> valueDescription; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> staticInstanceValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attributeValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> operationParameter;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entityValue;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> $value
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object>(
				"CxyhAwxlwm_ngjrw_4e726085_044d", "value", INSTANCE, java.lang.Object.class, "value", org.instantlogic.designer.DeductionParameterDesign.class);
		value = $value;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String> $valueDescription
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String>(
				"owxwljnfzeaeebaa_b80857b8_f6d6", "valueDescription", INSTANCE, java.lang.String.class, "valueDescription", org.instantlogic.designer.DeductionParameterDesign.class);
		valueDescription = $valueDescription;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> $staticInstanceValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
				"Asvn_UcgoqgmykOd_d20befac_db31", "staticInstanceValue", INSTANCE, "staticInstanceValue", org.instantlogic.designer.DeductionParameterDesign.class);
		staticInstanceValue = $staticInstanceValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attributeValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"JnyEnthvgu_hwdnm_23b3f6cd_ca69", "attributeValue", INSTANCE, "attributeValue", org.instantlogic.designer.DeductionParameterDesign.class);
		attributeValue = $attributeValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> $operationParameter
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign>(
				"_qoOmhqmAi_aidmg_c783655a_e589", "operationParameter", INSTANCE, "operationParameter", org.instantlogic.designer.DeductionParameterDesign.class);
		operationParameter = $operationParameter;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entityValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"oarIwUoI_ebyimog_e5fb2cbe_dae2", "entityValue", INSTANCE, "entityValue", org.instantlogic.designer.DeductionParameterDesign.class);
		entityValue = $entityValue;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"ZfuAnE_auedOygxv_6e94d610_0f15", "deduction", INSTANCE, "deduction", org.instantlogic.designer.DeductionParameterDesign.class);
		deduction = $deduction;
		
		// Phase 2
		$valueDescription.dataType.put("category", "text");
		$valueDescription.readOnly = true;
		$valueDescription.rule = createDeduction0();

		$staticInstanceValue.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstanceValue.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstanceValue.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.staticInstanceValueOnDeductionParameterDesign);
		$attributeValue.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributeValue.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attributeValue.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeValueOnDeductionParameterDesign);
		$operationParameter.valueClass = org.instantlogic.designer.DeductionOperationParameterDesign.class;
		$operationParameter.to = org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
		$operationParameter.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operationParameterOnDeductionParameterDesign);
		$entityValue.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entityValue.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entityValue.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.entityValueOnDeductionParameterDesign);

		$deduction.reverse = true;
		$deduction.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deduction.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deduction.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.parameters);
	}

	@Override
	public org.instantlogic.designer.DeductionParameterDesign createInstance() {
		return new org.instantlogic.designer.DeductionParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionParameterDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "LkEybuIkkucOUhyh_3f6f4d9e_f9b6";
	}
	
	@Override
	public String getName() {
		return "DeductionParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
		valueDescription,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		staticInstanceValue,
		attributeValue,
		operationParameter,
		entityValue,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deduction,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionParameterDesign.getStaticDeductionParameterDesignInstances();
	}
}
