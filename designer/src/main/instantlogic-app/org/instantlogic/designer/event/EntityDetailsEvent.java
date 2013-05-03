package org.instantlogic.designer.event;

public class EntityDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final EntityDetailsEvent INSTANCE = new EntityDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public EntityDetailsEvent() {
		super("EntityDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		});
	}
}
