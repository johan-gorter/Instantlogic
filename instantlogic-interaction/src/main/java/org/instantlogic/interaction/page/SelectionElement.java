/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
	private final Element[] children; // TODO: Single child
	
	public SelectionElement(Deduction<?> selection, Element... children) {
		this.selection = selection;
		this.children = children;
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
			for (Element template: children) {
				template.render(context, appendTo);
			}
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
			for (Element template: children) {
				FlowEventOccurrence itemResult = template.submit(submitContext);
				if (itemResult!=null) {
					if (result!=null) { 
						throw new RuntimeException("More than one FlowEventOccurrence");
					}
					result = itemResult;
				}
			}
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
			for (Element template: children) {
				template.change(changeContext);
			}
			changeContext.popSelectedInstance(instance);
			changeContext.exitScope();
		} else {
			throw new RuntimeException("Not sure how to handle selection of primitives");
		}
	}
}
