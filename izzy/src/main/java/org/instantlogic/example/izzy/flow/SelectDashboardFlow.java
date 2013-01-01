package org.instantlogic.example.izzy.flow;

import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;
import org.instantlogic.example.izzy.entity.ProjectEntity;
import org.instantlogic.example.izzy.event.DashboardEvent;
import org.instantlogic.example.izzy.event.NotLoggedInEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class SelectDashboardFlow extends AbstractSelectDashboardFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		String username = context.getTraveler().getAuthenticatedUsername();
		if (username==null) return new FlowEventOccurrence(NotLoggedInEvent.INSTANCE);
		Project project = context.getSelectedInstance(ProjectEntity.INSTANCE);
		User user = null;
		for (User candidateUser : project.getUsers()) {
			if (candidateUser.getUsername().equals(username)) {
				user = candidateUser;
				break;
			}
		}
		if (user==null) {
			user = new User();
			user.setUsername(username);
			project.addToUsers(user);
		}
		return new FlowEventOccurrence(DashboardEvent.INSTANCE, user);
	}
}
