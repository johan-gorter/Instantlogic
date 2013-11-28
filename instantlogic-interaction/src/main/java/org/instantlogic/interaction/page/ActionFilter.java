package org.instantlogic.interaction.page;

import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class ActionFilter extends AbstractFragmentFilter {

	@Deprecated
	private final FlowEvent event;
	private final PlaceTemplate destination;
	
	@Deprecated
	public ActionFilter(FlowEvent event) {
		if (event==null) 
			throw new IllegalArgumentException("destination");
		this.event = event;
		this.destination = null;
	}

	
	public ActionFilter(PlaceTemplate destination) {
		if (destination==null) 
			throw new IllegalArgumentException("destination");
		this.event = null;
		this.destination = destination;
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		if (submitContext.getPageElementId().equals(id)) {
			if (destination!=null) {
				return new FlowEventOccurrence(destination, submitContext.getSelectedInstances(destination.getParameters()));
			}
			return this.event.createOccurrence(submitContext);
		}
		return super.submit(submitContext, id, chain);
	}
}
