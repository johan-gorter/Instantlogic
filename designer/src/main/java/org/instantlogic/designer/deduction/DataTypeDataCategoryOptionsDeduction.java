/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
import org.instantlogic.fabric.value.Multi;

public class DataTypeDataCategoryOptionsDeduction extends Deduction<Multi<DataCategoryDesign>>{

	private static final List<DataCategoryDesign> ATTRIBUTE_OPTIONS = Arrays.asList(new DataCategoryDesign[]{
		DataCategoryDesign.text, DataCategoryDesign.number, DataCategoryDesign.dateTime, 
		DataCategoryDesign._boolean, DataCategoryDesign.custom}); 
	
	@Override
	public ValueAndLevel<Multi<DataCategoryDesign>> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.rule(new Multi<DataCategoryDesign>(Collections.singletonList(DataCategoryDesign.entity)));
		}
		return ValueAndLevel.rule(new Multi<DataCategoryDesign>(ATTRIBUTE_OPTIONS));
	}
}
