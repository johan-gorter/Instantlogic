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

public class TechnicalNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		String name = getName(context);
		if (name==null) return ValueAndLevel.inconclusive();
		return ValueAndLevel.rule(makeTechnicalName(name));
	}

	public static String makeTechnicalName(String name) {
		StringBuilder sb = new StringBuilder(name);
		if (sb.length()==0) {
			return "_";
		}
		boolean nextLetterToUppercase = false;
		for (int i=0;i<sb.length();) {
			char ch = sb.charAt(i);
			if (!Character.isLetterOrDigit(ch) && ch!='_') {
				sb.delete(i, i+1);
				nextLetterToUppercase = true;
				continue;
			}
			if (nextLetterToUppercase && Character.isLetter(ch)) {
				nextLetterToUppercase = false;
				sb.setCharAt(i, Character.toUpperCase(ch));
			}
			if (i==0 && Character.isDigit(ch)) {
				sb.insert(0, '_');
				i++;
			}
			i++;
		}
		return sb.toString();
	}

	protected String getName(DeductionContext context) {
		Design design = context.getSelectedInstance(DesignEntity.INSTANCE);
		return design.getName();
	}

	public static String capitalizeFirst(String name) {
		StringBuffer result = new StringBuffer(name);
		result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
		return result.toString();
	}
}
