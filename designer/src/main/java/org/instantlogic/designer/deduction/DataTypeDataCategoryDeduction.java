

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeDataCategoryDeduction extends Deduction<DataCategoryDesign> {

	@Override
	public ValueAndLevel<DataCategoryDesign> execute(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getReverseRelation()!=null || dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.rule(DataCategoryDesign.entity); // A (reverse) relation
		}
		return ValueAndLevel.inconclusive(); // Just a normal attribute
	}
}
