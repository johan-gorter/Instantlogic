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
public class UserEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.User> {

	public static final UserEntity INSTANCE = new UserEntity();
	

	
	@Override
	public org.instantlogic.example.izzy.User createInstance() {
		return new org.instantlogic.example.izzy.User();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.User> getInstanceClass() {
		return org.instantlogic.example.izzy.User.class;
	}
	
	@Override
	public String getName() {
		return "user";
	}

	// Deductions

	private static org.instantlogic.fabric.deduction.Deduction<java.lang.String> createDeduction0() {
		  	org.instantlogic.fabric.deduction.Deduction<org.instantlogic.example.izzy.User> d0 
		  		= org.instantlogic.fabric.deduction.SelectedInstanceDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.INSTANCE);
		  	org.instantlogic.fabric.deduction.Deduction<java.lang.String> d1 
		  		= org.instantlogic.fabric.deduction.AttributeDeduction.create(org.instantlogic.example.izzy.entity.UserEntity.username, d0);
		return d1;
	}


	// Title
	private org.instantlogic.fabric.text.TextTemplate title;
	@Override
	public org.instantlogic.fabric.text.TextTemplate getTitle() {
		if (title==null) {
			title = new org.instantlogic.fabric.text.TextTemplate(new org.instantlogic.fabric.text.StringTemplate(createDeduction0()));
		}
		return title;
	}
	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.User, java.lang.String, java.lang.String> username 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.User, java.lang.String, java.lang.String>(
			"username", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.User, java.lang.String> get(org.instantlogic.example.izzy.User instance) {
				return instance.getUsernameAttributeValue();
			}
            
		};
	
	// Relations
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.User, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> assignedIssues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.User, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
			"assignedIssues", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, org.instantlogic.example.izzy.entity.IssueEntity.assignee
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Issue> get(
					org.instantlogic.example.izzy.User instance) {
				return instance.getAssignedIssuesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.Comment> comments
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.Comment>(
			"comments", INSTANCE, org.instantlogic.example.izzy.entity.CommentEntity.INSTANCE, org.instantlogic.example.izzy.Comment.class, org.instantlogic.example.izzy.entity.CommentEntity.by
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Comment> get(
					org.instantlogic.example.izzy.User instance) {
				return instance.getCommentsRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project> project
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Project, org.instantlogic.example.izzy.Project>(
			"project", INSTANCE, org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE, org.instantlogic.example.izzy.Project.class, org.instantlogic.example.izzy.entity.ProjectEntity.users
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Project> get(
					org.instantlogic.example.izzy.User instance) {
				return instance.getProjectRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.User, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue> reportedIssues
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.User, org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue>, org.instantlogic.example.izzy.Issue>(
			"reportedIssues", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, org.instantlogic.example.izzy.entity.IssueEntity.reporter
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.Issue> get(
					org.instantlogic.example.izzy.User instance) {
				return instance.getReportedIssuesRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		username,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		assignedIssues,
		comments,
		project,
		reportedIssues,
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
	public java.util.Map<String, org.instantlogic.example.izzy.User> getStaticInstances() {
		return org.instantlogic.example.izzy.User.getStaticUserInstances();
	}
}
