package org.instantlogic.fabric.text;


import org.instantlogic.fabric.util.DeductionContext;

public class ConstantTextTemplate extends TextTemplate {

	private final String untranslated;
	
	public ConstantTextTemplate(String untranslated) {
		this.untranslated = untranslated;
	}
	
	@Override
	public String renderText(DeductionContext context) {
		return untranslated;
	}
	
	public ConstantTextTemplate addTranslation(String languageCode, String translated) {
		// TODO translations
		throw new UnsupportedOperationException();
	}

}
