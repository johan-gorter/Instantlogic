package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SubFlowGenerator extends AbstractGenerator {

	public SubFlowDesign subFlowDesign;
	
	public SubFlowGenerator(SubFlowDesign subFlowDesign) {
		this.subFlowDesign = subFlowDesign;
	}

	@Override
	public void update(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return;

		CaseAdministration caseAdministration = subFlowDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		SubFlowClassModel model = initModel();
		model.rootPackageName = updateRootPackageName(((ApplicationDesign)subFlowDesign.getMetadata().getCase()).getRootPackageName(), context);
		model.determineIsDeleted(true /*TODO subFlowDesign.isValidForCodeGeneration()*/);
		
		model.subFlowName = subFlowDesign.getFlow().getTechnicalNameCapitalized();
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedSubFlows.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		SubFlowClassModel model = initModel();
		model.isDeleted = true;
		context.updatedSubFlows.add(model);
	}

	private SubFlowClassModel initModel() {
		SubFlowClassModel model = new SubFlowClassModel();
		model.name = subFlowDesign.getName();
		model.rootPackageName = lastRootPackageName;
		model.technicalNameCapitalized = subFlowDesign.getTechnicalNameCapitalized();
		model.isCustomized = subFlowDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = subFlowDesign.getOwner().getTechnicalName();
		return model;
	}
}
