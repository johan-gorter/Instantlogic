/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction.flow.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class SimpleFlowEvent extends FlowEvent {

	private String name;
	
	private Entity<?>[] parameterTypes;

	public SimpleFlowEvent(String name, Entity<?>... parameterTypes) {
		this.name = name;
		this.parameterTypes = parameterTypes;
	}
	
	@Override
	public Entity<?>[] getParameterTypes() {
		return parameterTypes;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FlowEventOccurrence createOccurrence(SubmitContext context) {
		Instance[] parameters = new Instance[parameterTypes.length];
		for (int i=0;i<parameters.length;i++) {
			parameters[i]=context.getSelectedInstance(parameterTypes[i]);
		}
		return new FlowEventOccurrence(this, parameters);
	}
	
}
