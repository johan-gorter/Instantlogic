package org.instantlogic.engine.izzy;

import org.instantlogic.example.izzy.Comment;
import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;

public class IzzyProjectFixture {
	
	public final Project project;
	public final User tester;
	public final User programmer;
	public final Issue issue1;
	public final Comment comment1;
	
	public IzzyProjectFixture() {
		tester = new User().setUsername("tester");
		programmer = new User().setUsername("programmer");
		issue1 = new Issue().setHeadline("issue1");
		comment1 = new Comment().setText("comment1");
		project = new Project()
			.addToUsers(tester)
			.addToUsers(programmer)
			.addToIssues(issue1);
		issue1.setReporter(tester).setAssignee(programmer);
		issue1.addToComments(comment1);
		comment1.setBy(programmer);
	}
	
}
