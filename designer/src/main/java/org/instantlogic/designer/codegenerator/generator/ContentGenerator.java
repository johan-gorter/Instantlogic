package org.instantlogic.designer.codegenerator.generator;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.designer.RelationDesign;
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
			model.category = Category.Fragment;
			FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) element;
			if (!fragmentTemplate.isValidForCodegeneration()) {
				model.fragmentTypeName = "WorkInProgress";
			} else if (fragmentTemplate.getType()!=null) {
				model.fragmentTypeName = fragmentTemplate.getType().getName(); // Official way
			} else {
				model.fragmentTypeName = fragmentTemplate.getFragmentTypeName(); // Unofficial way				
			}
			for (PropertyDesign property:fragmentTemplate.getProperties()) {
				String propertyName = property.getPropertyName();
				if (propertyName==null) continue;
				if (property.getChildren().size()>0) {
					List<ContentModel> children = new ArrayList<ContentModel>();
					for (ElementDesign child : property.getChildren()) {
						ContentModel childElement = generate(child, deductionHolder);
						if (childElement!=null) {
							children.add(childElement);
						}
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
				model.styleNames = fragmentTemplate.getStyleNames().asCollection().toArray(new String[fragmentTemplate.getStyleNames().size()]);
				if (fragmentTemplate.getEditorOpen()) {
					String[] newStyleNames = new String[model.styleNames.length+1];
					System.arraycopy(model.styleNames, 0, newStyleNames, 0, model.styleNames.length);
					newStyleNames[newStyleNames.length-1]="designer-editor-open";
					model.styleNames = newStyleNames;
				}
			}
			else if (fragmentTemplate.getEditorOpen())
			{
				model.styleNames = new String[]{"designer-editor-open"}; 
			}
			if (fragmentTemplate.getFragmentFilters().size()>0) {
				model.fragmentFilters = fragmentTemplate.getFragmentFilters().asList().toArray(new String[fragmentTemplate.getFragmentFilters().size()]);
			}
			if (fragmentTemplate.getAttribute()!=null && fragmentTemplate.getAttribute().isValidForCodegeneration()) {
				model.entity = fragmentTemplate.getEntity().getTechnicalNameCapitalized();
				model.attribute = fragmentTemplate.getAttribute().getTechnicalName();
				model.attributeIsRelation = (fragmentTemplate.getAttribute() instanceof RelationDesign);
			}
		} else if (element instanceof SelectionDesign) {
			model.category = Category.Selection;
			SelectionDesign selection = (SelectionDesign) element;
			model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, selection.getSelection()));
			if (selection.getChild()!=null) {
				model.child = generate(selection.getChild(), deductionHolder);
			}
		} else if (element instanceof IfElseDesign) {
			model.category = Category.IfElse;
			IfElseDesign ifElse = (IfElseDesign) element;
			model.deductionIndex = deductionHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionHolder.rootPackageName, ifElse.getCondition()));
			if (ifElse.getIfChild()!=null) {
				model.child = generate(ifElse.getIfChild(), deductionHolder);
			}
			if (ifElse.getElseChild()!=null) {
				model.elseChild = generate(ifElse.getElseChild(), deductionHolder);
			}
		} else {
			throw new RuntimeException("What the");
		}
		return model;
	}
}
