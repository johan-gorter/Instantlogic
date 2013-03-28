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
public class DeductionInputDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionInputDesign> {

	public static final DeductionInputDesignEntity INSTANCE = new DeductionInputDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.DeductionInputDesign createInstance() {
		return new org.instantlogic.designer.DeductionInputDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionInputDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionInputDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionInputDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign> inputs
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionDesign>, org.instantlogic.designer.DeductionDesign>(
			"inputs", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, 
			org.instantlogic.designer.entity.DeductionDesignEntity.outputs
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionInputDesign instance) {
				return instance.getInputsRelationValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign> operationInput
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationInputDesign>(
			"operationInput", INSTANCE, org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE, org.instantlogic.designer.DeductionOperationInputDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionOperationInputDesign> get(
					org.instantlogic.designer.DeductionInputDesign instance) {
				return instance.getOperationInputRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign> deduction
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign, org.instantlogic.designer.DeductionDesign>(
			"deduction", INSTANCE, org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE, org.instantlogic.designer.DeductionDesign.class, org.instantlogic.designer.entity.DeductionDesignEntity.inputs
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionInputDesign, org.instantlogic.designer.DeductionDesign> get(
					org.instantlogic.designer.DeductionInputDesign instance) {
				return instance.getDeductionRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		inputs,
		operationInput,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionInputDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionInputDesign.getStaticDeductionInputDesignInstances();
	}
}
