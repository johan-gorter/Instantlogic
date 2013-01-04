/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.flow.Flow;


public class SubmitContext extends RenderContext {

	public static SubmitContext create(Flow mainFlow, String path, Instance caseInstance, String caseId, String pageElementId, TravelerInfo travelerInfo) {
		FlowContext flowContext = FlowContext.create(mainFlow, path, caseInstance, caseId, travelerInfo);
		return new SubmitContext(flowContext, path, pageElementId);
	}
	
	private String pageElementId;
	
	public SubmitContext(FlowContext flowContext, String pageCoordinates, String pageElementId) {
		super(flowContext, pageCoordinates);
		this.pageElementId = pageElementId;
	}

	public String getPageElementId() {
		return pageElementId;
	}
}
