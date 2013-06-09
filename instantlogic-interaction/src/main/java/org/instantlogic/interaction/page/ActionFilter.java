

package org.instantlogic.interaction.page;

import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ActionFilter extends AbstractFragmentFilter {

	private final FlowEvent event;
	
	public ActionFilter(FlowEvent event) {
		this.event = event;
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		if (submitContext.getPageElementId().equals(id)) {
			return this.event.createOccurrence(submitContext);
		}
		return super.submit(submitContext, id, chain);
	}
}
