package org.instantlogic.interaction.page;

import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

/**
 * Does not create a fragment on the client, but selects instances on the server.
 */
public class SelectionElement extends Element {

	private final Deduction<?> selection;
	private final Element child;
	
	public SelectionElement(Deduction<?> selection, Element child) {
		this.selection = selection;
		this.child = child;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		ValueAndLevel<?> valueAndLevel = selection.deduce(context);
		if (!valueAndLevel.isConclusive()) {
			throw new RuntimeException("Selection did not yield a conclusive result"); // TODO: render an error
		}
		if (valueAndLevel.hasValue()) {
			Object value = valueAndLevel.getValue();
			if (value instanceof Multi<?>) {
				for (Object item: (Multi<?>)value) {
					renderWith(item, context, appendTo);
				}
			} else  {
				renderWith(value, context, appendTo);
			}
		} 
	}

	private void renderWith(Object value, RenderContext context, List<Map<String, Object>> appendTo) {
		if (value instanceof Instance) {
			Instance instance = (Instance) value;
			context.enterScope(instance);
			context.pushSelectedInstance(instance);
			child.render(context, appendTo);
			context.popSelectedInstance(instance);
			context.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		FlowEventOccurrence result = null;
		ValueAndLevel<?> valueAndLevel = selection.deduce(submitContext);
		if (valueAndLevel.hasValue()) {
			Object value = valueAndLevel.getValue();
			if (value instanceof Multi<?>) {
				for (Object item: (Multi<?>)value) {
					FlowEventOccurrence itemResult = submitWith(item, submitContext);
					if (itemResult!=null) {
						if (result!=null) { 
							throw new RuntimeException("More than one FlowEventOccurrence");
						}
						result = itemResult;
					}
				}
			} else  {
				result = submitWith(value, submitContext);
			}
		}
		return result;
	}

	private FlowEventOccurrence submitWith(Object value, SubmitContext submitContext) {
		FlowEventOccurrence result = null;
		if (value instanceof Instance) {
			Instance instance = (Instance) value;
			submitContext.enterScope(instance);
			submitContext.pushSelectedInstance(instance);
			result = child.submit(submitContext);
			submitContext.popSelectedInstance(instance);
			submitContext.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
		return result;
	}

	@Override
	public void change(ChangeContext changeContext) {
		ValueAndLevel<?> valueAndLevel = selection.deduce(changeContext);
		if (valueAndLevel.hasValue()) {
			Object value = valueAndLevel.getValue();
			if (value instanceof Multi<?>) {
				for (Object item: (Multi<?>)value) {
					changeWith(item, changeContext);
				}
			} else  {
				changeWith(value, changeContext);
			}
		}
	}
	
	private void changeWith(Object value, ChangeContext changeContext) {
		if (value instanceof Instance) {
			Instance instance = (Instance) value;
			changeContext.enterScope(instance);
			changeContext.pushSelectedInstance(instance);
			child.change(changeContext);
			changeContext.popSelectedInstance(instance);
			changeContext.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
	}
}
