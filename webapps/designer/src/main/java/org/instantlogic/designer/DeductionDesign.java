package org.instantlogic.designer;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeductionDesign extends AbstractDeductionDesign {

	private static final Logger logger = LoggerFactory
			.getLogger(DeductionDesign.class);
	private ValueChangeObserver operationChanged = new ValueChangeObserver() {

		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (event.isUndoEvent()) {
				return;
			}
			DeductionOperationDesign newOperation = getOperation();
			if (newOperation != null) {
				// Inputs
				List<DeductionInputDesign> inputRemovalCandidates = new ArrayList<>(getInputs().asCollection());
				for (DeductionOperationInputDesign operationInput : newOperation.getInputs()) {
					DeductionInputDesign existingInput = findInput(operationInput);
					if (existingInput != null) {
						// Make sure the operationInput matches
						existingInput.setOperationInput(operationInput);
						inputRemovalCandidates.remove(existingInput);
					} else {
						// Create a new input
						DeductionInputDesign newInput = new DeductionInputDesign();
						addToInputs(newInput);
						newInput.setOperationInput(operationInput);
						inputRemovalCandidates.remove(newInput);
					}
				}
				// Remove old inputs
				for (DeductionInputDesign removeInput : inputRemovalCandidates) {
					// Policy: Never throw away data without explicit
					// instruction from the user
					if (removeInput.getInputs().size() == 0) {
						removeFromInputs(removeInput);
					}
				}

				// Parameters
				List<DeductionParameterDesign> parameterRemovalCandidates = new ArrayList<>(getParameters().asCollection());
				for (DeductionOperationParameterDesign operationParameter : newOperation.getParameters()) {
					DeductionParameterDesign existingParameter = findParameter(operationParameter);
					if (existingParameter != null) {
						// Make sure the operationParameter matches
						existingParameter.setOperationParameter(operationParameter);
						parameterRemovalCandidates.remove(existingParameter);
					} else {
						// Create a new parameter
						DeductionParameterDesign newParameter = new DeductionParameterDesign();
						addToParameters(newParameter);
						newParameter.setOperationParameter(operationParameter);
						parameterRemovalCandidates.remove(newParameter);
					}
				}
				// Remove old parameters
				for (DeductionParameterDesign removeParameter : parameterRemovalCandidates) {
					// Policy: Never throw away data without explicit
					// instruction from the user
					if (removeParameter.getEntityValue() == null && removeParameter.getAttributeValue() == null && removeParameter.getValue() == null) {
						removeFromParameters(removeParameter);
					}
				}
			}
		}
	};

	public DeductionDesign() {
		// TODO: getOperationRelationValue().addValueChangeObserver(operationChanged);
	}

	protected DeductionParameterDesign findParameter(DeductionOperationParameterDesign operationParameter) {
		// Find exact match
		for (DeductionParameterDesign candidate : getParameters()) {
			if (candidate.getOperationParameter() == operationParameter) {
				return candidate;
			}
		}
		// Find with the same name
		for (DeductionParameterDesign candidate : getParameters()) {
			if (candidate.getOperationParameter() != null
					&& candidate.getOperationParameter().getName()
							.equals(operationParameter.getName())) {
				return candidate;
			}
		}
		return null;
	}

	protected DeductionInputDesign findInput(DeductionOperationInputDesign operationInput) {
		// Find exact match
		for (DeductionInputDesign candidate : getInputs()) {
			if (candidate.getOperationInput() == operationInput) {
				return candidate;
			}
		}
		// Find with the same name
		for (DeductionInputDesign candidate : getInputs()) {
			if (candidate.getOperationInput() != null
					&& candidate.getOperationInput().getName()
							.equals(operationInput.getName())) {
				return candidate;
			}
		}
		return null;
	}

	public DeductionInputDesign addInput(DeductionOperationInputDesign operationInput, DeductionDesign... inputs) {
		DeductionInputDesign result = new DeductionInputDesign();
		addToInputs(result);
		result.setOperationInput(operationInput);
		for (DeductionDesign input : inputs) {
			result.addToInputs(input);
		}
		return result;
	}

	public boolean isValidForCodeGeneration() {
		if (getOperation() != null) {
			for (DeductionParameterDesign parameter : getParameters()) {
				if (parameter.getOperationParameter() == null) {
					return false;
				}
			}
			return true;
		} else {
			logger.warn("Deduction without operation " + this);
		}
		return false;
	}
}
