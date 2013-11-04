package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionOperationInputDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationInputDesign> {

	public static final DeductionOperationInputDesignEntity INSTANCE = new DeductionOperationInputDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue("primary");
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String> diagramPosition; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> operationInputOnDeductionInputDesign;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean>(
				"Ndouqc_zui_hqkfv_4da9edb9_ed9a", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DeductionOperationInputDesign.class);
		multivalue = $multivalue;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String> $diagramPosition
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String>(
				"uykzypltcuatqiOl_70c815e6_88f8", "diagramPosition", INSTANCE, java.lang.String.class, "diagramPosition", org.instantlogic.designer.DeductionOperationInputDesign.class);
		diagramPosition = $diagramPosition;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"Sbz_uhIiAmcyuaou_5ab7f140_072f", "dataType", INSTANCE, "dataType", org.instantlogic.designer.DeductionOperationInputDesign.class);
		dataType = $dataType;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"AkyAxExAjqcnUjoA_ad16f82b_688a", "operation", INSTANCE, "operation", org.instantlogic.designer.DeductionOperationInputDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $operationInputOnDeductionInputDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"udyim_mtiiczUfow_72eba5f5_aa7b", "operationInputOnDeductionInputDesign", INSTANCE, "operationInputOnDeductionInputDesign", org.instantlogic.designer.DeductionOperationInputDesign.class);
		operationInputOnDeductionInputDesign = $operationInputOnDeductionInputDesign;
		
		// Phase 2
		$multivalue.dataType.put("category", "boolean");
		$multivalue._default = createDeduction0();
		$diagramPosition.dataType.put("category", "text");
		$diagramPosition._default = createDeduction1();

		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.dataTypeOnDeductionOperationInputDesign);

		$operation.reverse = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$operation.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.inputs);
		$operationInputOnDeductionInputDesign.reverse = true;
		$operationInputOnDeductionInputDesign.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$operationInputOnDeductionInputDesign.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$operationInputOnDeductionInputDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.operationInput);
		$operationInputOnDeductionInputDesign.multivalue = true;
	}

	@Override
	public org.instantlogic.designer.DeductionOperationInputDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationInputDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationInputDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationInputDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "iEsAfy_EaibzkcEm_80d4ec53_74fb";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationInputDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		multivalue,
		diagramPosition,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataType,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
		operationInputOnDeductionInputDesign,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationInputDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationInputDesign.getStaticDeductionOperationInputDesignInstances();
	}
}
