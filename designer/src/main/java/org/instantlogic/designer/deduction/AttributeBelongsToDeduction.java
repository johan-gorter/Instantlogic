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

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.AttributeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeBelongsToDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> deduct(DeductionContext context) {
		AttributeDesign attributeDesign = context.getSelectedInstance(AttributeDesignEntity.INSTANCE);
		if (attributeDesign instanceof RelationDesign) {
			return ValueAndLevel.rule(((RelationDesign)attributeDesign).getFrom());
		}
		return ValueAndLevel.rule(attributeDesign.getAttributeOf());
	}

}
