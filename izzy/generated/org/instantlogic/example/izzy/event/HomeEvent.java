package org.instantlogic.example.izzy.event;

public class HomeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final HomeEvent INSTANCE = new HomeEvent();

	public HomeEvent() {
		super("home", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
