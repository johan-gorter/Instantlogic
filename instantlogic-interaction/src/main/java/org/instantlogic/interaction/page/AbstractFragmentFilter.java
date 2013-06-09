

package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class AbstractFragmentFilter implements FragmentFilter {

	@Override
	public Map<String, Object> render(RenderContext context, String id, FragmentFilterChain chain) {
		return chain.render(context);
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain) {
		return chain.submit(submitContext);
	}
	
	public void change(ChangeContext changeContext, String id, FragmentFilterChain chain) {
		chain.change(changeContext);
	}
}
