package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public interface FragmentFilterChain {

	Map<String, Object> render(RenderContext context);
	
	FlowEventOccurrence submit(SubmitContext context);
	
	void change(ChangeContext context);
	
}
