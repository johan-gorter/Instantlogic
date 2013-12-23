package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.ApplicationDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddEntityPlaceTemplate extends AbstractAddEntityPlaceTemplate {

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		ApplicationDesign application = context.getSelectedInstance(ApplicationDesignEntity.INSTANCE);
		EntityDesign result = new EntityDesign();
		application.addToEntities(result);
		return new FlowEventOccurrence(EntityDetailsPlaceTemplate.INSTANCE, result);
	}
}
