

package org.instantlogic.designer.deduction;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class CapitalizeFirstDeduction extends Deduction<String> {

	private Deduction<String> input;

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		ValueAndLevel<String> inputString = input.deduce(context);
		if (!inputString.hasValue()) return ValueAndLevel.inconclusive();
		return ValueAndLevel.rule(TechnicalNameDeduction.capitalizeFirst(inputString.getValue()));
	}

	public void setInput(Deduction<String> input) {
		this.input = input;
	}
	
	@Deprecated
	public void addToInputs(Deduction<String> input) {
		this.input = input;
	}
}
