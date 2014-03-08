package org.instantlogic.example.izzy.placetemplate;

import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;
import org.instantlogic.example.izzy.entity.ProjectEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class SelectDashboardPlaceTemplate extends AbstractSelectDashboardPlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		String username = context.getTraveler().getAuthenticatedUsername();
		if (username==null) return new FlowEventOccurrence(NotLoggedInPlaceTemplate.INSTANCE);
		Project project = context.getSelectedInstance(ProjectEntity.INSTANCE);
		User user = null;
		for (User candidateUser : project.getUsers()) {
			if (candidateUser.getUsername().equals(username)) {
				user = candidateUser;
				if (user.getName()==null) {
					if (username.contains("@")) {
						user.setName(Character.toUpperCase(username.charAt(0))+username.substring(1, username.indexOf('@')));
					} else {
						user.setName(username);
					}
				}
				break;
			}
		}
		if (user==null) {
			user = new User();
			user.setUsername(username);
			project.addToUsers(user);
		}
		return new FlowEventOccurrence(DashboardPlaceTemplate.INSTANCE, user);
	}

}
