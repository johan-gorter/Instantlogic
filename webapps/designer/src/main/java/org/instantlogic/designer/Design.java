package org.instantlogic.designer;

import org.instantlogic.designer.deduction.TechnicalNameDeduction;

public class Design extends AbstractDesign {

	protected static FragmentTemplateDesign createText(String fragmentTypeName, TextTemplateDesign text) {
		FragmentTemplateDesign result = new FragmentTemplateDesign();
		result.setFragmentTypeName(fragmentTypeName);
		result.setText("text", text);
		return result;
	}
	
	protected static TextTemplateDesign createConstantText(String untranslated) {
		TextTemplateDesign result = new TextTemplateDesign();
		StringTemplateDesign stringTemplateDesign = new StringTemplateDesign();
		stringTemplateDesign.setConstantText(untranslated);
		result.addToUntranslated(stringTemplateDesign);
		return result;
	}
	
	public String getTechnicalNameCapitalized() {
		return TechnicalNameDeduction.capitalizeFirst(getTechnicalName());
	}
	
	public static boolean hasLength(String text) {
		return text!=null && text.length()>0;
	}
}
