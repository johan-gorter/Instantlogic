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

import java.util.Map;

import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public class SubmitMessage extends Message {

	private final String placeElementId;
	
	public SubmitMessage(String placeElementId) {
		this.placeElementId = placeElementId;
	}

	public SubmitMessage(Map<String, Object> fragment) {
		this.placeElementId = (String) fragment.get("id");
	}

	@Override
	public void execute(Application application, Traveler traveler, Presence presence, Instance theCase) {
		SubmitContext submitContext = SubmitContext.create(application.getMainFlow(), traveler.getCurrentPlace().getUrl(), theCase, presence.getCaseName(), placeElementId, traveler.getTravelerInfo());
		FlowContext flowContext = submitContext.getFlowContext();
		PlaceTemplate placeTemplate = (PlaceTemplate)flowContext.getFlowStack().getCurrentNode();
		FlowEventOccurrence eventOccurrence = placeTemplate.submit(submitContext);
		while (eventOccurrence!=null) {
			eventOccurrence = flowContext.step(eventOccurrence);
		}
		traveler.getPresence().enter(traveler, flowContext.getFlowStack().toPath());
	}
}
