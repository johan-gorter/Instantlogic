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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeductionSchemeGenerator {

	private static final Logger logger = LoggerFactory.getLogger(DeductionSchemeGenerator.class);
	
	public static DeductionSchemeModel generate(String rootPackageName, DeductionSchemeDesign deductionSchemeDesign) {
		DeductionSchemeModel model = new DeductionSchemeModel();
		if (!deductionSchemeDesign.isValidForCodeGeneration()) {
			DeductionModel unknown = new DeductionModel();
			unknown.type = "org.instantlogic.fabric.deduction.InvalidDeduction";
			unknown.index = 0;
			model.deductions.add(unknown);
			return model;
		}
		List<DeductionDesign> deductionDesigns = new ArrayList<DeductionDesign>();
		fillDeductions(deductionSchemeDesign.getOutput(), deductionDesigns);
		Collections.reverse(deductionDesigns);
		int deductionIndex = 0;
		for (DeductionDesign deduction : deductionDesigns) {
			DeductionModel classModel = new DeductionModel();
			classModel.index = deductionIndex++;
			if (deduction.isValidForCodeGeneration()) {
				classModel.type = deduction.getOperation().getJavaClassName();
				for (DeductionParameterDesign parameter : deduction.getParameters()) {
					DeductionModel.Parameter parameterModel = new DeductionModel.Parameter();
					parameterModel.name = parameter.getOperationParameter().getTechnicalNameCapitalized();
					if (parameter.getEntityValue()!=null) {
						parameterModel.value = parameter.getEntityValue().asStaticFieldValue();
					} else if (parameter.getAttributeValue()!=null) {
						parameterModel.value = parameter.getAttributeValue().asStaticFieldValue();
					} else if (parameter.getStaticInstanceValue()!=null) {
						parameterModel.value = parameter.getStaticInstanceValue().asStaticFieldValue();
					} else {
						parameterModel.value = new ConstantValueModel(parameter.getValue());
					}
					parameterModel.valueClass = parameter.getOperationParameter().getValueClass();
					if (parameterModel.valueClass==null) {
						throw new RuntimeException("No value class specified for "+deduction.getOperation().getName()+", parameter "+parameter.getOperationParameter().getName());
					}
					classModel.parameters.add(parameterModel);
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
			}
			else {
				classModel.type = "org.instantlogic.fabric.deduction.InvalidDeduction";
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
