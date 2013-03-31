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

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.CustomDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionInputDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.codegenerator.classmodel.ConstantValueModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel.Input;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.codegenerator.classmodel.StaticFieldValueModel;

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
			} else {
				// Obsolete:
				classModel.type = deduction.getMetadata().getEntity().getName();
				classModel.type = "org.instantlogic.fabric.deduction."+classModel.type.substring(0, classModel.type.length()-6); // leave Design suffix off
			}
			if (deduction instanceof SelectedInstanceDeductionDesign) {
				String name = ((SelectedInstanceDeductionDesign)deduction).getOfEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(new StaticFieldValueModel(rootPackageName+".entity."+name+"Entity","INSTANCE"));
			} else if (deduction instanceof AttributeDeductionDesign) {
				AttributeDesign attribute = ((AttributeDeductionDesign)deduction).getAttribute(); 
				String name = attribute.getJavaIdentifier();
				String entityName = (attribute instanceof RelationDesign)?((RelationDesign)attribute).getFrom().getTechnicalNameCapitalized():attribute.getBelongsToEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(new StaticFieldValueModel(rootPackageName+".entity."+entityName+"Entity",name));
			} else if (deduction instanceof ReverseRelationDeductionDesign) {
				RelationDesign relation = ((ReverseRelationDeductionDesign)deduction).getRelation(); 
				String name = relation.getJavaIdentifier();
				String entityName = relation.getFrom().getTechnicalNameCapitalized();
				classModel.parameters.add(new StaticFieldValueModel(rootPackageName+".entity."+entityName+"Entity",name));
			} else if (deduction instanceof CastInstanceDeductionDesign) {
				String name = ((CastInstanceDeductionDesign)deduction).getToEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(new StaticFieldValueModel(rootPackageName+".entity."+name+"Entity","INSTANCE"));
			} else if (deduction instanceof ConstantDeductionDesign) {
				classModel.parameters.add(new ConstantValueModel(((ConstantDeductionDesign)deduction).getValue()));
			} else if (deduction instanceof CustomDeductionDesign) {
				classModel.customization = ((CustomDeductionDesign) deduction).getImplementationClassName();
			}
			for (DeductionInputDesign input : deduction.getInputs()) {
				for (DeductionDesign inputDeduction: input.getInputs()) {
					Input inputModel = new DeductionModel.Input();
					inputModel.deductionIndex = deductionDesigns.indexOf(inputDeduction);
					inputModel.multivalue = true; //TODO
					inputModel.inputName = "Inputs"; // TODO
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
