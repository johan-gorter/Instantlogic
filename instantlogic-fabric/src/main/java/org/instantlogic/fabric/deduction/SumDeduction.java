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

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class SumDeduction<V extends Number> extends Deduction<V> {

	public static <V extends Number> SumDeduction<V> create(Deduction<? extends Number>... inputs) {
		return new SumDeduction<V>(inputs);
	}
	
	private Deduction<? extends Number>[] inputs;

	public SumDeduction(Deduction<? extends Number>... inputs) {
		this.inputs = inputs;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		Number result = Integer.valueOf(0);
		for(Deduction<? extends Number> input: inputs) {
			Number term = input.deduct(context).getValue();
			if (term==null) return ValueAndLevel.inconclusive();
			if (term instanceof Double || result instanceof Double) {
				result = result.doubleValue()+term.doubleValue();
			} else if (term instanceof Long || result instanceof Long) {
				result = result.longValue()+term.longValue();
			} else {
				result = result.intValue()+term.intValue();
			}
		}
		return ValueAndLevel.rule((V)result);
	}
	
}
