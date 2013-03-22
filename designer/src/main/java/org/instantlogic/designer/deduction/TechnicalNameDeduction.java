package org.instantlogic.designer.deduction;

import org.instantlogic.designer.Design;
import org.instantlogic.designer.entity.DesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class TechnicalNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> execute(DeductionContext context) {
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
