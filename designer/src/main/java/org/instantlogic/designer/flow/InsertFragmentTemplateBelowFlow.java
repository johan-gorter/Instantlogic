

package org.instantlogic.designer.flow;

import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.PropertyDesign;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class InsertFragmentTemplateBelowFlow extends AbstractInsertFragmentTemplateBelowFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) occurrence.getParameters()[0];
		PropertyDesign property = fragmentTemplate.getChildrenForFragment();
		int index = property.getChildren().asList().indexOf(fragmentTemplate);
		FragmentTemplateDesign newFragmentTemplate = new FragmentTemplateDesign();
		property.addToChildren(newFragmentTemplate, index+1);
		newFragmentTemplate.setEditorOpen(true);
		return occurrence;
	}
}
