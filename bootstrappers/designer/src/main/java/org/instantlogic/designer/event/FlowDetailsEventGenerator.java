package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesignEntityGenerator;

public class FlowDetailsEventGenerator extends EventDesign {

	public static FlowDetailsEventGenerator EVENT = new FlowDetailsEventGenerator();
	
	private FlowDetailsEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("FlowDetails");
		addToParameters(FlowDesignEntityGenerator.ENTITY);
	}
}
