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
	private final Element[] ifElements;
	private final Element[] elseElements;
	
	public IfElseElement(Deduction<Boolean> selection, Element[] ifElements, Element[] elseElements) {
		this.condition = selection;
		this.ifElements = ifElements;
		this.elseElements = elseElements;
	}

	@Override
	public void render(RenderContext context, List<Map<String, Object>> appendTo) {
		ValueAndLevel<Boolean> valueAndLevel = condition.deduct(context);
		if (!valueAndLevel.hasValue()) {
			return; // Render no If nor Else elements. This may be worth reconsidering
		}
		Element[] elements = valueAndLevel.getValue()==Boolean.TRUE?ifElements:elseElements;
		for (Element template: elements) {
			template.render(context, appendTo);
		}
	}

	@Override
	public FlowEventOccurrence submit(SubmitContext submitContext) {
		FlowEventOccurrence result = null;
		ValueAndLevel<?> valueAndLevel = condition.deduct(submitContext);
		if (!valueAndLevel.hasValue()) return null; 
		Element[] elements = valueAndLevel.getValue()==Boolean.TRUE?ifElements:elseElements;

		for (Element template: elements) {
			FlowEventOccurrence itemResult = template.submit(submitContext);
			if (itemResult!=null) {
				if (result!=null) { 
					throw new RuntimeException("More than one FlowEventOccurrence");
				}
				result = itemResult;
			}
		}
		return result;
	}

	@Override
	public void change(ChangeContext changeContext) {
		ValueAndLevel<?> valueAndLevel = condition.deduct(changeContext);
		if (!valueAndLevel.hasValue()) return; // Depend on render() to handle this gracefully
		Element[] elements = valueAndLevel.getValue()==Boolean.TRUE?ifElements:elseElements;
		
		for (Element element: elements) {
			element.change(changeContext);
		}
	}
}
