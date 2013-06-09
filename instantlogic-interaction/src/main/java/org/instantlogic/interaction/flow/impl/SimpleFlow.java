package org.instantlogic.interaction.flow.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.InvalidFlowCoordinatesException;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.SubFlow;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.FlowStack;
import org.instantlogic.interaction.util.PageCoordinates.Coordinate;


public abstract class SimpleFlow extends Flow {
	
	public abstract FlowNodeBase[] getNodes();
	public abstract FlowEdge[] getEdges();
	public abstract Entity<? extends Instance>[] getParameters();

	/**
	 * Finds the page (pagePath is in the format subflowName.subflowName.pageName)
	 */
	public PlaceTemplate getPage(String[] path, int pathIndex) {
		for (FlowNodeBase node: getNodes()) {
			if (node.getName().equals(path[pathIndex])) {
				if (pathIndex==path.length-1) {
					return (PlaceTemplate) node;
				} else {
					return ((SubFlow)node).getFlow().getPage(path, pathIndex+1);
				}
			}
		}
		throw new RuntimeException("Page/Subflow not found: "+path[pathIndex]);
	}
	
	public FlowEdge findEdge(FlowNodeBase from, FlowEventOccurrence occurrence) {
		if (from !=null) {
			// Find an edge with the right start node
			for (FlowEdge edge: getEdges()) {
				if (occurrence.getEvent()==edge.getEvent() && edge.getStartNode()==from) {
					return edge;
				}
			}
		}
		for (FlowEdge edge: getEdges()) {
			// Find an edge without a start node (wildcard, matches any node)
			if (occurrence.getEvent()==edge.getEvent() && edge.getStartNode()==null) {
				return edge;
			}
		}
		return null;
	}
	
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FlowEdge edge = findEdge(null, occurrence);
		context.pushFlowContext(this);
		acceptParameters(context, occurrence.getParameters());
		return reach(edge.getEndNode(), occurrence, context);
	}
	
	protected void acceptParameters(FlowContext context, Instance[] selectedInstances) {
		nextParameter: for (Entity<? extends Instance> entity : this.getParameters()) {
			for (Instance instance: selectedInstances) {
				if (Entity.extendsFrom(instance.getMetadata().getEntity(), entity)) {
					context.getFlowStack().pushSelectedInstance(instance);
					continue nextParameter;
				}
			}
			throw new RuntimeException("No instance selected which matches parameter "+entity.getName());
		}
	}

	// Step to the next point in the flow. Updates context and results in the next trigger
	// returns null if a page has been reached.
	public FlowEventOccurrence step(FlowNodeBase flowNode, FlowEventOccurrence occurrence, FlowContext context) {
		FlowEdge edge = findEdge(flowNode, occurrence);
		if (edge==null) { // No edge at this level, pop to the flow above and check again
			context.popFlowContext();
			return occurrence;
		}
		return reach(edge.getEndNode(), occurrence, context);
	}

	// The end of an edge or source has been reached
	private FlowEventOccurrence reach(FlowNodeBase node, FlowEventOccurrence occurrence, FlowContext context) {
		context.getFlowStack().setCurrentNode(node);
		context.logOccurrence(occurrence);
		if (node instanceof SubFlow) {
			return ((SubFlow)node).getFlow().enter(occurrence, context);
		} else if (node instanceof PlaceTemplate) {
			return null;
		} else {
			throw new RuntimeException("Edge did not reach something useful "+node);
		}
	}

	public FlowStack createFlowStack(FlowStack parentStack, String current, Iterator<String> moreCoordinates, Instance caseInstance) {
		FlowStack result = new FlowStack(parentStack, this);
		for (Entity<? extends Instance> entity: this.getParameters()) {
			if (!moreCoordinates.hasNext()) throw new InvalidFlowCoordinatesException("Not enough parameters for flow "+getName());
			String instanceId = moreCoordinates.next();
			Instance instance = caseInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(instanceId);
			if (instance==null) {
				throw new InvalidFlowCoordinatesException("Unknown instance "+instanceId);
			}
			if (!entity.getInstanceClass().isAssignableFrom(instance.getClass())) {
				throw new InvalidFlowCoordinatesException("Selected instance is not a "+entity.getInstanceClass().getName());
			}
			result.pushSelectedInstance(instance);
		}
		if (!moreCoordinates.hasNext()) {
			return result; // Ends in a flow
		}
		String next = moreCoordinates.next();
		FlowNodeBase nextNode = getNode(next);
		result.setCurrentNode(nextNode);
		if (nextNode instanceof SubFlow) {
			Flow flow = ((SubFlow)nextNode).getFlow(); 
			result = flow.createFlowStack(result, next, moreCoordinates, caseInstance);
			return result;
		} else {
			// Ends on a page
			if (moreCoordinates.hasNext()) {
				throw new InvalidFlowCoordinatesException("Too many parameters");
			}
			return result;
		}
	}
	
	@Override
	public FlowEvent findEvent(String eventName) {
		for (FlowEdge edge : getEdges()) {
			if (edge.getEvent()!=null && edge.getEvent().getName().equals(eventName)) {
				return edge.getEvent();
			}
		}
		return null;
	}
	
	@Deprecated
	protected void stackSelectedInstances(FlowStack stack, Coordinate current, Instance caseInstance) {
		if (current.getActiveInstances().size()!=this.getParameters().length) {
			throw new RuntimeException("Number of parameters does not match number of selected instances"); // TODO check if the right instances are selected
		}
		for (String instanceId: current.getActiveInstances()) {
			Instance instance = caseInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(instanceId);
			if (instance==null) {
				throw new RuntimeException("Instance "+instanceId+" invalid");
			}
			stack.pushSelectedInstance(instance);
		}
	}
	
	private FlowNodeBase getNode(String nodeName) {
		for (FlowNodeBase node: getNodes()) {
			if (node.getName().equals(nodeName)) {
				return node;
			}
		}
		throw new NoSuchElementException("Node: "+nodeName);
	}
}
