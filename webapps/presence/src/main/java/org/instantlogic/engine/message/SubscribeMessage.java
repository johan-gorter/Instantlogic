package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscribeMessage extends Message {

  private static final Logger logger = LoggerFactory.getLogger(SubscribeMessage.class);

  private final String location;

  public SubscribeMessage(String location) {
    if (location == null || location.length() == 0) {
      throw new IllegalArgumentException("newLocation may not be null");
    }
    this.location = location;
  }

  @Override
  public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
    logger.info("Traveler subscribing {}-{}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
    traveler.addSubscription(location);
  }
}
