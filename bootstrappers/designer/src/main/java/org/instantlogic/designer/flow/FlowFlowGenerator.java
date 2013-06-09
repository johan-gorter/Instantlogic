

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowDesignEntityGenerator;
import org.instantlogic.designer.event.FlowDetailsEventGenerator;
import org.instantlogic.designer.flow.flow.FlowDetailsPlaceGenerator;

public class FlowFlowGenerator  extends FlowDesign {
	
	public static final FlowFlowGenerator FLOW = new FlowFlowGenerator();

	private FlowFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Flow");
	}
	
	@Override
	public void init() {
		addToParameters(FlowDesignEntityGenerator.ENTITY);

		addToNodes(FlowDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setEvent(FlowDetailsEventGenerator.EVENT)
			.setEndNode(FlowDetailsPlaceGenerator.PLACE);

		
		super.init();
	}
}
