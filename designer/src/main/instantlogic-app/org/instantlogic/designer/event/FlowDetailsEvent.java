package org.instantlogic.designer.event;

public class FlowDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final FlowDetailsEvent INSTANCE = new FlowDetailsEvent();

	public FlowDetailsEvent() {
		super("FlowDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
		});
	}
}
