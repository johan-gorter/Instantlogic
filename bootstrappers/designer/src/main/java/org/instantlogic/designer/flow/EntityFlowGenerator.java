

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.AddAttributeEventGenerator;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.flow.entity.EntityDetailsPlaceGenerator;

public class EntityFlowGenerator extends FlowDesign {
	
	public static final EntityFlowGenerator FLOW = new EntityFlowGenerator();

	private EntityFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Entity");
	}
	
	@Override
	public void init() {
		addToParameters(EntityDesignEntityGenerator.ENTITY);

		SubFlowDesign addAttributeSubFlow = addSubFlow(AddAttributeFlowGenerator.FLOW);

		addToNodes(EntityDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(EntityDetailsPlaceGenerator.PLACE);

		newEdge()
			.setEvent(AddAttributeEventGenerator.EVENT)
			.setEndNode(addAttributeSubFlow);
		
		super.init();
	}
}
