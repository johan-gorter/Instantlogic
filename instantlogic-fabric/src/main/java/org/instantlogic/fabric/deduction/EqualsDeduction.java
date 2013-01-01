package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueLevel;

/**
 * Returns true if all inputs are equal to one another
 */
public class EqualsDeduction extends Deduction<Boolean> { 

	public static EqualsDeduction create(Deduction<?>... inputs) {
		return new EqualsDeduction(inputs);
	}
	
	private Deduction<?>[] inputs;

	public EqualsDeduction(Deduction<?>... inputs) {
		this.inputs = inputs;
	}

	@Override
	public ValueAndLevel<Boolean> deduct(DeductionContext context) {
		if (inputs.length<2) return ValueAndLevel.rule(Boolean.TRUE);
		ValueAndLevel<?> firstValue = inputs[0].deduct(context);
		if (firstValue.getValueLevel()==ValueLevel.INCONCLUSIVE || firstValue.getValueLevel()==ValueLevel.IRRELEVANT) {
			return ValueAndLevel.inconclusive();
		}
		for (int i=1;i<inputs.length;i++) {
			ValueAndLevel<?> nextValue = inputs[i].deduct(context);
			if (firstValue.getValueLevel()==ValueLevel.INCONCLUSIVE || firstValue.getValueLevel()==ValueLevel.IRRELEVANT) {
				return ValueAndLevel.inconclusive();
			}
			if (firstValue.getValue()==null && nextValue.getValue()!=null) {
				return ValueAndLevel.rule(Boolean.FALSE);
			}
			if (!firstValue.getValue().equals(nextValue.getValue())) {
				return ValueAndLevel.rule(Boolean.FALSE);
			}
		}
		return ValueAndLevel.rule(Boolean.TRUE);
	}
}
