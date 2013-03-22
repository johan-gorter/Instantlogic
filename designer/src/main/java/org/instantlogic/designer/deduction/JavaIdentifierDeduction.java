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

import org.instantlogic.designer.Design;
import org.instantlogic.designer.entity.DesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class JavaIdentifierDeduction extends Deduction<String> {

	public static final String[] RESERVED_WORDS = new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
	
	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
		String result = getTechnicalName(context);
		if (result==null) return ValueAndLevel.inconclusive();
		if (Arrays.binarySearch(RESERVED_WORDS, result)>=0) {
			return ValueAndLevel.rule("_"+result);
		}
		return ValueAndLevel.rule(result);
	}
	
	protected String getTechnicalName(DeductionContext context) {
		Design design = context.getSelectedInstance(DesignEntity.INSTANCE);
		return design.getTechnicalName();
	}
}
