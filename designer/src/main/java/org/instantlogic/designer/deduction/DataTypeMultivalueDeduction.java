

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeMultivalueDeduction extends Deduction<Boolean> {

	@Override
	public ValueAndLevel<Boolean> execute(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getReverseRelation()!=null) {
			return ValueAndLevel.rule(dataType.getReverseRelation().getReverseMultivalue());
		}
		return ValueAndLevel.inconclusive();
	}
}
