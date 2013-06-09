

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class AddEntityFlowGenerator extends FlowDesign {
	
	public static final AddEntityFlowGenerator FLOW = new AddEntityFlowGenerator();

	private AddEntityFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("AddEntity");
		setIsCustomized(true);
	}
	
}
