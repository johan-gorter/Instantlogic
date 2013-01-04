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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnterMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(EnterMessage.class);
	
	private final String newLocation;
	
	public EnterMessage(String newLocation) {
		if (newLocation==null || newLocation.length()==0) throw new IllegalArgumentException("newLocation may not be null");
		this.newLocation = newLocation;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		logger.info("Traveler entering {}-{}", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
		presence.enter(traveler, newLocation); // Update presence
	}
}
