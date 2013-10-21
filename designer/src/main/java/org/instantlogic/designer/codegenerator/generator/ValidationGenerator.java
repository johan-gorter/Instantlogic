package org.instantlogic.designer.codegenerator.generator;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.ValidationDesign;
import org.instantlogic.designer.codegenerator.classmodel.ValidationClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class ValidationGenerator extends AbstractGenerator<ValidationClassModel> {

	public ValidationDesign validationDesign;
	
	public ValidationGenerator(ValidationDesign validationDesign) {
		this.validationDesign = validationDesign;
	}

	@Override
	public ValidationClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return null;

		CaseAdministration caseAdministration = validationDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		ValidationClassModel model = new ValidationClassModel();
		model.name = validationDesign.getName();
		model.rootPackageName = ((ApplicationDesign)validationDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = validationDesign.getTechnicalNameCapitalized();
		model.isCustomized = validationDesign.getIsCustomized()==Boolean.TRUE;

		model.determineIsDeleted(validationDesign.isValidForCodeGeneration());
		
		model.message = TextGenerator.generate(validationDesign.getMessage(), model);
		model.ruleDeductionIndex = model.addDeductionScheme(DeductionSchemeGenerator.generate(model.rootPackageName, validationDesign.getRule()));
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		
		return model;
	}
	
	@Override
	public void queueClassModel(ValidationClassModel classModel, GeneratedClassModels context) {
		context.updatedValidations.add(classModel);
	}
}
