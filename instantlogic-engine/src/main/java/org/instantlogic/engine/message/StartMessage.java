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
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StartMessage extends Message {

	private static final Logger logger = LoggerFactory.getLogger(StartMessage.class);
	private final String location;
	private final String event;
	
	public StartMessage(String location, String event) {
		this.location= location;
		this.event = event;
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		FlowEventOccurrence eventOccurrence;
		FlowContext flowContext = FlowContext.create(application.getMainFlow(), location, theCase, presence.getCaseName(), traveler.getTravelerInfo());
		if (event!=null) {
			String[] components = event.split("/");
			Instance[] instances = new Instance[components.length-1];
			for (int i=1;i<components.length;i++) {
				instances[i-1] = theCase.getMetadata().getCaseAdministration().getInstanceByUniqueId(components[i]);
			}
			FlowEvent event = flowContext.getFlowStack().findEvent(components[0]);
			eventOccurrence = new FlowEventOccurrence(event, instances);
		} else {
			logger.info("Traveler {}-{} starting", new Object[]{traveler.getTravelerInfo().getAuthenticatedUsername(), traveler.getTravelerInfo().getTravelerId()});
			eventOccurrence = new FlowEventOccurrence(application.getStartEvent());
		}
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getPresence().enter(traveler, flowContext.getFlowStack().toPath());
	}
}
