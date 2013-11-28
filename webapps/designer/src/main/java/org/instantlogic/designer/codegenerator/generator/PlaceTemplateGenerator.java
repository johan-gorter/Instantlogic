package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.PlaceParameterDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.PlaceTemplateClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.value.ValueList;

public class PlaceTemplateGenerator extends AbstractGenerator<PlaceTemplateClassModel> {

	private PlaceTemplateDesign placeTemplateDesign;
	
	public PlaceTemplateGenerator(PlaceTemplateDesign placeTemplateDesign) {
		this.placeTemplateDesign = placeTemplateDesign;
	}

	@Override
	public PlaceTemplateClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return null;

		CaseAdministration caseAdministration = placeTemplateDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		PlaceTemplateClassModel model = new PlaceTemplateClassModel();
		model.name = placeTemplateDesign.getName();
		model.rootPackageName = ((ApplicationDesign)placeTemplateDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = placeTemplateDesign.getTechnicalNameCapitalized();
		model.id = placeTemplateDesign.getMetadata().getUniqueId();
		model.isCustomized = placeTemplateDesign.getIsCustomized()==Boolean.TRUE;
		if (placeTemplateDesign.getOwner()!=null) {
			model.flowname = placeTemplateDesign.getOwner().getTechnicalName();
		}
		
		model.determineIsDeleted(placeTemplateDesign.isValidForCodeGeneration());
		
		if (placeTemplateDesign.getContent()!=null) {
			model.content = ContentGenerator.generate(placeTemplateDesign.getContent(), model);
		}
		model.title = TextGenerator.generate(placeTemplateDesign.getTitle(), model);
		for (PlaceParameterDesign parameter: placeTemplateDesign.getParameters()) {
			if (parameter.getEntity()!=null) {
				model.parameters.add(parameter.getEntity().getTechnicalNameCapitalized());
			}
		}
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(PlaceTemplateClassModel classModel, GeneratedClassModels context) {
		context.updatedPlaces.add(classModel);
	}
}
