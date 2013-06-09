

package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public abstract class Message {

	public abstract void execute(Application application, Traveler traveler, Presence presence, Instance theCase);

	
}
