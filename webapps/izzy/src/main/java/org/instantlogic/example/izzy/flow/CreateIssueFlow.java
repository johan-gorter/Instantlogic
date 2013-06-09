

package org.instantlogic.example.izzy.flow;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IssueStatus;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;
import org.instantlogic.example.izzy.entity.ProjectEntity;
import org.instantlogic.example.izzy.event.IssueDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class CreateIssueFlow extends AbstractCreateIssueFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Project project = context.getSelectedInstance(ProjectEntity.INSTANCE);
		Issue issue = new Issue();
		project.addToIssues(issue);
		Integer lastIssueNumber = project.getLastIssueNumber();
		project.setLastIssueNumber(lastIssueNumber+1);
		issue.setNumber(lastIssueNumber+1);
		issue.setHeadline("New issue");
		issue.setReporter(findUser(project, context.getTraveler().getAuthenticatedUsername()));
		issue.setStatus(IssueStatus.draft);
		return new FlowEventOccurrence(IssueDetailsEvent.INSTANCE, issue);
	}

	private User findUser(Project project, String authenticatedUsername) {
		for (User user : project.getUsers()) {
			if (user.getUsername().equals(authenticatedUsername)) {
				return user;
			}
		}
		return null;
	}
}
