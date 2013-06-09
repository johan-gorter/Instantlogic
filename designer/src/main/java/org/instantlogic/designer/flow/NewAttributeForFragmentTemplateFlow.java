

package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.event.AttributeDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class NewAttributeForFragmentTemplateFlow extends AbstractNewAttributeForFragmentTemplateFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) occurrence.getParameters()[0];
		EntityDesign entity = fragmentTemplate.getEntity();
		AttributeDesign result = new AttributeDesign();
		entity.addToAttributes(result);
		fragmentTemplate.setAttribute(result);
		return new FlowEventOccurrence(AttributeDetailsEvent.INSTANCE, result);
	}
}
