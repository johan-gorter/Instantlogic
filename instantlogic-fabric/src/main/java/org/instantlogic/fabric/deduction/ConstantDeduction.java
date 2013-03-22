package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class ConstantDeduction<V> extends Deduction<V> {

	private ValueAndLevel<V> constant;

	public ConstantDeduction(V constant) {
		this.constant = ValueAndLevel.rule(constant);
	}

	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		return constant;
	}

	@Deprecated
	public static <X> Deduction<X> create(X x) {
		ConstantDeduction<X> result = new ConstantDeduction<X>(x);
		return result;
	}
}
