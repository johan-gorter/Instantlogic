package org.instantlogic.fabric.deduction;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class ConcatenateDeduction extends Deduction<String> {

	private List<Deduction<String>> strings = new ArrayList<Deduction<String>>();

	public void addToStrings(Deduction<String> _string) {
		strings.add(_string);
	}

	@Override
	protected ValueAndLevel<String> execute(DeductionContext context) {
		StringBuilder result = new StringBuilder();
		for (Deduction<String> _string : strings) {
			ValueAndLevel<? extends Object> stringResult = _string.execute(context);
			if (stringResult.hasValue()) {
				result.append(stringResult.getValue());
			}
		}
		return ValueAndLevel.rule(result.toString());
	}
}
