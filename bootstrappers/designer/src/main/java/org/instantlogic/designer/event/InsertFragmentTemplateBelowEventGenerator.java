

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class InsertFragmentTemplateBelowEventGenerator extends EventDesign {

	public static InsertFragmentTemplateBelowEventGenerator EVENT = new InsertFragmentTemplateBelowEventGenerator();
	
	private InsertFragmentTemplateBelowEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("InsertFragmentTemplateBelow");
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}