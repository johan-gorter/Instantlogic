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
