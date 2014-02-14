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
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> eventOnFragmentTemplateDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> eventOnFlowEdgeDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> application;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> loggedInEventOnApplicationDesign;
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> startEventOnApplicationDesign;

	static {
		// Phase 1
		// Attributes
		// Relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> $parameters
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
				"RelationDesign_parameters_1", "parameters", INSTANCE, "parameters", org.instantlogic.designer.AbstractEventDesign.class);
		parameters = $parameters;
		// Reverse relations
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign> $eventOnFragmentTemplateDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign>, org.instantlogic.designer.FragmentTemplateDesign>(
				"RelationDesign_event", "eventOnFragmentTemplateDesign", INSTANCE, "eventOnFragmentTemplateDesign", org.instantlogic.designer.AbstractEventDesign.class);
		eventOnFragmentTemplateDesign = $eventOnFragmentTemplateDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign> $eventOnFlowEdgeDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign>, org.instantlogic.designer.FlowEdgeDesign>(
				"RelationDesign_event_1", "eventOnFlowEdgeDesign", INSTANCE, "eventOnFlowEdgeDesign", org.instantlogic.designer.AbstractEventDesign.class);
		eventOnFlowEdgeDesign = $eventOnFlowEdgeDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $application
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_events", "application", INSTANCE, "application", org.instantlogic.designer.AbstractEventDesign.class);
		application = $application;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $loggedInEventOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_loggedInEvent", "loggedInEventOnApplicationDesign", INSTANCE, "loggedInEventOnApplicationDesign", org.instantlogic.designer.AbstractEventDesign.class);
		loggedInEventOnApplicationDesign = $loggedInEventOnApplicationDesign;
		org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign> $startEventOnApplicationDesign
			= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.EventDesign, org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.ApplicationDesign>(
				"RelationDesign_startEvent", "startEventOnApplicationDesign", INSTANCE, "startEventOnApplicationDesign", org.instantlogic.designer.AbstractEventDesign.class);
		startEventOnApplicationDesign = $startEventOnApplicationDesign;
		
		// Phase 2

		$parameters.valueClass = org.instantlogic.designer.EntityDesign.class;
		$parameters.to = org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE;
		$parameters.setReverseRelation(org.instantlogic.designer.entity.EntityDesignEntity.parametersOnEventDesign);
		$parameters.multivalue = true;

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
		$application.reverse = true;
		$application.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$application.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$application.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
		$loggedInEventOnApplicationDesign.reverse = true;
		$loggedInEventOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$loggedInEventOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$loggedInEventOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.loggedInEvent);
		$startEventOnApplicationDesign.reverse = true;
		$startEventOnApplicationDesign.valueClass = org.instantlogic.designer.ApplicationDesign.class;
		$startEventOnApplicationDesign.to = org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
		$startEventOnApplicationDesign.setReverseRelation(org.instantlogic.designer.entity.ApplicationDesignEntity.startEvent);
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
		return "EntityDesign_EventDesign";
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
		eventOnFragmentTemplateDesign,
		eventOnFlowEdgeDesign,
		application,
		loggedInEventOnApplicationDesign,
		startEventOnApplicationDesign,
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
