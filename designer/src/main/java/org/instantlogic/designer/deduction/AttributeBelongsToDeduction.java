

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.AttributeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeBelongsToDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> execute(DeductionContext context) {
		AttributeDesign attributeDesign = context.getSelectedInstance(AttributeDesignEntity.INSTANCE);
		if (attributeDesign instanceof RelationDesign) {
			return ValueAndLevel.rule(((RelationDesign)attributeDesign).getFrom());
		}
		return ValueAndLevel.rule(attributeDesign.getAttributeOf());
	}

}
