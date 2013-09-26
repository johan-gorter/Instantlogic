package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionParameterDesign> {

	public static final DeductionParameterDesignEntity INSTANCE = new DeductionParameterDesignEntity();
	

	
	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.AttributeDeduction d0 = new org.instantlogic.fabric.deduction.AttributeDeduction();
		    d0.setAttribute(org.instantlogic.designer.entity.DeductionParameterDesignEntity.valueDescription);
		  	org.instantlogic.fabric.deduction.SelectedInstanceDeduction d1 = new org.instantlogic.fabric.deduction.SelectedInstanceDeduction();
		    d1.setOfEntity(org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE);
		    d0.setInstance(d1);
		return d0;
	}


	private static org.instantlogic.fabric.deduction.Deduction createDeduction1() {
		  	org.instantlogic.designer.deduction.DeductionParameterValueDescriptionRuleDeduction d0 = new org.instantlogic.designer.deduction.DeductionParameterValueDescriptionRuleDeduction();
		return d0;
	}


	// Title
	private static final org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		return title;
	}
	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> value; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String> valueDescription; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attributeValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entityValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> staticInstanceValue;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> operationParameter;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction;

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> $value
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object>(
				"ayerstUfjeczAjhq_89a40931_a9eb", "value", INSTANCE, java.lang.Object.class, "value", org.instantlogic.designer.DeductionParameterDesign.class);
		value = $value;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String> $valueDescription
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.String, java.lang.String>(
				"onEyqrEpIIfgiinx_6db92004_cb35", "valueDescription", INSTANCE, java.lang.String.class, "valueDescription", org.instantlogic.designer.DeductionParameterDesign.class);
		valueDescription = $valueDescription;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> $attributeValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
				"AxddjvmaledIsg_o_383bccd4_af6b", "attributeValue", INSTANCE, "attributeValue", org.instantlogic.designer.DeductionParameterDesign.class);
		attributeValue = $attributeValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $entityValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"EmggnvdaIaefgnrI_1c4a678e_c778", "entityValue", INSTANCE, "entityValue", org.instantlogic.designer.DeductionParameterDesign.class);
		entityValue = $entityValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign> $staticInstanceValue
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.StaticInstanceDesign, org.instantlogic.designer.StaticInstanceDesign>(
				"PAzwemjlxeglukjv_a79db643_8b59", "staticInstanceValue", INSTANCE, "staticInstanceValue", org.instantlogic.designer.DeductionParameterDesign.class);
		staticInstanceValue = $staticInstanceValue;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> $operationParameter
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign>(
				"otqbep_Eymdxw_Ow_06e2472a_82e2", "operationParameter", INSTANCE, "operationParameter", org.instantlogic.designer.DeductionParameterDesign.class);
		operationParameter = $operationParameter;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> $deduction
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
				"ApbnqhsodIaesaAx_5519e0a6_0f98", "deduction", INSTANCE, "deduction", org.instantlogic.designer.DeductionParameterDesign.class);
		deduction = $deduction;
		
		// Phase 2
		$valueDescription.dataType.put("category", "text");
		$valueDescription.readOnly = true;
		$valueDescription.rule = createDeduction1();

		$attributeValue.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributeValue.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attributeValue.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeValueOnDeductionParameterDesign);
		$entityValue.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entityValue.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entityValue.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.entityValueOnDeductionParameterDesign);
		$staticInstanceValue.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstanceValue.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstanceValue.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.staticInstanceValueOnDeductionParameterDesign);
		$operationParameter.valueClass = org.instantlogic.designer.DeductionOperationParameterDesign.class;
		$operationParameter.to = org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE;
		$operationParameter.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.operationParameterOnDeductionParameterDesign);

		$deduction.reverse = true;
		$deduction.valueClass = org.instantlogic.designer.DeductionDesign.class;
		$deduction.to = org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
		$deduction.setReverseRelation(org.instantlogic.designer.entity.DeductionDesignEntity.parameters);

		title = new org.instantlogic.fabric.text.TextTemplate().getUntranslated().add(createDeduction0()).getTextTemplate();
	}

	@Override
	public org.instantlogic.designer.DeductionParameterDesign createInstance() {
		return new org.instantlogic.designer.DeductionParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionParameterDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "YAlwhnOdla_oqcIe_09a384f4_9931";
	}
	
	@Override
	public String getName() {
		return "DeductionParameterDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
		valueDescription,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributeValue,
		entityValue,
		staticInstanceValue,
		operationParameter,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionParameterDesign.getStaticDeductionParameterDesignInstances();
	}
}
