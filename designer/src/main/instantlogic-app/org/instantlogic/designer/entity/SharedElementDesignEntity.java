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
public class SharedElementDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.SharedElementDesign> {

	public static final SharedElementDesignEntity INSTANCE = new SharedElementDesignEntity();
	
	@Override
	public org.instantlogic.fabric.model.Entity extendsEntity() {
		return org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE;
	}

	
	@Override
	public org.instantlogic.designer.SharedElementDesign createInstance() {
		return new org.instantlogic.designer.SharedElementDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.SharedElementDesign> getInstanceClass() {
		return org.instantlogic.designer.SharedElementDesign.class;
	}
	
	@Override
	public String getName() {
		return "SharedElementDesign";
	}

	// Deductions

	
	// Attributes
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign> definition
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign, org.instantlogic.designer.SharedElementDefinitionDesign>(
			"definition", INSTANCE, org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedElementDefinitionDesign.class, 
			org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.usages
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.SharedElementDesign, org.instantlogic.designer.SharedElementDefinitionDesign> get(
					org.instantlogic.designer.SharedElementDesign instance) {
				return instance.getDefinitionRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		definition,
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
	public java.util.Map<String, org.instantlogic.designer.SharedElementDesign> getStaticInstances() {
		return org.instantlogic.designer.SharedElementDesign.getStaticSharedElementDesignInstances();
	}
}
