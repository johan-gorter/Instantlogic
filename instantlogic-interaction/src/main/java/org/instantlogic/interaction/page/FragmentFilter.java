

package org.instantlogic.interaction.page;

import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public interface FragmentFilter {

	Map<String, Object> render(RenderContext renderContext, String id, FragmentFilterChain chain);
	
	FlowEventOccurrence submit(SubmitContext submitContext, String id, FragmentFilterChain chain);

	void change(ChangeContext changeContext, String id, FragmentFilterChain chain);
	
}
