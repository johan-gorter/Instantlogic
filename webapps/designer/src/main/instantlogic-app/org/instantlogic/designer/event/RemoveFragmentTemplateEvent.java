package org.instantlogic.designer.event;

public class RemoveFragmentTemplateEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final RemoveFragmentTemplateEvent INSTANCE = new RemoveFragmentTemplateEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public RemoveFragmentTemplateEvent() {
		super("RemoveFragmentTemplate", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
		});
	}
}
