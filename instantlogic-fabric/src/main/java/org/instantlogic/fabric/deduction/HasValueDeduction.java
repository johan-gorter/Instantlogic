package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

/**
 * Returns true if the input is not inconclusive, missing or irrelevant (which means the value is not null) 
 */
public class HasValueDeduction extends Deduction<Boolean> { // V extends I

	public static HasValueDeduction create(Deduction<? extends Object> input) {
		return new HasValueDeduction(input);
	}
	
	private Deduction<? extends Object> input;

	public HasValueDeduction(Deduction<? extends Object> input) {
		this.input = input;
	}

	@Override
	public ValueAndLevel<Boolean> deduct(DeductionContext context) {
		ValueAndLevel<? extends Object> inputValue = input.deduct(context);
		return ValueAndLevel.rule(inputValue.hasValue()?Boolean.TRUE:Boolean.FALSE);
	}
}
