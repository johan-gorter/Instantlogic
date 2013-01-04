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


import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.TextModel;
import org.instantlogic.fabric.value.Multi;

public abstract class TextGenerator extends AbstractGenerator {

	public static TextModel generate(TextTemplateDesign text, AbstractClassModel deductionSchemeHolder) {
		if (text==null) return null;
		TextModel model = new TextModel();
		Multi<StringTemplateDesign> list = text.getUntranslated();
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
