

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class RemoveFragmentTemplateEventGenerator extends EventDesign {

	public static RemoveFragmentTemplateEventGenerator EVENT = new RemoveFragmentTemplateEventGenerator();
	
	private RemoveFragmentTemplateEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("RemoveFragmentTemplate");
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}