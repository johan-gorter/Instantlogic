package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.deduction.CapitalizeFirstDeduction;
import org.instantlogic.designer.event.AddEntityEventGenerator;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.event.FlowDetailsEventGenerator;

public class WelcomePlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final WelcomePlaceTemplateGenerator PLACE = new WelcomePlaceTemplateGenerator();
	
	private WelcomePlaceTemplateGenerator() {
		setName("Welcome");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign applicationName, entitiesDeduction, flowsDeduction, entityName, flowName;
		FragmentTemplateDesign entityLink, flowLink, addEntityButton;
		
		setTitle(createConstantText("Welcome"));
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content", 
						createText("Heading3", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setDeduction(applicationName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" (Application)"))),
									
						createText("Paragraph", createConstantText("Welcome to the Designer")),
						
						new FragmentTemplateDesign("Table")
							.setChildren("columns", 
								new FragmentTemplateDesign("Column")
									.setText("header", createConstantText("Entities"))
							)
							.setChildren("rows",
								new SelectionDesign()
									.setSelection(entitiesDeduction = new DeductionSchemeDesign())
									.addToChildren(
										new FragmentTemplateDesign("Row")
											.setChildren("cells",
												new FragmentTemplateDesign("Cell")
													.setChildren("content",
														entityLink = new FragmentTemplateDesign("Link")
															.setText("text", 
																new TextTemplateDesign().addToUntranslated(
																	new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign())
																)
														)
													)
											)
									)
							),
							
							addEntityButton = new FragmentTemplateDesign("Button")
								.setText("text", createConstantText("Add entity")),
							
							new FragmentTemplateDesign("Table")
								.setChildren("columns", 
									new FragmentTemplateDesign("Column")
										.setText("header", createConstantText("Flows"))
								)
								.setChildren("rows",
									new SelectionDesign()
										.setSelection(flowsDeduction = new DeductionSchemeDesign())
										.addToChildren(
											new FragmentTemplateDesign("Row")
												.setChildren("cells",
													new FragmentTemplateDesign("Cell")
														.setChildren("content",
															flowLink = new FragmentTemplateDesign("Link")
																.setText("text", 
																	new TextTemplateDesign().addToUntranslated(
																		new StringTemplateDesign().setDeduction(flowName = new DeductionSchemeDesign())
																	)
															)
														)
												)
										)
								)
						)
		));

		applicationName.deduceCustom(CapitalizeFirstDeduction.class, String.class, applicationName.deduceAttribute(ApplicationDesignEntityGenerator.name));
		entitiesDeduction.deduceRelation(ApplicationDesignEntityGenerator.entities);
		flowsDeduction.deduceRelation(ApplicationDesignEntityGenerator.flows);
		entityName.deduceAttribute(DesignEntityGenerator.name);
		flowName.deduceAttribute(DesignEntityGenerator.name, flowName.deduceSelectedInstance(FlowDesignEntityGenerator.ENTITY));
		entityLink.setEvent(EntityDetailsEventGenerator.EVENT);
		addEntityButton.setEvent(AddEntityEventGenerator.EVENT);
		flowLink.setEvent(FlowDetailsEventGenerator.EVENT);
	}
}
