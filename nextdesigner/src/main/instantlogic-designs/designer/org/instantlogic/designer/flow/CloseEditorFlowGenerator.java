package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class CloseEditorFlowGenerator extends FlowDesign {
	
	public static final CloseEditorFlowGenerator FLOW = new CloseEditorFlowGenerator();

	private CloseEditorFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("CloseEditor");
		setIsCustomized(true);
	}
}
