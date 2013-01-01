package org.instantlogic.designer.event;

public class AttributeDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AttributeDetailsEvent INSTANCE = new AttributeDetailsEvent();

	public AttributeDetailsEvent() {
		super("AttributeDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		});
	}
}
