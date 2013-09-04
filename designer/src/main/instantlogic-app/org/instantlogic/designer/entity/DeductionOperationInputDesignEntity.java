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
		    d0.setValue("primary");
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(false);
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String> diagramPosition; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean> multivalue; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String> $diagramPosition
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.String, java.lang.String>(
				"QAyEppejcycjknjo_11a318ba_9f33", "diagramPosition", INSTANCE, java.lang.String.class, "diagramPosition", org.instantlogic.designer.DeductionOperationInputDesign.class);
		diagramPosition = $diagramPosition;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean> $multivalue
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean>(
				"SIsgenafcy_pimct_601ed864_f715", "multivalue", INSTANCE, java.lang.Boolean.class, "multivalue", org.instantlogic.designer.DeductionOperationInputDesign.class);
		multivalue = $multivalue;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"AsUOrgqkOmg_uiun_70e56d42_9c9b", "dataType", INSTANCE, "dataType", org.instantlogic.designer.DeductionOperationInputDesign.class);
		dataType = $dataType;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"PgrbbOtkEigOifwr_527c2952_fc15", "operation", INSTANCE, "operation", org.instantlogic.designer.DeductionOperationInputDesign.class);
		operation = $operation;
		
		// Phase 2
		$diagramPosition.dataType.put("category", "text");
		$diagramPosition._default = createDeduction0();
		$multivalue.dataType.put("category", "boolean");
		$multivalue._default = createDeduction1();

		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;

		$operation.reverse = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$operation.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.inputs);
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
		return "BuOxameuxu_dulzc_c79d6871_2609";
	}
	
	@Override
	public String getName() {
		return "DeductionOperationInputDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		diagramPosition,
		multivalue,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataType,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
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
