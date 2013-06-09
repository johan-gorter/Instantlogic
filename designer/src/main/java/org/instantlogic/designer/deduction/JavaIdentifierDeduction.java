

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
