package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class FlowNodeChoiceFlowGenerator extends FlowDesign {
	
	public static final FlowNodeChoiceFlowGenerator FLOW = new FlowNodeChoiceFlowGenerator();

	private FlowNodeChoiceFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("FlowNodeChoice");
		setIsCustomized(true);
	}
}
