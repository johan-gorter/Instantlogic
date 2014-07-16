package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnsubscribeMessage extends Message {

  private static final Logger logger = LoggerFactory.getLogger(UnsubscribeMessage.class);

  private final String location;

  public UnsubscribeMessage(String location) {
    if (location == null || location.length() == 0) {
      throw new IllegalArgumentException("location may not be null");
    }
    this.location = location;
  }

  @Override
  public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
    logger.info("Traveler unsubscribing {}-{}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
    traveler.removeSubscription(location);
  }
}
