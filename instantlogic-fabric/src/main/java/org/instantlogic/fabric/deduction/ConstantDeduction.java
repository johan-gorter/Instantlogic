package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class ConstantDeduction<V> extends Deduction<V> {

	private V value;

	public ConstantDeduction() {
	}

	public ConstantDeduction(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		return ValueAndLevel.rule(value);
	}
}
