

package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EntityClassModel;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.designer.codegenerator.classmodel.FlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;

public class GeneratedClassModels {

	public static GeneratedClassModels merge(List<GeneratedClassModels> read) {
		GeneratedClassModels result = new GeneratedClassModels();
		for (GeneratedClassModels item : read) {
			result.addFrom(item);
		}
		return result;
	}

	public final List<EntityClassModel> updatedEntities = new ArrayList<EntityClassModel>();
	public final List<EntityClassModel> deletedEntities = new ArrayList<EntityClassModel>();
	
	public final List<SharedPageFragmentClassModel> updatedSharedPageFragments = new ArrayList<SharedPageFragmentClassModel>();
	public final List<SharedPageFragmentClassModel> deletedSharedPageFragments = new ArrayList<SharedPageFragmentClassModel>();

	public final List<EventClassModel> updatedEvents = new ArrayList<EventClassModel>();
	public final List<EventClassModel> deletedEvents = new ArrayList<EventClassModel>();
	
	public final List<FlowClassModel> updatedFlows = new ArrayList<FlowClassModel>();
	public final List<FlowClassModel> deletedFlows = new ArrayList<FlowClassModel>();
	
	public final List<PlaceClassModel> updatedPlaces = new ArrayList<PlaceClassModel>();
	public final List<PlaceClassModel> deletedPlaces = new ArrayList<PlaceClassModel>();
	
	public final List<SubFlowClassModel> updatedSubFlows = new ArrayList<SubFlowClassModel>();
	public final List<SubFlowClassModel> deletedSubFlows = new ArrayList<SubFlowClassModel>();

	public final List<ValidationClassModel> updatedValidations = new ArrayList<ValidationClassModel>();
	public final List<ValidationClassModel> deletedValidations = new ArrayList<ValidationClassModel>();
	
	public ApplicationClassModel updatedApplication = null;
	
	public String rootPackageName;
	
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

	public int countDeletes() {
		return deletedEntities.size() 
			+ deletedSharedPageFragments.size()
			+ deletedEvents.size()
			+ deletedFlows.size()
			+ deletedPlaces.size()
			+ deletedSubFlows.size()
			+ deletedValidations.size();
	}

	private void addFrom(GeneratedClassModels newer) {
		if (newer.updatedApplication!=null) {
			updatedApplication = newer.updatedApplication;
		}
		// Entities
		for (EntityClassModel deletedEntity: newer.deletedEntities) {
			removeClassModel(updatedEntities, deletedEntity);
			deletedEntities.add(deletedEntity);
		}
		for (EntityClassModel updatedEntity: newer.updatedEntities) {
			removeClassModel(updatedEntities, updatedEntity);
			updatedEntities.add(updatedEntity);
		}
		// SharedPageFragments
		for (SharedPageFragmentClassModel deletedSharedPageFragment: newer.deletedSharedPageFragments) {
			removeClassModel(updatedSharedPageFragments, deletedSharedPageFragment);
			deletedSharedPageFragments.add(deletedSharedPageFragment);
		}
		for (SharedPageFragmentClassModel updatedSharedPageFragment: newer.updatedSharedPageFragments) {
			removeClassModel(updatedSharedPageFragments, updatedSharedPageFragment);
			updatedSharedPageFragments.add(updatedSharedPageFragment);
		}
		// Events
		for (EventClassModel deletedEvent: newer.deletedEvents) {
			removeClassModel(updatedEvents, deletedEvent);
			deletedEvents.add(deletedEvent);
		}
		for (EventClassModel updatedEvent: newer.updatedEvents) {
			removeClassModel(updatedEvents, updatedEvent);
			updatedEvents.add(updatedEvent);
		}
		// Flows
		for (FlowClassModel deletedFlow: newer.deletedFlows) {
			removeClassModel(updatedFlows, deletedFlow);
			deletedFlows.add(deletedFlow);
		}
		for (FlowClassModel updatedFlow: newer.updatedFlows) {
			removeClassModel(updatedFlows, updatedFlow);
			updatedFlows.add(updatedFlow);
		}
		// Places
		for (PlaceClassModel deletedPlace: newer.deletedPlaces) {
			removeClassModel(updatedPlaces, deletedPlace);
			deletedPlaces.add(deletedPlace);
		}
		for (PlaceClassModel updatedPlace: newer.updatedPlaces) {
			removeClassModel(updatedPlaces, updatedPlace);
			updatedPlaces.add(updatedPlace);
		}
		// SubFlows
		for (SubFlowClassModel deletedSubFlow: newer.deletedSubFlows) {
			removeClassModel(updatedSubFlows, deletedSubFlow);
			deletedSubFlows.add(deletedSubFlow);
		}
		for (SubFlowClassModel updatedSubFlow: newer.updatedSubFlows) {
			removeClassModel(updatedSubFlows, updatedSubFlow);
			updatedSubFlows.add(updatedSubFlow);
		}
		// Validations
		for (ValidationClassModel deletedValidation: newer.deletedValidations) {
			removeClassModel(updatedValidations, deletedValidation);
			deletedValidations.add(deletedValidation);
		}
		for (ValidationClassModel updatedValidation: newer.updatedValidations) {
			removeClassModel(updatedValidations, updatedValidation);
			updatedValidations.add(updatedValidation);
		}
		rootPackageName = newer.rootPackageName;
	}

	private <T extends AbstractClassModel> void  removeClassModel(List<T> list, T toRemove) {
		Iterator<T> iterator = list.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			if (next.getTechnicalNameCapitalized().equals(toRemove.getTechnicalNameCapitalized())) {
				iterator.remove();
			}
		}
	}
}
