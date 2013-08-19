package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.TextModel;
import org.instantlogic.fabric.value.ValueList;

public abstract class TextGenerator extends AbstractGenerator {

	public static TextModel generate(TextTemplateDesign text, AbstractClassModel deductionSchemeHolder) {
		if (text==null) return null;
		TextModel model = new TextModel();
		ValueList<StringTemplateDesign> list = text.getUntranslated();
		for (StringTemplateDesign spInstance : list) {
			TextModel.StringTemplate result = new TextModel.StringTemplate();
			if (spInstance.getConstantText()!=null) {
				result.type = "constant";
				result.constant = spInstance.getConstantText();
			} else {
				result.type = "formattedValue";
				DeductionSchemeDesign scheme = spInstance.getDeduction();
				result.deductionIndex = deductionSchemeHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionSchemeHolder.rootPackageName, scheme));
			}
			model.untranslated.add(result);
		}
		return model;
	}
}
