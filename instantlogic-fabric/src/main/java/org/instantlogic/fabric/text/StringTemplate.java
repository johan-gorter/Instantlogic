/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.text;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class StringTemplate {

	private final Deduction<? extends Object> deduction;
	
	private final String constant;

	// TODO: make room for another constructor which accepts a formatter string and a deduction

	public StringTemplate(Deduction<? extends Object> deduction) {
		this.deduction = deduction;
		this.constant = null;
	}

	public StringTemplate(String constant) {
		this.deduction = null;
		this.constant = constant;
	}
	
	String render(DeductionContext context) {
		if (constant!=null) {
			return constant;
		}
		ValueAndLevel<?> result =  deduction.deduce(context);
		if (result.hasValue()) {
			return result.getValue().toString();
		}
		return "";
	}
}
