package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.entity.ElementDesignEntity;
import org.instantlogic.designer.entity.PlaceTemplateDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class CloseEditorPlaceTemplate extends AbstractCloseEditorPlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		ElementDesign element = (ElementDesign) context.getSelectedInstance(ElementDesignEntity.INSTANCE);
		element.setEditorOpen(false);
		return PlaceTemplateUtil.toContentOwner(element);
	}
}
