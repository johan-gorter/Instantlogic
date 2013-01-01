package org.instantlogic.example.izzy.flow.main;

public class DashboardSubFlow extends org.instantlogic.interaction.flow.SubFlow {

	public static final DashboardSubFlow INSTANCE = new DashboardSubFlow();
	
	@Override
	public org.instantlogic.interaction.flow.Flow getFlow() {
		return org.instantlogic.example.izzy.flow.DashboardFlow.INSTANCE;
	}
	
	@Override
	public String getName() {
		return "dashboard";
	}
}
