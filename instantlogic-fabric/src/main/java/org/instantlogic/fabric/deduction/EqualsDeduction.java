

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
