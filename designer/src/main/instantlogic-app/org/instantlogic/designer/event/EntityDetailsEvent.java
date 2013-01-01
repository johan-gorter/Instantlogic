package org.instantlogic.designer.event;

public class EntityDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final EntityDetailsEvent INSTANCE = new EntityDetailsEvent();

	public EntityDetailsEvent() {
		super("EntityDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.EntityDesignEntity.INSTANCE,
		});
	}
}
