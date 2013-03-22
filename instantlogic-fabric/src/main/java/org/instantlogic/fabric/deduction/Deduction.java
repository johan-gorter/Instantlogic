package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public abstract class Deduction<V extends Object> {

	// Default constructor is always assumed
	
	public final ValueAndLevel<V> deduce(DeductionContext context) {
		ValueAndLevel<V> result = execute(context);
		if (result==null) throw new IllegalStateException("Deduction execution should always return a ValueAndLevel (inconclusive perhaps?)");
		return result;
	}
	
	protected abstract ValueAndLevel<V> execute(DeductionContext context);
}
