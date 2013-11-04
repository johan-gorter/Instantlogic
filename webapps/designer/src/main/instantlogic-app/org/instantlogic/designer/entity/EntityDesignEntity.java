package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class EntityDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EntityDesign> {

	public static final EntityDesignEntity INSTANCE = new EntityDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> relations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> extendsFrom;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> attributes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> title;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> staticInstances;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> validations;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> caseEntityOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> entityValueOnDeductionParameterDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> extensions;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> belongsToEntityOnAttributeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> parametersOnEventDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> parametersOnFlowDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> entityOnFragmentTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> reverseRelations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> entityOnDataTypeDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $relations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"ChlekOxg_aaiyctq_14d3be5d_af29", "relations", INSTANCE, "relations", org.instantlogic.designer.AbstractEntityDesign.class);
		relations = $relations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $extendsFrom
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Eppzpms_eu_dukIh_d8c91732_e558", "extendsFrom", INSTANCE, "extendsFrom", org.instantlogic.designer.AbstractEntityDesign.class);
		extendsFrom = $extendsFrom;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $attributes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"Jb_p_oytnIdhejrb_e516aee2_1cc6", "attributes", INSTANCE, "attributes", org.instantlogic.designer.AbstractEntityDesign.class);
		attributes = $attributes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign> $title
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.TextTemplateDesign, org.instantlogic.designer.TextTemplateDesign>(
				"JuiyhOzkpef_ymkj_520ac7e3_6f8a", "title", INSTANCE, "title", org.instantlogic.designer.AbstractEntityDesign.class);
		title = $title;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign> $staticInstances
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.StaticInstanceDesign>, org.instantlogic.designer.StaticInstanceDesign>(
				"LOlefhsgEiaAwdxq_4d19f2db_36bb", "staticInstances", INSTANCE, "staticInstances", org.instantlogic.designer.AbstractEntityDesign.class);
		staticInstances = $staticInstances;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $dataType
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"OierzzcUIecoUcag_d77c30c4_29b3", "dataType", INSTANCE, "dataType", org.instantlogic.designer.AbstractEntityDesign.class);
		dataType = $dataType;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign> $validations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.ValidationDesign>, org.instantlogic.designer.ValidationDesign>(
				"ixvgrxb_wigmwjtm_caa6ffc3_53d8", "validations", INSTANCE, "validations", org.instantlogic.designer.AbstractEntityDesign.class);
		validations = $validations;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $caseEntityOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"EInabAOlnIdbsnqI_a1429ca7_fecc", "caseEntityOnApplicationDesign", INSTANCE, "caseEntityOnApplicationDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		caseEntityOnApplicationDesign = $caseEntityOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign> $entityValueOnDeductionParameterDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionParameterDesign>, org.instantlogic.designer.DeductionParameterDesign>(
				"EmggnvdaIaefgnrI_1c4a678e_c778", "entityValueOnDeductionParameterDesign", INSTANCE, "entityValueOnDeductionParameterDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityValueOnDeductionParameterDesign = $entityValueOnDeductionParameterDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $extensions
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"Eppzpms_eu_dukIh_d8c91732_e558", "extensions", INSTANCE, "extensions", org.instantlogic.designer.AbstractEntityDesign.class);
		extensions = $extensions;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign> $belongsToEntityOnAttributeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.AttributeDesign>, org.instantlogic.designer.AttributeDesign>(
				"FrxyasOjnucocnd_2f6adbce_f95c", "belongsToEntityOnAttributeDesign", INSTANCE, "belongsToEntityOnAttributeDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		belongsToEntityOnAttributeDesign = $belongsToEntityOnAttributeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> $parametersOnEventDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
				"GvflEnapkIflyawo_e12a08d5_7314", "parametersOnEventDesign", INSTANCE, "parametersOnEventDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		parametersOnEventDesign = $parametersOnEventDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> $parametersOnFlowDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
				"IyajpUkcyefsidbt_47ce5dea_bc51", "parametersOnFlowDesign", INSTANCE, "parametersOnFlowDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		parametersOnFlowDesign = $parametersOnFlowDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $entityOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"QEhcakqI_qdbucno_51a877ef_5e33", "entityOnFragmentTemplateDesign", INSTANCE, "entityOnFragmentTemplateDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityOnFragmentTemplateDesign = $entityOnFragmentTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"SttwUOEnjyecu_Eh_2c178686_aa27", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEntityDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign> $reverseRelations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.RelationDesign>, org.instantlogic.designer.RelationDesign>(
				"_tjconnpIIecadOt_52b47f1d_ddb6", "reverseRelations", INSTANCE, "reverseRelations", org.instantlogic.designer.AbstractEntityDesign.class);
		reverseRelations = $reverseRelations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> $entityOnDataTypeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EntityDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
				"imUpelkddadhIofg_fe5dc10f_03bf", "entityOnDataTypeDesign", INSTANCE, "entityOnDataTypeDesign", org.instantlogic.designer.AbstractEntityDesign.class);
		entityOnDataTypeDesign = $entityOnDataTypeDesign;
		
		// Phase 2

		$relations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$relations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$relations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.from);
		$relations.owner = true;
		$relations.multivalue = true;
		$extendsFrom.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extendsFrom.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extendsFrom.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extensions);
		$attributes.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$attributes.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$attributes.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.attributeOf);
		$attributes.owner = true;
		$attributes.multivalue = true;
		$title.valueClass = org.instantlogic.designer.TextTemplateDesign.class;
		$title.to = org.instantlogic.designer.entity.TextTemplateDesignEntity.INSTANCE;
		$title.setReverseRelation(org.instantlogic.designer.entity.TextTemplateDesignEntity.titleOfEntity);
		$title.owner = true;
		$staticInstances.valueClass = org.instantlogic.designer.StaticInstanceDesign.class;
		$staticInstances.to = org.instantlogic.designer.entity.StaticInstanceDesignEntity.INSTANCE;
		$staticInstances.setReverseRelation(org.instantlogic.designer.entity.StaticInstanceDesignEntity.entity);
		$staticInstances.owner = true;
		$staticInstances.multivalue = true;
		$dataType.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$dataType.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$dataType.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.forEntity);
		$dataType.owner = true;
		$dataType.autoCreate = true;
		$validations.valueClass = org.instantlogic.designer.ValidationDesign.class;
		$validations.to = org.instantlogic.designer.entity.ValidationDesignEntity.INSTANCE;
		$validations.setReverseRelation(org.instantlogic.designer.entity.ValidationDesignEntity.forEntity);
		$validations.owner = true;
		$validations.multivalue = true;

		$caseEntityOnApplicationDesign.reverse = true;
		$caseEntityOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$caseEntityOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$caseEntityOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity);
		$entityValueOnDeductionParameterDesign.reverse = true;
		$entityValueOnDeductionParameterDesign.valueClass = org.instantlogic.designer.DeductionParameterDesign.class;
		$entityValueOnDeductionParameterDesign.to = org.instantlogic.designer.entity.DeductionParameterDesignEntity.INSTANCE;
		$entityValueOnDeductionParameterDesign.setReverseRelation(org.instantlogic.designer.entity.DeductionParameterDesignEntity.entityValue);
		$entityValueOnDeductionParameterDesign.multivalue = true;
		$extensions.reverse = true;
		$extensions.valueClass = org.instantlogic.designer.EntityDesign.class;
		$extensions.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$extensions.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.extendsFrom);
		$extensions.multivalue = true;
		$belongsToEntityOnAttributeDesign.reverse = true;
		$belongsToEntityOnAttributeDesign.valueClass = org.instantlogic.designer.AttributeDesign.class;
		$belongsToEntityOnAttributeDesign.to = org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE;
		$belongsToEntityOnAttributeDesign.setReverseRelation(org.instantlogic.designer.entity.AttributeDesignEntity.belongsToEntity);
		$belongsToEntityOnAttributeDesign.multivalue = true;
		$parametersOnEventDesign.reverse = true;
		$parametersOnEventDesign.valueClass = org.instantlogic.designer.EventDesign.class;
		$parametersOnEventDesign.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$parametersOnEventDesign.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		$parametersOnEventDesign.multivalue = true;
		$parametersOnFlowDesign.reverse = true;
		$parametersOnFlowDesign.valueClass = org.instantlogic.designer.FlowDesign.class;
		$parametersOnFlowDesign.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$parametersOnFlowDesign.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.parameters);
		$parametersOnFlowDesign.multivalue = true;
		$entityOnFragmentTemplateDesign.reverse = true;
		$entityOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$entityOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$entityOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.entity);
		$entityOnFragmentTemplateDesign.multivalue = true;
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		$reverseRelations.reverse = true;
		$reverseRelations.valueClass = org.instantlogic.designer.RelationDesign.class;
		$reverseRelations.to = org.instantlogic.designer.entity.RelationDesignEntity.INSTANCE;
		$reverseRelations.setReverseRelation(org.instantlogic.designer.entity.RelationDesignEntity.to);
		$reverseRelations.multivalue = true;
		$entityOnDataTypeDesign.reverse = true;
		$entityOnDataTypeDesign.valueClass = org.instantlogic.designer.DataTypeDesign.class;
		$entityOnDataTypeDesign.to = org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE;
		$entityOnDataTypeDesign.setReverseRelation(org.instantlogic.designer.entity.DataTypeDesignEntity.entity);
	}

	@Override
	public org.instantlogic.designer.EntityDesign createInstance() {
		return new org.instantlogic.designer.EntityDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EntityDesign> getInstanceClass() {
		return org.instantlogic.designer.EntityDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "OzsbEzyAtmfashuo_d8939902_d00f";
	}
	
	@Override
	public String getName() {
		return "EntityDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		relations,
		extendsFrom,
		attributes,
		title,
		staticInstances,
		dataType,
		validations,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		caseEntityOnApplicationDesign,
		entityValueOnDeductionParameterDesign,
		extensions,
		belongsToEntityOnAttributeDesign,
		parametersOnEventDesign,
		parametersOnFlowDesign,
		entityOnFragmentTemplateDesign,
		application,
		reverseRelations,
		entityOnDataTypeDesign,
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
	public java.util.Map<String, org.instantlogic.designer.EntityDesign> getStaticInstances() {
		return org.instantlogic.designer.EntityDesign.getStaticEntityDesignInstances();
	}
}
