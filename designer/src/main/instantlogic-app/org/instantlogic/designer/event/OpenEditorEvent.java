package org.instantlogic.designer.event;

public class OpenEditorEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final OpenEditorEvent INSTANCE = new OpenEditorEvent();

	public OpenEditorEvent() {
		super("OpenEditor", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.ElementDesignEntity.INSTANCE,
		});
	}
}
