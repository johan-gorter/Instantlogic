package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class AddAttributeFlowGenerator extends FlowDesign {
	
	public static final AddAttributeFlowGenerator FLOW = new AddAttributeFlowGenerator();

	private AddAttributeFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("AddAttribute");
		setIsCustomized(true);
	}
}
