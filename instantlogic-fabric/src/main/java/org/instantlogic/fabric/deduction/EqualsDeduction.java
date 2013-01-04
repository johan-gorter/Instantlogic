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
import org.instantlogic.fabric.util.ValueLevel;

/**
 * Returns true if all inputs are equal to one another
 */
public class EqualsDeduction extends Deduction<Boolean> { 

	public static EqualsDeduction create(Deduction<?>... inputs) {
		return new EqualsDeduction(inputs);
	}
	
	private Deduction<?>[] inputs;

	public EqualsDeduction(Deduction<?>... inputs) {
		this.inputs = inputs;
	}

	@Override
	public ValueAndLevel<Boolean> deduct(DeductionContext context) {
		if (inputs.length<2) return ValueAndLevel.rule(Boolean.TRUE);
		ValueAndLevel<?> firstValue = inputs[0].deduct(context);
		if (firstValue.getValueLevel()==ValueLevel.INCONCLUSIVE || firstValue.getValueLevel()==ValueLevel.IRRELEVANT) {
			return ValueAndLevel.inconclusive();
		}
		for (int i=1;i<inputs.length;i++) {
			ValueAndLevel<?> nextValue = inputs[i].deduct(context);
			if (firstValue.getValueLevel()==ValueLevel.INCONCLUSIVE || firstValue.getValueLevel()==ValueLevel.IRRELEVANT) {
				return ValueAndLevel.inconclusive();
			}
			if (firstValue.getValue()==null && nextValue.getValue()!=null) {
				return ValueAndLevel.rule(Boolean.FALSE);
			}
			if (!firstValue.getValue().equals(nextValue.getValue())) {
				return ValueAndLevel.rule(Boolean.FALSE);
			}
		}
		return ValueAndLevel.rule(Boolean.TRUE);
	}
}
