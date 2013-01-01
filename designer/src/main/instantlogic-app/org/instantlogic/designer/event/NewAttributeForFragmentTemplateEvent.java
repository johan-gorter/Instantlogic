package org.instantlogic.designer.event;

public class NewAttributeForFragmentTemplateEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final NewAttributeForFragmentTemplateEvent INSTANCE = new NewAttributeForFragmentTemplateEvent();

	public NewAttributeForFragmentTemplateEvent() {
		super("NewAttributeForFragmentTemplate", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.designer.entity.FragmentTemplateDesignEntity.INSTANCE,
		});
	}
}
