package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

/**
 * Returns true if the input is not inconclusive, missing or irrelevant (which means the value is not null) 
 */
public class HasValueDeduction extends Deduction<Boolean> {

	private Deduction<? extends Object> input;

	public void setInput(Deduction<? extends Object> input) {
		this.input = input;
	}

	@Override
	protected ValueAndLevel<Boolean> execute(DeductionContext context) {
		ValueAndLevel<? extends Object> inputValue = input.deduce(context);
		return ValueAndLevel.rule(inputValue.hasValue()?Boolean.TRUE:Boolean.FALSE);
	}

	@Deprecated
	public void addToInputs(Deduction<? extends Object> d1) {
		input = d1;
	}
}
