package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class PlaceTemplateGenerator extends AbstractGenerator {

	
	private PlaceTemplateDesign placeTemplateDesign;
	
	public PlaceTemplateGenerator(PlaceTemplateDesign placeTemplateDesign) {
		this.placeTemplateDesign = placeTemplateDesign;
	}

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		CaseAdministration caseAdministration = placeTemplateDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		PlaceClassModel model = initModel();
		model.rootPackageName = updateRootPackageName(((ApplicationDesign)placeTemplateDesign.getMetadata().getCase()).getRootPackageName(), context);
		model.determineIsDeleted(placeTemplateDesign.isValidForCodeGeneration());
		
		model.content = ContentGenerator.generate(placeTemplateDesign.getContent(), model);
		model.title = TextGenerator.generate(placeTemplateDesign.getTitle(), model);

		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedPlaces.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		PlaceClassModel model = initModel();
		model.isDeleted = true;
		context.updatedPlaces.add(model);
	}

	private PlaceClassModel initModel() {
		PlaceClassModel model = new PlaceClassModel();
		model.name = placeTemplateDesign.getName();
		model.rootPackageName = lastRootPackageName;
		model.technicalNameCapitalized = placeTemplateDesign.getTechnicalNameCapitalized();
		model.id = placeTemplateDesign.getMetadata().getUniqueId();
		model.isCustomized = placeTemplateDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = placeTemplateDesign.getOwner().getTechnicalName();
		return model;
	}
}
