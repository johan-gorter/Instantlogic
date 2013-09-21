package org.instantlogic.designer;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public abstract class AbstractApplicationDesign extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, ApplicationDesign> _staticInstances = new java.util.LinkedHashMap<String, ApplicationDesign>();
	
	public static java.util.Map<String, ApplicationDesign> getStaticApplicationDesignInstances() {
		return _staticInstances;
	}
	
	private static ApplicationDesign addStaticInstance(String name, ApplicationDesign instance) {
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
		return org.instantlogic.designer.entity.ApplicationDesignEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> rootPackageName
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.rootPackageName);
	
	public java.lang.String getRootPackageName() {
		return rootPackageName.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getRootPackageNameAttributeValue() {
		return rootPackageName;
	}

	public ApplicationDesign setRootPackageName(java.lang.String newValue) {
		rootPackageName.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> sourcePath
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.sourcePath);
	
	public java.lang.String getSourcePath() {
		return sourcePath.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getSourcePathAttributeValue() {
		return sourcePath;
	}

	public ApplicationDesign setSourcePath(java.lang.String newValue) {
		sourcePath.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> isCustomized
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.isCustomized);
	
	public java.lang.Boolean getIsCustomized() {
		return isCustomized.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.Boolean> getIsCustomizedAttributeValue() {
		return isCustomized;
	}

	public ApplicationDesign setIsCustomized(java.lang.Boolean newValue) {
		isCustomized.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValues<ApplicationDesign, java.lang.String> themeNames
		= createAttributeValues(org.instantlogic.designer.entity.ApplicationDesignEntity.themeNames);
	
	public org.instantlogic.fabric.value.Values<java.lang.String> getThemeNames() {
		return themeNames.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValues<ApplicationDesign, java.lang.String> getThemeNamesAttributeValue() {
		return themeNames;
	}

	public ApplicationDesign addToThemeNames(java.lang.String item) {
		themeNames.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromThemeNames(java.lang.String item) {
		themeNames.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> name
		= createAttributeValue(org.instantlogic.designer.entity.ApplicationDesignEntity.name);
	
	public java.lang.String getName() {
		return name.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<ApplicationDesign, java.lang.String> getNameAttributeValue() {
		return name;
	}

	public ApplicationDesign setName(java.lang.String newValue) {
		name.setValue(newValue);
		return (ApplicationDesign)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FragmentTypeDesign> fragmentTypes
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.fragmentTypes);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FragmentTypeDesign> getFragmentTypesRelationValue() {
		return fragmentTypes;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FragmentTypeDesign> getFragmentTypes() {
		return fragmentTypes.getValue();
	}
	
	public ApplicationDesign addToFragmentTypes(FragmentTypeDesign item) {
		fragmentTypes.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromFragmentTypes(FragmentTypeDesign item) {
		fragmentTypes.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> flows
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.flows);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, FlowDesign> getFlowsRelationValue() {
		return flows;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.FlowDesign> getFlows() {
		return flows.getValue();
	}
	
	public ApplicationDesign addToFlows(FlowDesign item) {
		flows.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromFlows(FlowDesign item) {
		flows.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> caseEntity
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.caseEntity);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EntityDesign> getCaseEntityRelationValue() {
		return caseEntity;
	}

	public org.instantlogic.designer.EntityDesign getCaseEntity() {
		return caseEntity.getValue();
	}
	
	public ApplicationDesign setCaseEntity(org.instantlogic.designer.EntityDesign newValue) {
		caseEntity.setValue(newValue);
		return (ApplicationDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, SharedElementDefinitionDesign> sharedElements
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.sharedElements);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, SharedElementDefinitionDesign> getSharedElementsRelationValue() {
		return sharedElements;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.SharedElementDefinitionDesign> getSharedElements() {
		return sharedElements.getValue();
	}
	
	public ApplicationDesign addToSharedElements(SharedElementDefinitionDesign item) {
		sharedElements.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromSharedElements(SharedElementDefinitionDesign item) {
		sharedElements.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, FlowDesign> mainFlow
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.mainFlow);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, FlowDesign> getMainFlowRelationValue() {
		return mainFlow;
	}

	public org.instantlogic.designer.FlowDesign getMainFlow() {
		return mainFlow.getValue();
	}
	
	public ApplicationDesign setMainFlow(org.instantlogic.designer.FlowDesign newValue) {
		mainFlow.setValue(newValue);
		return (ApplicationDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> entities
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.entities);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EntityDesign> getEntitiesRelationValue() {
		return entities;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.EntityDesign> getEntities() {
		return entities.getValue();
	}
	
	public ApplicationDesign addToEntities(EntityDesign item) {
		entities.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEntities(EntityDesign item) {
		entities.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, DeductionOperationDesign> customDeductionOperations
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.customDeductionOperations);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, DeductionOperationDesign> getCustomDeductionOperationsRelationValue() {
		return customDeductionOperations;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.DeductionOperationDesign> getCustomDeductionOperations() {
		return customDeductionOperations.getValue();
	}
	
	public ApplicationDesign addToCustomDeductionOperations(DeductionOperationDesign item) {
		customDeductionOperations.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromCustomDeductionOperations(DeductionOperationDesign item) {
		customDeductionOperations.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EventDesign> loggedInEvent
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.loggedInEvent);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EventDesign> getLoggedInEventRelationValue() {
		return loggedInEvent;
	}

	public org.instantlogic.designer.EventDesign getLoggedInEvent() {
		return loggedInEvent.getValue();
	}
	
	public ApplicationDesign setLoggedInEvent(org.instantlogic.designer.EventDesign newValue) {
		loggedInEvent.setValue(newValue);
		return (ApplicationDesign)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> events
		= createRelationValues(org.instantlogic.designer.entity.ApplicationDesignEntity.events);
		
	public org.instantlogic.fabric.value.RelationValues<ApplicationDesign, EventDesign> getEventsRelationValue() {
		return events;
	}

	public org.instantlogic.fabric.value.Values<org.instantlogic.designer.EventDesign> getEvents() {
		return events.getValue();
	}
	
	public ApplicationDesign addToEvents(EventDesign item) {
		events.addValue(item);
		return (ApplicationDesign)this;
	}
	
	public ApplicationDesign removeFromEvents(EventDesign item) {
		events.removeValue(item);
		return (ApplicationDesign)this;
	}
	
	
	
	private final org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EventDesign> startEvent
		= createRelationValue(org.instantlogic.designer.entity.ApplicationDesignEntity.startEvent);
		
	public org.instantlogic.fabric.value.RelationValue<ApplicationDesign, EventDesign> getStartEventRelationValue() {
		return startEvent;
	}

	public org.instantlogic.designer.EventDesign getStartEvent() {
		return startEvent.getValue();
	}
	
	public ApplicationDesign setStartEvent(org.instantlogic.designer.EventDesign newValue) {
		startEvent.setValue(newValue);
		return (ApplicationDesign)this;
	}
	


	// Reverse relations

}
