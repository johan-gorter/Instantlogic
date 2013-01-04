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

/**
 * Returns true if the input is not inconclusive, missing or irrelevant (which means the value is not null) 
 */
public class HasValueDeduction extends Deduction<Boolean> { // V extends I

	public static HasValueDeduction create(Deduction<? extends Object> input) {
		return new HasValueDeduction(input);
	}
	
	private Deduction<? extends Object> input;

	public HasValueDeduction(Deduction<? extends Object> input) {
		this.input = input;
	}

	@Override
	public ValueAndLevel<Boolean> deduct(DeductionContext context) {
		ValueAndLevel<? extends Object> inputValue = input.deduct(context);
		return ValueAndLevel.rule(inputValue.hasValue()?Boolean.TRUE:Boolean.FALSE);
	}
}
