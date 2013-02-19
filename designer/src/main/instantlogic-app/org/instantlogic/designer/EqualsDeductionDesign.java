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

@SuppressWarnings({"unchecked","rawtypes","unused"})
public class EqualsDeductionDesign extends DeductionDesign { 

	private static final java.util.Map<String, EqualsDeductionDesign> _staticInstances = new java.util.LinkedHashMap<String, EqualsDeductionDesign>();
	
	public static java.util.Map<String, EqualsDeductionDesign> getStaticEqualsDeductionDesignInstances() {
		return _staticInstances;
	}
	
	private static EqualsDeductionDesign addStaticInstance(String name, EqualsDeductionDesign instance) {
		_staticInstances.put(name, instance);
		instance.getMetadata().makeStatic(name);
		return instance;
	}
	
	
	static {
	}
	
	@Override
	protected org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.EqualsDeductionDesignEntity.INSTANCE;
	}

	// Attributes
	
	// Relations

	// Reverse relations

}