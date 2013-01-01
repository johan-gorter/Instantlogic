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
