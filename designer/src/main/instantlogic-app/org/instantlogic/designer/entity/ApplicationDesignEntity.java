package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ApplicationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> themeNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> isCustomized; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> rootPackageName; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> fragmentTypes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> mainFlow;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> sharedElements;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> loggedInEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> startEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> customDeductionOperations;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $themeNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"KAuuapIiry_pc_U_f03e21a9_114e", "themeNames", INSTANCE, java.lang.String.class, "themeNames", org.instantlogic.designer.AbstractApplicationDesign.class);
		themeNames = $themeNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $name
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"LbyeApdOzyfwakU_528e53d7_4331", "name", INSTANCE, java.lang.String.class, "name", org.instantlogic.designer.AbstractApplicationDesign.class);
		name = $name;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> $isCustomized
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean>(
				"QhAf_ObbIegxwnmw_95112c92_2c41", "isCustomized", INSTANCE, java.lang.Boolean.class, "isCustomized", org.instantlogic.designer.AbstractApplicationDesign.class);
		isCustomized = $isCustomized;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $rootPackageName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"TfjrOavAxa_sghUq_cc941e22_4cac", "rootPackageName", INSTANCE, java.lang.String.class, "rootPackageName", org.instantlogic.designer.AbstractApplicationDesign.class);
		rootPackageName = $rootPackageName;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $sourcePath
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"_qb_Oah_gubcy_go_fb94e556_c386", "sourcePath", INSTANCE, java.lang.String.class, "sourcePath", org.instantlogic.designer.AbstractApplicationDesign.class);
		sourcePath = $sourcePath;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> $fragmentTypes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign>(
				"Aonvyqqp_mfbcfja_aa073938_8b16", "fragmentTypes", INSTANCE, "fragmentTypes", org.instantlogic.designer.AbstractApplicationDesign.class);
		fragmentTypes = $fragmentTypes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $caseEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"Dyqvtjb_cidEodxj_f02dd530_09aa", "caseEntity", INSTANCE, "caseEntity", org.instantlogic.designer.AbstractApplicationDesign.class);
		caseEntity = $caseEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $mainFlow
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"HvcghjczUmchkcke_9994cd85_49b4", "mainFlow", INSTANCE, "mainFlow", org.instantlogic.designer.AbstractApplicationDesign.class);
		mainFlow = $mainFlow;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> $flows
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
				"KolswtrlEuacIgOU_4eefa492_7205", "flows", INSTANCE, "flows", org.instantlogic.designer.AbstractApplicationDesign.class);
		flows = $flows;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> $sharedElements
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"LvgtaUmUtqgpahAq_b11ce80c_4042", "sharedElements", INSTANCE, "sharedElements", org.instantlogic.designer.AbstractApplicationDesign.class);
		sharedElements = $sharedElements;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $entities
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"SlafUuEkay_OynAr_08afa352_5e84", "entities", INSTANCE, "entities", org.instantlogic.designer.AbstractApplicationDesign.class);
		entities = $entities;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> $events
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
				"VccgIzjUOmgmcjhs_565a9a0e_a88b", "events", INSTANCE, "events", org.instantlogic.designer.AbstractApplicationDesign.class);
		events = $events;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $loggedInEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"eidixfUAbIdIqdcf_cd64faeb_1dc7", "loggedInEvent", INSTANCE, "loggedInEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		loggedInEvent = $loggedInEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $startEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"eldfUAgiumcwggvq_899f9e1b_af32", "startEvent", INSTANCE, "startEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		startEvent = $startEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> $customDeductionOperations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign>(
				"oitpItglky_nccju_d886bb91_499f", "customDeductionOperations", INSTANCE, "customDeductionOperations", org.instantlogic.designer.AbstractApplicationDesign.class);
		customDeductionOperations = $customDeductionOperations;
		// Reverse relations
		
		// Phase 2
		$themeNames.dataType.put("category", "text");
		$themeNames.multivalue = true;
		$name.dataType.put("category", "text");
		$isCustomized.dataType.put("category", "boolean");
		$rootPackageName.dataType.put("category", "text");
		$sourcePath.dataType.put("category", "text");

		$fragmentTypes.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$fragmentTypes.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$fragmentTypes.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.application);
		$fragmentTypes.owner = true;
		$fragmentTypes.multivalue = true;
		$caseEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$caseEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$mainFlow.valueClass = org.instantlogic.designer.FlowDesign.class;
		$mainFlow.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$flows.valueClass = org.instantlogic.designer.FlowDesign.class;
		$flows.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$flows.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.application);
		$flows.owner = true;
		$flows.multivalue = true;
		$sharedElements.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$sharedElements.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$sharedElements.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.application);
		$sharedElements.owner = true;
		$sharedElements.multivalue = true;
		$entities.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entities.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entities.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.application);
		$entities.owner = true;
		$entities.multivalue = true;
		$events.valueClass = org.instantlogic.designer.EventDesign.class;
		$events.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$events.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.application);
		$events.owner = true;
		$events.multivalue = true;
		$loggedInEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$loggedInEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$startEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$startEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$customDeductionOperations.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$customDeductionOperations.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$customDeductionOperations.owner = true;
		$customDeductionOperations.multivalue = true;

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
		return "LfOswAwpfeeiwoyk_053741ce_651a";
	}
	
	@Override
	public String getName() {
		return "ApplicationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		themeNames,
		name,
		isCustomized,
		rootPackageName,
		sourcePath,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragmentTypes,
		caseEntity,
		mainFlow,
		flows,
		sharedElements,
		entities,
		events,
		loggedInEvent,
		startEvent,
		customDeductionOperations,
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
