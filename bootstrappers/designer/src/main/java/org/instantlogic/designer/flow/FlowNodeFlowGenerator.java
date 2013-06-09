package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowNodeBaseDesignEntityGenerator;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.FlowNodeDetailsEventGenerator;
import org.instantlogic.designer.event.PlaceTemplateDetailsEventGenerator;

public class FlowNodeFlowGenerator extends FlowDesign {
	
	public static final FlowNodeFlowGenerator FLOW = new FlowNodeFlowGenerator();

	private FlowNodeFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("FlowNode");
	}
	
	@Override
	public void init() {
		addToParameters(FlowNodeBaseDesignEntityGenerator.ENTITY);

		SubFlowDesign flowNodeChoiceSubFlow = addSubFlow(FlowNodeChoiceFlowGenerator.FLOW);

		newEdge()
			.setEvent(FlowNodeDetailsEventGenerator.EVENT)
			.setEndNode(flowNodeChoiceSubFlow);

		
		super.init();
	}
}
