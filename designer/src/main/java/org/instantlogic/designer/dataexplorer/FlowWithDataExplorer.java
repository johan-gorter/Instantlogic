package org.instantlogic.designer.dataexplorer;

import java.util.Iterator;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.SubFlow;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;

// Wraps the main flow of an application to add
// a DataExplorer subflow
public class FlowWithDataExplorer extends FlowWrapper {
	
	private final DataExplorerRootFlow dataExplorerRootFlow;
	private final SubFlow dataExplorerRootSubFlow;

	public FlowWithDataExplorer(Flow delegate, Application application) {
		super(delegate);
		dataExplorerRootFlow = new DataExplorerRootFlow(application);
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
	
	@Override
	public FlowStack createFlowStack(FlowStack parentStack, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		if ("dataExplorer".equals(current)) {
			FlowStack result = new FlowStack(parentStack, this);
			String next = moreCoordinates.next();
			result.setCurrentNode(dataExplorerRootSubFlow);
			return dataExplorerRootFlow.createFlowStack(result, next, moreCoordinates, caseInstance);
		}
		return super.createFlowStack(parentStack, current, moreCoordinates, caseInstance);
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
		if ("ExploreData".equals(occurrence.getEvent().getName())) {
			flowContext.getFlowStack().setCurrentNode(dataExplorerRootSubFlow);
			flowContext.logOccurrence(occurrence);
			return dataExplorerRootFlow.enter(occurrence, flowContext);
		}
		return super.step(currentNode, occurrence, flowContext);
	}
}
