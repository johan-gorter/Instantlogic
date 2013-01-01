package org.instantlogic.example.izzy.flow.main;

public class IssueSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final IssueSubFlow INSTANCE = new IssueSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.example.izzy.flow.IssueFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "issue";
	}
}
