package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractPlaceTemplateDesign extends FlowNodeBaseDesign { 

	private static final java.util.Map<String, PlaceTemplateDesign> _staticInstances = new java.util.LinkedHashMap<String, PlaceTemplateDesign>();
	
	public static java.util.Map<String, PlaceTemplateDesign> getStaticPlaceTemplateDesignInstances() {
		return _staticInstances;
	}
	
	private static PlaceTemplateDesign addStaticInstance(String name, PlaceTemplateDesign instance) {
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
		return org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ElementDesign> content
		= createRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.content);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ElementDesign> getContentRelationValue() {
		return content;
	}

	public org.instantlogic.designer.ElementDesign getContent() {
		return content.getValue();
	}
	
	public PlaceTemplateDesign setContent(org.instantlogic.designer.ElementDesign newValue) {
		content.setValue(newValue);
		return (PlaceTemplateDesign)this;
	}
	
	public org.instantlogic.designer.ElementDesign newContent() {
		org.instantlogic.designer.ElementDesign newValue = new org.instantlogic.designer.ElementDesign(); 
		content.setValue(newValue);
		return newValue;
	}

	
	private final org.instantlogic.fabric.value.RelationValueList<PlaceTemplateDesign, PlaceParameterDesign> parameters
		= createRelationValueList(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.parameters);
		
	public org.instantlogic.fabric.value.RelationValueList<PlaceTemplateDesign, PlaceParameterDesign> getParametersRelationValue() {
		return parameters;
	}

	public org.instantlogic.fabric.value.ValueList<org.instantlogic.designer.PlaceParameterDesign> getParameters() {
		return parameters.getValue();
	}
	
	public PlaceTemplateDesign addToParameters(PlaceParameterDesign item) {
		parameters.addValue(item);
		return (PlaceTemplateDesign)this;
	}
	
	public PlaceTemplateDesign removeFromParameters(PlaceParameterDesign item) {
		parameters.removeValue(item);
		return (PlaceTemplateDesign)this;
	}
	
	public PlaceTemplateDesign removeFromParameters(int index) {
		parameters.removeValue(index);
		return (PlaceTemplateDesign)this;
	}

	public PlaceTemplateDesign addToParameters(PlaceParameterDesign item, int index) {
		parameters.insertValue(item, index);
		return (PlaceTemplateDesign)this;
	}	
	
	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, TextTemplateDesign> title
		= createRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.title);
		
	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, TextTemplateDesign> getTitleRelationValue() {
		return title;
	}

	public org.instantlogic.designer.TextTemplateDesign getTitle() {
		return title.getValue();
	}
	
	public PlaceTemplateDesign setTitle(org.instantlogic.designer.TextTemplateDesign newValue) {
		title.setValue(newValue);
		return (PlaceTemplateDesign)this;
	}
	
	public org.instantlogic.designer.TextTemplateDesign newTitle() {
		org.instantlogic.designer.TextTemplateDesign newValue = new org.instantlogic.designer.TextTemplateDesign(); 
		title.setValue(newValue);
		return newValue;
	}


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<PlaceTemplateDesign, DestinationDesign> incomingLinks
		= createReverseRelationValues(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.incomingLinks);

	public org.instantlogic.fabric.value.RelationValues<PlaceTemplateDesign, DestinationDesign> getIncomingLinksRelationValue() {
		return incomingLinks;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DestinationDesign> getIncomingLinks() {
		return incomingLinks.getValue();
	}

    public PlaceTemplateDesign addToIncomingLinks(DestinationDesign item) {
        incomingLinks.addValue(item);
        return (PlaceTemplateDesign)this;
    }

    public PlaceTemplateDesign removeFromIncomingLinks(DestinationDesign item) {
        incomingLinks.removeValue(item);
        return (PlaceTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<PlaceTemplateDesign, FragmentTemplateDesign> incomingLinksFromFragmentTemplates
		= createReverseRelationValues(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.incomingLinksFromFragmentTemplates);

	public org.instantlogic.fabric.value.RelationValues<PlaceTemplateDesign, FragmentTemplateDesign> getIncomingLinksFromFragmentTemplatesRelationValue() {
		return incomingLinksFromFragmentTemplates;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTemplateDesign> getIncomingLinksFromFragmentTemplates() {
		return incomingLinksFromFragmentTemplates.getValue();
	}

    public PlaceTemplateDesign addToIncomingLinksFromFragmentTemplates(FragmentTemplateDesign item) {
        incomingLinksFromFragmentTemplates.addValue(item);
        return (PlaceTemplateDesign)this;
    }

    public PlaceTemplateDesign removeFromIncomingLinksFromFragmentTemplates(FragmentTemplateDesign item) {
        incomingLinksFromFragmentTemplates.removeValue(item);
        return (PlaceTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> loggedInPlaceOnApplicationDesign
		= createReverseRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.loggedInPlaceOnApplicationDesign);

	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> getLoggedInPlaceOnApplicationDesignRelationValue() {
		return loggedInPlaceOnApplicationDesign;
	}

	public org.instantlogic.designer.ApplicationDesign getLoggedInPlaceOnApplicationDesign() {
		return loggedInPlaceOnApplicationDesign.getValue();
	}

    public PlaceTemplateDesign setLoggedInPlaceOnApplicationDesign(org.instantlogic.designer.ApplicationDesign newValue) {
        loggedInPlaceOnApplicationDesign.setValue(newValue);
        return (PlaceTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> application
		= createReverseRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.application);

	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> getApplicationRelationValue() {
		return application;
	}

	public org.instantlogic.designer.ApplicationDesign getApplication() {
		return application.getValue();
	}

    public PlaceTemplateDesign setApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        application.setValue(newValue);
        return (PlaceTemplateDesign)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> startPlaceOnApplication
		= createReverseRelationValue(org.instantlogic.designer.entity.PlaceTemplateDesignEntity.startPlaceOnApplication);

	public org.instantlogic.fabric.value.RelationValue<PlaceTemplateDesign, ApplicationDesign> getStartPlaceOnApplicationRelationValue() {
		return startPlaceOnApplication;
	}

	public org.instantlogic.designer.ApplicationDesign getStartPlaceOnApplication() {
		return startPlaceOnApplication.getValue();
	}

    public PlaceTemplateDesign setStartPlaceOnApplication(org.instantlogic.designer.ApplicationDesign newValue) {
        startPlaceOnApplication.setValue(newValue);
        return (PlaceTemplateDesign)this;
    }


}
