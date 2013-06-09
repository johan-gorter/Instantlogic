

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class AddAttributeEventGenerator extends EventDesign {

	public static AddAttributeEventGenerator EVENT = new AddAttributeEventGenerator();
	
	private AddAttributeEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("AddAttribute");
		addToParameters(EntityDesignEntityGenerator.ENTITY);
	}
}