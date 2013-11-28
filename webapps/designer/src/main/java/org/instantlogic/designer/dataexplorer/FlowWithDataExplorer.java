package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.SubFlow;
import org.instantlogic.interaction.flow.impl.SimpleFlow;
import org.instantlogic.interaction.flow.impl.SimpleFlowEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

// Wraps the main flow of an application to add
// a DataExplorer subflow
public class FlowWithDataExplorer extends FlowWrapper {
	
	private final DataExplorerRootFlow dataExplorerRootFlow;
	private final SubFlow dataExplorerRootSubFlow;
	private final Map<Entity<?>, List<FlowEvent>> directEvents = new HashMap<Entity<?>, List<FlowEvent>>();

	public FlowWithDataExplorer(Flow delegate, Application application) {
		super(delegate);
		if (delegate instanceof SimpleFlow) {
			for (FlowEdge edge : ((SimpleFlow)delegate).getEdges()) {
				if (edge.getEvent() instanceof SimpleFlowEvent) {
					Entity<?>[] parameterTypes = ((SimpleFlowEvent)edge.getEvent()).getParameterTypes();
					if (parameterTypes.length==1) {
						addDirectEvent(parameterTypes[0], edge.getEvent());
					}
				}
			}
		}
		dataExplorerRootFlow = new DataExplorerRootFlow(application, this);
		dataExplorerRootSubFlow = new SubFlow(){
			@Override
			public Flow getFlow() {
				return dataExplorerRootFlow;
			}
			@Override
			public String getName() {
				return "dataExplorer";
			}
		};
	}
	
	private void addDirectEvent(Entity<?> entity, FlowEvent event) {
		List<FlowEvent> list = directEvents.get(entity);
		if (list==null) {
			list = new ArrayList<FlowEvent>();
			directEvents.put(entity, list);
		}
		list.add(event);
	}
	
	@SuppressWarnings("unchecked")
	public List<FlowEvent> getDirectEvents(Entity<?> entity) {
		List<FlowEvent> result = directEvents.get(entity);
		if (result==null) {
			return Collections.EMPTY_LIST;
		}
		return result;
	}

	@Override
	public FlowStack createFlowStack(FlowStack parentStack, Flow thisOrWrapper, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		if ("dataExplorer".equals(current)) {
			FlowStack result = new FlowStack(parentStack, this);
			String next = moreCoordinates.next();
			result.setCurrentNode(dataExplorerRootSubFlow);
			return dataExplorerRootFlow.createFlowStack(result, dataExplorerRootFlow, next, moreCoordinates, caseInstance);
		}
		return super.createFlowStack(parentStack, thisOrWrapper, current, moreCoordinates, caseInstance);
	}
	
	@Override
	public FlowEvent findEvent(String eventName) {
		if ("ExploreData".equals(eventName)) {
			return ExploreDataEvent.INSTANCE;
		}
		return super.findEvent(eventName);
	}
	
	@Override
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		if ("dataExplorer".equals(path[pathIndex])) {
			return dataExplorerRootFlow.getPage(path, pathIndex+1);
		}
		return super.getPage(path, pathIndex);
	}
	
	@Override
	public FlowEventOccurrence step(FlowNodeBase currentNode, FlowEventOccurrence occurrence, FlowContext flowContext) {
		if (occurrence.getEvent()!=null && "ExploreData".equals(occurrence.getEvent().getName())) {
			flowContext.getFlowStack().setCurrentNode(dataExplorerRootSubFlow);
			flowContext.logOccurrence(occurrence);
			return dataExplorerRootFlow.enter(occurrence, flowContext);
		}
		return super.step(currentNode, occurrence, flowContext);
	}
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		return super.enter(occurrence, context);
	}
}
