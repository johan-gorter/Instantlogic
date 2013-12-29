package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.entity.ElementDesignEntity;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class OpenEditorPlaceTemplate extends AbstractOpenEditorPlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		ElementDesign element = (ElementDesign) context.getSelectedInstance(ElementDesignEntity.INSTANCE);
		element.setEditorOpen(true);
		return PlaceTemplateUtil.toContentOwner(element);
	}
}
