package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ApplicationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> themeNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> isCustomized; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> rootPackageName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> mainFlow;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> fragmentTypes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> loggedInEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> startEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> sharedElements;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> customDeductionOperations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $themeNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"CIpEshpAdi_rikUq_553a3fe6_0672", "themeNames", INSTANCE, java.lang.String.class, "themeNames", org.instantlogic.designer.AbstractApplicationDesign.class);
		themeNames = $themeNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> $isCustomized
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean>(
				"DzljivyoqybtaoIE_056ab192_7f44", "isCustomized", INSTANCE, java.lang.Boolean.class, "isCustomized", org.instantlogic.designer.AbstractApplicationDesign.class);
		isCustomized = $isCustomized;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $rootPackageName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"NenwqmidEaehscgb_e0d29967_b1cf", "rootPackageName", INSTANCE, java.lang.String.class, "rootPackageName", org.instantlogic.designer.AbstractApplicationDesign.class);
		rootPackageName = $rootPackageName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $name
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"VqnrEapsme_oUmlr_442440d9_d0fc", "name", INSTANCE, java.lang.String.class, "name", org.instantlogic.designer.AbstractApplicationDesign.class);
		name = $name;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $sourcePath
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"XgmvhtpaxygOamAc_fa84e061_1383", "sourcePath", INSTANCE, java.lang.String.class, "sourcePath", org.instantlogic.designer.AbstractApplicationDesign.class);
		sourcePath = $sourcePath;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $entities
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"KUayiswijagyqdsi_0a6bb7a6_2370", "entities", INSTANCE, "entities", org.instantlogic.designer.AbstractApplicationDesign.class);
		entities = $entities;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $mainFlow
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"MefAaqOtougbwhaI_ad8d410d_8924", "mainFlow", INSTANCE, "mainFlow", org.instantlogic.designer.AbstractApplicationDesign.class);
		mainFlow = $mainFlow;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> $fragmentTypes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign>(
				"Mhsbwih_tagEgdjj_d1298bdb_8a07", "fragmentTypes", INSTANCE, "fragmentTypes", org.instantlogic.designer.AbstractApplicationDesign.class);
		fragmentTypes = $fragmentTypes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $loggedInEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"Pg_qhIxkaeftihUf_e2be8f61_8e5a", "loggedInEvent", INSTANCE, "loggedInEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		loggedInEvent = $loggedInEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $startEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"VctIsplIymfagiEq_13e3490d_966c", "startEvent", INSTANCE, "startEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		startEvent = $startEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> $sharedElements
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"VnUlEezztecicmnp_45922162_762a", "sharedElements", INSTANCE, "sharedElements", org.instantlogic.designer.AbstractApplicationDesign.class);
		sharedElements = $sharedElements;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> $customDeductionOperations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign>(
				"eAnbnUuvOmcpojnU_01ef0a92_12da", "customDeductionOperations", INSTANCE, "customDeductionOperations", org.instantlogic.designer.AbstractApplicationDesign.class);
		customDeductionOperations = $customDeductionOperations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> $flows
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
				"ibsqfsdIlmfsygwi_45898708_f31c", "flows", INSTANCE, "flows", org.instantlogic.designer.AbstractApplicationDesign.class);
		flows = $flows;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> $events
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
				"ivIAhqwIzIceqonE_36aae776_406e", "events", INSTANCE, "events", org.instantlogic.designer.AbstractApplicationDesign.class);
		events = $events;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $caseEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"urgulfskOIegmkag_293ec1af_b40c", "caseEntity", INSTANCE, "caseEntity", org.instantlogic.designer.AbstractApplicationDesign.class);
		caseEntity = $caseEntity;
		// Reverse relations
		
		// Phase 2
		$themeNames.dataType.put("category", "text");
		$themeNames.multivalue = true;
		$isCustomized.dataType.put("category", "boolean");
		$rootPackageName.dataType.put("category", "text");
		$name.dataType.put("category", "text");
		$sourcePath.dataType.put("category", "text");

		$entities.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entities.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entities.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.application);
		$entities.owner = true;
		$entities.multivalue = true;
		$mainFlow.valueClass = org.instantlogic.designer.FlowDesign.class;
		$mainFlow.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$fragmentTypes.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$fragmentTypes.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$fragmentTypes.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.application);
		$fragmentTypes.owner = true;
		$fragmentTypes.multivalue = true;
		$loggedInEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$loggedInEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$startEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$startEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$sharedElements.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$sharedElements.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$sharedElements.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.application);
		$sharedElements.owner = true;
		$sharedElements.multivalue = true;
		$customDeductionOperations.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$customDeductionOperations.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$customDeductionOperations.owner = true;
		$customDeductionOperations.multivalue = true;
		$flows.valueClass = org.instantlogic.designer.FlowDesign.class;
		$flows.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$flows.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.application);
		$flows.owner = true;
		$flows.multivalue = true;
		$events.valueClass = org.instantlogic.designer.EventDesign.class;
		$events.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$events.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.application);
		$events.owner = true;
		$events.multivalue = true;
		$caseEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$caseEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;

	}

	@Override
	public org.instantlogic.designer.ApplicationDesign createInstance() {
		return new org.instantlogic.designer.ApplicationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ApplicationDesign> getInstanceClass() {
		return org.instantlogic.designer.ApplicationDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "PaImemiyoecaIeda_aed589fc_d534";
	}
	
	@Override
	public String getName() {
		return "ApplicationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		themeNames,
		isCustomized,
		rootPackageName,
		name,
		sourcePath,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		entities,
		mainFlow,
		fragmentTypes,
		loggedInEvent,
		startEvent,
		sharedElements,
		customDeductionOperations,
		flows,
		events,
		caseEntity,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	public java.util.Map<String, org.instantlogic.designer.ApplicationDesign> getStaticInstances() {
		return org.instantlogic.designer.ApplicationDesign.getStaticApplicationDesignInstances();
	}
}
