package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class EventGenerator extends AbstractGenerator<EventClassModel> {

	private EventDesign eventDesign;

	public EventGenerator(EventDesign eventDesign) {
		this.eventDesign = eventDesign;
	}
	
	@Override
	public EventClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) {
			return null;
		}

		CaseAdministration caseAdministration = eventDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		EventClassModel model = new EventClassModel();
		model.name = eventDesign.getName();
		model.rootPackageName = ((ApplicationDesign)eventDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = eventDesign.getTechnicalNameCapitalized();
		model.isCustomized = eventDesign.getIsCustomized()==Boolean.TRUE;

		model.determineIsDeleted(eventDesign.isValidForCodeGeneration());
		
		for (EntityDesign parameter: eventDesign.getParameters()) {
			model.parameters.add(parameter.getTechnicalNameCapitalized());
		}
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(EventClassModel classModel, GeneratedClassModels context) {
		context.updatedEvents.add(classModel);
	}
}
