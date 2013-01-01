package org.instantlogic.example.izzy.event;

public class IssueDetailsEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final IssueDetailsEvent INSTANCE = new IssueDetailsEvent();

	public IssueDetailsEvent() {
		super("issue details", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.example.izzy.entity.IssueEntity.INSTANCE,
		});
	}
}
