package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionDesign> {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.designer.deduction.DeductionParameterValuesDescriptionRuleDeduction d0 = new org.instantlogic.designer.deduction.DeductionParameterValuesDescriptionRuleDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(40.0);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(80.0);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction d0 = new org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction();
		return d0;
	}


	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String> parameterValuesDescription; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramHeight; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramWidth; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> diagramPosition; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> inputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> parameters;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> outputs;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> selectionInScheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> outputOfScheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> scheme;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String> $parameterValuesDescription
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String>(
				"AaedUsyljmcjonqe_bf885c8e_35b2", "parameterValuesDescription", INSTANCE, java.lang.String.class, "parameterValuesDescription", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameterValuesDescription = $parameterValuesDescription;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramHeight
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"NglzjbdmEeatAjrv_4ba85159_6e19", "diagramHeight", INSTANCE, java.lang.Double.class, "diagramHeight", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramHeight = $diagramHeight;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramWidth
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"PczxAUqiIifEgdvv_8f6ab3d2_8fcf", "diagramWidth", INSTANCE, java.lang.Double.class, "diagramWidth", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramWidth = $diagramWidth;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> $diagramPosition
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d>(
				"UpjjettjaefgaowA_bcabe409_b7dd", "diagramPosition", INSTANCE, org.instantlogic.designer.util.diagram.Point2d.class, "diagramPosition", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramPosition = $diagramPosition;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"NIw_ijdjnIcvsknm_53334049_d70d", "inputs", INSTANCE, "inputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		inputs = $inputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"SjxuEotaryd_sjyf_b6a96b21_1156", "operation", INSTANCE, "operation", org.instantlogic.designer.AbstractDeductionDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"ZarAdcpypIa_okdq_79d88a68_257c", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractDeductionDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"oOej_IkOfIdyUdge_58aa09f6_174b", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameters = $parameters;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $outputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"BmEbaensqu_kwbbq_d77440a2_db98", "outputs", INSTANCE, "outputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputs = $outputs;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $selectionInScheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"PoiUUolExI_pg_xr_2bb85a7c_c886", "selectionInScheme", INSTANCE, "selectionInScheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		selectionInScheme = $selectionInScheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $outputOfScheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"SlimujbjbyczAhdu_943b209e_9bd5", "outputOfScheme", INSTANCE, "outputOfScheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputOfScheme = $outputOfScheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $scheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"TsqfgIzcqycha_bk_bfe2eb40_cca9", "scheme", INSTANCE, "scheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		scheme = $scheme;
		
		// Phase 2
		$parameterValuesDescription.dataType.put("category", "text");
		$parameterValuesDescription.readOnly = true;
		$parameterValuesDescription.rule = createDeduction0();
		$diagramHeight.dataType.put("category", "number");
		$diagramHeight._default = createDeduction1();
		$diagramWidth.dataType.put("category", "number");
		$diagramWidth._default = createDeduction2();
		$diagramPosition._default = createDeduction3();

		$inputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.deduction);
		$inputs.owner = true;
		$inputs.multivalue = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
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
		$selectionInScheme.reverse = true;
		$selectionInScheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$selectionInScheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$selectionInScheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectedDeduction);
		$outputOfScheme.reverse = true;
		$outputOfScheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$outputOfScheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$outputOfScheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
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
		return "Wlkaafhtaq_hs_sh_83184d87_2599";
	}
	
	@Override
	public String getName() {
		return "DeductionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		parameterValuesDescription,
		diagramHeight,
		diagramWidth,
		diagramPosition,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		inputs,
		operation,
		dataType,
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		outputs,
		selectionInScheme,
		outputOfScheme,
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
