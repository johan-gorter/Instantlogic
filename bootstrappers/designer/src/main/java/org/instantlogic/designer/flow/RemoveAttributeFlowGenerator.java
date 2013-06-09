package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class RemoveAttributeFlowGenerator extends FlowDesign {
	
	public static final RemoveAttributeFlowGenerator FLOW = new RemoveAttributeFlowGenerator();

	private RemoveAttributeFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("RemoveAttribute");
		setIsCustomized(true);
	}
}
