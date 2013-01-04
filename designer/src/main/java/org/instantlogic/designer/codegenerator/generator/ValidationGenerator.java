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
