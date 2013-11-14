package org.instantlogic.designer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeductionDesign extends AbstractDeductionDesign {

	private static final Logger logger = LoggerFactory.getLogger(DeductionDesign.class);
	
	public DeductionInputDesign addInput(DeductionOperationInputDesign operationInput, DeductionDesign... inputs) {
		DeductionInputDesign result = new DeductionInputDesign();
		addToInputs(result);
		result.setOperationInput(operationInput);
		for (DeductionDesign input: inputs) {
			result.addToInputs(input);
		}
		return result;
	}

	public boolean isValidForCodeGeneration() {
		if (getOperation()!=null) {
			for(DeductionParameterDesign parameter : getParameters()) {
				if (parameter.getOperationParameter()==null) {
					return false;
				}
			}
			return true;
		} else {
			logger.warn("Deduction without operation "+this);
		}
		return false;
	}
}
