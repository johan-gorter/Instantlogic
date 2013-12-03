package org.instantlogic.example.izzy.placetemplate;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IssueStatus;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;
import org.instantlogic.example.izzy.entity.ProjectEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class CreateIssuePlaceTemplate extends AbstractCreateIssuePlaceTemplate {

	private User findUser(Project project, String authenticatedUsername) {
		for (User user : project.getUsers()) {
			if (user.getUsername().equals(authenticatedUsername)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Project project = context.getSelectedInstance(ProjectEntity.INSTANCE);
		Issue issue = new Issue();
		project.addToIssues(issue);
		Integer lastIssueNumber = project.getLastIssueNumber();
		project.setLastIssueNumber(lastIssueNumber+1);
		issue.setNumber(lastIssueNumber+1);
		issue.setHeadline("New issue");
		issue.setReporter(findUser(project, context.getTraveler().getAuthenticatedUsername()));
		issue.setStatus(IssueStatus.draft);
		return new FlowEventOccurrence(IssueDetailsPlaceTemplate.INSTANCE, issue);
	}
}
