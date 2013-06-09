package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class RemoveFragmentTemplateFlowGenerator extends FlowDesign {
	
	public static final RemoveFragmentTemplateFlowGenerator FLOW = new RemoveFragmentTemplateFlowGenerator();

	private RemoveFragmentTemplateFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("RemoveFragmentTemplate");
		setIsCustomized(true);
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}
