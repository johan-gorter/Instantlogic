package org.instantlogic.designer.flow;

import org.instantlogic.designer.AttributeDesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowEdgeDesign;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.flow.attribute.AttributeDetailsPlaceGenerator;

public class AttributeFlowGenerator extends FlowDesign {
	
	public static final AttributeFlowGenerator FLOW = new AttributeFlowGenerator();

	private AttributeFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Attribute");
	}
	
	@Override
	public void init() {
		addToParameters(AttributeDesignEntityGenerator.ENTITY);

		addToNodes(AttributeDetailsPlaceGenerator.PLACE);
		
		new FlowEdgeDesign()
			.setOwner(this)
			.setEvent(AttributeDetailsEventGenerator.EVENT)
			.setEndNode(AttributeDetailsPlaceGenerator.PLACE);

		super.init();
	}
}
