package org.instantlogic.designer.event;

public class FlowNodeDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final FlowNodeDetailsEvent INSTANCE = new FlowNodeDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public FlowNodeDetailsEvent() {
		super("FlowNodeDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE,
		});
	}
}
