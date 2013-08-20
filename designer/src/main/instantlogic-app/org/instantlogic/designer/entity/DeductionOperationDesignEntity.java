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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign> parameters;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> outputDataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> inputs;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String> $javaClassName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String>(
				"ikoufAzUse_Eqbdd_a4986c63_17a7", "javaClassName", INSTANCE, java.lang.String.class, "javaClassName", org.instantlogic.designer.DeductionOperationDesign.class);
		javaClassName = $javaClassName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationParameterDesign>, org.instantlogic.designer.DeductionOperationParameterDesign>(
				"GoyOsbEkfuebIajh_6b73b644_be4c", "parameters", INSTANCE, "parameters", org.instantlogic.designer.DeductionOperationDesign.class);
		parameters = $parameters;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $outputDataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"KEfvfxoziagmckcd_e68ee4bb_3281", "outputDataType", INSTANCE, "outputDataType", org.instantlogic.designer.DeductionOperationDesign.class);
		outputDataType = $outputDataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign>(
				"Q_awrrkgxqdhmfpf_9eae0ade_6bf8", "inputs", INSTANCE, "inputs", org.instantlogic.designer.DeductionOperationDesign.class);
		inputs = $inputs;
		// Reverse relations
		
		// Phase 2
		$javaClassName.dataType.put("category", "text");

		$parameters.valueClass = org.instantlogic.designer.DeductionOperationParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operation);
		$parameters.owner = true;
		$parameters.multivalue = true;
		$outputDataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$outputDataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$inputs.valueClass = org.instantlogic.designer.DeductionOperationInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.operation);
		$inputs.owner = true;
		$inputs.multivalue = true;

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
		return "Tohhlmjbiy_Owmov_bbd14d72_e77e";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		javaClassName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		parameters,
		outputDataType,
		inputs,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
