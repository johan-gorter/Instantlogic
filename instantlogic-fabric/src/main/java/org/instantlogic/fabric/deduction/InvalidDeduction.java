package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

/**
 * Used when the design contains an error and the generated code would not compile.
 * 
 * @param <V> The type of value to be returned
 */
public class InvalidDeduction<V> extends Deduction<V> {

	public static <V> InvalidDeduction<V> create() {
		return new InvalidDeduction<V>();
	}
	
	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		return ValueAndLevel.inconclusive();
	}
}
