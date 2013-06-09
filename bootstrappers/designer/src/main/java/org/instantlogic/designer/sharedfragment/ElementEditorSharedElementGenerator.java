

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
import org.instantlogic.designer.event.InsertFragmentTemplateBelowEventGenerator;
import org.instantlogic.designer.event.NewAttributeForFragmentTemplateEventGenerator;
import org.instantlogic.designer.event.OpenEditorEventGenerator;
import org.instantlogic.designer.event.RemoveFragmentTemplateEventGenerator;

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
		FragmentTemplateDesign openEditorLink, closeEditorLink, newAttributeButton, insertBelowButton, removeButton;
		SharedElementDesign recursiveElementEditor;
		
		setFragment(
			new FragmentTemplateDesign("Block").addToStyleNames("element")
				.setChildren("content",
					asFragmentTemplate = new SelectionDesign()
						.setChild( // Editor
							new IfElseDesign()
								.setCondition(editorOpen1 = new DeductionSchemeDesign())
								.setIfChild(
									new FragmentTemplateDesign("Block")
										.setChildren("content", // necessary for animation
											new FragmentTemplateDesign("Block").addToStyleNames("editor").addToStyleNames("popover").addToStyleNames("top")
												.setChildren("content", 
													new FragmentTemplateDesign("Block").addToStyleNames("arrow"),
													fragmentTypeInput = new FragmentTemplateDesign("Input"),
													new IfElseDesign()
														.setCondition(hasAttribute = new DeductionSchemeDesign())
														.setIfChild(new FragmentTemplateDesign("Block")
															.setChildren("content",
																entityInput = new FragmentTemplateDesign("Input"),
																new IfElseDesign()
																	.setCondition(entityHasValue = new DeductionSchemeDesign())
																	.setIfChild(new FragmentTemplateDesign("Block")
																		.setChildren("content",
																			attributeInput = new FragmentTemplateDesign("Input"),
																			newAttributeButton = new FragmentTemplateDesign("Button")
																				.setText("text", createConstantText("New attribute"))
																				.addToStyleNames("after-previous-field")
																		)
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
										new FragmentTemplateDesign("Block").addToStyleNames("btn-group").addToStyleNames("element-edit-options")
											.setChildren("content", 
												new IfElseDesign()
													.setCondition(editorOpen2 = new DeductionSchemeDesign())
													.setIfChild(
														closeEditorLink = new FragmentTemplateDesign("Button").addToStyleNames("btn-small").addToStyleNames("active")
															.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-pencil"))
													)
													.setElseChild(
														openEditorLink = new FragmentTemplateDesign("Button").addToStyleNames("btn-small")
															.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-pencil"))
													),
												insertBelowButton = new FragmentTemplateDesign("Button").addToStyleNames("btn-small").addToStyleNames("btn-success")
													.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-hand-down")),
												removeButton = new FragmentTemplateDesign("Button").addToStyleNames("btn-small").addToStyleNames("btn-danger")
													.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-remove"))
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
										.setChild(
											selectPropertyChildren = new SelectionDesign()
												.setChild(recursiveElementEditor = new SharedElementDesign()) // .element's
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
		
		closeEditorLink.setEvent(CloseEditorEventGenerator.EVENT);
		openEditorLink.setEvent(OpenEditorEventGenerator.EVENT);
		insertBelowButton.setEvent(InsertFragmentTemplateBelowEventGenerator.EVENT);
		removeButton.setEvent(RemoveFragmentTemplateEventGenerator.EVENT);
		
		fragmentType.deduceAttribute(DesignEntityGenerator.name, fragmentType.deduceRelation(FragmentTemplateDesignEntityGenerator.type));
		selectProperties.newSelection()
			.deduceAttribute(FragmentTemplateDesignEntityGenerator.properties, selectProperties.getSelection()
				.deduceCastInstance(selectProperties.getSelection()
					.deduceSelectedInstance(ElementDesignEntityGenerator.ENTITY), FragmentTemplateDesignEntityGenerator.ENTITY
				)
			);
//		propertyName.deduceAttribute(PropertyDesignEntityGenerator.propertyName);
		selectPropertyChildren.newSelection().deduceRelation(PropertyDesignEntityGenerator.children);
		
		recursiveElementEditor.setDefinition(DEFINITION);
	}
}
