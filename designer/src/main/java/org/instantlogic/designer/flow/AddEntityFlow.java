

package org.instantlogic.designer.flow;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.ApplicationDesignEntity;
import org.instantlogic.designer.event.EntityDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddEntityFlow extends AbstractAddEntityFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		ApplicationDesign application = context.getSelectedInstance(ApplicationDesignEntity.INSTANCE);
		EntityDesign result = new EntityDesign();
		application.addToEntities(result);
		return new FlowEventOccurrence(EntityDetailsEvent.INSTANCE, result);
	}
}
