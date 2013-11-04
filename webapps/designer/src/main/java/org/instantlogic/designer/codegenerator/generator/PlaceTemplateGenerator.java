package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.PlaceClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class PlaceTemplateGenerator extends AbstractGenerator<PlaceClassModel> {

	
	private PlaceTemplateDesign placeTemplateDesign;
	
	public PlaceTemplateGenerator(PlaceTemplateDesign placeTemplateDesign) {
		this.placeTemplateDesign = placeTemplateDesign;
	}

	@Override
	public PlaceClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return null;

		CaseAdministration caseAdministration = placeTemplateDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		PlaceClassModel model = new PlaceClassModel();
		model.name = placeTemplateDesign.getName();
		model.rootPackageName = ((ApplicationDesign)placeTemplateDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = placeTemplateDesign.getTechnicalNameCapitalized();
		model.id = placeTemplateDesign.getMetadata().getUniqueId();
		model.isCustomized = placeTemplateDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = placeTemplateDesign.getOwner().getTechnicalName();
		
		model.determineIsDeleted(placeTemplateDesign.isValidForCodeGeneration());
		
		if (placeTemplateDesign.getContent()!=null) {
			model.content = ContentGenerator.generate(placeTemplateDesign.getContent(), model);
		}
		model.title = TextGenerator.generate(placeTemplateDesign.getTitle(), model);

		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(PlaceClassModel classModel, GeneratedClassModels context) {
		context.updatedPlaces.add(classModel);
	}
}
