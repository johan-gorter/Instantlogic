package org.instantlogic.designer.dataexplorer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

// This flow has DataExplorerEntityFlows subFlows for every Entity
public class DataExplorerRootFlow extends Flow {

	private Map<String, DataExplorerEntityFlow> entityFlows = new HashMap<String, DataExplorerEntityFlow>();
	private Map<String, SimpleFlowEvent> entityDetailsEvents = new HashMap<String, SimpleFlowEvent>();
	private Map<String, DataExplorerOwnerBreadcrumbElement> breadcrumbElements = new HashMap<String, DataExplorerOwnerBreadcrumbElement>();
	private Map<SimpleFlowEvent, DataExplorerEntityFlow> detailEventToFlow = new HashMap<SimpleFlowEvent, DataExplorerEntityFlow>();
	private FlowWithDataExplorer flowWithDataExplorer;
	private DataExplorerStaticInstancesPlaceTemplate staticInstancesPlaceTemplate;
	private Entity<? extends Instance> caseEntity;
	private Application application;
	
	public Application getApplication() {
		return application;
	}

	public Entity<? extends Instance> getCaseEntity() {
		return caseEntity;
	}

	public DataExplorerRootFlow(Application application, FlowWithDataExplorer flowWithDataExplorer) {
		this.application = application;
		this.flowWithDataExplorer = flowWithDataExplorer;
		this.caseEntity = application.getCaseEntity();
		SortedMap<String,Entity<?>> allEntitiesById = CaseAdministration.getAllEntitiesById(application.getCaseEntity());
		for (Entity<?> entity : allEntitiesById.values()) {
			DataExplorerOwnerBreadcrumbElement breadcrumbElement = new DataExplorerOwnerBreadcrumbElement(entity, this, false);
			breadcrumbElements.put(entity.getUniqueId(), breadcrumbElement);
			SimpleFlowEvent detailsEvent = new SimpleFlowEvent(entity.getUniqueId()+"-details", entity);
			DataExplorerEntityFlow entityFlow = new DataExplorerEntityFlow(entity, detailsEvent, breadcrumbElement, new DataExplorerOwnerBreadcrumbElement(entity, this, true), flowWithDataExplorer.getDirectEvents(entity));
			entityFlows.put(entity.getUniqueId(), entityFlow);
			entityDetailsEvents.put(entity.getUniqueId(), detailsEvent);
			detailEventToFlow.put(detailsEvent, entityFlow);
			for (SimpleFlowEvent relationEvent: entityFlow.getRelationDetailsEvents()) {
				detailEventToFlow.put(relationEvent, entityFlow);
			}
		}
		this.staticInstancesPlaceTemplate = new DataExplorerStaticInstancesPlaceTemplate(this);
	}
	
	@SuppressWarnings("rawtypes")
	public SimpleFlowEvent getEntityDetailsEvent(Entity entity) {
		return entityDetailsEvents.get(entity.getUniqueId());
	}
	
	@SuppressWarnings("rawtypes")
	public DataExplorerOwnerBreadcrumbElement getBreadcrumbElement(Entity entity) {
		return breadcrumbElements.get(entity.getUniqueId());
	}

	private DataExplorerEntityFlow getEntityFlow(String entityId) {
		return entityFlows.get(entityId);
	}

	@Override
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		return getEntityFlow(path[pathIndex]).getPage(path, pathIndex+1);
	}

	// Used in case of a StartMessage (browser navigates directly to a url)
	@Override
	public FlowEvent findEvent(String eventName) {
		if (eventName.equals(ExploreStaticInstancesEvent.INSTANCE.getName())) {
			return ExploreStaticInstancesEvent.INSTANCE;
		}
		return ExploreDataEvent.INSTANCE;
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, Flow thisOrWrapper, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		FlowStack result = new FlowStack(parentStack, this);
		String entityId = moreCoordinates.next();
		if (entityId.equals("Static instances")) {
			result.setCurrentNode(this.staticInstancesPlaceTemplate);
			return result;
		}
		result.setCurrentNode(fakeSubFlow(entityId));
		DataExplorerEntityFlow entityFlow = getEntityFlow(entityId);
		return entityFlow.createFlowStack(result, entityFlow, entityId, moreCoordinates, caseInstance);
	}

	// ExploreDataEvent gets translated to a more specific entityDetailsEvent
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		// Handles only ExploreData-like events
		Instance instanceToExplore = findInstanceToExplore(occurrence, context);
		String entityId = instanceToExplore.getMetadata().getEntity().getUniqueId();
		
		context.pushFlowContext(this);
		context.getFlowStack().setCurrentNode(fakeSubFlow(entityId));
		
		FlowEventOccurrence newOccurrance = new FlowEventOccurrence(entityDetailsEvents.get(entityId), instanceToExplore);
		return getEntityFlow(entityId).enter(newOccurrance, context);
	}

	// Effectively scans the url back to front to find an instance, if none is found, the caseinstance is returned.
	private Instance findInstanceToExplore(FlowEventOccurrence occurrence, FlowContext context) {
		for (int i=occurrence.getParameters().length-1;i>=0;i--) {
			Instance candidate = occurrence.getParameters()[i];
			if (candidate!=null) {
				return candidate;
			}
		}
		return context.getCaseInstance();
	}

	private FlowNodeBase fakeSubFlow(final String entityId) {
		return new FlowNodeBase() {
			@Override
			public String getName() {
				return entityId;
			}
		};
	}

	@Override
	public FlowEventOccurrence step(FlowNodeBase currentNode, FlowEventOccurrence occurrence, FlowContext flowContext) {
		DataExplorerEntityFlow entityFlow = detailEventToFlow.get(occurrence.getEvent()); 
		if (entityFlow==null) {
			if (occurrence.getEvent()==ExploreStaticInstancesEvent.INSTANCE) {
				flowContext.getFlowStack().setCurrentNode(this.staticInstancesPlaceTemplate);
				return null;
			}
			if (occurrence.getEvent().getName().equals("ExploreData")) {
				// ExploreDataEvent
				Instance instanceToExplore = findInstanceToExplore(occurrence, flowContext);
				String entityId = instanceToExplore.getMetadata().getEntity().getUniqueId();
				entityFlow = entityFlows.get(entityId);
				occurrence = new FlowEventOccurrence(this.entityDetailsEvents.get(entityId), instanceToExplore);
			} else {
				// Normal flow
				flowContext.popFlowContext();
				return occurrence;
			}
		}
		// EntityDetailsEvents
		flowContext.getFlowStack().setCurrentNode(fakeSubFlow(entityFlow.getEntity().getUniqueId()));
		return entityFlow.enter(occurrence, flowContext);
	}

	@Override
	public String getName() {
		return "DataExplorerRoot";
	}

	public DataExplorerEntityFlow getEntityFlow(Entity<?> entity) {
		return getEntityFlow(entity.getUniqueId());
	}
}
