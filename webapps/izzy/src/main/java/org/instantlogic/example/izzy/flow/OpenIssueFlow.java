package org.instantlogic.example.izzy.flow;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IssueStatus;
import org.instantlogic.example.izzy.event.IssueDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class OpenIssueFlow extends AbstractOpenIssueFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Issue issue = (Issue) occurrence.getParameters()[0];
		issue.setStatus(IssueStatus.open);
		return new FlowEventOccurrence(IssueDetailsEvent.INSTANCE, issue);
	}
	
}