package org.instantlogic.designer.deduction;

import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.RelationDesignEntity;
import org.instantlogic.fabric.util.DeductionContext;

public class ReverseTechnicalNameDeduction extends TechnicalNameDeduction {

	@Override
	protected String getName(DeductionContext context) {
		RelationDesign relation = context.getSelectedInstance(RelationDesignEntity.INSTANCE);
		return relation.getReverseName();
	}
}
