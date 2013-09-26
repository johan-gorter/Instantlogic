package org.instantlogic.fabric.text;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;

public class TextTranslationTemplate {
	private final List<StringTemplate> stringTemplates = new ArrayList<StringTemplate>();
	private final TextTemplate parent;
	
	public TextTranslationTemplate(TextTemplate parent) {
		this.parent = parent;
	}

	public TextTemplate getTextTemplate() {
		return parent;
	}
	
	public TextTranslationTemplate add(String constant) {
		stringTemplates.add(new StringTemplate(constant));
		return this;
	}
	
	// TODO: add overload with format
	public TextTranslationTemplate add(Deduction<? extends Object> value) {
		stringTemplates.add(new StringTemplate(value));
		return this;
	}

	public TextTranslationTemplate insert(int position, String constant) {
		stringTemplates.add(position, new StringTemplate(constant));
		return this;
	}
	
	public TextTranslationTemplate insert(int position, Deduction<? extends Object> value) {
		stringTemplates.add(position, new StringTemplate(value));
		return this;
	}

	public String render(DeductionContext context) {
		StringBuffer sb = new StringBuffer();
		for (StringTemplate stringTemplate : stringTemplates) {
			sb.append(stringTemplate.render(context));
		}
		return sb.toString();
	}
}
