package org.instantlogic.example.izzy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.interaction.Application;
import org.junit.Test;

public class ReverseRelationTest {

	@Test
	public void testDirectly() {
		Project project = new Project();
		Issue issue = new Issue();
		User user = new User();
		project.addToUsers(user);
		project.addToIssues(issue);
		issue.setAssignee(user);
		user.addToReportedIssues(issue);
		
		assertEquals(project, issue.getProject());
		assertEquals(user, issue.getReporter());
		assertTrue(user.getAssignedIssues().contains(issue));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testIndirectly() {
		Application izzy = IzzyApplication.INSTANCE;
		Entity<? extends Instance> projectEntity = izzy.getCaseEntity();
		Instance project = projectEntity.createInstance();
		CaseAdministration caseAdministration = project.getMetadata().getCaseAdministration();
		Instance user = caseAdministration.createInstance("user");
		Instance issue = caseAdministration.createInstance("issue");
		
		add(project, "users", user);
		add(project, "issues", issue);
		set(issue, "assignee", user);
		add(user, "reported issues", issue);
		
		assertEquals(project, get(issue, "project"));
		assertEquals(user, get(issue, "reporter"));
		assertTrue(((Multi)get(user, "assigned issues")).contains(issue));
	}

	private Object get(Instance instance, String attributeOrRelationName) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		return attributeValue.getValue();
	}

	private void set(Instance instance, String attributeOrRelationName, Instance value) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		((AttributeValue)attributeValue).setValue(value);
	}

	private void add(Instance instance, String attributeOrRelationName, Object value) {
		Entity<?> entity = instance.getMetadata().getEntity();
		Attribute attribute = entity.getAttributeOrRelation(attributeOrRelationName);
		ReadOnlyAttributeValue attributeValue = attribute.get(instance);
		((AttributeValues)attributeValue).addValue(value);
	}
}
