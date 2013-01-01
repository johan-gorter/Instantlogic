package org.instantlogic.example.izzy.flow.main;

public class SelectDashboardSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final SelectDashboardSubFlow INSTANCE = new SelectDashboardSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.example.izzy.flow.SelectDashboardFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "select dashboard";
	}
}
