package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceTemplateClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;

// Queue of updates to classModels
public class GeneratedClassModels {

	public static GeneratedClassModels merge(List<GeneratedClassModels> read) {
		GeneratedClassModels result = new GeneratedClassModels();
		for (GeneratedClassModels item : read) {
			result.addFrom(item);
		}
		return result;
	}

	public final List<EntityClassModel> updatedEntities = new ArrayList<EntityClassModel>();
	
	public final List<SharedPageFragmentClassModel> updatedSharedPageFragments = new ArrayList<SharedPageFragmentClassModel>();

	public final List<EventClassModel> updatedEvents = new ArrayList<EventClassModel>();
	
	public final List<FlowClassModel> updatedFlows = new ArrayList<FlowClassModel>();
	
	public final List<PlaceTemplateClassModel> updatedPlaces = new ArrayList<PlaceTemplateClassModel>();
	
	public final List<SubFlowClassModel> updatedSubFlows = new ArrayList<SubFlowClassModel>();

	public final List<ValidationClassModel> updatedValidations = new ArrayList<ValidationClassModel>();
	
	public ApplicationClassModel updatedApplication = null;
	
	public int countUpdates() {
		return (updatedApplication==null?0:1)
			+ updatedEntities.size() 
			+ updatedSharedPageFragments.size()
			+ updatedEvents.size()
			+ updatedFlows.size()
			+ updatedPlaces.size()
			+ updatedSubFlows.size()
			+ updatedValidations.size();
	}

	private void addFrom(GeneratedClassModels newer) {
		if (newer.updatedApplication!=null) {
			updatedApplication = newer.updatedApplication;
		}
		// Entities
		for (EntityClassModel updatedEntity: newer.updatedEntities) {
			removeClassModel(updatedEntities, updatedEntity);
			updatedEntities.add(updatedEntity);
		}
		// SharedPageFragments
		for (SharedPageFragmentClassModel updatedSharedPageFragment: newer.updatedSharedPageFragments) {
			removeClassModel(updatedSharedPageFragments, updatedSharedPageFragment);
			updatedSharedPageFragments.add(updatedSharedPageFragment);
		}
		// Events
		for (EventClassModel updatedEvent: newer.updatedEvents) {
			removeClassModel(updatedEvents, updatedEvent);
			updatedEvents.add(updatedEvent);
		}
		// Flows
		for (FlowClassModel updatedFlow: newer.updatedFlows) {
			removeClassModel(updatedFlows, updatedFlow);
			updatedFlows.add(updatedFlow);
		}
		// Places
		for (PlaceTemplateClassModel updatedPlace: newer.updatedPlaces) {
			removeClassModel(updatedPlaces, updatedPlace);
			updatedPlaces.add(updatedPlace);
		}
		// SubFlows
		for (SubFlowClassModel updatedSubFlow: newer.updatedSubFlows) {
			removeClassModel(updatedSubFlows, updatedSubFlow);
			updatedSubFlows.add(updatedSubFlow);
		}
		// Validations
		for (ValidationClassModel updatedValidation: newer.updatedValidations) {
			removeClassModel(updatedValidations, updatedValidation);
			updatedValidations.add(updatedValidation);
		}
	}

	private <T extends AbstractClassModel> void  removeClassModel(List<T> list, T toRemove) {
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (next.getTechnicalNameCapitalized().equals(toRemove.getTechnicalNameCapitalized()) 
				&& next.rootPackageName.equals(toRemove.rootPackageName)) {
				iterator.remove();
			}
		}
	}
}
