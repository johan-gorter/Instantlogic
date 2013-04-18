package org.instantlogic.designer.codegenerator.jvmbytecode;

import static org.instantlogic.fabric.util.InstanceUtil.add;
import static org.instantlogic.fabric.util.InstanceUtil.get;
import static org.instantlogic.fabric.util.InstanceUtil.set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.instantlogic.designer.test.application.IzzyApplicationGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.TestDeductionContext;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.interaction.Application;
import org.junit.Test;

public class BytecodeGeneratorTest extends AbstractBytecodeGeneratorTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testReverseRelation() throws Exception {
		Application izzy = generate(IzzyApplicationGenerator.DESIGN);

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

	@Test
	public void testTitle() throws Exception {
		Application izzy = generate(IzzyApplicationGenerator.DESIGN);
		
		Entity<? extends Instance> projectEntity = izzy.getCaseEntity();
		Instance project = projectEntity.createInstance();
		CaseAdministration caseAdministration = project.getMetadata().getCaseAdministration();
		Instance user = caseAdministration.createInstance("user");
		
		set(user, "username", "John");
		
		assertEquals("John", user.renderTitle(new TestDeductionContext()));
	}
}
