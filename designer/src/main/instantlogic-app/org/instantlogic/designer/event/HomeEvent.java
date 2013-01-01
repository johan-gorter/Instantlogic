package org.instantlogic.designer.event;

public class HomeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final HomeEvent INSTANCE = new HomeEvent();

	public HomeEvent() {
		super("Home", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
