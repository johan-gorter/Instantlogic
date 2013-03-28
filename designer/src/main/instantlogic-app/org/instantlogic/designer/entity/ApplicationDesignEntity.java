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
public class ApplicationDesignEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.designer.ApplicationDesign> {

	public static final ApplicationDesignEntity INSTANCE = new ApplicationDesignEntity();
	

	
	@Override
	public org.instantlogic.designer.ApplicationDesign createInstance() {
		return new org.instantlogic.designer.ApplicationDesign();
	}
	
	@Override
	public Class<org.instantlogic.designer.ApplicationDesign> getInstanceClass() {
		return org.instantlogic.designer.ApplicationDesign.class;
	}
	
	@Override
	public String getName() {
		return "ApplicationDesign";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean> isCustomized 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean, java.lang.Boolean>(
			"isCustomized", INSTANCE, java.lang.Boolean.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.Boolean> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getIsCustomizedAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> name 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"name", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getNameAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> rootPackageName 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"rootPackageName", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getRootPackageNameAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String> sourcePath 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, java.lang.String, java.lang.String>(
			"sourcePath", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSourcePathAttributeValue();
			}
            
		};
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String> themeNames 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<java.lang.String>, java.lang.String>(
			"themeNames", INSTANCE, java.lang.String.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValues<org.instantlogic.designer.ApplicationDesign, java.lang.String> get(org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getThemeNamesAttributeValue();
			}
	
			public boolean isMultivalue() {
				return true;
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign> caseEntity
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign, org.instantlogic.designer.EntityDesign>(
			"caseEntity", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getCaseEntityRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign> deductionOperations
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.DeductionOperationDesign>, org.instantlogic.designer.DeductionOperationDesign>(
			"deductionOperations", INSTANCE, org.instantlogic.designer.entity.DeductionOperationDesignEntity.INSTANCE, org.instantlogic.designer.DeductionOperationDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.DeductionOperationDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getDeductionOperationsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign> entities
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EntityDesign>, org.instantlogic.designer.EntityDesign>(
			"entities", INSTANCE, org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE, org.instantlogic.designer.EntityDesign.class, 
			org.instantlogic.designer.entity.EntityDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EntityDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEntitiesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign> events
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.EventDesign>, org.instantlogic.designer.EventDesign>(
			"events", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, 
			org.instantlogic.designer.entity.EventDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getEventsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign> flows
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FlowDesign>, org.instantlogic.designer.FlowDesign>(
			"flows", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, 
			org.instantlogic.designer.entity.FlowDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getFlowsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign> fragmentTypes
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTypeDesign>, org.instantlogic.designer.FragmentTypeDesign>(
			"fragmentTypes", INSTANCE, org.instantlogic.designer.entity.FragmentTypeDesignEntity.INSTANCE, org.instantlogic.designer.FragmentTypeDesign.class, 
			org.instantlogic.designer.entity.FragmentTypeDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FragmentTypeDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getFragmentTypesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign> mainFlow
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign, org.instantlogic.designer.FlowDesign>(
			"mainFlow", INSTANCE, org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE, org.instantlogic.designer.FlowDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.FlowDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getMainFlowRelationValue();
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign> sharedElements
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.fabric.value.Multi<org.instantlogic.designer.SharedElementDefinitionDesign>, org.instantlogic.designer.SharedElementDefinitionDesign>(
			"sharedElements", INSTANCE, org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.INSTANCE, org.instantlogic.designer.SharedElementDefinitionDesign.class, 
			org.instantlogic.designer.entity.SharedElementDefinitionDesignEntity.application
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.SharedElementDefinitionDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getSharedElementsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign> startEvent
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign, org.instantlogic.designer.EventDesign>(
			"startEvent", INSTANCE, org.instantlogic.designer.entity.EventDesignEntity.INSTANCE, org.instantlogic.designer.EventDesign.class, 
			null
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.designer.ApplicationDesign, org.instantlogic.designer.EventDesign> get(
					org.instantlogic.designer.ApplicationDesign instance) {
				return instance.getStartEventRelationValue();
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		isCustomized,
		name,
		rootPackageName,
		sourcePath,
		themeNames,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		caseEntity,
		deductionOperations,
		entities,
		events,
		flows,
		fragmentTypes,
		mainFlow,
		sharedElements,
		startEvent,
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
	public java.util.Map<String, org.instantlogic.designer.ApplicationDesign> getStaticInstances() {
		return org.instantlogic.designer.ApplicationDesign.getStaticApplicationDesignInstances();
	}
}
