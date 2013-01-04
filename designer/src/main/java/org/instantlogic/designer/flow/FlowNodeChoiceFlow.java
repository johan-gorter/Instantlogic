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

import org.instantlogic.designer.FlowNodeBaseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.entity.FlowNodeBaseDesignEntity;
import org.instantlogic.designer.event.PlaceTemplateDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class FlowNodeChoiceFlow extends AbstractFlowNodeChoiceFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FlowNodeBaseDesign node = context.getSelectedInstance(FlowNodeBaseDesignEntity.INSTANCE);
		if (node instanceof PlaceTemplateDesign) {
			return new FlowEventOccurrence(PlaceTemplateDetailsEvent.INSTANCE, node);
		}
		throw new RuntimeException("Node not yet implemeted: "+node.getClass());
	}
}
