

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class NewAttributeForFragmentTemplateEventGenerator extends EventDesign {

	public static NewAttributeForFragmentTemplateEventGenerator EVENT = new NewAttributeForFragmentTemplateEventGenerator();
	
	private NewAttributeForFragmentTemplateEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("NewAttributeForFragmentTemplate");
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}