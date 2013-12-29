package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.entity.FragmentTemplateDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class RemoveFragmentTemplatePlaceTemplate extends AbstractRemoveFragmentTemplatePlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = context.getSelectedInstance(FragmentTemplateDesignEntity.INSTANCE);
		FlowEventOccurrence result = PlaceTemplateUtil.toContentOwner(fragmentTemplate);
		fragmentTemplate.getChildrenForFragment().removeFromChildren(fragmentTemplate);
		return result;
	}
}
