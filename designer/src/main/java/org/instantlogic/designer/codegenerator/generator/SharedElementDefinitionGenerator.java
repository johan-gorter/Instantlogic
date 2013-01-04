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
		model.rootPackageName = context.rootPackageName;
		model.content = ContentGenerator.generate(definition.getFragment(), model);
		
		this.observations = new ObservationsOutdatedObserver(caseAdministration.stopRecordingObservations(), null);
		context.updatedSharedPageFragments.add(model);
	}

	@Override
	public void delete(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = initModel(context);
		context.deletedSharedPageFragments.add(model);
	}

	private SharedPageFragmentClassModel initModel(GeneratedClassModels context) {
		SharedPageFragmentClassModel model = new SharedPageFragmentClassModel();
		model.rootPackageName = context.rootPackageName;
		model.name = definition.getName();
		model.technicalNameCapitalized = definition.getTechnicalNameCapitalized();
		model.isCustomized = definition.getIsCustomized()==Boolean.TRUE;
		return model;
	}
}
