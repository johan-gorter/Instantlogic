package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public abstract class Deduction<V extends Object> {
	
	/**
	 * Execute the rule on the given context and return the result.
	 * @param context context
	 * @return ValueAndLevel.inconclusive() or ValueAndLevel.rule(value) 
	 */
	public abstract ValueAndLevel<V> deduct(DeductionContext context);
	
}
