package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionParameterDesign> {

	public static final DeductionParameterDesignEntity INSTANCE = new DeductionParameterDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> value; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attributeValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entityValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> operationParameter;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> staticInstanceValue;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> $value
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object>(
				"PksAmmxsvqczaewq_a81ce1a9_e51e", "value", INSTANCE, java.lang.Object.class, "value", org.instantlogic.designer.DeductionParameterDesign.class);
		value = $value;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attributeValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"BhcnxtpOiIfieoEi_453502ad_7f81", "attributeValue", INSTANCE, "attributeValue", org.instantlogic.designer.DeductionParameterDesign.class);
		attributeValue = $attributeValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entityValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"OulbuOpyEycjukbU_f41e4f20_115a", "entityValue", INSTANCE, "entityValue", org.instantlogic.designer.DeductionParameterDesign.class);
		entityValue = $entityValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> $operationParameter
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign>(
				"ZiI_v_IIqub_qiip_95152ef1_ab82", "operationParameter", INSTANCE, "operationParameter", org.instantlogic.designer.DeductionParameterDesign.class);
		operationParameter = $operationParameter;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> $staticInstanceValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
				"ZmrdrsacIietckmr_739c38c5_6c3b", "staticInstanceValue", INSTANCE, "staticInstanceValue", org.instantlogic.designer.DeductionParameterDesign.class);
		staticInstanceValue = $staticInstanceValue;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"GqskAOgwUuacqiut_a0da8b68_1250", "deduction", INSTANCE, "deduction", org.instantlogic.designer.DeductionParameterDesign.class);
		deduction = $deduction;
		
		// Phase 2

		$attributeValue.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributeValue.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$entityValue.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entityValue.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$operationParameter.valueClass = org.instantlogic.designer.DeductionOperationParameterDesign.class;
		$operationParameter.to = org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
		$staticInstanceValue.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstanceValue.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;

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
		return "Ipoiajlaeu_oyfup_7f23aea2_33ff";
	}
	
	@Override
	public String getName() {
		return "DeductionParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributeValue,
		entityValue,
		operationParameter,
		staticInstanceValue,
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
