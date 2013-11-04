package org.instantlogic.designer.flow;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class RemoveFragmentTemplateFlow extends AbstractRemoveFragmentTemplateFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) occurrence.getParameters()[0];
		fragmentTemplate.getChildrenForFragment().removeFromChildren(fragmentTemplate);
		return occurrence;
	}
	
}
