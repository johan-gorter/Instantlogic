/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.util;

import java.util.List;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;


public class SingleInstanceDeductionContext extends DeductionContext {

	private final Instance instance;
	
	public SingleInstanceDeductionContext(Instance instance) {
		this.instance = instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <I extends Instance> I getSelectedInstance(Entity<I> entity) {
		if (Entity.extendsFrom(instance.getMetadata().getEntity(), entity)) {
			return (I)instance;
		}
		Instance instanceCase = instance.getMetadata().getCase(); // The case to which the instance belongs is also checked.
		if (Entity.extendsFrom(instanceCase.getMetadata().getEntity(), entity)) {
			return (I)instanceCase;
		}
		throw new RuntimeException("No active instance of entity "+entity.getName());
	}

	@Override
	protected void addSelectedInstances(List<Instance> result) {
		result.add(instance);
	}

	@Override
	public String printDiagnostics() {
		return "SingleInstanceDeductionContext("+instance+")";
	}

}
