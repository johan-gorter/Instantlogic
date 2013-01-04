/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.codegenerator.generator;


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
		model.rootPackageName = context.rootPackageName;
		model.subFlowName = subFlowDesign.getFlow().getTechnicalNameCapitalized();
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedSubFlows.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		SubFlowClassModel model = initModel();
		context.deletedSubFlows.add(model);
	}

	private SubFlowClassModel initModel() {
		SubFlowClassModel model = new SubFlowClassModel();
		model.name = subFlowDesign.getName();
		model.technicalNameCapitalized = subFlowDesign.getTechnicalNameCapitalized();
		model.isCustomized = subFlowDesign.getIsCustomized()==Boolean.TRUE;
		model.flowname = subFlowDesign.getOwner().getTechnicalName();
		return model;
	}
}
