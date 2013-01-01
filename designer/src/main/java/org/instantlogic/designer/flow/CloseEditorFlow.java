package org.instantlogic.designer.flow;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class CloseEditorFlow extends AbstractCloseEditorFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		ElementDesign element = (ElementDesign) occurrence.getParameters()[0];
		element.setEditorOpen(false);
		return occurrence;
	}
}
