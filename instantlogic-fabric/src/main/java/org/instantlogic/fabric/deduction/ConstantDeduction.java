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
