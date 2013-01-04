/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
