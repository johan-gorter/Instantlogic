/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer.flow;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.AddEntityEventGenerator;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.event.FlowDetailsEventGenerator;
import org.instantlogic.designer.event.FlowNodeDetailsEventGenerator;
import org.instantlogic.designer.event.HomeEventGenerator;
import org.instantlogic.designer.event.PlaceTemplateDetailsEventGenerator;
import org.instantlogic.designer.flow.main.WelcomePlaceTemplateGenerator;

public class MainFlowGenerator extends FlowDesign {
	
	public static final MainFlowGenerator FLOW = new MainFlowGenerator();

	private MainFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Main");
	}
	
	@Override
	public void init() {
		SubFlowDesign entitySubFlow = addSubFlow(EntityFlowGenerator.FLOW); 
		SubFlowDesign flowSubFlow = addSubFlow(FlowFlowGenerator.FLOW);
		SubFlowDesign addEntitySubFlow = addSubFlow(AddEntityFlowGenerator.FLOW); 
		SubFlowDesign flowNodeSubFlow = addSubFlow(FlowNodeFlowGenerator.FLOW);
		SubFlowDesign placeTemplateSubFlow = addSubFlow(PlaceTemplateFlowGenerator.FLOW);
		SubFlowDesign attributeSubFlow = addSubFlow(AttributeFlowGenerator.FLOW);

		addToNodes(WelcomePlaceTemplateGenerator.PLACE);

		newEdge()
			.setEvent(HomeEventGenerator.EVENT)
			.setEndNode(WelcomePlaceTemplateGenerator.PLACE);

		newEdge()
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(entitySubFlow);
		newEdge()
			.setEvent(AttributeDetailsEventGenerator.EVENT)
			.setEndNode(attributeSubFlow);

		newEdge()
			.setEvent(FlowDetailsEventGenerator.EVENT)
			.setEndNode(flowSubFlow);

		newEdge()
			.setEvent(AddEntityEventGenerator.EVENT)
			.setEndNode(addEntitySubFlow);
		
		newEdge()
			.setEvent(FlowNodeDetailsEventGenerator.EVENT)
			.setEndNode(flowNodeSubFlow);
		
		newEdge()
			.setEvent(PlaceTemplateDetailsEventGenerator.EVENT)
			.setEndNode(placeTemplateSubFlow);
		
		super.init();
	}
}
