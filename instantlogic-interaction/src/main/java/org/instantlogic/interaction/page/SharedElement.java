

package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;


public class SharedElement extends Element {

	private Element delegate;

	protected void setElement(Element delegate) {
		this.delegate = delegate;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		delegate.render(context, appendTo);
	}
	
	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		return delegate.submit(submitContext);
	}

	@Override
	public void change(ChangeContext changeContext) {
		delegate.change(changeContext);
		
	}
}
