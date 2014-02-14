package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractEventDesign extends Design { 

	private static final java.util.Map<String, EventDesign> _staticInstances = new java.util.LinkedHashMap<String, EventDesign>();
	
	public static java.util.Map<String, EventDesign> getStaticEventDesignInstances() {
		return _staticInstances;
	}
	
	private static EventDesign addStaticInstance(String name, EventDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	  // Phase 1
	  // Phase 2
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EventDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> parameters
		= createRelationValues(org.instantlogic.designer.entity.EventDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValues<EventDesign, EntityDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign> getParameters() {
		return parameters.getValue();
	}
	
	public EventDesign addToParameters(EntityDesign item) {
		parameters.addValue(item);
		return (EventDesign)this;
	}
	
	public EventDesign removeFromParameters(EntityDesign item) {
		parameters.removeValue(item);
		return (EventDesign)this;
	}
	
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, FragmentTemplateDesign> eventOnFragmentTemplateDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.eventOnFragmentTemplateDesign);

	public org.instantlogic.fabric.value.RelationValues<EventDesign, FragmentTemplateDesign> getEventOnFragmentTemplateDesignRelationValue() {
		return eventOnFragmentTemplateDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign> getEventOnFragmentTemplateDesign() {
		return eventOnFragmentTemplateDesign.getValue();
	}

    public EventDesign addToEventOnFragmentTemplateDesign(FragmentTemplateDesign item) {
        eventOnFragmentTemplateDesign.addValue(item);
        return (EventDesign)this;
    }

    public EventDesign removeFromEventOnFragmentTemplateDesign(FragmentTemplateDesign item) {
        eventOnFragmentTemplateDesign.removeValue(item);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<EventDesign, FlowEdgeDesign> eventOnFlowEdgeDesign
		= createReverseRelationValues(org.instantlogic.designer.entity.EventDesignEntity.eventOnFlowEdgeDesign);

	public org.instantlogic.fabric.value.RelationValues<EventDesign, FlowEdgeDesign> getEventOnFlowEdgeDesignRelationValue() {
		return eventOnFlowEdgeDesign;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowEdgeDesign> getEventOnFlowEdgeDesign() {
		return eventOnFlowEdgeDesign.getValue();
	}

    public EventDesign addToEventOnFlowEdgeDesign(FlowEdgeDesign item) {
        eventOnFlowEdgeDesign.addValue(item);
        return (EventDesign)this;
    }

    public EventDesign removeFromEventOnFlowEdgeDesign(FlowEdgeDesign item) {
        eventOnFlowEdgeDesign.removeValue(item);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public EventDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> loggedInEventOnApplicationDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.loggedInEventOnApplicationDesign);

	public org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> getLoggedInEventOnApplicationDesignRelationValue() {
		return loggedInEventOnApplicationDesign;
	}

	public org.instantlogic.designer.ApplicationDesign getLoggedInEventOnApplicationDesign() {
		return loggedInEventOnApplicationDesign.getValue();
	}

    public EventDesign setLoggedInEventOnApplicationDesign(org.instantlogic.designer.ApplicationDesign newValue) {
        loggedInEventOnApplicationDesign.setValue(newValue);
        return (EventDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> startEventOnApplicationDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.EventDesignEntity.startEventOnApplicationDesign);

	public org.instantlogic.fabric.value.RelationValue<EventDesign, ApplicationDesign> getStartEventOnApplicationDesignRelationValue() {
		return startEventOnApplicationDesign;
	}

	public org.instantlogic.designer.ApplicationDesign getStartEventOnApplicationDesign() {
		return startEventOnApplicationDesign.getValue();
	}

    public EventDesign setStartEventOnApplicationDesign(org.instantlogic.designer.ApplicationDesign newValue) {
        startEventOnApplicationDesign.setValue(newValue);
        return (EventDesign)this;
    }


}
