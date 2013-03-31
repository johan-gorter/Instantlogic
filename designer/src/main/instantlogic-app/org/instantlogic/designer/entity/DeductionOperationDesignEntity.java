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
public class DeductionOperationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.DeductionOperationDesign> {

	public static final DeductionOperationDesignEntity INSTANCE = new DeductionOperationDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.DeductionOperationDesign createInstance() {
		return new org.instantlogic.designer.DeductionOperationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.DeductionOperationDesign> getInstanceClass() {
		return org.instantlogic.designer.DeductionOperationDesign.class;
	}
	
	@Override
	public String getName() {
		return "DeductionOperationDesign";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String> javaClassName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.DeductionOperationDesign, java.lang.String, java.lang.String>(
			"javaClassName", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.DeductionOperationDesign, java.lang.String> get(org.instantlogic.designer.DeductionOperationDesign instance) {
				return instance.getJavaClassNameAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign> inputs
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationInputDesign>, org.instantlogic.designer.DeductionOperationInputDesign>(
			"inputs", INSTANCE, org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.INSTANCE, org.instantlogic.designer.DeductionOperationInputDesign.class, 
			org.instantlogic.designer.entity.DeductionOperationInputDesignEntity.operation
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DeductionOperationInputDesign> get(
					org.instantlogic.designer.DeductionOperationDesign instance) {
				return instance.getInputsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign> outputDataType
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign, org.instantlogic.designer.DataTypeDesign>(
			"outputDataType", INSTANCE, org.instantlogic.designer.entity.DataTypeDesignEntity.INSTANCE, org.instantlogic.designer.DataTypeDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.DeductionOperationDesign, org.instantlogic.designer.DataTypeDesign> get(
					org.instantlogic.designer.DeductionOperationDesign instance) {
				return instance.getOutputDataTypeRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		javaClassName,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		inputs,
		outputDataType,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
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
	public java.util.Map<String, org.instantlogic.designer.DeductionOperationDesign> getStaticInstances() {
		return org.instantlogic.designer.DeductionOperationDesign.getStaticDeductionOperationDesignInstances();
	}
}
