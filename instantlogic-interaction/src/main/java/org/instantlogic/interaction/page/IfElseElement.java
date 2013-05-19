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

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.SubmitContext;

/**
 * Does not create a fragment on the client.
 */
public class IfElseElement extends Element {
	private final Deduction<Boolean> condition;
	private final Element ifElement;
	private final Element elseElement;
	
	public IfElseElement(Deduction<Boolean> selection, Element ifElement, Element elseElement) {
		this.condition = selection;
		this.ifElement = ifElement;
		this.elseElement = elseElement;
	}
	
	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		ValueAndLevel<Boolean> valueAndLevel = condition.deduce(context);
		if (!valueAndLevel.hasValue()) {
			return; // Render no If nor Else elements. This may be worth reconsidering
		}
		Element element = valueAndLevel.getValue()==Boolean.TRUE?ifElement:elseElement;
		if (element!=null) {
			element.render(context, appendTo);
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		ValueAndLevel<?> valueAndLevel = condition.deduce(submitContext);
		if (!valueAndLevel.hasValue()) return null; 
		Element element = valueAndLevel.getValue()==Boolean.TRUE?ifElement:elseElement;

		if (element != null) {
			FlowEventOccurrence itemResult = element.submit(submitContext);
			if (itemResult!=null) {
				return itemResult;
			}
		}
		return null;
	}

	@Override
	public void change(ChangeContext changeContext) {
		ValueAndLevel<?> valueAndLevel = condition.deduce(changeContext);
		if (!valueAndLevel.hasValue()) return; // Depend on render() to handle this gracefully
		Element element = valueAndLevel.getValue()==Boolean.TRUE?ifElement:elseElement;
		
		if (element!=null) {
			element.change(changeContext);
		}
	}
}
