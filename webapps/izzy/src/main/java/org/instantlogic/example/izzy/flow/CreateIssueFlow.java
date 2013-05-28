/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
