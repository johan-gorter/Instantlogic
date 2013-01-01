package org.instantlogic.designer.codegenerator.generator;


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.CustomDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;
import org.instantlogic.designer.deduction.TechnicalNameDeduction;
import org.instantlogic.fabric.Instance;

public class DeductionSchemeGenerator {
	
	public static DeductionSchemeModel generate(String rootPackageName, DeductionSchemeDesign deductionSchemeDesign) {
		List<DeductionDesign> deductionDesigns = new ArrayList<DeductionDesign>();
		fillDeductions(deductionSchemeDesign.getOutput(), deductionDesigns);
		int deductionIndex = 0;
		DeductionSchemeModel model = new DeductionSchemeModel();
		for (DeductionDesign deduction : deductionDesigns) {
			DeductionModel classModel = new DeductionModel();
			classModel.index = deductionIndex++;
			classModel.type = deduction.getMetadata().getEntity().getName();
			classModel.type = "org.instantlogic.fabric.deduction."+classModel.type.substring(0, classModel.type.length()-6); // leave Design suffix off
			if (deduction.getDataType()==null || deduction.getDataType().getJavaClassName()==null) {
				throw new RuntimeException("Resulting classname was not specified for deduction "+deduction);
			}
			classModel.resultType = deduction.getDataType().getJavaClassName();
			if (deduction.getDataType().getMultivalue() == Boolean.TRUE) {
				classModel.resultType="org.instantlogic.fabric.value.Multi<"+classModel.resultType+">";
			}
			if (deduction instanceof SelectedInstanceDeductionDesign) {
				String name = ((SelectedInstanceDeductionDesign)deduction).getOfEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(rootPackageName+".entity."+name+"Entity.INSTANCE");
			} else if (deduction instanceof AttributeDeductionDesign) {
				AttributeDesign attribute = ((AttributeDeductionDesign)deduction).getAttribute(); 
				String name = attribute.getJavaIdentifier();
				String entityName = (attribute instanceof RelationDesign)?((RelationDesign)attribute).getFrom().getTechnicalNameCapitalized():attribute.getBelongsToEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(rootPackageName+".entity."+entityName+"Entity."+name);
			} else if (deduction instanceof ReverseRelationDeductionDesign) {
				RelationDesign relation = ((ReverseRelationDeductionDesign)deduction).getRelation(); 
				String name = relation.getJavaIdentifier();
				String entityName = relation.getFrom().getTechnicalNameCapitalized();
				classModel.parameters.add(rootPackageName+".entity."+entityName+"Entity."+name);
			} else if (deduction instanceof CastInstanceDeductionDesign) {
				String name = ((CastInstanceDeductionDesign)deduction).getToEntity().getTechnicalNameCapitalized();
				classModel.parameters.add(rootPackageName+".entity."+name+"Entity.INSTANCE");
			} else if (deduction instanceof ConstantDeductionDesign) {
				Object value = ((ConstantDeductionDesign)deduction).getValue();
				String valueAsText;
				if (value==null) {
					valueAsText = "null";
				} else if (value instanceof Instance) { // Must be a static instance
					valueAsText = ((Instance)value).getMetadata().getEntity().getInstanceClass().getName() + "."+TechnicalNameDeduction.makeTechnicalName(((Instance)value).getMetadata().getStaticName());
				} else if (String.class.getName().equals(deduction.getDataType().getJavaClassName())) {
					valueAsText="\""+value.toString()+"\"";
				} else {
					valueAsText = value.toString();
				}
				classModel.parameters.add(valueAsText);
			} else if (deduction instanceof CustomDeductionDesign) {
				classModel.customization = ((CustomDeductionDesign) deduction).getImplementationClassName();
			}
			for (DeductionDesign input : deduction.getInputs()) {
				classModel.parameters.add("d"+deductionDesigns.indexOf(input));
			}
			model.deductions.add(classModel);
		}
		return model;
	}

	private static void fillDeductions(DeductionDesign fromOutput, List<DeductionDesign> deductionDesigns) {
		if (deductionDesigns.contains(fromOutput)) return;
		for (DeductionDesign input: fromOutput.getInputs()) {
			fillDeductions(input, deductionDesigns);
		}
		if (deductionDesigns.contains(fromOutput)) return;
		deductionDesigns.add(fromOutput);
	}
}
