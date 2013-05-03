package org.instantlogic.designer.event;

public class FlowDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final FlowDetailsEvent INSTANCE = new FlowDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public FlowDetailsEvent() {
		super("FlowDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FlowDesignEntity.INSTANCE,
		});
	}
}
