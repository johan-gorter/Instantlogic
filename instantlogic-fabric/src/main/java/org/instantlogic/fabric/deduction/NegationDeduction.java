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
