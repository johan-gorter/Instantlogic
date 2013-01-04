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

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.ConstantDeductionDesign;
import org.instantlogic.designer.CustomDeductionDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.EqualsDeductionDesign;
import org.instantlogic.designer.HasValueDeductionDesign;
import org.instantlogic.designer.NegationDeductionDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.entity.DeductionDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DeductionDataTypeDeduction extends Deduction<DataTypeDesign> {

	@Override
	public ValueAndLevel<DataTypeDesign> deduct(DeductionContext context) {
		DeductionDesign deductionDesign = context.getSelectedInstance(DeductionDesignEntity.INSTANCE);
		if (deductionDesign instanceof AttributeDeductionDesign) {
			return ValueAndLevel.rule(((AttributeDeductionDesign)deductionDesign).getAttribute().getDataType());
		}
		if (deductionDesign instanceof ReverseRelationDeductionDesign) {
			return ValueAndLevel.rule(((ReverseRelationDeductionDesign)deductionDesign).getRelation().getReverseDataType());
		}
		if (deductionDesign instanceof SelectedInstanceDeductionDesign) {
			return ValueAndLevel.rule(((SelectedInstanceDeductionDesign)deductionDesign).getOfEntity().getDataType());
		}
		if (deductionDesign instanceof ConstantDeductionDesign) {
			return ValueAndLevel.rule(((ConstantDeductionDesign)deductionDesign).getConstantDataType());
		}
		if (deductionDesign instanceof CustomDeductionDesign) {
			return ValueAndLevel.rule(((CustomDeductionDesign)deductionDesign).getCustomDataType());
		}
		if (deductionDesign instanceof HasValueDeductionDesign 
				|| deductionDesign instanceof NegationDeductionDesign
				|| deductionDesign instanceof EqualsDeductionDesign) {
			return ValueAndLevel.rule(DataTypeDesign._boolean);
		}
		if (deductionDesign instanceof CastInstanceDeductionDesign) {
			return ValueAndLevel.rule(((CastInstanceDeductionDesign)deductionDesign).getToEntity().getDataType());
		}
		return ValueAndLevel.inconclusive();
	}
}
