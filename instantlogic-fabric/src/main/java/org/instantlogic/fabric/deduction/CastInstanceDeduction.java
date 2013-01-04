/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

// If the input is the specified subclass, the input is returned, otherwise null is returned 
public class CastInstanceDeduction<I extends Instance, V extends Instance> extends Deduction<V> { // V extends I

	public static <I extends Instance, V extends Instance> CastInstanceDeduction<I, V> create(Entity<V> entity, Deduction<I> instanceDeduction) {
		return new CastInstanceDeduction<I, V>(entity, instanceDeduction);
	}
	
	private Deduction<I> instanceDeduction;
	private Entity<V> toEntity;

	public CastInstanceDeduction(Entity<V> toEntity, Deduction<I> instanceDeduction) {
		this.instanceDeduction = instanceDeduction;
		this.toEntity = toEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<I> candidate = instanceDeduction.deduct(context);
		if (Entity.extendsFrom(candidate.getValue().getMetadata().getEntity(), toEntity)) {
			return ValueAndLevel.rule((V)candidate.getValue());
		}
		return ValueAndLevel.rule(null);
	}
}
