package org.instantlogic.designer;

public class DeductionDesign extends AbstractDeductionDesign {

	public DeductionInputDesign addInput(DeductionOperationInputDesign operationInput, DeductionDesign... inputs) {
		DeductionInputDesign result = new DeductionInputDesign();
		addToInputs(result);
		result.setOperationInput(operationInput);
		for (DeductionDesign input: inputs) {
			result.addToInputs(input);
		}
		return result;
	}
}
