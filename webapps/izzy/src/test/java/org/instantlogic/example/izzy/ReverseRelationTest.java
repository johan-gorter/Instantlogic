package org.instantlogic.example.izzy;

import static org.instantlogic.fabric.util.InstanceUtil.add;
import static org.instantlogic.fabric.util.InstanceUtil.get;
import static org.instantlogic.fabric.util.InstanceUtil.set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.instantlogic.example.izzy.flow.MainFlow;
import org.instantlogic.example.izzy.flow.dashboard.DashboardPlaceTemplate;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.TestDeductionContext;
import org.instantlogic.fabric.value.ValueList;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

import com.google.gson.Gson;
public class ReverseRelationTest {

	@Test
	public void testDirectly() {
		Project project = new Project();
		Issue issue = new Issue();
		User user = new User();
		project.addToUsers(user);
		project.addToIssues(issue);
		issue.setAssignee(user);
		user.addToAssignedIssues(issue);
		user.setUsername("user1");
		
		assertEquals(project, issue.getProject());
		assertEquals(user, issue.getAssignee());
		assertTrue(user.getAssignedIssues().contains(issue));
		
		
		TravelerInfo travelerInfo = new TravelerInfo("travelerId");
		travelerInfo.setAuthenticatedUsername("user1");
		RenderContext renderContext = RenderContext.create(new PlaceTemplate[0], MainFlow.INSTANCE, "dashboard/"+user.getMetadata().getUniqueId()+"/dashboard", project, "caseId", travelerInfo);
		System.out.println(new Gson().toJson(DashboardPlaceTemplate.INSTANCE.render(renderContext)));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		assertTrue(((ValueList)get(user, "assigned issues")).contains(issue));
	}
	
	@Test
	public void testTitle() {
		User user = new User();
		user.setName("John");
		assertEquals("John", user.renderTitle(new TestDeductionContext()));
	}
}
