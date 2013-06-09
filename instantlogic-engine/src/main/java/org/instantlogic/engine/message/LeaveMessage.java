

package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeaveMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(LeaveMessage.class);
	
	public LeaveMessage() {
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		logger.info("Traveler leaving {}-{}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
		presence.removeFromActiveTravelers(traveler);
	}
}
