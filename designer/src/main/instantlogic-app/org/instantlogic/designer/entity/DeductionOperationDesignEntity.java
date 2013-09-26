package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionOperationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationDesign> {

	public static final DeductionOperationDesignEntity INSTANCE = new DeductionOperationDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String> javaClassName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> inputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign> parameters;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> outputDataType;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> operationOnDeductionDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> customDeductionOperationsOnApplicationDesign;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String>(
				"TEkxgAEsqIagIlmt_38351c8a_52d5", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DeductionOperationDesign.class);
		javaClassName = $javaClassName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign>(
				"AkyAxExAjqcnUjoA_ad16f82b_688a", "inputs", INSTANCE, "inputs", org.instantlogic.designer.DeductionOperationDesign.class);
		inputs = $inputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign>(
				"P_olEuwjyIeiu_fO_3d00bb07_3bf4", "parameters", INSTANCE, "parameters", org.instantlogic.designer.DeductionOperationDesign.class);
		parameters = $parameters;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $outputDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"iqkrtwejkeezgkft_43a6739c_4b18", "outputDataType", INSTANCE, "outputDataType", org.instantlogic.designer.DeductionOperationDesign.class);
		outputDataType = $outputDataType;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $operationOnDeductionDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"CxzoOocf_acmAkhf_e7996aba_ecab", "operationOnDeductionDesign", INSTANCE, "operationOnDeductionDesign", org.instantlogic.designer.DeductionOperationDesign.class);
		operationOnDeductionDesign = $operationOnDeductionDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $customDeductionOperationsOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RpphyhkeqIaskkmn_90c964a5_5fff", "customDeductionOperationsOnApplicationDesign", INSTANCE, "customDeductionOperationsOnApplicationDesign", org.instantlogic.designer.DeductionOperationDesign.class);
		customDeductionOperationsOnApplicationDesign = $customDeductionOperationsOnApplicationDesign;
		
		// Phase 2
		$javaClassName.dataType.put("category", "text");

		$inputs.valueClass = org.instantlogic.designer.DeductionOperationInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.operation);
		$inputs.owner = true;
		$inputs.multivalue = true;
		$parameters.valueClass = org.instantlogic.designer.DeductionOperationParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operation);
		$parameters.owner = true;
		$parameters.multivalue = true;
		$outputDataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$outputDataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$outputDataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.outputDataTypeOnDeductionOperationDesign);

		$operationOnDeductionDesign.reverse = true;
		$operationOnDeductionDesign.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$operationOnDeductionDesign.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$operationOnDeductionDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.operation);
		$operationOnDeductionDesign.multivalue = true;
		$customDeductionOperationsOnApplicationDesign.reverse = true;
		$customDeductionOperationsOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$customDeductionOperationsOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$customDeductionOperationsOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.customDeductionOperations);
	}

	@Override
	public org.instantlogic.designer.DeductionOperationDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Svcybrefuqamiodu_31562d88_912e";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		javaClassName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		inputs,
		parameters,
		outputDataType,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operationOnDeductionDesign,
		customDeductionOperationsOnApplicationDesign,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationDesign.getStaticDeductionOperationDesignInstances();
	}
}
