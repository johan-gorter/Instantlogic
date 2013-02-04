/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow.entity;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.deduction.CapitalizeFirstDeduction;
import org.instantlogic.designer.event.AddAttributeEventGenerator;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.sharedfragment.ApplicationContextSharedElementGenerator;

public class EntityDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final EntityDetailsPlaceGenerator PLACE = new EntityDetailsPlaceGenerator();

	private EntityDetailsPlaceGenerator() {
		setName("EntityDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign entityName, attributes, attributeName;
		FragmentTemplateDesign nameInput, attributeLink, addAttributeButton;
		SharedElementDesign applicationContext;
		
		setTitle(new TextTemplateDesign()
					.addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign()))
					.addToUntranslated(new StringTemplateDesign().setConstantText(" (Entity)"))
		);
		
		entityName.deduceCustom(CapitalizeFirstDeduction.class, String.class, entityName.deduceAttribute(DesignEntityGenerator.name));
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				
				applicationContext = new SharedElementDesign(),	
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading3", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setDeduction(entityName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" (Entity)"))
						),
						
						nameInput = new FragmentTemplateDesign("Input"),
						
						createText("Heading4",
							new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setConstantText("Attributes"))
						),
						
						new SelectionDesign()
							.setSelection(attributes = new DeductionSchemeDesign())
							.addToChildren(
								attributeLink = new FragmentTemplateDesign("Link")
									.setChildren("content", 
										new FragmentTemplateDesign("Block")
											.setChildren("content",
												new FragmentTemplateDesign("Strong")
													.setText("text", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign())))
											)
									)
							),
						
						addAttributeButton = new FragmentTemplateDesign("Button").setText("text", createConstantText("Add attribute"))
					)
			)
		);
		
		applicationContext.setDefinition(ApplicationContextSharedElementGenerator.DEFINITION);
		
		entityName.deduceCustom(CapitalizeFirstDeduction.class, String.class, entityName.deduceAttribute(DesignEntityGenerator.name));
		attributes.deduceAttribute(EntityDesignEntityGenerator.attributes);
		attributeName.deduceAttribute(DesignEntityGenerator.name, attributeName.deduceSelectedInstance(AttributeDesignEntityGenerator.ENTITY));
		attributeLink.setEvent(AttributeDetailsEventGenerator.EVENT);
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
		addAttributeButton.setEvent(AddAttributeEventGenerator.EVENT);
	}
}
