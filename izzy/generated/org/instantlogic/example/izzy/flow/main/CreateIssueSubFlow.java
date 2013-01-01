package org.instantlogic.example.izzy.flow.main;

public class CreateIssueSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final CreateIssueSubFlow INSTANCE = new CreateIssueSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.example.izzy.flow.CreateIssueFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "create issue";
	}
}
