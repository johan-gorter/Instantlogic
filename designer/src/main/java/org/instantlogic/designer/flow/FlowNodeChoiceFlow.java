

package org.instantlogic.designer.flow;

import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.entity.FlowNodeBaseDesignEntity;
import org.instantlogic.designer.event.PlaceTemplateDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class FlowNodeChoiceFlow extends AbstractFlowNodeChoiceFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FlowNodeBaseDesign node = context.getSelectedInstance(FlowNodeBaseDesignEntity.INSTANCE);
		if (node instanceof PlaceTemplateDesign) {
			return new FlowEventOccurrence(PlaceTemplateDetailsEvent.INSTANCE, node);
		}
		throw new RuntimeException("Node not yet implemeted: "+node.getClass());
	}
}
