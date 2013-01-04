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
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeDeduction<V, I extends Instance> extends Deduction<V> {

	public static <V, I extends Instance> AttributeDeduction<V, I> create(Attribute<I, V, ? extends Object> attribute, Deduction<? extends I> input) {
		return new AttributeDeduction<V, I>(attribute, input);
	}
	
	private Deduction<? extends I> instanceDeduction;
	private Attribute<I, V, ? extends Object> attribute;

	public AttributeDeduction(Attribute<I, V, ? extends Object> attribute, Deduction<? extends I> instanceDeduction) {
		if (attribute==null) throw new IllegalArgumentException();
		this.instanceDeduction = instanceDeduction;
		this.attribute = attribute;
	}

	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		ValueAndLevel<? extends I> instanceValue = instanceDeduction.deduct(context);
		if (instanceValue.getValue()==null) {
			//TODO: think carefully before throwing this out: throw new RuntimeException("No instance while getting value for attribute "+attribute+" on entity "+attribute.getEntity()+", context: "+context.printDiagnostics());
			return ValueAndLevel.inconclusive();
		}
		return attribute.get(instanceValue.getValue()).getValueAndLevel();
	}
}
