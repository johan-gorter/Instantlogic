package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.entity.FragmentTemplateDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class NewAttributeForFragmentTemplatePlaceTemplate extends AbstractNewAttributeForFragmentTemplatePlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) context.getSelectedInstance(FragmentTemplateDesignEntity.INSTANCE);
		EntityDesign entity = fragmentTemplate.getEntity();
		AttributeDesign result = new AttributeDesign();
		entity.addToAttributes(result);
		fragmentTemplate.setAttribute(result);
		return new FlowEventOccurrence(AttributeDetailsPlaceTemplate.INSTANCE, result);
	}
}
