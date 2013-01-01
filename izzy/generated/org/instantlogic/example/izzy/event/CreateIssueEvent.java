package org.instantlogic.example.izzy.event;

public class CreateIssueEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final CreateIssueEvent INSTANCE = new CreateIssueEvent();

	public CreateIssueEvent() {
		super("create issue", new org.instantlogic.fabric.model.Entity[]{
		});
	}
}
