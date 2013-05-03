package org.instantlogic.designer.event;

public class AttributeDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AttributeDetailsEvent INSTANCE = new AttributeDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public AttributeDetailsEvent() {
		super("AttributeDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		});
	}
}
