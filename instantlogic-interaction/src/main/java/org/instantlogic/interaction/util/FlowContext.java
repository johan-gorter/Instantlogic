package org.instantlogic.interaction.util;

import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.AbstractDeductionContext;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.InvalidFlowCoordinatesException;
import org.instantlogic.interaction.flow.PlaceTemplate;

// TODO: Rename to PlaceContext
public class FlowContext extends AbstractDeductionContext {

	public static FlowContext create(Application application, String path, Instance caseInstance, String caseId, TravelerInfo travelerInfo) {
		FlowContext result = new FlowContext(application, caseInstance, caseId, travelerInfo);
		if (path == null || path.length()==0) {
			result.setCurrentPlaceTemplate(application.getStartPlace());
		} else {
			String[] pathElements = path.split("[/(,)]");
			if (pathElements.length>0) {
				for(PlaceTemplate placeTemplate : application.getPlaceTemplates()) {
					if (placeTemplate.getTechnicalName().equals(pathElements[0])) {
						int index = 1;
						result.setCurrentPlaceTemplate(placeTemplate);
						for(Entity<?> parameter: placeTemplate.getParameters()) {
							if (pathElements.length<=index) {
								throw new RuntimeException("Not enough parameters");
							}
							String[] keyValue = pathElements[index++].split(":");
							if (keyValue.length!=2 || (parameter!=null && !parameter.getName().equals(keyValue[0]))) {
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
		}
		if (result.getCurrentPlaceTemplate()==null) {
			throw new NoSuchElementException();
		}
		return result;
	}

	public static FlowContext create(Application application, Instance caseInstance, String caseId, TravelerInfo travelerInfo, PlaceTemplate placeTemplate, Instance... placeParameters) {
		FlowContext result = new FlowContext(application, caseInstance, caseId, travelerInfo);
		result.setCurrentPlaceTemplate(placeTemplate);
		for (Instance instance : placeParameters) {
			result.pushSelectedInstance(instance);
		}
		return result;
	}

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
		if (entity != null && !entity.getInstanceClass().isAssignableFrom(instance.getClass())) {
			throw new InvalidFlowCoordinatesException("Selected instance is not a "+entity.getInstanceClass().getName());
		}
		return instance;
	}
	
	
	private final Instance caseInstance;
	private final String caseId;
	private final TravelerInfo traveler;
	private final Application application;
	private PlaceTemplate currentPlaceTemplate;
	
	// For debugging purposes
	private PlaceTemplate lastNode;
	private FlowEventOccurrence lastOccurrence;

	public FlowContext(Application application, Instance caseInstance, String caseId, TravelerInfo traveler) {
		super(null);
		this.application = application;
		this.caseInstance = caseInstance;
		this.caseId = caseId;
		this.traveler = traveler;
	}
	
	public PlaceTemplate getPage() {
		return getCurrentPlaceTemplate();
	}
	
	public Instance getCaseInstance() {
		return this.caseInstance;
	}

	public String getCaseId() {
		return caseId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		Instance result = super.getSelectedInstance(entity);
		if (result==null && Entity.extendsFrom(caseInstance.getMetadata().getEntity(), entity)) {
			return (I)caseInstance;
		}
		if (result!=null) {
			return (I)result;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	public FlowEventOccurrence step(FlowEventOccurrence occurrence) {
		lastOccurrence = occurrence;
		lastNode = currentPlaceTemplate;
		
		PlaceTemplate destination = occurrence.getDestination();
		setCurrentPlaceTemplate(destination);
		selectedInstances.clear();
		
		for(Instance parameterValue: occurrence.getParameters()) {
			pushSelectedInstance(parameterValue);
		}
		return destination.enter(this);
	}

	@Override
	public String toString() {
		return toPath();
	}
	
	public String toPath() {
		StringBuilder sb = new StringBuilder();
		toPath(sb);
		return sb.toString();
	}

	public void logOccurrence(FlowEventOccurrence occurrence) {
		this.lastNode = currentPlaceTemplate;
		this.lastOccurrence = occurrence;
	}

	public TravelerInfo getTraveler() {
		return traveler;
	}

	public PlaceTemplate getCurrentPlaceTemplate() {
		return currentPlaceTemplate;
	}

	public void setCurrentPlaceTemplate(PlaceTemplate currentPlaceTemplate) {
		this.currentPlaceTemplate = currentPlaceTemplate;
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
	
	void toPath(StringBuilder result) {
		result.append(currentPlaceTemplate.getTechnicalName());
			result.append("(");
			boolean first = true;
			for (Entity<?> parameter: currentPlaceTemplate.getParameters()) {
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

	public Application getApplication() {
		return application;
	}
	
}
