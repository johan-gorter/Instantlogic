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
import java.util.List;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel;
import org.instantlogic.designer.codegenerator.classmodel.ContentModel.Category;

public abstract class ContentGenerator extends AbstractGenerator {

	public static ContentModel generate(ElementDesign element, AbstractClassModel deductionHolder) {
		ContentModel model = new ContentModel();
		model.id=element.getMetadata().getUniqueId();
		model.rootPackageName = deductionHolder.rootPackageName;
		model.isCustomized = element.getIsCustomized() == Boolean.TRUE;
		if (element instanceof SharedElementDesign) {
			model.category = Category.Shared;
			model.name = ((SharedElementDesign) element).getDefinition().getName();
		} else if (element instanceof FragmentTemplateDesign) {
			FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) element;
			model.category = Category.Fragment;
			if (fragmentTemplate.getType()!=null) {
				model.fragmentTypeName = fragmentTemplate.getType().getName(); // Official way
			} else {
				model.fragmentTypeName= fragmentTemplate.getFragmentTypeName(); // Unofficial way				
			}
			for (PropertyDesign property:fragmentTemplate.getProperties()) {
				String propertyName = property.getPropertyName();
				if (propertyName==null) continue;
				if (property.getChildren().size()>0) {
					List<ContentModel> children = new ArrayList<ContentModel>();
					for (ElementDesign child : property.getChildren()) {
						children.add(generate(child, deductionHolder));
					}
					model.childLists.put(propertyName, children);
				} 
				if (property.getText()!=null) {
					model.texts.put(propertyName, TextGenerator.generate(property.getText(), deductionHolder));
				} 
				if (property.getValue()!=null) {
					int deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, property.getValue()));
					model.values.put(propertyName, deductionIndex);
				}
			}
			if (fragmentTemplate.getEvent()!=null) {
				model.event = fragmentTemplate.getEvent().getTechnicalNameCapitalized();
			}
			if (fragmentTemplate.getStyleNames().size()>0) {
				model.styleNames = fragmentTemplate.getStyleNames().asList().toArray(new String[fragmentTemplate.getStyleNames().size()]);
			}
			if (fragmentTemplate.getFragmentFilters().size()>0) {
				model.fragmentFilters = fragmentTemplate.getFragmentFilters().asList().toArray(new String[fragmentTemplate.getFragmentFilters().size()]);
			}
			if (fragmentTemplate.getAttribute()!=null) {
				model.entity = fragmentTemplate.getEntity().getTechnicalNameCapitalized();
				model.attribute = fragmentTemplate.getAttribute().getTechnicalName();
			}
		} else if (element instanceof SelectionDesign) {
			model.category = Category.Selection;
			SelectionDesign selection = (SelectionDesign) element;
			model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, selection.getSelection()));
			for (ElementDesign child: selection.getChildren()) {
				model.children.add(generate(child, deductionHolder));
			}
		} else if (element instanceof IfElseDesign) {
			model.category = Category.IfElse;
			IfElseDesign ifElse = (IfElseDesign) element;
			model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, ifElse.getCondition()));
			for (ElementDesign child: ifElse.getIfChildren()) {
				model.children.add(generate(child, deductionHolder));
			}
			for (ElementDesign child: ifElse.getElseChildren()) {
				model.elseChildren.add(generate(child, deductionHolder));
			}
		} else {
			throw new RuntimeException("What the");
		}
		return model;
	}
}
