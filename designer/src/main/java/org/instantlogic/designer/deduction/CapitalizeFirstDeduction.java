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

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class CapitalizeFirstDeduction extends Deduction<String> {

	private Deduction<String> input;

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		ValueAndLevel<String> inputString = input.deduce(context);
		if (!inputString.hasValue()) return ValueAndLevel.inconclusive();
		return ValueAndLevel.rule(TechnicalNameDeduction.capitalizeFirst(inputString.getValue()));
	}

	public void setInput(Deduction<String> input) {
		this.input = input;
	}
	
	@Deprecated
	public void addToInputs(Deduction<String> input) {
		this.input = input;
	}
}
