package org.instantlogic.designer.event;

public class FlowNodeDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final FlowNodeDetailsEvent INSTANCE = new FlowNodeDetailsEvent();

	public FlowNodeDetailsEvent() {
		super("FlowNodeDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FlowNodeBaseDesignEntity.INSTANCE,
		});
	}
}
