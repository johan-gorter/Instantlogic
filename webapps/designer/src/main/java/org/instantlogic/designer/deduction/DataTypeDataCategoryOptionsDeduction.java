package org.instantlogic.designer.deduction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.ValueList;

public class DataTypeDataCategoryOptionsDeduction extends Deduction<ValueList<DataCategoryDesign>>{

	private static final List<DataCategoryDesign> ATTRIBUTE_OPTIONS = Arrays.asList(new DataCategoryDesign[]{
		DataCategoryDesign.text, DataCategoryDesign.number, DataCategoryDesign.dateTime, 
		DataCategoryDesign._boolean, DataCategoryDesign.custom}); 
	
	@Override
	public ValueAndLevel<ValueList<DataCategoryDesign>> execute(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.rule(new ValueList<DataCategoryDesign>(Collections.singletonList(DataCategoryDesign.entity)));
		}
		return ValueAndLevel.rule(new ValueList<DataCategoryDesign>(ATTRIBUTE_OPTIONS));
	}
}
