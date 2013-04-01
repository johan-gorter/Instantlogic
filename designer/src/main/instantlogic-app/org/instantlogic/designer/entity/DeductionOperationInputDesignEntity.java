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
public class DeductionOperationInputDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationInputDesign> {

	public static final DeductionOperationInputDesignEntity INSTANCE = new DeductionOperationInputDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.DeductionOperationInputDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationInputDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationInputDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationInputDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionOperationInputDesign";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction createDeduction0() {
		  	org.instantlogic.fabric.deduction.ConstantDeduction d0 
		  	  = new org.instantlogic.fabric.deduction.ConstantDeduction(false);
		return d0;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean> multivalue 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean, java.lang.Boolean>(
			"multivalue", INSTANCE, java.lang.Boolean.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DeductionOperationInputDesign, java.lang.Boolean> get(org.instantlogic.designer.DeductionOperationInputDesign instance) {
				return instance.getMultivalueAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Boolean> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction0();
                }
                return defaultDeduction;
            }
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> dataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"dataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.DeductionOperationInputDesign instance) {
				return instance.getDataTypeRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign> operation
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationDesign>(
			"operation", INSTANCE, org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE, org.instantlogic.designer.DeductionOperationDesign.class, org.instantlogic.designer.entity.DeductionOperationDesignEntity.inputs
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionOperationInputDesign, org.instantlogic.designer.DeductionOperationDesign> get(
					org.instantlogic.designer.DeductionOperationInputDesign instance) {
				return instance.getOperationRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		multivalue,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		dataType,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		operation,
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationInputDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationInputDesign.getStaticDeductionOperationInputDesignInstances();
	}
}
