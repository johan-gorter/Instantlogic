package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class FirstDeduction<V> extends Deduction<V> {

	public static <V> FirstDeduction<V> create(Deduction<V>... inputs) {
		return new FirstDeduction<V>(inputs);
	}
	
	private Deduction<V>[] inputs;

	public FirstDeduction(Deduction<V>... inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public ValueAndLevel<V> deduct(DeductionContext context) {
		for(Deduction<V> input: inputs) {
			ValueAndLevel<V> result = input.deduct(context);
			if (result.isConclusive()) {
				return ValueAndLevel.rule(result.getValue());
			}
		}
		return null;
	}
}
