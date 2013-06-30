package org.instantlogic.designer.event;

public abstract class AbstractDataEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final DataEvent INSTANCE = new DataEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public AbstractDataEvent() {
		super("Data", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
