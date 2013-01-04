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

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.event.AttributeDetailsEvent;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class NewAttributeForFragmentTemplateFlow extends AbstractNewAttributeForFragmentTemplateFlow {

	@Override
	public FlowEventOccurrence enter(FlowEventOccurrence occurrence, FlowContext context) {
		FragmentTemplateDesign fragmentTemplate = (FragmentTemplateDesign) occurrence.getParameters()[0];
		EntityDesign entity = fragmentTemplate.getEntity();
		AttributeDesign result = new AttributeDesign();
		entity.addToAttributes(result);
		fragmentTemplate.setAttribute(result);
		return new FlowEventOccurrence(AttributeDetailsEvent.INSTANCE, result);
	}
}
