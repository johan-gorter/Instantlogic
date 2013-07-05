package org.instantlogic.fabric.deduction;


import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class IdDeduction extends Deduction<String> {

	private Deduction<? extends Instance> instance;

	public void setIdOfInstance(Deduction<? extends Instance> instance) {
		this.instance = instance;
	}

	@Override
	protected ValueAndLevel<String> execute(DeductionContext context) {
		ValueAndLevel<? extends Object> inputValue = instance.deduce(context);
		if (inputValue.isConclusive()) {
			if (inputValue.hasValue()) {
				return ValueAndLevel.rule(((Instance)inputValue.getValue()).getMetadata().getUniqueId());
			}
			return ValueAndLevel.rule(null);
		} else {
			return ValueAndLevel.inconclusive();
		}
	}
}
