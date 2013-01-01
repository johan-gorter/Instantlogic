package org.instantlogic.designer.deduction;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class CapitalizeFirstDeduction extends Deduction<String> {

	private Deduction<String> input;

	public CapitalizeFirstDeduction(Deduction<String> input) {
		this.input = input;
	}
	
	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		ValueAndLevel<String> inputString = input.deduct(context);
		if (!inputString.hasValue()) return ValueAndLevel.inconclusive();
		return ValueAndLevel.rule(TechnicalNameDeduction.capitalizeFirst(inputString.getValue()));
	}
}
