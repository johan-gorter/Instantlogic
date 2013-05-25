package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionDesign> {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> inputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> parameters;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> outputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> scheme;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"Relationdesign__0016", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractDeductionDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"Relationdesign__0017", "inputs", INSTANCE, "inputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		inputs = $inputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"Relationdesign__0015", "operation", INSTANCE, "operation", org.instantlogic.designer.AbstractDeductionDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"Relationdesign__0018", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameters = $parameters;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $outputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"Relationdesign__0020", "outputs", INSTANCE, "outputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputs = $outputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $scheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"Relationdesign__0013", "scheme", INSTANCE, "scheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		scheme = $scheme;
		
		// Phase 2

		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$inputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.deduction);
		$inputs.owner = true;
		$inputs.multivalue = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$parameters.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.deduction);
		$parameters.owner = true;
		$parameters.multivalue = true;

		$outputs.reverse = true;
		$outputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$outputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$outputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		$outputs.multivalue = true;
		$scheme.reverse = true;
		$scheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$scheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$scheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
	}

	@Override
	public org.instantlogic.designer.DeductionDesign createInstance() {
		return new org.instantlogic.designer.DeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Entitydesign__0011";
	}
	
	@Override
	public String getName() {
		return "DeductionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataType,
		inputs,
		operation,
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		outputs,
		scheme,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionDesign.getStaticDeductionDesignInstances();
	}
}
