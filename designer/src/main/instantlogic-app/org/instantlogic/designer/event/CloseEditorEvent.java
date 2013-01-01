package org.instantlogic.designer.event;

public class CloseEditorEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final CloseEditorEvent INSTANCE = new CloseEditorEvent();

	public CloseEditorEvent() {
		super("CloseEditor", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE,
		});
	}
}
