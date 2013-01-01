package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.flow.traveler.TravelerPlaceTemplateGenerator;

public class TravelerFlowGenerator extends FlowDesign {
	
	public static final TravelerFlowGenerator FLOW = new TravelerFlowGenerator();

	private TravelerFlowGenerator() {
		PresenceApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Traveler");
	}
	
	@Override
	public void init() {
		addToParameters(TravelerEntityGenerator.ENTITY);
		addToNodes(TravelerPlaceTemplateGenerator.PLACE);
		super.init();
	}
}
