package org.instantlogic.designer.event;

public class InsertFragmentTemplateBelowEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final InsertFragmentTemplateBelowEvent INSTANCE = new InsertFragmentTemplateBelowEvent();

	public InsertFragmentTemplateBelowEvent() {
		super("InsertFragmentTemplateBelow", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
		});
	}
}
