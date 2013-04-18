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
