package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionParameterDesign;
import org.instantlogic.designer.entity.DeductionDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DeductionParameterValuesDescriptionRuleDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		DeductionDesign deduction = context.getSelectedInstance(DeductionDesignEntity.INSTANCE);
		StringBuffer sb = new StringBuffer();
		for (DeductionParameterDesign parameter : deduction.getParameters()) {
			if (sb.length()!=0) {
				sb.append(" ");
			}
			sb.append(parameter.getValueDescription());
		}
		return ValueAndLevel.rule(sb.toString());
	}
}