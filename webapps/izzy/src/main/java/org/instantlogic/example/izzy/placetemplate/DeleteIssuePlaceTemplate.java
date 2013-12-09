package org.instantlogic.example.izzy.placetemplate;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.entity.IssueEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DeleteIssuePlaceTemplate extends AbstractDeleteIssuePlaceTemplate {

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Issue issue = (Issue) context.getSelectedInstance(IssueEntity.INSTANCE);
		issue.getProject().removeFromIssues(issue);
		return new FlowEventOccurrence(SelectDashboardPlaceTemplate.INSTANCE);
	}
}
