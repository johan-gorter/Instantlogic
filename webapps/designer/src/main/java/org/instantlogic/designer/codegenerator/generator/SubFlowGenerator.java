package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.codegenerator.classmodel.SubFlowClassModel;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;

public class SubFlowGenerator extends AbstractGenerator<SubFlowClassModel> {

	public SubFlowDesign subFlowDesign;
	
	public SubFlowGenerator(SubFlowDesign subFlowDesign) {
		this.subFlowDesign = subFlowDesign;
	}

	@Override
	public SubFlowClassModel generate(GeneratedClassModels context) {
		if (observations!=null && !observations.isOutdated()) return null;

		CaseAdministration caseAdministration = subFlowDesign.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		
		SubFlowClassModel model = new SubFlowClassModel();
		model.name = subFlowDesign.getName();
		model.rootPackageName = ((ApplicationDesign)subFlowDesign.getMetadata().getCase()).getRootPackageName();
		model.technicalNameCapitalized = subFlowDesign.getTechnicalNameCapitalized();
		model.isCustomized = subFlowDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = subFlowDesign.getOwner().getTechnicalName().toLowerCase();
		model.determineIsDeleted(true /*TODO subFlowDesign.isValidForCodeGeneration()*/);
		
		if (subFlowDesign.getFlow()!=null) {
			model.subFlowName = subFlowDesign.getFlow().getTechnicalNameCapitalized();
		}
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		return model;
	}
	
	@Override
	public void queueClassModel(SubFlowClassModel classModel, GeneratedClassModels context) {
		context.updatedSubFlows.add(classModel);
	}

}
