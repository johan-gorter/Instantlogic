/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.example.izzy;

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class User extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, User> _staticInstances = new java.util.LinkedHashMap<String, User>();
	
	public static java.util.Map<String, User> getStaticUserInstances() {
		return _staticInstances;
	}
	
	private static User addStaticInstance(String name, User instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.UserEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> username
		= createAttributeValue(org.instantlogic.example.izzy.entity.UserEntity.username);
	
	public java.lang.String getUsername() {
		return username.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<User, java.lang.String> getUsernameAttributeValue() {
		return username;
	}

	public User setUsername(java.lang.String newValue) {
		username.setValue(newValue);
		return (User)this;
	}
	
	
	// Relations

	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValues<User, Issue> assignedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.assignedIssues);

	public org.instantlogic.fabric.value.RelationValues<User, Issue> getAssignedIssuesRelationValue() {
		return assignedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getAssignedIssues() {
		return assignedIssues.getValue();
	}

    public User addToAssignedIssues(Issue item) {
        assignedIssues.addValue(item);
        return (User)this;
    }

    public User removeFromAssignedIssues(Issue item) {
        assignedIssues.removeValue(item);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<User, Comment> comments
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.comments);

	public org.instantlogic.fabric.value.RelationValue<User, Comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.example.izzy.Comment getComments() {
		return comments.getValue();
	}

    public User setComments(org.instantlogic.example.izzy.Comment newValue) {
        comments.setValue(newValue);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValue<User, Project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.UserEntity.project);

	public org.instantlogic.fabric.value.RelationValue<User, Project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.Project getProject() {
		return project.getValue();
	}

    public User setProject(org.instantlogic.example.izzy.Project newValue) {
        project.setValue(newValue);
        return (User)this;
    }

	
	private final org.instantlogic.fabric.value.RelationValues<User, Issue> reportedIssues
		= createReverseRelationValues(org.instantlogic.example.izzy.entity.UserEntity.reportedIssues);

	public org.instantlogic.fabric.value.RelationValues<User, Issue> getReportedIssuesRelationValue() {
		return reportedIssues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getReportedIssues() {
		return reportedIssues.getValue();
	}

    public User addToReportedIssues(Issue item) {
        reportedIssues.addValue(item);
        return (User)this;
    }

    public User removeFromReportedIssues(Issue item) {
        reportedIssues.removeValue(item);
        return (User)this;
    }


}
