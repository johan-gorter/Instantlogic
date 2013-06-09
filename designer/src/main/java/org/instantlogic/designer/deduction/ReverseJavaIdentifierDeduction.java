

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.RelationDesignEntity;
import org.instantlogic.fabric.util.DeductionContext;

public class ReverseJavaIdentifierDeduction extends JavaIdentifierDeduction {

	@Override
	protected String getTechnicalName(DeductionContext context) {
		RelationDesign relation = context.getSelectedInstance(RelationDesignEntity.INSTANCE);
		return relation.getReverseTechnicalName();
	}
}
