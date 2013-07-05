package org.instantlogic.designer.event;

public class DeductionSchemeDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final DeductionSchemeDetailsEvent INSTANCE = new DeductionSchemeDetailsEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public DeductionSchemeDetailsEvent() {
		super("DeductionSchemeDetails", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.DeductionSchemeDesignEntity.INSTANCE,
		});
	}
}
