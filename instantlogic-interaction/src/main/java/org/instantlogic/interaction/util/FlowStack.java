package org.instantlogic.interaction.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.flow.InvalidFlowCoordinatesException;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.flow.impl.SimpleFlow;

public class FlowStack extends AbstractDeductionContext {
	
	private static Instance getInstance(Entity entity, String instanceId, Instance caseInstance) {
		Instance instance = caseInstance.getMetadata().getCaseAdministration().getInstanceByUniqueId(instanceId);
		if (instance==null) {
			if (instanceId.contains("!")) {
				int index = instanceId.indexOf('!');
				Entity<?> instanceEntity = caseInstance.getMetadata().getCaseAdministration().getAllEntities().get(instanceId.substring(0, index));
				if (instanceEntity!=null) {
					instance = instanceEntity.getStaticInstances().get(instanceId.substring(index+1));
				}
			} 
			if (instance==null){
				throw new InvalidFlowCoordinatesException("Unknown instance "+instanceId);
			}
		}
		if (!entity.getInstanceClass().isAssignableFrom(instance.getClass())) {
			throw new InvalidFlowCoordinatesException("Selected instance is not a "+entity.getInstanceClass().getName());
		}
		return instance;
	}
	
	public static FlowStack create(PlaceTemplate[] placeTemplates, Flow mainFlow, String path, Instance caseInstance) {
		if (path==null) return new FlowStack(null, mainFlow);
		String[] pathElements = path.split("[/(,)]");
		if (pathElements.length>0) {
			for(PlaceTemplate placeTemplate : placeTemplates) {
				if (placeTemplate.getTechnicalName().equals(pathElements[0])) {
					// The new way
					int index = 1;
					FlowStack result = new FlowStack(null, mainFlow);
					result.currentNode = placeTemplate;
					for(Entity<?> parameter: placeTemplate.getParameters()) {
						String[] keyValue = pathElements[index++].split(":");
						if (keyValue.length!=2 || !parameter.getName().equals(keyValue[0])) {
							throw new RuntimeException("Invalid place parameter value "+pathElements[index-1]);
						}
						result.pushSelectedInstance(getInstance(parameter, keyValue[1], caseInstance));
					}
					if (index!=pathElements.length) {
						throw new RuntimeException("Too many parameter values");
					}
					return result;
				}
			}
		}
		// The old way
		Iterator<String> iterator = Arrays.asList(pathElements).iterator();
		return mainFlow.createFlowStack(null, mainFlow, pathElements[0], iterator, caseInstance);
	}
	
	private final FlowStack parent;
	
	@Deprecated
	private final Flow flow;
	
	private FlowNodeBase currentNode;

	public FlowStack(FlowStack parent, Flow flow) {
		super(parent);
		this.parent = parent;
		this.flow = flow;
	}

	public FlowNodeBase getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(FlowNodeBase currentNode) {
		this.currentNode = currentNode;
	}

	public FlowStack getParent() {
		return parent;
	}

	public Flow getFlow() {
		return flow;
	}
	
	public String toPath() {
		StringBuilder result = new StringBuilder();
		toPath(result);
		return result.toString();
	}
	
	void toPath(StringBuilder result) {
		if (this.getCurrentNode() instanceof PlaceTemplate) {
			PlaceTemplate place = (PlaceTemplate) this.getCurrentNode();
			if (this.flow==null) {
				// New
				result.append(place.getTechnicalName());
				result.append("(");
				boolean first = true;
				for (Entity<?> parameter: place.getParameters()) {
					if (!first) {
						result.append(",");
					} else {
						first = false;
					}
					result.append(parameter.getName());
					result.append(":");
					appendInstanceId(result, getSelectedInstance(parameter));
				}
				result.append(")");
				return;
			}
		}
		// Old
		if (parent!=null) {
			parent.toPath(result);
			result.append("/");
			for (Instance instance: selectedInstances) {
				appendInstanceId(result, instance);
				result.append("/");
			}
		}
		result.append(this.getCurrentNode().getName());
	}
	
	private void appendInstanceId(StringBuilder result, Instance instance) {
		if (instance.getMetadata().isStatic()) {
			result.append(instance.getMetadata().getEntity().getName());
			result.append("!");
			result.append(instance.getMetadata().getStaticName());
		} else {
			result.append(instance.getMetadata().getUniqueId());					
		}
	}

	@Override
	public String toString() {
		return "("+currentNode+" in "+flow+")"+(parent==null?"":"-->"+parent);
	}

	public FlowEvent findEvent(String eventName) {
		FlowEvent result = flow.findEvent(eventName);
		if (result!=null) {
			return result;
		}
		if (parent==null) {
			throw new NoSuchElementException("Event not found from this flow: "+eventName);
		}
		return parent.findEvent(eventName);
	}
}
