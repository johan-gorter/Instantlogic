package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class IfDeduction<V> extends Deduction<V> {

	private Deduction<Boolean> condition;
	private Deduction<V> trueValue;
	private Deduction<V> falseValue;
	
	
	public void setCondition(Deduction<Boolean> condition) {
		this.condition = condition;
	}

	public void setTrueValue(Deduction<V> trueValue) {
		this.trueValue = trueValue;
	}

	public void setFalseValue(Deduction<V> falseValue) {
		this.falseValue = falseValue;
	}

	@Override
	protected ValueAndLevel<V> execute(DeductionContext context) {
		ValueAndLevel<Boolean> conditionResult = condition.execute(context);
		if (conditionResult.isConclusive()) {
			if (conditionResult.hasValue()) {
				if (conditionResult.getValue()!=Boolean.FALSE) {
					return trueValue.execute(context);
				} else {
					return falseValue.execute(context);
				}
			}
			return ValueAndLevel.rule(null);
		}
		return ValueAndLevel.inconclusive();
	}
}
