package org.instantlogic.designer.event;

public class AddEntityEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final AddEntityEvent INSTANCE = new AddEntityEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public AddEntityEvent() {
		super("AddEntity", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
