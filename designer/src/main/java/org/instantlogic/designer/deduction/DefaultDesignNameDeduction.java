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
