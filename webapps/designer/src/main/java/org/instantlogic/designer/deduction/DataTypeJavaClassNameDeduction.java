package org.instantlogic.designer.deduction;

import java.math.BigDecimal;
import java.util.Date;

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeJavaClassNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		Class<?> result = determinePrimitiveJavaClass(dataType);
		if (result!=null) {
			return ValueAndLevel.rule(result.getName());
		}
		if (dataType.getDataCategory() == DataCategoryDesign.entity && dataType.getEntity()!=null) {
			return ValueAndLevel.rule(dataType.getEntity().getApplication().getRootPackageName()+"."+dataType.getEntity().getTechnicalNameCapitalized());
		}
		return ValueAndLevel.inconclusive();
	}

	private Class<?> determinePrimitiveJavaClass(DataTypeDesign type) {
		DataCategoryDesign dataCategory = type.getDataCategory();
		if (dataCategory == DataCategoryDesign._boolean) {
			return Boolean.class;
		}
		if (dataCategory == DataCategoryDesign.dateTime) {
			return Date.class;
		}
		if (dataCategory == DataCategoryDesign.text) {
			return String.class;
		}
		if (dataCategory == DataCategoryDesign.number) {
			if (type.getWholeNumber()==Boolean.TRUE) return Integer.class;
			if (type.getExactRounding()==Boolean.TRUE) return BigDecimal.class;
			return Double.class;
		}
		return null;
	}
}
