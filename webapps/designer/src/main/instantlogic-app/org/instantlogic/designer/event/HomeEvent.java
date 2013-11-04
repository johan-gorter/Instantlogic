package org.instantlogic.designer.event;

public class HomeEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final HomeEvent INSTANCE = new HomeEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public HomeEvent() {
		super("Home", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
