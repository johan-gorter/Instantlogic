package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.AttributeDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class RemoveAttributePlaceTemplate extends AbstractRemoveAttributePlaceTemplate {

	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		AttributeDesign attribute = context.getSelectedInstance(AttributeDesignEntity.INSTANCE);
		EntityDesign entity = attribute.getBelongsToEntity();
		entity.removeFromAttributes(attribute);
		
		return new FlowEventOccurrence(EntityDetailsPlaceTemplate.INSTANCE, entity);
	}

}
