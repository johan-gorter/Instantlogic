package org.instantlogic.designer.event;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;

public class RemoveAttributeEventGenerator extends EventDesign {

	public static RemoveAttributeEventGenerator EVENT = new RemoveAttributeEventGenerator();
	
	private RemoveAttributeEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("RemoveAttribute");
		addToParameters(AttributeDesignEntityGenerator.ENTITY);
	}
}