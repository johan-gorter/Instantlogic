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
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

// This flow has DataExplorerEntityFlows subFlows for every Entity
public class DataExplorerRootFlow extends Flow {

	private Map<String, DataExplorerEntityFlow> entityFlows = new HashMap<String, DataExplorerEntityFlow>();
	
	public DataExplorerRootFlow(Application application) {
		SortedMap<String,Entity<?>> allEntitiesById = CaseAdministration.getAllEntitiesById(application.getCaseEntity());
		for (Entity<?> entity : allEntitiesById.values()) {
			entityFlows.put(entity.getUniqueId(), new DataExplorerEntityFlow(entity));
		}
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
		return ExploreDataEvent.INSTANCE;
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		String next = moreCoordinates.next();
		return getEntityFlow(next).createFlowStack(parentStack, next, moreCoordinates, caseInstance);
	}

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Instance instanceToExplore = findInstanceToExplore(occurrence, context);
		String entityId = instanceToExplore.getMetadata().getEntity().getUniqueId();
		
		context.pushFlowContext(this);
		context.getFlowStack().setCurrentNode(fakeSubFlow(entityId));
		
		FlowEventOccurrence newOccurrance = new FlowEventOccurrence(ExploreDataEvent.INSTANCE, instanceToExplore);
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
		throw new RuntimeException("Not supported");
	}

	@Override
	public String getName() {
		return "DataExplorerRoot";
	}
}
