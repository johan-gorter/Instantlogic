package org.instantlogic.designer.codegenerator.generator;

import org.instantlogic.designer.ValidationDesign;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class ValidationGenerator extends AbstractGenerator {

	public ValidationDesign validationDesign;
	
	public ValidationGenerator(ValidationDesign validationDesign) {
		this.validationDesign = validationDesign;
	}

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		CaseAdministration caseAdministration = validationDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		ValidationClassModel model = initModel();
		model.rootPackageName = context.rootPackageName;
		model.message = TextGenerator.generate(validationDesign.getMessage(), model);
		model.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(context.rootPackageName, validationDesign.getRule()));
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedValidations.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		ValidationClassModel model = initModel();
		context.deletedValidations.add(model);
	}

	private ValidationClassModel initModel() {
		ValidationClassModel model = new ValidationClassModel();
		model.name = validationDesign.getName();
		model.technicalNameCapitalized = validationDesign.getTechnicalNameCapitalized();
		model.isCustomized = validationDesign.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
