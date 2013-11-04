package org.instantlogic.designer.event;

public class CloseEditorEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final CloseEditorEvent INSTANCE = new CloseEditorEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public CloseEditorEvent() {
		super("CloseEditor", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE,
		});
	}
}
