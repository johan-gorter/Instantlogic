package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SharedElementDefinitionGenerator extends AbstractGenerator<SharedPageFragmentClassModel> {

	private SharedElementDefinitionDesign definition;

	public SharedElementDefinitionGenerator(SharedElementDefinitionDesign pageFragmentHolderDesign) {
		this.definition = pageFragmentHolderDesign;
	}


	@Override
	public SharedPageFragmentClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) { 
			return null; 
		}

		CaseAdministration caseAdministration = definition.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		SharedPageFragmentClassModel model = new SharedPageFragmentClassModel();
		model.rootPackageName = ((ApplicationDesign)definition.getMetadata().getCase()).getRootPackageName();
		model.name = definition.getName();
		model.technicalNameCapitalized = definition.getTechnicalNameCapitalized();
		model.isCustomized = definition.getIsCustomized()==Boolean.TRUE;
		model.determineIsDeleted(definition.isValidForCodeGeneration());
		
		model.content = ContentGenerator.generate(definition.getFragment(), model);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(SharedPageFragmentClassModel classModel, GeneratedClassModels context) {
		context.updatedSharedPageFragments.add(classModel);
	}
}
