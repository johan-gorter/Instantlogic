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
	public ValueAndLevel<DataCategoryDesign> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType == DataTypeDesign._boolean) { 
			return ValueAndLevel.rule(DataCategoryDesign._boolean); // Hack until static instances are fully supported
		}
		if (dataType.getAttribute()!=null && !(dataType.getAttribute() instanceof RelationDesign)) {
			return ValueAndLevel.inconclusive(); // Just a normal attribute
		}
		if (dataType.getConstantDeductionDesign()!=null || dataType.getCustomDeductionDesign()!=null) {
			return ValueAndLevel.rule(DataCategoryDesign.custom);
		}
		return ValueAndLevel.rule(DataCategoryDesign.entity); // A (reverse) relation
	}

}
