package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionDesign> {

	public static final DeductionDesignEntity INSTANCE = new DeductionDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConcatenateDeduction d0 = new org.instantlogic.fabric.deduction.ConcatenateDeduction();
		  	org.instantlogic.fabric.deduction.AttributeDeduction d1 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d1.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.parameterValuesDescription);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d2 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d2.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.ConstantDeduction d3 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d3.setValue(" ");
		  	org.instantlogic.fabric.deduction.AttributeDeduction d4 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d4.setAttribute(org.instantlogic.designer.entity.DesignEntity.name);
		  	org.instantlogic.fabric.deduction.AttributeDeduction d5 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d5.setAttribute(org.instantlogic.designer.entity.DeductionDesignEntity.operation);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d6 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d6.setOfEntity(org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE);
		    d0.addToStrings(d4);
		    d0.addToStrings(d3);
		    d0.addToStrings(d1);
		    d1.setInstance(d2);
		    d4.setInstance(d5);
		    d5.setInstance(d6);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.DeductionParameterValuesDescriptionRuleDeduction d0 = new org.instantlogic.designer.deduction.DeductionParameterValuesDescriptionRuleDeduction();
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction2() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(80.0);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction3() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 = new org.instantlogic.fabric.deduction.ConstantDeduction();
		    d0.setValue(40.0);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction4() {
		  	org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction d0 = new org.instantlogic.designer.deduction.DeductionDiagramPositionDefaultDeduction();
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String> parameterValuesDescription; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramWidth; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> diagramHeight; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> diagramPosition; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> parameters;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> inputs;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> outputOfScheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> scheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> selectionInScheme;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> outputs;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String> $parameterValuesDescription
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.String, java.lang.String>(
				"GlasAOhqjIazgmxe_088e6f4b_3cf8", "parameterValuesDescription", INSTANCE, java.lang.String.class, "parameterValuesDescription", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameterValuesDescription = $parameterValuesDescription;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramWidth
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"HjgIezsefa_mAbtj_d7b2ec1f_68e9", "diagramWidth", INSTANCE, java.lang.Double.class, "diagramWidth", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramWidth = $diagramWidth;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double> $diagramHeight
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, java.lang.Double, java.lang.Double>(
				"LIsEfcaghuf_chkE_557e7c04_56e2", "diagramHeight", INSTANCE, java.lang.Double.class, "diagramHeight", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramHeight = $diagramHeight;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d> $diagramPosition
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.util.diagram.Point2d, org.instantlogic.designer.util.diagram.Point2d>(
				"PbripepkyieggfOl_716d7d62_da01", "diagramPosition", INSTANCE, org.instantlogic.designer.util.diagram.Point2d.class, "diagramPosition", org.instantlogic.designer.AbstractDeductionDesign.class);
		diagramPosition = $diagramPosition;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"ApbnqhsodIaesaAx_5519e0a6_0f98", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractDeductionDesign.class);
		parameters = $parameters;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> $operation
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
				"CxzoOocf_acmAkhf_e7996aba_ecab", "operation", INSTANCE, "operation", org.instantlogic.designer.AbstractDeductionDesign.class);
		operation = $operation;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"U_sAOulygIcpmemz_743f5b32_1394", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractDeductionDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $inputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"_yUympgfbyfrI_qr_001e9a3e_781a", "inputs", INSTANCE, "inputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		inputs = $inputs;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $outputOfScheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"Ackmlqfxhu_wweir_c3ff75f8_f2d4", "outputOfScheme", INSTANCE, "outputOfScheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputOfScheme = $outputOfScheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $scheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"CcayAqvfiIadIaf_4569b6c0_adaf", "scheme", INSTANCE, "scheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		scheme = $scheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign> $selectionInScheme
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionSchemeDesign, org.instantlogic.designer.DeductionSchemeDesign>(
				"HnnEbgdOgmfIqkgt_412b0536_3e68", "selectionInScheme", INSTANCE, "selectionInScheme", org.instantlogic.designer.AbstractDeductionDesign.class);
		selectionInScheme = $selectionInScheme;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign> $outputs
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionInputDesign>, org.instantlogic.designer.DeductionInputDesign>(
				"WzA_AoIxqygpogeq_aeef531d_58c1", "outputs", INSTANCE, "outputs", org.instantlogic.designer.AbstractDeductionDesign.class);
		outputs = $outputs;
		
		// Phase 2
		$parameterValuesDescription.dataType.put("category", "text");
		$parameterValuesDescription.readOnly = true;
		$parameterValuesDescription.rule = createDeduction1();
		$diagramWidth.dataType.put("category", "number");
		$diagramWidth._default = createDeduction2();
		$diagramHeight.dataType.put("category", "number");
		$diagramHeight._default = createDeduction3();
		$diagramPosition._default = createDeduction4();

		$parameters.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$parameters.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.deduction);
		$parameters.owner = true;
		$parameters.multivalue = true;
		$operation.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$operation.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$operation.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.operationOnDeductionDesign);
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.dataTypeOnDeductionDesign);
		$inputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$inputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$inputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.deduction);
		$inputs.owner = true;
		$inputs.multivalue = true;

		$outputOfScheme.reverse = true;
		$outputOfScheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$outputOfScheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$outputOfScheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.output);
		$scheme.reverse = true;
		$scheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$scheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$scheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.deductions);
		$selectionInScheme.reverse = true;
		$selectionInScheme.valueClass = org.instantlogic.designer.DeductionSchemeDesign.class;
		$selectionInScheme.to = org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE;
		$selectionInScheme.setReverseRelation(org.instantlogic.designer.entity.DeductionSchemeDesignEntity.selectedDeduction);
		$outputs.reverse = true;
		$outputs.valueClass = org.instantlogic.designer.DeductionInputDesign.class;
		$outputs.to = org.instantlogic.designer.entity.DeductionInputDesignEntity.INSTANCE;
		$outputs.setReverseRelation(org.instantlogic.designer.entity.DeductionInputDesignEntity.inputs);
		$outputs.multivalue = true;

		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
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
		return "VivhyOasrybIalUO_79ff8c08_16dc";
	}
	
	@Override
	public String getName() {
		return "DeductionDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		parameterValuesDescription,
		diagramWidth,
		diagramHeight,
		diagramPosition,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		parameters,
		operation,
		dataType,
		inputs,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		outputOfScheme,
		scheme,
		selectionInScheme,
		outputs,
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
