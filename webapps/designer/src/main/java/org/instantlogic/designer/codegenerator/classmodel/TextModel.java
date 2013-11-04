package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class TextModel {

	public static class StringTemplate
	{
		public String type;
		public String constant;
		public int deductionIndex;
		
		public String getType() {
			return type;
		}
		public String getConstant() {
			return constant;
		}
		public int getDeductionIndex() {
			return deductionIndex;
		}
	}
	
	public final List<StringTemplate> untranslated = new ArrayList<StringTemplate>();
	
	public List<StringTemplate> getUntranslated() {
		return untranslated;
	}
}
