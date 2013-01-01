package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowNodeBaseDesignEntityGenerator;

public class FlowNodeDetailsEventGenerator extends EventDesign {

	public static FlowNodeDetailsEventGenerator EVENT = new FlowNodeDetailsEventGenerator();
	
	private FlowNodeDetailsEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("FlowNodeDetails");
		addToParameters(FlowNodeBaseDesignEntityGenerator.ENTITY);
	}
}
