package org.instantlogic.fabric.deduction;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class SumDeduction<V extends Number> extends Deduction<V> {

	private List<Deduction<? extends Number>> operands = new ArrayList<Deduction<? extends Number>>();

	public void addToOperands(Deduction<? extends Number> operand) {
		operands.add(operand);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		Number result = Integer.valueOf(0);
		for(Deduction<? extends Number> input: operands) {
			Number term = input.deduce(context).getValue();
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
