package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionDesign> {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(4.0);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction d0 = new org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(8.0);
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramHeight; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> diagramPosition; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramWidth; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> parameters;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> inputs;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> outputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> scheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> outputOfScheme;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramHeight
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"Cwxtcalniyfvqkfm_87650bc6_edc0", "diagramHeight", INSTANCE, java.lang.Double.class, "diagramHeight", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramHeight = $diagramHeight;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> $diagramPosition
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d>(
				"HEIclpUowI_rcdwu_b5ec5210_51cc", "diagramPosition", INSTANCE, org.instantlogic.designer.util.diagram.Point2d.class, "diagramPosition", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramPosition = $diagramPosition;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramWidth
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"ubfhoogtxmeycfb_a1e9db73_31b9", "diagramWidth", INSTANCE, java.lang.Double.class, "diagramWidth", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramWidth = $diagramWidth;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"LOzdjApEiIgtqngo_b5771165_80f4", "operation", INSTANCE, "operation", org.instantlogic.designer.AbstractDeductionDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"NUobIlItfufzUhou_857b6f2b_078c", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameters = $parameters;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"PiardUimqucvonnk_292f4dd7_56c9", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractDeductionDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"RxldhibEnqawciy_89c5ae47_2f87", "inputs", INSTANCE, "inputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		inputs = $inputs;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $outputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"Qzwiceba_IffaiqO_b879f3e4_01a6", "outputs", INSTANCE, "outputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputs = $outputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $scheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"YwthtemejeejibzI_3f004c6a_5646", "scheme", INSTANCE, "scheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		scheme = $scheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $outputOfScheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"ZeUOt_mnAyfpafqy_e79df60c_98c0", "outputOfScheme", INSTANCE, "outputOfScheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputOfScheme = $outputOfScheme;
		
		// Phase 2
		$diagramHeight._default = createDeduction0();
		$diagramPosition._default = createDeduction1();
		$diagramWidth._default = createDeduction2();

		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$parameters.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.deduction);
		$parameters.owner = true;
		$parameters.multivalue = true;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$inputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.deduction);
		$inputs.owner = true;
		$inputs.multivalue = true;

		$outputs.reverse = true;
		$outputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$outputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$outputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		$outputs.multivalue = true;
		$scheme.reverse = true;
		$scheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$scheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$scheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		$outputOfScheme.reverse = true;
		$outputOfScheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$outputOfScheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$outputOfScheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
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
		return "XvhkqhosdeftImqb_ac7f5b1f_8b65";
	}
	
	@Override
	public String getName() {
		return "DeductionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		diagramHeight,
		diagramPosition,
		diagramWidth,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
		parameters,
		dataType,
		inputs,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		outputs,
		scheme,
		outputOfScheme,
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
