package org.instantlogic.designer.event;

public class AddAttributeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AddAttributeEvent INSTANCE = new AddAttributeEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public AddAttributeEvent() {
		super("AddAttribute", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		});
	}
}
