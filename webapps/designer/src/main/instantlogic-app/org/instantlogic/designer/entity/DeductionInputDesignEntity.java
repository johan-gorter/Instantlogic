package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionInputDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionInputDesign> {

	public static final DeductionInputDesignEntity INSTANCE = new DeductionInputDesignEntity();
	

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> inputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign> operationInput;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
				"WzA_AoIxqygpogeq_aeef531d_58c1", "inputs", INSTANCE, "inputs", org.instantlogic.designer.DeductionInputDesign.class);
		inputs = $inputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign> $operationInput
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign>(
				"udyim_mtiiczUfow_72eba5f5_aa7b", "operationInput", INSTANCE, "operationInput", org.instantlogic.designer.DeductionInputDesign.class);
		operationInput = $operationInput;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"_yUympgfbyfrI_qr_001e9a3e_781a", "deduction", INSTANCE, "deduction", org.instantlogic.designer.DeductionInputDesign.class);
		deduction = $deduction;
		
		// Phase 2

		$inputs.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.outputs);
		$inputs.multivalue = true;
		$inputs.ordered = true;
		$operationInput.valueClass = org.instantlogic.designer.DeductionOperationInputDesign.class;
		$operationInput.to = org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE;
		$operationInput.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.operationInputOnDeductionInputDesign);

		$deduction.reverse = true;
		$deduction.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deduction.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deduction.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.inputs);
	}

	@Override
	public org.instantlogic.designer.DeductionInputDesign createInstance() {
		return new org.instantlogic.designer.DeductionInputDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionInputDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionInputDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "UclyfUapxufAimxi_b136c9d3_afe7";
	}
	
	@Override
	public String getName() {
		return "DeductionInputDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		inputs,
		operationInput,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionInputDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionInputDesign.getStaticDeductionInputDesignInstances();
	}
}