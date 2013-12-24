package org.instantlogic.interaction.page;

import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class ActionFilter extends AbstractFragmentFilter {

	private final PlaceTemplate destination;
	
	public ActionFilter(PlaceTemplate destination) {
		if (destination==null) 
			throw new IllegalArgumentException("destination");
		this.destination = destination;
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		if (submitContext.getPageElementId().equals(id)) {
			return new FlowEventOccurrence(destination, submitContext.getSelectedInstances(destination.getParameters()));
		}
		return super.submit(submitContext, id, chain);
	}
}
