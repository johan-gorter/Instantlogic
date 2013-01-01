package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

/**
 * Can be a FragementTemplate or a server-side processing instruction (loop, if/else)
 */
public abstract class Element {

	public abstract void render(RenderContext context, List<Map<String, Object>> appendTo);
	
	public abstract FlowEventOccurrence submit(SubmitContext submitContext);
	
	public abstract void change(ChangeContext changeContext);

}
