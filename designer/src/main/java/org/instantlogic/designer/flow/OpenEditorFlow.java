

package org.instantlogic.designer.flow;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class OpenEditorFlow extends AbstractOpenEditorFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		ElementDesign element = (ElementDesign) occurrence.getParameters()[0];
		element.setEditorOpen(true);
		return occurrence;
	}
}
