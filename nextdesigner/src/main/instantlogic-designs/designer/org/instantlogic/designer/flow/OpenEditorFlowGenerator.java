package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;

public class OpenEditorFlowGenerator extends FlowDesign {
	
	public static final OpenEditorFlowGenerator FLOW = new OpenEditorFlowGenerator();

	private OpenEditorFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("OpenEditor");
		setIsCustomized(true);
	}
}
