/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class DeductionParameterDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionParameterDesign> {

	public static final DeductionParameterDesignEntity INSTANCE = new DeductionParameterDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.DeductionParameterDesign createInstance() {
		return new org.instantlogic.designer.DeductionParameterDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionParameterDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionParameterDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionParameterDesign";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object> value 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object, java.lang.Object>(
			"value", INSTANCE, java.lang.Object.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DeductionParameterDesign, java.lang.Object> get(org.instantlogic.designer.DeductionParameterDesign instance) {
				return instance.getValueAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign> attributeValue
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign, org.instantlogic.designer.AttributeDesign>(
			"attributeValue", INSTANCE, org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE, org.instantlogic.designer.AttributeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.AttributeDesign> get(
					org.instantlogic.designer.DeductionParameterDesign instance) {
				return instance.getAttributeValueRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> entityValue
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"entityValue", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.DeductionParameterDesign instance) {
				return instance.getEntityValueRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> operationParameter
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign>(
			"operationParameter", INSTANCE, org.instantlogic.designer.entity.DeductionOperationParameterDesignEntity.INSTANCE, org.instantlogic.designer.DeductionOperationParameterDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionOperationParameterDesign> get(
					org.instantlogic.designer.DeductionParameterDesign instance) {
				return instance.getOperationParameterRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.parameters
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionParameterDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionParameterDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		value,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		attributeValue,
		entityValue,
		operationParameter,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		deduction,
	};
	private static final org.instantlogic.fabric.model.Validation[] VALIDATIONS = new org.instantlogic.fabric.model.Validation[]{
	};
	

	@Override
	public org.instantlogic.fabric.model.Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public org.instantlogic.fabric.model.Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
	@Override
	public org.instantlogic.fabric.model.Validation[] getLocalValidations() {
		return VALIDATIONS;
	}
	
	@Override
	public java.util.Map<String, org.instantlogic.designer.DeductionParameterDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionParameterDesign.getStaticDeductionParameterDesignInstances();
	}
}
