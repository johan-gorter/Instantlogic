package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionOperationParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationParameterDesign> {

	public static final DeductionOperationParameterDesignEntity INSTANCE = new DeductionOperationParameterDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String> valueClass; 
	
	// Relations
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> operationParameterOnDeductionParameterDesign;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String> $valueClass
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationParameterDesign, java.lang.String, java.lang.String>(
				"_giqmmOrnaewmhOo_d6638dbc_c704", "valueClass", INSTANCE, java.lang.String.class, "valueClass", org.instantlogic.designer.DeductionOperationParameterDesign.class);
		valueClass = $valueClass;
		// Relations
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"P_olEuwjyIeiu_fO_3d00bb07_3bf4", "operation", INSTANCE, "operation", org.instantlogic.designer.DeductionOperationParameterDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $operationParameterOnDeductionParameterDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"otqbep_Eymdxw_Ow_06e2472a_82e2", "operationParameterOnDeductionParameterDesign", INSTANCE, "operationParameterOnDeductionParameterDesign", org.instantlogic.designer.DeductionOperationParameterDesign.class);
		operationParameterOnDeductionParameterDesign = $operationParameterOnDeductionParameterDesign;
		
		// Phase 2
		$valueClass.dataType.put("category", "text");


		$operation.reverse = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$operation.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.parameters);
		$operationParameterOnDeductionParameterDesign.reverse = true;
		$operationParameterOnDeductionParameterDesign.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$operationParameterOnDeductionParameterDesign.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$operationParameterOnDeductionParameterDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.operationParameter);
		$operationParameterOnDeductionParameterDesign.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.DeductionOperationParameterDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationParameterDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "FrdteUkz_ufnobpc_34d85660_96cb";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		valueClass,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
		operationParameterOnDeductionParameterDesign,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationParameterDesign.getStaticDeductionOperationParameterDesignInstances();
	}
}
