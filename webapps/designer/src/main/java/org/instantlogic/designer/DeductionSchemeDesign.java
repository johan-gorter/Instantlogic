package org.instantlogic.designer;



public class DeductionSchemeDesign extends AbstractDeductionSchemeDesign {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static DeductionSchemeDesign constant(Object value) {
		return new DeductionSchemeDesign().deduceConstant((Class)value.getClass(), value).getScheme();
	}
	
	public DeductionDesign deduceSelectedInstance(EntityDesign entity) {
		DeductionDesign deductionDesign = new DeductionDesign();
		addToDeductions(deductionDesign);
		setOutput(deductionDesign);
		deductionDesign.setOperation(DeductionOperationDesign.selectedInstance);
		
		DeductionParameterDesign parameter = new DeductionParameterDesign().setOperationParameter(DeductionOperationParameterDesign.selectedInstanceEntity);
		deductionDesign.addToParameters(parameter);
		parameter.setEntityValue(entity);
		
		return deductionDesign;
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute) {
		return deduceAttribute(attribute, null);
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute, DeductionDesign instanceDeduction) {
		if (instanceDeduction==null) {
			instanceDeduction = deduceSelectedInstance(attribute.getBelongsToEntity());
		}
		DeductionDesign attributeDeductionDesign = new DeductionDesign();
		
		addToDeductions(attributeDeductionDesign);
		setOutput(attributeDeductionDesign);
		
		attributeDeductionDesign.setOperation(DeductionOperationDesign.attribute);
		DeductionInputDesign input = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.attributeInstance);
		
		attributeDeductionDesign.addToInputs(input);
		input.addToInputs(instanceDeduction);

		DeductionParameterDesign parameter = new DeductionParameterDesign().setOperationParameter(DeductionOperationParameterDesign.attribute);
		attributeDeductionDesign.addToParameters(parameter);
		parameter.setAttributeValue(attribute);

		return attributeDeductionDesign;
	}

	public DeductionDesign deduceRelation(RelationDesign relation, DeductionDesign instance) {
		if (instance==null) {
			instance = deduceSelectedInstance(relation.getFrom());
		}
		return deduceAttribute(relation, instance);
	}

	public DeductionDesign deduceRelation(RelationDesign relation) {
		return deduceRelation(relation, null);
	}
	
	public <V> DeductionDesign deduceStaticInstance(StaticInstanceDesign staticInstance) {
		DeductionDesign deductionDesign = new DeductionDesign();

		addToDeductions(deductionDesign);
		setOutput(deductionDesign);
		
		deductionDesign.setOperation(DeductionOperationDesign.constant);

		DeductionParameterDesign parameter = new DeductionParameterDesign().setOperationParameter(DeductionOperationParameterDesign.constantValue);
		deductionDesign.addToParameters(parameter);
		parameter.setStaticInstanceValue(staticInstance);
		
		return deductionDesign;
	}
	
	public <V> DeductionDesign deduceConstant(Class<V> className, V value) {
		DeductionDesign deductionDesign = new DeductionDesign();

		addToDeductions(deductionDesign);
		setOutput(deductionDesign);
		
		deductionDesign.setOperation(DeductionOperationDesign.constant);

		DeductionParameterDesign parameter = new DeductionParameterDesign().setOperationParameter(DeductionOperationParameterDesign.constantValue);
		deductionDesign.addToParameters(parameter);
		parameter.setValue(value);
		
		return deductionDesign;
	}
	
	public DeductionDesign deduceCustom(DeductionOperationDesign operation) {
		DeductionDesign result = new DeductionDesign();
		addToDeductions(result);
		setOutput(result);
		result.setOperation(operation);
		return result;
	}
	
	// With only 1 input
	public DeductionDesign deduceCustom(DeductionOperationDesign operation, DeductionOperationInputDesign input1, DeductionDesign input1InputDeduction) {
		DeductionDesign result = deduceCustom(operation);
		DeductionInputDesign input1Input = new DeductionInputDesign();
		result.addToInputs(input1Input);
		input1Input.setOperationInput(input1);
		input1Input.addToInputs(input1InputDeduction);
		return result;
	}
	
	public DeductionDesign deduceHasValue(DeductionDesign input) {
		return deduceCustom(DeductionOperationDesign.hasValue, DeductionOperationInputDesign.hasValueInput, input);
		
//		HasValueDeductionDesign result = new HasValueDeductionDesign();
//
//		addToDeductions(result);
//		setOutput(result);
//		
//		DeductionInputDesign deductionInput = new DeductionInputDesign()
//			.setOperationInput(DeductionOperationInputDesign.hasValueInput);
//		
//		result.addToInputs(deductionInput);
//		
//		deductionInput.addToInputs(input);
//		return result;
	}
	
	public DeductionDesign deduceId(DeductionDesign instance) {
		return deduceCustom(DeductionOperationDesign.id, DeductionOperationInputDesign.idOfInstance, instance);
	}

	public DeductionDesign deduceAttributeHasValue(AttributeDesign attribute) {
//		DeductionDesign result = new DeductionDesign();
//
//		addToDeductions(result);
		DeductionDesign attributeDeduction = deduceAttribute(attribute);
		return deduceHasValue(attributeDeduction);
//		setOutput(result);
//		
//		DeductionInputDesign input = new DeductionInputDesign()
//			.setOperationInput(DeductionOperationInputDesign.hasValueInput);
//		
//		result.addToInputs(input);
//		
//		input.addToInputs(attributeDeduction);
//		return result;
	}
	
	public DeductionDesign deduceCastInstance(DeductionDesign input, EntityDesign to) {
		DeductionDesign result = new DeductionDesign();
		
		addToDeductions(result);
		setOutput(result);
		
		result.setOperation(DeductionOperationDesign.cast);
		DeductionInputDesign deductionInput = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.castInstance);
		
		result.addToInputs(deductionInput);
		
		deductionInput.addToInputs(input);

		DeductionParameterDesign parameter = new DeductionParameterDesign();
		result.addToParameters(parameter);
		parameter.setEntityValue(to);
		parameter.setOperationParameter(DeductionOperationParameterDesign.castToEntity);
		
		return result;
	}

	public DeductionDesign deduceEquals(DeductionDesign... inputs) {
		DeductionDesign result = new DeductionDesign();

		addToDeductions(result);
		setOutput(result);

		result.setOperation(DeductionOperationDesign.equals);
		DeductionInputDesign deductionInput = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.equalsOperands);
		result.addToInputs(deductionInput);
		
		for (DeductionDesign input: inputs) {
			deductionInput.addToInputs(input);
		}
		
		return result;
	}
	
	public DeductionDesign deduceReverseRelation(RelationDesign relation, DeductionDesign instance) {
		DeductionDesign result = new DeductionDesign();
		
		addToDeductions(result);
		setOutput(result);

		result.setOperation(DeductionOperationDesign.reverseRelation);
		DeductionInputDesign input = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.reverseRelationToInstance);
		
		result.addToInputs(input);
		input.addToInputs(instance);
		
		DeductionParameterDesign parameter = new DeductionParameterDesign();
		result.addToParameters(parameter);
		parameter.setOperationParameter(DeductionOperationParameterDesign.reverseRelationRelation);
		parameter.setAttributeValue(relation);
		return result; 
	}

	public boolean isValidForCodeGeneration() {
		return getOutput()!=null;
	}
}
