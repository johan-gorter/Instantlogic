package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DeductionParameterDesign;
import org.instantlogic.designer.entity.DeductionParameterDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

import com.google.gson.Gson;

public class DeductionParameterValueDescriptionRuleDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		DeductionParameterDesign parameter = context.getSelectedInstance(DeductionParameterDesignEntity.INSTANCE);
		if (parameter.getStaticInstanceValue()!=null) {
			return ValueAndLevel.rule(parameter.getStaticInstanceValue().getName());
		}
		if (parameter.getAttributeValue()!=null) {
			return ValueAndLevel.rule(parameter.getAttributeValue().getName());
		}
		if (parameter.getEntityValue()!=null) {
			return ValueAndLevel.rule(parameter.getEntityValue().getName());
		}
		if (parameter.getValue()!=null) {
			return ValueAndLevel.rule(new Gson().toJson(parameter.getValue()));
		}
		return ValueAndLevel.inconclusive();
	}
}