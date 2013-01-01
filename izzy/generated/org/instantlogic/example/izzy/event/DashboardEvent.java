package org.instantlogic.example.izzy.event;

public class DashboardEvent extends org.instantlogic.interaction.flow.impl.SimpleFlowEvent {

	public static final DashboardEvent INSTANCE = new DashboardEvent();

	public DashboardEvent() {
		super("dashboard", new org.instantlogic.fabric.model.Entity[]{
			org.instantlogic.example.izzy.entity.UserEntity.INSTANCE,
		});
	}
}
