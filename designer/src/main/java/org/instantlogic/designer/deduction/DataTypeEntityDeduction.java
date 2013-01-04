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

import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeEntityDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute()!=null && dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.rule(((RelationDesign)dataType.getAttribute()).getTo());
		}
		if (dataType.getReverseRelation()!=null) {
			return ValueAndLevel.rule(dataType.getReverseRelation().getFrom());
		}
		if (dataType.getForEntity()!=null) {
			return ValueAndLevel.rule(dataType.getForEntity());
		}
		if (dataType.getConstantDeductionDesign()!=null) {
			Object value = dataType.getConstantDeductionDesign().getValue();
			if (value instanceof EntityDesign) {
				return ValueAndLevel.rule((EntityDesign)value);
			}
		}
		return ValueAndLevel.rule(null);
	}

}
