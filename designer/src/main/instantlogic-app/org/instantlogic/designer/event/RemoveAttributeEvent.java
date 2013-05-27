package org.instantlogic.designer.event;

public class RemoveAttributeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final RemoveAttributeEvent INSTANCE = new RemoveAttributeEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public RemoveAttributeEvent() {
		super("RemoveAttribute", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.AttributeDesignEntity.INSTANCE,
		});
	}
}
