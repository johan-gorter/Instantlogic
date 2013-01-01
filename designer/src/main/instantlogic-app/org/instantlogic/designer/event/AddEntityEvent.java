package org.instantlogic.designer.event;

public class AddEntityEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AddEntityEvent INSTANCE = new AddEntityEvent();

	public AddEntityEvent() {
		super("AddEntity", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
