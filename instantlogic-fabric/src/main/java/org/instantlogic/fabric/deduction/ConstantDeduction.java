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

public class ConstantDeduction<V> extends Deduction<V> {

	public static <V> ConstantDeduction<V> create(V constant) {
		return new ConstantDeduction<V>(constant);
	}
	
	private final ValueAndLevel<V> constant;
	
	public ConstantDeduction(V constant) {
		this.constant = ValueAndLevel.rule(constant);
	}

	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		return constant;
	}
}
