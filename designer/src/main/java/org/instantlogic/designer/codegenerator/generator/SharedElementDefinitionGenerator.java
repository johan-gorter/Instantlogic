package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.codegenerator.classmodel.SharedPageFragmentClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SharedElementDefinitionGenerator extends AbstractGenerator {

	private SharedElementDefinitionDesign definition;

	public SharedElementDefinitionGenerator(SharedElementDefinitionDesign pageFragmentHolderDesign) {
		this.definition = pageFragmentHolderDesign;
	}


	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) { return; }

		CaseAdministration caseAdministration = definition.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();

		SharedPageFragmentClassModel model = initModel(context);
		model.rootPackageName = updateRootPackageName(((ApplicationDesign)definition.getMetadata().getCase()).getRootPackageName(), context);
		model.determineIsDeleted(definition.isValidForCodeGeneration());
		
		model.content = ContentGenerator.generate(definition.getFragment(), model);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedSharedPageFragments.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = initModel(context);
		model.isDeleted = true;
		context.updatedSharedPageFragments.add(model);
	}

	private SharedPageFragmentClassModel initModel(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = new SharedPageFragmentClassModel();
		model.rootPackageName = lastRootPackageName;
		model.name = definition.getName();
		model.technicalNameCapitalized = definition.getTechnicalNameCapitalized();
		model.isCustomized = definition.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
