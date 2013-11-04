package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ApplicationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	

	
	// Deductions

	
	// Attributes
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> isCustomized; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> themeNames; 
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> rootPackageName; 
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> fragmentTypes;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> mainFlow;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> startEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> sharedElements;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> customDeductionOperations;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> loggedInEvent;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events;
	
	// Reverse relations

	static {
		// Phase 1
		// Attributes
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $name
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"GieypaqkeIdwa_bs_a91eb66f_cb88", "name", INSTANCE, java.lang.String.class, "name", org.instantlogic.designer.AbstractApplicationDesign.class);
		name = $name;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> $isCustomized
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean>(
				"Iawuwbjdpubtceng_4299dc8f_f37d", "isCustomized", INSTANCE, java.lang.Boolean.class, "isCustomized", org.instantlogic.designer.AbstractApplicationDesign.class);
		isCustomized = $isCustomized;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $sourcePath
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"JItbsIOgci_IUgIO_1a08dce2_2016", "sourcePath", INSTANCE, java.lang.String.class, "sourcePath", org.instantlogic.designer.AbstractApplicationDesign.class);
		sourcePath = $sourcePath;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String> $themeNames
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<java.lang.String>, java.lang.String>(
				"Kfsgwa_zaearsavl_fddc39b6_f9cb", "themeNames", INSTANCE, java.lang.String.class, "themeNames", org.instantlogic.designer.AbstractApplicationDesign.class);
		themeNames = $themeNames;
		org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> $rootPackageName
			= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
				"Whc__khzjibno_lw_b30890d4_5977", "rootPackageName", INSTANCE, java.lang.String.class, "rootPackageName", org.instantlogic.designer.AbstractApplicationDesign.class);
		rootPackageName = $rootPackageName;
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> $fragmentTypes
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign>(
				"DUsjdmgjti_homlm_23d7314d_bb55", "fragmentTypes", INSTANCE, "fragmentTypes", org.instantlogic.designer.AbstractApplicationDesign.class);
		fragmentTypes = $fragmentTypes;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> $caseEntity
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
				"EInabAOlnIdbsnqI_a1429ca7_fecc", "caseEntity", INSTANCE, "caseEntity", org.instantlogic.designer.AbstractApplicationDesign.class);
		caseEntity = $caseEntity;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> $mainFlow
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
				"FhUhveqney_rydgk_cecaa4f2_3fbd", "mainFlow", INSTANCE, "mainFlow", org.instantlogic.designer.AbstractApplicationDesign.class);
		mainFlow = $mainFlow;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $startEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"JbenElef_yfyihIl_39835988_8137", "startEvent", INSTANCE, "startEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		startEvent = $startEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> $sharedElements
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign>(
				"Ki_rAurlhqgiykyw_d0a02254_1413", "sharedElements", INSTANCE, "sharedElements", org.instantlogic.designer.AbstractApplicationDesign.class);
		sharedElements = $sharedElements;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> $flows
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
				"LczmUnotIygvsnwq_9acb01e1_656a", "flows", INSTANCE, "flows", org.instantlogic.designer.AbstractApplicationDesign.class);
		flows = $flows;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> $customDeductionOperations
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign>(
				"RpphyhkeqIaskkmn_90c964a5_5fff", "customDeductionOperations", INSTANCE, "customDeductionOperations", org.instantlogic.designer.AbstractApplicationDesign.class);
		customDeductionOperations = $customDeductionOperations;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $entities
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"SttwUOEnjyecu_Eh_2c178686_aa27", "entities", INSTANCE, "entities", org.instantlogic.designer.AbstractApplicationDesign.class);
		entities = $entities;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> $loggedInEvent
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
				"__AyOglzkmbyenf_f731a527_700e", "loggedInEvent", INSTANCE, "loggedInEvent", org.instantlogic.designer.AbstractApplicationDesign.class);
		loggedInEvent = $loggedInEvent;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> $events
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
				"_jcnfudwIm_tmcIn_f419d0d6_1374", "events", INSTANCE, "events", org.instantlogic.designer.AbstractApplicationDesign.class);
		events = $events;
		// Reverse relations
		
		// Phase 2
		$name.dataType.put("category", "text");
		$isCustomized.dataType.put("category", "boolean");
		$sourcePath.dataType.put("category", "text");
		$themeNames.dataType.put("category", "text");
		$themeNames.multivalue = true;
		$rootPackageName.dataType.put("category", "text");

		$fragmentTypes.valueClass = org.instantlogic.designer.FragmentTypeDesign.class;
		$fragmentTypes.to = org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE;
		$fragmentTypes.setReverseRelation(org.instantlogic.designer.entity.FragmentTypeDesignEntity.application);
		$fragmentTypes.owner = true;
		$fragmentTypes.multivalue = true;
		$caseEntity.valueClass = org.instantlogic.designer.EntityDesign.class;
		$caseEntity.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$caseEntity.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.caseEntityOnApplicationDesign);
		$mainFlow.valueClass = org.instantlogic.designer.FlowDesign.class;
		$mainFlow.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$mainFlow.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.mainFlowOnApplicationDesign);
		$startEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$startEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$startEvent.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.startEventOnApplicationDesign);
		$sharedElements.valueClass = org.instantlogic.designer.SharedElementDefinitionDesign.class;
		$sharedElements.to = org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE;
		$sharedElements.setReverseRelation(org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.application);
		$sharedElements.owner = true;
		$sharedElements.multivalue = true;
		$flows.valueClass = org.instantlogic.designer.FlowDesign.class;
		$flows.to = org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE;
		$flows.setReverseRelation(org.instantlogic.designer.entity.FlowDesignEntity.application);
		$flows.owner = true;
		$flows.multivalue = true;
		$customDeductionOperations.valueClass = org.instantlogic.designer.DeductionOperationDesign.class;
		$customDeductionOperations.to = org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE;
		$customDeductionOperations.setReverseRelation(org.instantlogic.designer.entity.DeductionOperationDesignEntity.customDeductionOperationsOnApplicationDesign);
		$customDeductionOperations.owner = true;
		$customDeductionOperations.multivalue = true;
		$entities.valueClass = org.instantlogic.designer.EntityDesign.class;
		$entities.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$entities.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.application);
		$entities.owner = true;
		$entities.multivalue = true;
		$loggedInEvent.valueClass = org.instantlogic.designer.EventDesign.class;
		$loggedInEvent.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$loggedInEvent.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.loggedInEventOnApplicationDesign);
		$events.valueClass = org.instantlogic.designer.EventDesign.class;
		$events.to = org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
		$events.setReverseRelation(org.instantlogic.designer.entity.EventDesignEntity.application);
		$events.owner = true;
		$events.multivalue = true;

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
		return "Fzpbnqxblqcqmlcl_0d62e8ec_a092";
	}
	
	@Override
	public String getName() {
		return "ApplicationDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		name,
		isCustomized,
		sourcePath,
		themeNames,
		rootPackageName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		fragmentTypes,
		caseEntity,
		mainFlow,
		startEvent,
		sharedElements,
		flows,
		customDeductionOperations,
		entities,
		loggedInEvent,
		events,
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
