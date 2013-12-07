package org.instantlogic.example.izzy.placetemplate;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IssueStatus;
import org.instantlogic.example.izzy.entity.IssueEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ResolveIssuePlaceTemplate extends AbstractResolveIssuePlaceTemplate {

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		Issue issue = (Issue) context.getSelectedInstance(IssueEntity.INSTANCE);
		issue.setStatus(IssueStatus.resolved);
		return new FlowEventOccurrence(IssueDetailsPlaceTemplate.INSTANCE, issue);
	}
}
