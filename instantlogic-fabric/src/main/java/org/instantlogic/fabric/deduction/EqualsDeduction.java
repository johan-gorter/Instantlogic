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


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueLevel;

/**
 * Returns true if all inputs are equal to one another
 */
public class EqualsDeduction extends Deduction<Boolean> { 

	private List<Deduction<?>> operands = new ArrayList<Deduction<?>>();
	
	@Deprecated
	public void addToInputs(Deduction<?> input) {
		operands.add(input);
	}

	public void addToOperands(Deduction<?> input) {
		operands.add(input);
	}

	@Override
	public ValueAndLevel<Boolean> execute(DeductionContext context) {
		if (operands.size()<2) return ValueAndLevel.rule(Boolean.TRUE);
		ValueAndLevel<?> firstValue = operands.get(0).deduce(context);
		if (firstValue.getValueLevel()==ValueLevel.INCONCLUSIVE || firstValue.getValueLevel()==ValueLevel.IRRELEVANT) {
			return ValueAndLevel.inconclusive();
		}
		for (int i=1;i<operands.size();i++) {
			ValueAndLevel<?> nextValue = operands.get(i).deduce(context);
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
