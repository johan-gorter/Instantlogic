package org.instantlogic.designer.event;

public class AddAttributeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AddAttributeEvent INSTANCE = new AddAttributeEvent();

	public AddAttributeEvent() {
		super("AddAttribute", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		});
	}
}
