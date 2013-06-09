

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.Design;
import org.instantlogic.designer.entity.DesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DefaultDesignNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		Design design = context.getSelectedInstance(DesignEntity.INSTANCE);
		String name = design.getMetadata().getEntity().getName();
		if (name.endsWith("Design")) {
			name = name.substring(0, name.length()-6);
		}
		return ValueAndLevel.rule("new "+name.toLowerCase());
	}
}
