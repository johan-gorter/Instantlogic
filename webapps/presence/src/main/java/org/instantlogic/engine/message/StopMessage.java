package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(StopMessage.class);
	
	public StopMessage() {
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
    logger.info("Traveler {}-{} stopping at {}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
		traveler.getPresence().enter(traveler, null);
	}

	@Override
	public String toString() {
		return "StopMessage";
	}
}
