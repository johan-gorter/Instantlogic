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
public class Comment extends org.instantlogic.fabric.Instance { 

	private static final java.util.Map<String, Comment> _staticInstances = new java.util.LinkedHashMap<String, Comment>();
	
	public static java.util.Map<String, Comment> getStaticCommentInstances() {
		return _staticInstances;
	}
	
	private static Comment addStaticInstance(String name, Comment instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.example.izzy.entity.CommentEntity.INSTANCE;
	}

	// Attributes
	
	private final org.instantlogic.fabric.value.AttributeValue<Comment, java.lang.String> text
		= createAttributeValue(org.instantlogic.example.izzy.entity.CommentEntity.text);
	
	public java.lang.String getText() {
		return text.getValue();
	}

	public org.instantlogic.fabric.value.AttributeValue<Comment, java.lang.String> getTextAttributeValue() {
		return text;
	}

	public Comment setText(java.lang.String newValue) {
		text.setValue(newValue);
		return (Comment)this;
	}
	
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValue<Comment, User> by
		= createRelationValue(org.instantlogic.example.izzy.entity.CommentEntity.by);
		
	public org.instantlogic.fabric.value.RelationValue<Comment, User> getByRelationValue() {
		return by;
	}

	public org.instantlogic.example.izzy.User getBy() {
		return by.getValue();
	}
	
	public Comment setBy(org.instantlogic.example.izzy.User newValue) {
		by.setValue(newValue);
		return (Comment)this;
	}
	


	// Reverse relations
	
	private final org.instantlogic.fabric.value.RelationValue<Comment, Issue> issue
		= createReverseRelationValue(org.instantlogic.example.izzy.entity.CommentEntity.issue);

	public org.instantlogic.fabric.value.RelationValue<Comment, Issue> getIssueRelationValue() {
		return issue;
	}

	public org.instantlogic.example.izzy.Issue getIssue() {
		return issue.getValue();
	}

    public Comment setIssue(org.instantlogic.example.izzy.Issue newValue) {
        issue.setValue(newValue);
        return (Comment)this;
    }


}
