package org.instantlogic.designer.flow.placetemplate;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DesignEntityGenerator;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.FlowNodeBaseDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesignEntityGenerator;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.SharedElementDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.sharedfragment.ElementEditorSharedElementGenerator;
import org.instantlogic.designer.sharedfragment.FlowContextSharedElementGenerator;

public class PlaceTemplateDetailsPlaceGenerator extends PlaceTemplateDesign {

	public static final PlaceTemplateDetailsPlaceGenerator PLACE = new PlaceTemplateDetailsPlaceGenerator();

	private PlaceTemplateDetailsPlaceGenerator() {
		setName("PlaceTemplateDetails");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign placeName, flow;
		FragmentTemplateDesign placeNameInput;
		SharedElementDesign flowContext, elementEditor;
		SelectionDesign selectContent;

		setTitle(new TextTemplateDesign()
			.addToUntranslated(new StringTemplateDesign().setDeduction(placeName = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText(" (Place)"))
		);
		
		placeName.deduceAttribute(DesignEntityGenerator.name);
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent", 
				new SelectionDesign()
					.setSelection(flow = new DeductionSchemeDesign())
					.setChild(flowContext = new SharedElementDesign()),
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading3", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setDeduction(placeName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText(" (Place template)"))
						),
					
						placeNameInput = new FragmentTemplateDesign("Input"),
						
						new FragmentTemplateDesign("Heading4").setText("text", createConstantText("Content")),
						selectContent = new SelectionDesign()
							.setChild(
								new FragmentTemplateDesign("ElementEditor")
									.setChildren("content", 
											elementEditor = new SharedElementDesign()
									)
							)
					)
				)
		);
		
		flow.deduceReverseRelation(FlowDesignEntityGenerator.nodes, flow.deduceSelectedInstance(FlowNodeBaseDesignEntityGenerator.ENTITY));
		flowContext.setDefinition(FlowContextSharedElementGenerator.DEFINITION);
		placeName.deduceAttribute(DesignEntityGenerator.name);
		
		placeNameInput.setEntity(DesignEntityGenerator.ENTITY).setAttribute(DesignEntityGenerator.name);
		
		selectContent.newSelection().deduceAttribute(PlaceTemplateDesignEntityGenerator.content);
		elementEditor.setDefinition(ElementEditorSharedElementGenerator.DEFINITION);
	}
}
