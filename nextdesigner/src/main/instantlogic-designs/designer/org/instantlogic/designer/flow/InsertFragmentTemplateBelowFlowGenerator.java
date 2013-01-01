package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class InsertFragmentTemplateBelowFlowGenerator extends FlowDesign {
	
	public static final InsertFragmentTemplateBelowFlowGenerator FLOW = new InsertFragmentTemplateBelowFlowGenerator();

	private InsertFragmentTemplateBelowFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("InsertFragmentTemplateBelow");
		setIsCustomized(true);
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}
