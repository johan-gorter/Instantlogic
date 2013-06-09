package org.instantlogic.designer.flow.entity;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
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
		
		
		entityName.deduceCustom(DesignerApplicationGenerator.CapitalizeFirstDeduction, 
			DesignerApplicationGenerator.CapitalizeFirstDeductionInput, entityName.deduceAttribute(DesignEntityGenerator.name));
		
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
							.setChild(
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
		
		entityName.deduceCustom(DesignerApplicationGenerator.CapitalizeFirstDeduction, 
			DesignerApplicationGenerator.CapitalizeFirstDeductionInput, entityName.deduceAttribute(DesignEntityGenerator.name));
		attributes.deduceAttribute(EntityDesignEntityGenerator.attributes);
		attributeName.deduceAttribute(DesignEntityGenerator.name, attributeName.deduceSelectedInstance(AttributeDesignEntityGenerator.ENTITY));
		attributeLink.setEvent(AttributeDetailsEventGenerator.EVENT);
		nameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
		addAttributeButton.setEvent(AddAttributeEventGenerator.EVENT);
	}
}
