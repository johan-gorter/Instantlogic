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

public class NegationDeduction<V extends Number> extends Deduction<V> {

	public static <V extends Number> NegationDeduction<V> create(Deduction<V> input) {
		return new NegationDeduction<V>(input);
	}
	
	private Deduction<V> input;

	public NegationDeduction(Deduction<V> input) {
		this.input = input;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		Number value = input.deduce(context).getValue();
		if (value==null) return ValueAndLevel.inconclusive();
		if (value instanceof Long) {
			return ValueAndLevel.rule((V)Long.valueOf(-value.longValue()));
		}
		if (value instanceof Integer) {
			return ValueAndLevel.rule((V)Integer.valueOf(-value.intValue()));
		}
		if (value instanceof Double) {
			return ValueAndLevel.rule((V)Double.valueOf(-value.doubleValue()));
		}
		throw new RuntimeException("Exotic number class not supported: "+value.getClass());
	}
}
