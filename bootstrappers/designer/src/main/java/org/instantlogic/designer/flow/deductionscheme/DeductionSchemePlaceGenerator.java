package org.instantlogic.designer.flow.deductionscheme;

import org.instantlogic.designer.DeductionDesignEntityGenerator;
import org.instantlogic.designer.DeductionInputDesignEntityGenerator;
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
		DeductionSchemeDesign schemeOutput, selectDeductions, selectInputs, deductionId, selected, deductionXY, deductionWidth, deductionHeight, deductionOperation,
			deductionInputId, deductionOperationInput, selectOutputs, toDeductionInputId;
		FragmentTemplateDesign exploreButton, deductionScheme, deduction;

		setTitle(new TextTemplateDesign()
			.addToUntranslated(new StringTemplateDesign().setConstantText("DeductionScheme"))
		);
		
		setContent(new FragmentTemplateDesign("Page")
			.setChildren("mainContent",

				new FragmentTemplateDesign("Block")
					.addToStyleNames("card")
					.setChildren("content",
						createText("Heading3", new TextTemplateDesign()
							.addToUntranslated(new StringTemplateDesign().setConstantText("DeductionScheme"))
						),
						
						exploreButton = new FragmentTemplateDesign("Button").addToStyleNames("btn")
							.setChildren("content", new FragmentTemplateDesign("Icon").addToStyleNames("icon-wrench"))
							.setText("text", createConstantText("Data")),
						
						deductionScheme = new FragmentTemplateDesign("DeductionScheme")
							.setValue("output", schemeOutput = new DeductionSchemeDesign())
							.setChildren("deductions",
								new SelectionDesign().setSelection(selectDeductions = new DeductionSchemeDesign())
									.setChild(deduction = new FragmentTemplateDesign("Deduction")
										.setValue("deductionId", deductionId = new DeductionSchemeDesign())
										.setValue("selected", selected = new DeductionSchemeDesign())
										.setValue("xy", deductionXY = new DeductionSchemeDesign())
										.setValue("width", deductionWidth = new DeductionSchemeDesign())
										.setValue("height", deductionHeight = new DeductionSchemeDesign())
										.setText("operationName", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(deductionOperation = new DeductionSchemeDesign())))
										.setChildren("inputs", 
											new SelectionDesign().setSelection(selectInputs = new DeductionSchemeDesign())
												.setChild(new FragmentTemplateDesign("DeductionInput")
													.setValue("deductionInputId", deductionInputId = new DeductionSchemeDesign())
													.setText("operationInputName", new TextTemplateDesign().addToUntranslated(new StringTemplateDesign().setDeduction(deductionOperationInput = new DeductionSchemeDesign())))
												)
										)
										.setChildren("outputs",
											new SelectionDesign().setSelection(selectOutputs = new DeductionSchemeDesign())
												.setChild(new FragmentTemplateDesign("Output")
													.setValue("toDeductionInputId", toDeductionInputId = new DeductionSchemeDesign())
												)
										)
									)
							)
					)
			)
		);

		deductionScheme
			.setEntity(DeductionSchemeDesignEntityGenerator.ENTITY)
			.setAttribute(DeductionSchemeDesignEntityGenerator.selectedDeduction);

		deduction
			.setEntity(DeductionDesignEntityGenerator.ENTITY)
			.setAttribute(DeductionDesignEntityGenerator.diagramPosition);

		exploreButton.setEvent(DataEventGenerator.EVENT);
		
		schemeOutput.deduceId(schemeOutput.deduceRelation(DeductionSchemeDesignEntityGenerator.output));
		deductionId.deduceId(deductionId.deduceSelectedInstance(DeductionDesignEntityGenerator.ENTITY));
		selected.deduceHasValue(selected.deduceReverseRelation(DeductionSchemeDesignEntityGenerator.selectedDeduction, selected.deduceSelectedInstance(DeductionDesignEntityGenerator.ENTITY)));
		deductionXY.deduceAttribute(DeductionDesignEntityGenerator.diagramPosition);
		deductionWidth.deduceAttribute(DeductionDesignEntityGenerator.diagramWidth);
		deductionHeight.deduceAttribute(DeductionDesignEntityGenerator.diagramHeight);
		deductionOperation.deduceRelation(DeductionDesignEntityGenerator.operation);
		
		selectDeductions.deduceRelation(DeductionSchemeDesignEntityGenerator.deductions);
		selectInputs.deduceRelation(DeductionDesignEntityGenerator.inputs);
		
		deductionInputId.deduceId(deductionInputId.deduceSelectedInstance(DeductionInputDesignEntityGenerator.ENTITY));
		deductionOperationInput.deduceRelation(DeductionInputDesignEntityGenerator.operationInput);
		
		selectOutputs.deduceReverseRelation(DeductionInputDesignEntityGenerator.inputs, selectOutputs.deduceSelectedInstance(DeductionDesignEntityGenerator.ENTITY));
		toDeductionInputId.deduceId(toDeductionInputId.deduceSelectedInstance(DeductionInputDesignEntityGenerator.ENTITY));
	}
}

