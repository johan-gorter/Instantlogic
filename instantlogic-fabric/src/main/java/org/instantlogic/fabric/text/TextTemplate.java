package org.instantlogic.fabric.text;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.fabric.util.DeductionContext;

public class TextTemplate {
	
	private Map<String, StringTemplate[]> translations = new HashMap<String, StringTemplate[]>();
	
	private final StringTemplate[] untranslated;
	
	public TextTemplate(StringTemplate... untranslated) {
		this.untranslated = untranslated;
	}
	
	public TextTemplate(String untranslatedConstantText) {
		this(new StringTemplate(untranslatedConstantText));
	}
	
	public TextTemplate addTranslation(String languageCode, StringTemplate... translation) {
		this.translations.put(languageCode, translation);
		return this;
	}
	
	public String renderText(DeductionContext context) {
		// TODO: use translations
		StringTemplate[] translation = untranslated;
		StringBuffer sb = new StringBuffer();
		for (StringTemplate stringTemplate : translation) {
			sb.append(stringTemplate.render(context));
		}
		return sb.toString();
	}
}
