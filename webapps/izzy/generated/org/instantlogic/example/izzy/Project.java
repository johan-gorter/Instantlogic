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
public class Project extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Project> _staticInstances = new java.util.LinkedHashMap<String, Project>();
	
	public static java.util.Map<String, Project> getStaticProjectInstances() {
		return _staticInstances;
	}
	
	private static Project addStaticInstance(String name, Project instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.ProjectEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Project, java.lang.Integer> lastIssueNumber
		= createAttributeValue(org.instantlogic.example.izzy.entity.ProjectEntity.lastIssueNumber);
	
	public java.lang.Integer getLastIssueNumber() {
		return lastIssueNumber.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Project, java.lang.Integer> getLastIssueNumberAttributeValue() {
		return lastIssueNumber;
	}

	public Project setLastIssueNumber(java.lang.Integer newValue) {
		lastIssueNumber.setValue(newValue);
		return (Project)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<Project, Issue> issues
		= createRelationValues(org.instantlogic.example.izzy.entity.ProjectEntity.issues);
		
	public org.instantlogic.fabric.value.RelationValues<Project, Issue> getIssuesRelationValue() {
		return issues;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Issue> getIssues() {
		return issues.getValue();
	}
	
	public Project addToIssues(Issue item) {
		issues.addValue(item);
		return (Project)this;
	}
	
	public Project addToIssues(Issue item, int index) {
		issues.insertValue(item, index);
		return (Project)this;
	}
	
	public Project removeFromIssues(Issue item) {
		issues.removeValue(item);
		return (Project)this;
	}
	
	public Project removeFromIssues(int index) {
		issues.removeValue(index);
		return (Project)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValues<Project, User> users
		= createRelationValues(org.instantlogic.example.izzy.entity.ProjectEntity.users);
		
	public org.instantlogic.fabric.value.RelationValues<Project, User> getUsersRelationValue() {
		return users;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.User> getUsers() {
		return users.getValue();
	}
	
	public Project addToUsers(User item) {
		users.addValue(item);
		return (Project)this;
	}
	
	public Project addToUsers(User item, int index) {
		users.insertValue(item, index);
		return (Project)this;
	}
	
	public Project removeFromUsers(User item) {
		users.removeValue(item);
		return (Project)this;
	}
	
	public Project removeFromUsers(int index) {
		users.removeValue(index);
		return (Project)this;
	}
	

	// Reverse relations

}
