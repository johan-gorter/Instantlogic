/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.sharedfragment;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;
import org.instantlogic.designer.FragmentTypeDesignEntityGenerator;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PropertyDesignEntityGenerator;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDefinitionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.CloseEditorEventGenerator;
import org.instantlogic.designer.event.NewAttributeForFragmentTemplateEventGenerator;
import org.instantlogic.designer.event.OpenEditorEventGenerator;

public class ElementEditorSharedElementGenerator extends SharedElementDefinitionDesign {

	public static final ElementEditorSharedElementGenerator DEFINITION = new ElementEditorSharedElementGenerator();
	
	private ElementEditorSharedElementGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToSharedElements(this);
		setName("ElementEditor");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign fragmentType, propertyName, editorOpen1, editorOpen2, hasAttribute, previewMode, entityHasValue;
		SelectionDesign asFragmentTemplate, selectProperties, selectPropertyChildren;
		FragmentTemplateDesign fragmentTypeInput, entityInput, attributeInput;
		FragmentTemplateDesign openEditorButton, closeEditorButton, newAttributeButton;
		SharedElementDesign recursiveElementEditor;
		
		setFragment(
			new FragmentTemplateDesign("Block").addToStyleNames("element")
				.setChildren("content",
					asFragmentTemplate = new SelectionDesign()
						.addToChildren( // Editor
							new IfElseDesign()
								.setCondition(editorOpen1 = new DeductionSchemeDesign())
								.addToIfChildren(
									new FragmentTemplateDesign("Block").addToStyleNames("editor")
										.setChildren("content", 
											fragmentTypeInput = new FragmentTemplateDesign("Input"),
											new IfElseDesign()
												.setCondition(hasAttribute = new DeductionSchemeDesign())
												.addToIfChildren(new FragmentTemplateDesign("Block")
													.setChildren("content",
														entityInput = new FragmentTemplateDesign("Input"),
														new IfElseDesign()
															.setCondition(entityHasValue = new DeductionSchemeDesign())
															.addToIfChildren(new FragmentTemplateDesign("Block")
																.setChildren("content",
																	attributeInput = new FragmentTemplateDesign("Input"),
																	newAttributeButton = new FragmentTemplateDesign("Button")
																		.setText("text", createConstantText("New attribute"))
																)
															)
													)
												)
										)
								)
						),
						new FragmentTemplateDesign("Block").addToStyleNames("collapsable-content")
							.setChildren("content",
								new FragmentTemplateDesign("Link").addToStyleNames("collapse-button")
									.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-chevron-down")),
								new FragmentTemplateDesign("PreviewLine")
									.setValue("previewMode", previewMode = new DeductionSchemeDesign())
									.setChildren("content", 
										new FragmentTemplateDesign("Strong")
											.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(fragmentType = new DeductionSchemeDesign()))),
										// TODO: put all other info on this line
										new IfElseDesign()
											.setCondition(editorOpen2 = new DeductionSchemeDesign())
											.addToIfChildren(
												closeEditorButton = new FragmentTemplateDesign("Link").setText("text", createConstantText("Close editor")).addToStyleNames("editor-toggle")
											)
											.addToElseChildren(
												openEditorButton = new FragmentTemplateDesign("Link").setText("text", createConstantText("Edit")).addToStyleNames("editor-toggle")
											),
										new FragmentTemplateDesign("Preview") // Floats right
											.setChildren("content",
												new FragmentTemplateDesign("PreviewPlaceholder").addToFragmentFilters("org.instantlogic.designer.fragmentfilter.PreviewFragmentFilter")
											)
									),
								selectProperties = new SelectionDesign()
//											.addToChildren(
//												new FragmentTemplateDesign("Paragraph").setText("text", new TextTemplateDesign()
//													.addToUntranslated(new StringTemplateDesign().setDeduction(propertyName = new DeductionSchemeDesign()))
//												)
//											)
										.addToChildren(
											selectPropertyChildren = new SelectionDesign()
												.addToChildren(recursiveElementEditor = new SharedElementDesign()) // .element's
										)
							)
				)
		);
		
		asFragmentTemplate.newSelection()
			.deduceCastInstance(asFragmentTemplate.getSelection()
				.deduceSelectedInstance(ElementDesignEntityGenerator.ENTITY), FragmentTemplateDesignEntityGenerator.ENTITY);
		editorOpen1.deduceAttribute(ElementDesignEntityGenerator.editorOpen);
		editorOpen2.deduceAttribute(ElementDesignEntityGenerator.editorOpen);
		previewMode.deduceAttribute(ElementDesignEntityGenerator.previewMode);

		fragmentTypeInput.setEntity(FragmentTemplateDesignEntityGenerator.ENTITY).setAttribute(FragmentTemplateDesignEntityGenerator.type);
		hasAttribute.deduceAttribute(FragmentTypeDesignEntityGenerator.hasAttribute, hasAttribute.deduceRelation(FragmentTemplateDesignEntityGenerator.type));
		entityInput.setEntity(FragmentTemplateDesignEntityGenerator.ENTITY).setAttribute(FragmentTemplateDesignEntityGenerator.entity);
		entityHasValue.deduceHasValue(entityHasValue.deduceAttribute(FragmentTemplateDesignEntityGenerator.entity));
		attributeInput.setEntity(FragmentTemplateDesignEntityGenerator.ENTITY).setAttribute(FragmentTemplateDesignEntityGenerator.attribute);
		newAttributeButton.setEvent(NewAttributeForFragmentTemplateEventGenerator.EVENT);
		
		closeEditorButton.setEvent(CloseEditorEventGenerator.EVENT);
		openEditorButton.setEvent(OpenEditorEventGenerator.EVENT);
		
		fragmentType.deduceAttribute(DesignEntityGenerator.name, fragmentType.deduceRelation(FragmentTemplateDesignEntityGenerator.type));
		selectProperties.newSelection().deduceAttribute(FragmentTemplateDesignEntityGenerator.properties);
//		propertyName.deduceAttribute(PropertyDesignEntityGenerator.propertyName);
		selectPropertyChildren.newSelection().deduceRelation(PropertyDesignEntityGenerator.children);
		
		recursiveElementEditor.setDefinition(DEFINITION);
	}
}
