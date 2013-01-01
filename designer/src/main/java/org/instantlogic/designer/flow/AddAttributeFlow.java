package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.EntityDesignEntity;
import org.instantlogic.designer.event.AttributeDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddAttributeFlow extends AbstractAddAttributeFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		EntityDesign entity = context.getSelectedInstance(EntityDesignEntity.INSTANCE);
		AttributeDesign result = new AttributeDesign();
		entity.addToAttributes(result);
		return new FlowEventOccurrence(AttributeDetailsEvent.INSTANCE, result);
	}
}
