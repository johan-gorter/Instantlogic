package org.instantlogic.designer.event;

public class PlaceTemplateDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final PlaceTemplateDetailsEvent INSTANCE = new PlaceTemplateDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public PlaceTemplateDetailsEvent() {
		super("PlaceTemplateDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.PlaceTemplateDesignEntity.INSTANCE,
		});
	}
}
