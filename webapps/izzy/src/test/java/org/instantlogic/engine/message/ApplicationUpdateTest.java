package org.instantlogic.engine.message;

import static org.junit.Assert.*;

import org.instantlogic.example.izzy.IzzyApplication;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;
import org.instantlogic.fabric.Instance;
import org.junit.Test;

public class ApplicationUpdateTest {

	@Test
	public void testLoadFrom() {
		Project project1 = new Project();
		User user1 = new User();
		user1.setUsername("user1");
		project1.addToUsers(user1);
		user1.getMetadata().initUniqueId("user1");

		ApplicationUpdate applicationUpdate = new ApplicationUpdate(IzzyApplication.INSTANCE, IzzyApplication.INSTANCE);

		Instance project1copy = applicationUpdate.loadFrom(project1);
		User user1copy = (User)project1copy.getMetadata().getCaseAdministration().getInstanceByUniqueId("user1");
		assertEquals("user1", user1copy.getUsername());
	}

}
