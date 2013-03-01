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
import org.instantlogic.designer.EntityDesignEntityGenerator;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.SubFlowDesign;
import org.instantlogic.designer.event.AddAttributeEventGenerator;
import org.instantlogic.designer.event.AttributeDetailsEventGenerator;
import org.instantlogic.designer.event.EntityDetailsEventGenerator;
import org.instantlogic.designer.flow.entity.EntityDetailsPlaceGenerator;

public class EntityFlowGenerator extends FlowDesign {
	
	public static final EntityFlowGenerator FLOW = new EntityFlowGenerator();

	private EntityFlowGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToFlows(this);
		setName("Entity");
	}
	
	@Override
	public void init() {
		addToParameters(EntityDesignEntityGenerator.ENTITY);

		SubFlowDesign addAttributeSubFlow = addSubFlow(AddAttributeFlowGenerator.FLOW);

		addToNodes(EntityDetailsPlaceGenerator.PLACE);
		
		newEdge()
			.setEvent(EntityDetailsEventGenerator.EVENT)
			.setEndNode(EntityDetailsPlaceGenerator.PLACE);

		newEdge()
			.setEvent(AddAttributeEventGenerator.EVENT)
			.setEndNode(addAttributeSubFlow);
		
		super.init();
	}
}
