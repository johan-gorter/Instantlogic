package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.AttributeDesignEntity;
import org.instantlogic.designer.event.EntityDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class RemoveAttributeFlow extends AbstractRemoveAttributeFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		AttributeDesign attribute = context.getSelectedInstance(AttributeDesignEntity.INSTANCE);
		EntityDesign entity = attribute.getBelongsToEntity();
		entity.removeFromAttributes(attribute);
		
		return new FlowEventOccurrence(EntityDetailsEvent.INSTANCE, entity);
	}
	
}
