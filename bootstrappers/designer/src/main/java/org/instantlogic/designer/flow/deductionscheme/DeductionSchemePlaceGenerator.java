package org.instantlogic.designer.flow.deductionscheme;

import org.instantlogic.designer.DeductionDesignEntityGenerator;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.DeductionSchemeDesignEntityGenerator;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.designer.event.DataEventGenerator;

public class DeductionSchemePlaceGenerator  extends PlaceTemplateDesign {

	public static final DeductionSchemePlaceGenerator PLACE = new DeductionSchemePlaceGenerator();

	private DeductionSchemePlaceGenerator() {
		setName("DeductionScheme");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign schemeOutput, selectDeductions, deductionId, deductionXY;
		//SharedElementDesign entityContext;
		FragmentTemplateDesign exploreButton;

		setTitle(new TextTemplateDesign()
//			.addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign()))
			.addToUntranslated(new StringTemplateDesign().setConstantText("DeductionScheme"))
		);
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent",

//				new SelectionDesign()
//					.setSelection(entity = new DeductionSchemeDesign())
//					.setChild(entityContext = new SharedElementDesign()),
				
				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading3", new TextTemplateDesign()
//							.addToUntranslated(new StringTemplateDesign().setDeduction(attributeName = new DeductionSchemeDesign()))
							.addToUntranslated(new StringTemplateDesign().setConstantText("DeductionScheme"))
						),
						
						exploreButton = new FragmentTemplateDesign("Button").addToStyleNames("btn")
							.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-wrench"))
							.setText("text", createConstantText("Data")),
						
						new FragmentTemplateDesign("DeductionScheme")
							.setValue("output", schemeOutput = new DeductionSchemeDesign())
							.setChildren("deductions",
								new SelectionDesign().setSelection(selectDeductions = new DeductionSchemeDesign())
									.setChild(new FragmentTemplateDesign("Deduction")
										.setValue("id", deductionId = new DeductionSchemeDesign())
										.setValue("xy", deductionXY = new DeductionSchemeDesign())
									)
							)
					)
			)
		);
		
		exploreButton.setEvent(DataEventGenerator.EVENT);
		
		schemeOutput.deduceId(schemeOutput.deduceRelation(DeductionSchemeDesignEntityGenerator.output));
		deductionId.deduceId(deductionId.deduceSelectedInstance(DeductionDesignEntityGenerator.ENTITY));
		deductionXY.deduceAttribute(DeductionDesignEntityGenerator.diagramPosition);
		selectDeductions.deduceRelation(DeductionSchemeDesignEntityGenerator.deductions);
	}
}

