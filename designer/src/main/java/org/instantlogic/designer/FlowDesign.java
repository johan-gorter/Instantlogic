/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

public class FlowDesign extends AbstractFlowDesign {

	public FlowDesign(){}
	
	public FlowDesign(String name) {
		setName(name);
	}
	
	public void init() {
		for (FlowNodeBaseDesign node : this.getNodes()) {
			if (node instanceof PlaceTemplateDesign) {
				PlaceTemplateDesign place = ((PlaceTemplateDesign)node);
				place.init();
			}
		}
	}

	// The methods below ease the pain a little, but a picture tells more than a 1000 words.

	public SubFlowDesign addSubFlow(FlowDesign flow) {
		SubFlowDesign result = new SubFlowDesign();
		addToNodes(result);
		result.setFlow(flow);
		result.setName(flow.getName());
		return result;
	}
	
	public FlowEdgeDesign newEdge() {
		FlowEdgeDesign edge = new FlowEdgeDesign();
		addToEdges(edge);
		return edge;
	}
}
