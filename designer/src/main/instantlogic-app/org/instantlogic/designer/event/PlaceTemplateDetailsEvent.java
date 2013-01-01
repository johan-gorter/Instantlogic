package org.instantlogic.designer.event;

public class PlaceTemplateDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final PlaceTemplateDetailsEvent INSTANCE = new PlaceTemplateDetailsEvent();

	public PlaceTemplateDetailsEvent() {
		super("PlaceTemplateDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE,
		});
	}
}
