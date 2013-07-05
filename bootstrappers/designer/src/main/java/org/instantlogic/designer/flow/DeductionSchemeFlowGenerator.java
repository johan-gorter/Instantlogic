package org.instantlogic.designer.flow;

import org.instantlogic.designer.DeductionSchemeDesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.event.DeductionSchemeDetailsEventGenerator;
import org.instantlogic.designer.flow.deductionscheme.DeductionSchemePlaceGenerator;

public class DeductionSchemeFlowGenerator extends FlowDesign {
	
	public static final DeductionSchemeFlowGenerator FLOW = new DeductionSchemeFlowGenerator();

	private DeductionSchemeFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("DeductionScheme");
	}
	
	@Override
	public void init() {
		addToParameters(DeductionSchemeDesignEntityGenerator.ENTITY);

		addToNodes(DeductionSchemePlaceGenerator.PLACE);
		
		new FlowEdgeDesign()
			.setOwner(this)
			.setEvent(DeductionSchemeDetailsEventGenerator.EVENT)
			.setEndNode(DeductionSchemePlaceGenerator.PLACE);

		super.init();
	}
}
