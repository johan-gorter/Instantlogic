package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.EntityDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class AddAttributePlaceTemplate extends AbstractAddAttributePlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		EntityDesign entity = context.getSelectedInstance(EntityDesignEntity.INSTANCE);
		AttributeDesign result = new AttributeDesign();
		entity.addToAttributes(result);
		return new FlowEventOccurrence(AddAttributePlaceTemplate.INSTANCE, result);
	}

}
