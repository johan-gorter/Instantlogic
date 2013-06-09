package org.instantlogic.engine.izzy;

import static org.junit.Assert.assertNull;

import org.instantlogic.fabric.util.Operation;
import org.junit.Before;
import org.junit.Test;

public class RemoveTests {

	private IzzyProjectFixture fixture;
	private Operation operation;

	@Before
	public void setUp() {
		fixture = new IzzyProjectFixture();
		operation = fixture.project.getMetadata().getCaseAdministration().startOperation();
	}
	
	public void tearDown() {
		operation.close();
	}
	
	@Test
	public void removeTester() {
		fixture.project.removeFromUsers(fixture.tester);
		assertNull(fixture.issue1.getReporter());
	}

	@Test
	public void removeProgrammer() {
		fixture.project.removeFromUsers(fixture.programmer);
		assertNull(fixture.issue1.getAssignee());
		assertNull(fixture.comment1.getBy());
	}
}
