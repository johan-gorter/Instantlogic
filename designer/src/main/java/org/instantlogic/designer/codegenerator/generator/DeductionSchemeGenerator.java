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


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionInputDesign;
import org.instantlogic.designer.DeductionParameterDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.codegenerator.classmodel.ConstantValueModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel.Input;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;

public class DeductionSchemeGenerator {
	
	public static DeductionSchemeModel generate(String rootPackageName, DeductionSchemeDesign deductionSchemeDesign) {
		List<DeductionDesign> deductionDesigns = new ArrayList<DeductionDesign>();
		fillDeductions(deductionSchemeDesign.getOutput(), deductionDesigns);
		Collections.reverse(deductionDesigns);
		int deductionIndex = 0;
		DeductionSchemeModel model = new DeductionSchemeModel();
		for (DeductionDesign deduction : deductionDesigns) {
			DeductionModel classModel = new DeductionModel();
			classModel.index = deductionIndex++;
			if (deduction.getOperation()!=null) {
				classModel.type = deduction.getOperation().getJavaClassName();
				for (DeductionParameterDesign parameter : deduction.getParameters()) {
					DeductionModel.Parameter parameterModel = new DeductionModel.Parameter();
					parameterModel.name = parameter.getOperationParameter().getTechnicalNameCapitalized();
					if (parameter.getEntityValue()!=null) {
						parameterModel.value = parameter.getEntityValue().asStaticFieldValue();
					} else if (parameter.getAttributeValue()!=null) {
						parameterModel.value = parameter.getAttributeValue().asStaticFieldValue();
					} else {
						parameterModel.value = new ConstantValueModel(parameter.getValue());
					}
					classModel.parameters.add(parameterModel);
				}
			}
			for (DeductionInputDesign input : deduction.getInputs()) {
				for (DeductionDesign inputDeduction: input.getInputs()) {
					Input inputModel = new DeductionModel.Input();
					inputModel.deductionIndex = deductionDesigns.indexOf(inputDeduction);
					inputModel.multivalue = input.getOperationInput().getMultivalue();
					inputModel.inputName = input.getOperationInput().getTechnicalNameCapitalized();
					classModel.inputs.add(inputModel);
				}
			}
			model.deductions.add(classModel);
		}
		return model;
	}

	private static void fillDeductions(DeductionDesign fromOutput, List<DeductionDesign> deductionDesigns) {
		if (deductionDesigns.contains(fromOutput)) return;
		for (DeductionInputDesign deductionInput: fromOutput.getInputs()) {
			for (DeductionDesign input:deductionInput.getInputs()) {
				fillDeductions(input, deductionDesigns);
			}
		}
		if (deductionDesigns.contains(fromOutput)) return;
		deductionDesigns.add(fromOutput);
	}
}
