/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow.main;

import org.instantlogic.designer.ApplicationDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
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
									.setChild(
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
										.setChild(
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

		applicationName.deduceCustom(DesignerApplicationGenerator.CapitalizeFirstDeduction, 
			DesignerApplicationGenerator.CapitalizeFirstDeductionInput, applicationName.deduceAttribute(ApplicationDesignEntityGenerator.name));
		
		entitiesDeduction.deduceRelation(ApplicationDesignEntityGenerator.entities);
		flowsDeduction.deduceRelation(ApplicationDesignEntityGenerator.flows);
		entityName.deduceAttribute(DesignEntityGenerator.name);
		flowName.deduceAttribute(DesignEntityGenerator.name, flowName.deduceSelectedInstance(FlowDesignEntityGenerator.ENTITY));
		entityLink.setEvent(EntityDetailsEventGenerator.EVENT);
		addEntityButton.setEvent(AddEntityEventGenerator.EVENT);
		flowLink.setEvent(FlowDetailsEventGenerator.EVENT);
	}
}
