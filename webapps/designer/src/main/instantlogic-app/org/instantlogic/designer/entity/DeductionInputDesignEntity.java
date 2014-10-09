package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionInputDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionInputDesign> {

	public static final DeductionInputDesignEntity INSTANCE = new DeductionInputDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DeductionInputDesignEntity.operationInput);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		    d1.setInstance(d2);
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
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
				"RelationDesign_inputs_1", "inputs", INSTANCE, "inputs", org.instantlogic.designer.DeductionInputDesign.class);
		inputs = $inputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign> $operationInput
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign>(
				"RelationDesign_operationInput", "operationInput", INSTANCE, "operationInput", org.instantlogic.designer.DeductionInputDesign.class);
		operationInput = $operationInput;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"reverse-RelationDesign_inputs", "deduction", INSTANCE, "deduction", org.instantlogic.designer.DeductionInputDesign.class);
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

		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
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
		return "EntityDesign_DeductionInputDesign";
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
