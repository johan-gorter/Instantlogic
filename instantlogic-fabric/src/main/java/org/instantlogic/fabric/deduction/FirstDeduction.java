package org.instantlogic.fabric.deduction;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class FirstDeduction<V> extends Deduction<V> {

	private List<Deduction<? extends V>> candidates = new ArrayList<Deduction<? extends V>>();
	
	public void addToCandidates(Deduction<? extends V> candidate) {
		candidates.add(candidate);
	}
	
	@Override
	public ValueAndLevel<V> execute(DeductionContext context) {
		for(Deduction<? extends V> candidate: candidates) {
			ValueAndLevel<? extends V> result = candidate.deduce(context);
			if (result.isConclusive()) {
				return ValueAndLevel.rule((V)result.getValue());
			}
		}
		return ValueAndLevel.inconclusive();
	}
}
