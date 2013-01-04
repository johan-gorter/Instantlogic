/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.presence.flow;

import org.instantlogic.designer.FlowDesign;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.flow.traveler.TravelerPlaceTemplateGenerator;

public class TravelerFlowGenerator extends FlowDesign {
	
	public static final TravelerFlowGenerator FLOW = new TravelerFlowGenerator();

	private TravelerFlowGenerator() {
		PresenceApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Traveler");
	}
	
	@Override
	public void init() {
		addToParameters(TravelerEntityGenerator.ENTITY);
		addToNodes(TravelerPlaceTemplateGenerator.PLACE);
		super.init();
	}
}
