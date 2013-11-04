package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class EventDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.EventDesign> {

	public static final EventDesignEntity INSTANCE = new EventDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	// Deductions

	
	// Attributes
	
	// Relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> parameters;
	
	// Reverse relations
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> startEventOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> eventOnFragmentTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> eventOnFlowEdgeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> loggedInEventOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"GvflEnapkIflyawo_e12a08d5_7314", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractEventDesign.class);
		parameters = $parameters;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $startEventOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"JbenElef_yfyihIl_39835988_8137", "startEventOnApplicationDesign", INSTANCE, "startEventOnApplicationDesign", org.instantlogic.designer.AbstractEventDesign.class);
		startEventOnApplicationDesign = $startEventOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $eventOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"JfudmgkjUIafk_bv_07444757_3706", "eventOnFragmentTemplateDesign", INSTANCE, "eventOnFragmentTemplateDesign", org.instantlogic.designer.AbstractEventDesign.class);
		eventOnFragmentTemplateDesign = $eventOnFragmentTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> $eventOnFlowEdgeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
				"TzoUgEvleIglemrA_c58e8ad6_3404", "eventOnFlowEdgeDesign", INSTANCE, "eventOnFlowEdgeDesign", org.instantlogic.designer.AbstractEventDesign.class);
		eventOnFlowEdgeDesign = $eventOnFlowEdgeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $loggedInEventOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"__AyOglzkmbyenf_f731a527_700e", "loggedInEventOnApplicationDesign", INSTANCE, "loggedInEventOnApplicationDesign", org.instantlogic.designer.AbstractEventDesign.class);
		loggedInEventOnApplicationDesign = $loggedInEventOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"_jcnfudwIm_tmcIn_f419d0d6_1374", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEventDesign.class);
		application = $application;
		
		// Phase 2

		$parameters.valueClass = org.instantlogic.designer.EntityDesign.class;
		$parameters.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.parametersOnEventDesign);
		$parameters.multivalue = true;

		$startEventOnApplicationDesign.reverse = true;
		$startEventOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$startEventOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$startEventOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.startEvent);
		$eventOnFragmentTemplateDesign.reverse = true;
		$eventOnFragmentTemplateDesign.valueClass = org.instantlogic.designer.FragmentTemplateDesign.class;
		$eventOnFragmentTemplateDesign.to = org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE;
		$eventOnFragmentTemplateDesign.setReverseRelation(org.instantlogic.designer.entity.FragmentTemplateDesignEntity.event);
		$eventOnFragmentTemplateDesign.multivalue = true;
		$eventOnFlowEdgeDesign.reverse = true;
		$eventOnFlowEdgeDesign.valueClass = org.instantlogic.designer.FlowEdgeDesign.class;
		$eventOnFlowEdgeDesign.to = org.instantlogic.designer.entity.FlowEdgeDesignEntity.INSTANCE;
		$eventOnFlowEdgeDesign.setReverseRelation(org.instantlogic.designer.entity.FlowEdgeDesignEntity.event);
		$eventOnFlowEdgeDesign.multivalue = true;
		$loggedInEventOnApplicationDesign.reverse = true;
		$loggedInEventOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$loggedInEventOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$loggedInEventOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.loggedInEvent);
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
	}

	@Override
	public org.instantlogic.designer.EventDesign createInstance() {
		return new org.instantlogic.designer.EventDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.EventDesign> getInstanceClass() {
		return org.instantlogic.designer.EventDesign.class;
	}
	
	@Override
	public String getUniqueId() {
		return "Qm_oEelEpueiiewg_441de02a_a8a0";
	}
	
	@Override
	public String getName() {
		return "EventDesign";
	}

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		parameters,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		startEventOnApplicationDesign,
		eventOnFragmentTemplateDesign,
		eventOnFlowEdgeDesign,
		loggedInEventOnApplicationDesign,
		application,
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
	public java.util.Map<String, org.instantlogic.designer.EventDesign> getStaticInstances() {
		return org.instantlogic.designer.EventDesign.getStaticEventDesignInstances();
	}
}
