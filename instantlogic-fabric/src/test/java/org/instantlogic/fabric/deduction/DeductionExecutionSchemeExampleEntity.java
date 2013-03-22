package org.instantlogic.fabric.deduction;

import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.testset.Period;
import org.instantlogic.testset.PeriodEntity;

//TODO: Remove
public class DeductionExecutionSchemeExampleEntity {

	private DeductionScheme<Integer> createExampleRule() {
		SelectedInstanceDeduction<Period> d0 = new SelectedInstanceDeduction<Period>();
		AttributeDeduction<Integer, Period> d1 = new AttributeDeduction<Integer, Period>();
		d1.setAttribute(PeriodEntity.daysBetween);
		d1.setInstanceDeduction(d0);
		return new DeductionScheme<Integer>(d1);
	}
	
}
