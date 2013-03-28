/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;



public class DeductionSchemeDesign extends AbstractDeductionSchemeDesign {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static DeductionSchemeDesign constant(Object value) {
		return new DeductionSchemeDesign().deduceConstant((Class)value.getClass(), value).getScheme();
	}
	
	public DeductionDesign deduceSelectedInstance(EntityDesign entity) {
		SelectedInstanceDeductionDesign selectedInstanceDeductionDesign = new SelectedInstanceDeductionDesign();
		
		addToDeductions(selectedInstanceDeductionDesign);
		setOutput(selectedInstanceDeductionDesign);
		
		selectedInstanceDeductionDesign.setOfEntity(entity);
		return selectedInstanceDeductionDesign;
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute) {
		return deduceAttribute(attribute, null);
	}

	public DeductionDesign deduceAttribute(AttributeDesign attribute, DeductionDesign instanceDeduction) {
		if (instanceDeduction==null) {
			instanceDeduction = deduceSelectedInstance(attribute.getBelongsToEntity());
		}
		AttributeDeductionDesign attributeDeductionDesign = new AttributeDeductionDesign();
		
		addToDeductions(attributeDeductionDesign);
		setOutput(attributeDeductionDesign);
		
		DeductionInputDesign input = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.attributeInstance);
		
		attributeDeductionDesign.addToInputs(input);
		input.addToInputs(instanceDeduction);
		attributeDeductionDesign.setAttribute(attribute);
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
	
	public <V> DeductionDesign deduceConstant(Class<V> className, V value) {
		ConstantDeductionDesign constantDeductionDesign = new ConstantDeductionDesign();

		addToDeductions(constantDeductionDesign);
		setOutput(constantDeductionDesign);
		
		constantDeductionDesign.setValue(value);
		constantDeductionDesign.getConstantDataType().setJavaClassName(className.getName());
		return constantDeductionDesign;
	}
	
	public DeductionDesign deduceCustom(Class<?> deductionClass, Class<?> resultClass, DeductionDesign... inputs) {
		return deduceCustom(deductionClass.getName(), resultClass.getName(), inputs);
	}

	public DeductionDesign deduceCustom(String javaClassName, Class<?> resultClass, DeductionDesign... inputs) {
		return deduceCustom(javaClassName, resultClass.getName(), inputs);
	}

	public DeductionDesign deduceCustom(String javaClassName, String resultClassName, DeductionDesign... inputs) {
		CustomDeductionDesign result = new CustomDeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		for (DeductionDesign input: inputs) {
			DeductionInputDesign deductionInput = new DeductionInputDesign();
			result.addToInputs(deductionInput); // TODO: operationInput?
			deductionInput.addToInputs(input);
		}
		
		result.setImplementationClassName(javaClassName);
		result.getDataType().setJavaClassName(resultClassName);
		return result;
	}
	
	public DeductionDesign deduceHasValue(DeductionDesign input) {
		HasValueDeductionDesign result = new HasValueDeductionDesign();

		addToDeductions(result);
		setOutput(result);
		
		DeductionInputDesign deductionInput = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.hasValueInput);
		
		result.addToInputs(deductionInput);
		
		deductionInput.addToInputs(input);
		return result;
	}

	public DeductionDesign deduceAttributeHasValue(AttributeDesign attribute) {
		HasValueDeductionDesign result = new HasValueDeductionDesign();

		addToDeductions(result);
		DeductionDesign attributeDeduction = deduceAttribute(attribute);
		setOutput(result);
		
		DeductionInputDesign input = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.hasValueInput);
		
		result.addToInputs(input);
		
		input.addToInputs(attributeDeduction);
		return result;
	}
	
	public DeductionDesign deduceCastInstance(DeductionDesign input, EntityDesign to) {
		CastInstanceDeductionDesign result = new CastInstanceDeductionDesign();
		
		addToDeductions(result);
		setOutput(result);
		
		DeductionInputDesign deductionInput = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.castInstance);
		
		result.addToInputs(deductionInput);
		
		deductionInput.addToInputs(input);

		result.setToEntity(to);
		return result;
	}

	public DeductionDesign deduceEquals(DeductionDesign... inputs) {
		EqualsDeductionDesign result = new EqualsDeductionDesign();

		addToDeductions(result);
		setOutput(result);

		DeductionInputDesign deductionInput = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.equalsOperands);
		result.addToInputs(deductionInput);
		
		for (DeductionDesign input: inputs) {
			deductionInput.addToInputs(input);
		}
		
		return result;
	}
	
	public DeductionDesign deduceReverseRelation(RelationDesign relation, DeductionDesign instance) {
		ReverseRelationDeductionDesign result = new ReverseRelationDeductionDesign();
		
		addToDeductions(result);
		setOutput(result);

		DeductionInputDesign input = new DeductionInputDesign()
			.setOperationInput(DeductionOperationInputDesign.reverseRelationToInstance);
		
		result.addToInputs(input);
		input.addToInputs(instance);
		result.setRelation(relation);
		return result; 
	}
}
