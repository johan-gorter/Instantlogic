package org.instantlogic.designer.event;

public class InsertFragmentTemplateBelowEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final InsertFragmentTemplateBelowEvent INSTANCE = new InsertFragmentTemplateBelowEvent();

    // Note: the phase1/phase2 distinction is not implemented here. Thusfar this did not seem neccessary.
	public InsertFragmentTemplateBelowEvent() {
		super("InsertFragmentTemplateBelow", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
		});
	}
}
