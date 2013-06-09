package org.instantlogic.engine.izzy;

import static org.junit.Assert.assertEquals;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.User;
import org.instantlogic.fabric.util.Operation;
import org.junit.Before;
import org.junit.Test;

public class ChangeTests {

	private IzzyProjectFixture fixture;
	private Operation operation;

	@Before
	public void setUp() {
		fixture = new IzzyProjectFixture();
		operation = fixture.project.getMetadata().getCaseAdministration().startOperation();
	}
	
	public void tearDown() {
		operation.close();
		assertEquals(fixture.issue1.getAssignee(), fixture.programmer);
	}
	
	@Test
	public void setAssignee() {
		User tester = fixture.project.getUsers().iterator().next();
		Issue issue1 = fixture.project.getIssues().iterator().next();
		tester.addToAssignedIssues(issue1);
		
		assertEquals(issue1.getAssignee(), tester);
	}
}
