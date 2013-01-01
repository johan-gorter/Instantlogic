package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

/**
 * A SharedElement may occur multiple times on a page. The id's must be kept unique.
 */
public class SharedElementHolder extends Element {

	private SharedElement sharedElement;
	private final String id;

	public SharedElementHolder(String id, SharedElement sharedElement) {
		this.sharedElement = sharedElement;
		this.id = id;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		context.enterScope(this);
		sharedElement.render(context, appendTo);
		context.exitScope();
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		submitContext.enterScope(this);
		FlowEventOccurrence result = sharedElement.submit(submitContext);
		submitContext.exitScope();
		return result;
	}

	@Override
	public void change(ChangeContext changeContext) {
		changeContext.enterScope(this);
		sharedElement.change(changeContext);
		changeContext.exitScope();
	}

	public String getId() {
		return id;
	}
}
