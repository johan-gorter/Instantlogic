/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy.entity;

@SuppressWarnings({"unchecked","rawtypes"})
public class ProjectEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Project> {

	public static final ProjectEntity INSTANCE = new ProjectEntity();
	

	
	@Override
	public org.instantlogic.example.izzy.Project createInstance() {
		return new org.instantlogic.example.izzy.Project();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.Project> getInstanceClass() {
		return org.instantlogic.example.izzy.Project.class;
	}
	
	@Override
	public String getName() {
		return "project";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d0 
		  		= org.instantlogic.fabric.deduction.ConstantDeduction.create("0");
		return d0;
	}


	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Project, java.lang.Integer, java.lang.Integer> lastIssueNumber 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Project, java.lang.Integer, java.lang.Integer>(
			"last issue number", INSTANCE, java.lang.Integer.class
		) {
			{
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Project, java.lang.Integer> get(org.instantlogic.example.izzy.Project instance) {
				return instance.getLastIssueNumberAttributeValue();
			}

            private org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> defaultDeduction;
            @Override
            public org.instantlogic.fabric.deduction.Deduction<java.lang.Integer> getDefault() {
                if (defaultDeduction==null) {
                    defaultDeduction = createDeduction0();
                }
                return defaultDeduction;
            }
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> issues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
			"issues", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, 
			org.instantlogic.example.izzy.entity.IssueEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Issue> get(
					org.instantlogic.example.izzy.Project instance) {
				return instance.getIssuesRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>, org.instantlogic.example.izzy.User> users
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Project, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User>, org.instantlogic.example.izzy.User>(
			"users", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.project
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Project instance) {
				return instance.getUsersRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		lastIssueNumber,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		issues,
		users,
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
	public java.util.Map<String, org.instantlogic.example.izzy.Project> getStaticInstances() {
		return org.instantlogic.example.izzy.Project.getStaticProjectInstances();
	}
}
