

package org.instantlogic.engine.message;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;

public class PresenceMessage extends Message {

	/**
	 * What action to take (setCommunicatorVisible, login, etc...)
	 */
	private final String command;
	/**
	 * On which element (chatId). optional.
	 */
	public final String id;
	/**
	 * A (new) value (true, chat message, etc...)
	 */
	private final Object value;

	public PresenceMessage(String command, String id, Object value) {
		this.command = command;
		this.id = id;
		this.value = value;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		presence.executeCommand(traveler, command, id, value);
	}

}
