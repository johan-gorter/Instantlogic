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
public class CastInstanceDeductionDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.CastInstanceDeductionDesign> {

	public static final CastInstanceDeductionDesignEntity INSTANCE = new CastInstanceDeductionDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.DeductionDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.CastInstanceDeductionDesign createInstance() {
		return new org.instantlogic.designer.CastInstanceDeductionDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.CastInstanceDeductionDesign> getInstanceClass() {
		return org.instantlogic.designer.CastInstanceDeductionDesign.class;
	}
	
	@Override
	public String getName() {
		return "CastInstanceDeductionDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.CastInstanceDeductionDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> toEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.CastInstanceDeductionDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"toEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.CastInstanceDeductionDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.CastInstanceDeductionDesign instance) {
				return instance.getToEntityRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		toEntity,
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
	public java.util.Map<String, org.instantlogic.designer.CastInstanceDeductionDesign> getStaticInstances() {
		return org.instantlogic.designer.CastInstanceDeductionDesign.getStaticCastInstanceDeductionDesignInstances();
	}
}
