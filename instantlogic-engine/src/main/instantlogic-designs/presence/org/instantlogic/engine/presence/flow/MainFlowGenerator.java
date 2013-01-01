package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		PresenceApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Main");
	}
	
	@Override
	public void init() {
		addSubFlow(TravelerFlowGenerator.FLOW);
		super.init();
	}
}
