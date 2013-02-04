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
public class Issue extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Issue> _staticInstances = new java.util.LinkedHashMap<String, Issue>();
	
	public static java.util.Map<String, Issue> getStaticIssueInstances() {
		return _staticInstances;
	}
	
	private static Issue addStaticInstance(String name, Issue instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.Integer> StoryPoints
		= createAttributeValue(org.instantlogic.example.izzy.entity.IssueEntity.StoryPoints);
	
	public java.lang.Integer getStoryPoints() {
		return StoryPoints.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.Integer> getStoryPointsAttributeValue() {
		return StoryPoints;
	}

	public Issue setStoryPoints(java.lang.Integer newValue) {
		StoryPoints.setValue(newValue);
		return (Issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> description
		= createAttributeValue(org.instantlogic.example.izzy.entity.IssueEntity.description);
	
	public java.lang.String getDescription() {
		return description.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> getDescriptionAttributeValue() {
		return description;
	}

	public Issue setDescription(java.lang.String newValue) {
		description.setValue(newValue);
		return (Issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> headline
		= createAttributeValue(org.instantlogic.example.izzy.entity.IssueEntity.headline);
	
	public java.lang.String getHeadline() {
		return headline.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> getHeadlineAttributeValue() {
		return headline;
	}

	public Issue setHeadline(java.lang.String newValue) {
		headline.setValue(newValue);
		return (Issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> newAttribute
		= createAttributeValue(org.instantlogic.example.izzy.entity.IssueEntity.newAttribute);
	
	public java.lang.String getNewAttribute() {
		return newAttribute.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.String> getNewAttributeAttributeValue() {
		return newAttribute;
	}

	public Issue setNewAttribute(java.lang.String newValue) {
		newAttribute.setValue(newValue);
		return (Issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.Integer> number
		= createAttributeValue(org.instantlogic.example.izzy.entity.IssueEntity.number);
	
	public java.lang.Integer getNumber() {
		return number.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Issue, java.lang.Integer> getNumberAttributeValue() {
		return number;
	}

	public Issue setNumber(java.lang.Integer newValue) {
		number.setValue(newValue);
		return (Issue)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<Issue, User> assignee
		= createRelationValue(org.instantlogic.example.izzy.entity.IssueEntity.assignee);
		
	public org.instantlogic.fabric.value.RelationValue<Issue, User> getAssigneeRelationValue() {
		return assignee;
	}

	public org.instantlogic.example.izzy.User getAssignee() {
		return assignee.getValue();
	}
	
	public Issue setAssignee(org.instantlogic.example.izzy.User newValue) {
		assignee.setValue(newValue);
		return (Issue)this;
	}
	

	
	private final org.instantlogic.fabric.value.RelationValues<Issue, Comment> comments
		= createRelationValues(org.instantlogic.example.izzy.entity.IssueEntity.comments);
		
	public org.instantlogic.fabric.value.RelationValues<Issue, Comment> getCommentsRelationValue() {
		return comments;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.example.izzy.Comment> getComments() {
		return comments.getValue();
	}
	
	public Issue addToComments(Comment item) {
		comments.addValue(item);
		return (Issue)this;
	}
	
	public Issue addToComments(Comment item, int index) {
		comments.insertValue(item, index);
		return (Issue)this;
	}
	
	public Issue removeFromComments(Comment item) {
		comments.removeValue(item);
		return (Issue)this;
	}
	
	public Issue removeFromComments(int index) {
		comments.removeValue(index);
		return (Issue)this;
	}
	
	
	private final org.instantlogic.fabric.value.RelationValue<Issue, User> reporter
		= createRelationValue(org.instantlogic.example.izzy.entity.IssueEntity.reporter);
		
	public org.instantlogic.fabric.value.RelationValue<Issue, User> getReporterRelationValue() {
		return reporter;
	}

	public org.instantlogic.example.izzy.User getReporter() {
		return reporter.getValue();
	}
	
	public Issue setReporter(org.instantlogic.example.izzy.User newValue) {
		reporter.setValue(newValue);
		return (Issue)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<Issue, Project> project
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.IssueEntity.project);

	public org.instantlogic.fabric.value.RelationValue<Issue, Project> getProjectRelationValue() {
		return project;
	}

	public org.instantlogic.example.izzy.Project getProject() {
		return project.getValue();
	}

    public Issue setProject(org.instantlogic.example.izzy.Project newValue) {
        project.setValue(newValue);
        return (Issue)this;
    }


}
