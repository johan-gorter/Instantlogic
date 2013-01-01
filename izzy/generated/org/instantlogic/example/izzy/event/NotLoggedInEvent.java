package org.instantlogic.example.izzy.event;

public class NotLoggedInEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final NotLoggedInEvent INSTANCE = new NotLoggedInEvent();

	public NotLoggedInEvent() {
		super("not logged in", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
