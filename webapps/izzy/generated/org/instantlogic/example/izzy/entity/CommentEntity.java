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
public class CommentEntity extends org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Comment> {

	public static final CommentEntity INSTANCE = new CommentEntity();
	

	
	@Override
	public org.instantlogic.example.izzy.Comment createInstance() {
		return new org.instantlogic.example.izzy.Comment();
	}
	
	@Override
	public Class<org.instantlogic.example.izzy.Comment> getInstanceClass() {
		return org.instantlogic.example.izzy.Comment.class;
	}
	
	@Override
	public String getName() {
		return "comment";
	}

	// Deductions

	
	// Attributes
	
	public static final org.instantlogic.fabric.model.Attribute<org.instantlogic.example.izzy.Comment, java.lang.String, java.lang.String> text 
		= new org.instantlogic.fabric.model.impl.SimpleAttribute<org.instantlogic.example.izzy.Comment, java.lang.String, java.lang.String>(
			"text", INSTANCE, java.lang.String.class
		) {
			{
				dataType.put("category", "text");
			}
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyAttributeValue<org.instantlogic.example.izzy.Comment, java.lang.String> get(org.instantlogic.example.izzy.Comment instance) {
				return instance.getTextAttributeValue();
			}
            
		};
	
	// Relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User> by
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.User, org.instantlogic.example.izzy.User>(
			"by", INSTANCE, org.instantlogic.example.izzy.entity.UserEntity.INSTANCE, org.instantlogic.example.izzy.User.class, 
			org.instantlogic.example.izzy.entity.UserEntity.comments
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.User> get(
					org.instantlogic.example.izzy.Comment instance) {
				return instance.getByRelationValue();
			}
		};
	
	// Reverse relations
	
	public static final org.instantlogic.fabric.model.Relation<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Issue> issue
		= new org.instantlogic.fabric.model.impl.SimpleRelation<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.Issue, org.instantlogic.example.izzy.Issue>(
			"issue", INSTANCE, org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE, org.instantlogic.example.izzy.Issue.class, org.instantlogic.example.izzy.entity.IssueEntity.comments
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValue<org.instantlogic.example.izzy.Comment, org.instantlogic.example.izzy.Issue> get(
					org.instantlogic.example.izzy.Comment instance) {
				return instance.getIssueRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		text,
	};
	private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		by,
	};
	private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		issue,
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
	public java.util.Map<String, org.instantlogic.example.izzy.Comment> getStaticInstances() {
		return org.instantlogic.example.izzy.Comment.getStaticCommentInstances();
	}
}
