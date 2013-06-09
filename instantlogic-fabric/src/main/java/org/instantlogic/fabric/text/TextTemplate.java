

package org.instantlogic.fabric.text;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.fabric.util.DeductionContext;

public class TextTemplate {
	
	private Map<String, TextTranslationTemplate> translations = new HashMap<String, TextTranslationTemplate>();
	
	private final TextTranslationTemplate untranslated = new TextTranslationTemplate(this);

	public TextTemplate() {
	}

	@Deprecated
	public TextTemplate(StringTemplate... stringTemplates) {
		getUntranslated().add("TODO");
	}

	public TextTranslationTemplate addTranslation(String languageCode) {
		TextTranslationTemplate result = new TextTranslationTemplate(this);
		this.translations.put(languageCode, result);
		return result;
	}

	public TextTranslationTemplate getUntranslated() {
		return untranslated;
	}
	
	public String renderText(DeductionContext context) {
		// TODO: use translations
		TextTranslationTemplate translation = untranslated;
		return translation.render(context);
	}
}
