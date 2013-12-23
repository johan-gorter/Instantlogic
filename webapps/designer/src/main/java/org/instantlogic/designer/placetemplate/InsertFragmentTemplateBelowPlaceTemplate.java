package org.instantlogic.designer.placetemplate;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.designer.entity.FragmentTemplateDesignEntity;
import org.instantlogic.designer.entity.PlaceTemplateDesignEntity;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class InsertFragmentTemplateBelowPlaceTemplate extends AbstractInsertFragmentTemplateBelowPlaceTemplate {
	
	@Override
	public FlowEventOccurrence enter(FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) context.getSelectedInstance(FragmentTemplateDesignEntity.INSTANCE);
		PropertyDesign property = fragmentTemplate.getChildrenForFragment();
		int index = property.getChildren().asList().indexOf(fragmentTemplate);
		FragmentTemplateDesign newFragmentTemplate = new FragmentTemplateDesign();
		property.addToChildren(newFragmentTemplate, index+1);
		newFragmentTemplate.setEditorOpen(true);
		return new FlowEventOccurrence(PlaceTemplateDetailsPlaceTemplate.INSTANCE, context.getSelectedInstance(PlaceTemplateDesignEntity.INSTANCE));
	}
}
