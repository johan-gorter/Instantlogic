

package org.instantlogic.example.izzy.flow;

import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.event.HomeEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class DeleteIssueFlow extends AbstractDeleteIssueFlow {
	
	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		Issue issue = (Issue) occurrence.getParameters()[0];
		issue.getProject().removeFromIssues(issue);
		return new FlowEventOccurrence(HomeEvent.INSTANCE);
	}
}
