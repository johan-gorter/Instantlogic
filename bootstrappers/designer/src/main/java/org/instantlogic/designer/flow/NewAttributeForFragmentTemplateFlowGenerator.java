

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FragmentTemplateDesignEntityGenerator;

public class NewAttributeForFragmentTemplateFlowGenerator extends FlowDesign {
	
	public static final NewAttributeForFragmentTemplateFlowGenerator FLOW = new NewAttributeForFragmentTemplateFlowGenerator();

	private NewAttributeForFragmentTemplateFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("NewAttributeForFragmentTemplate");
		setIsCustomized(true);
		addToParameters(FragmentTemplateDesignEntityGenerator.ENTITY);
	}
}
