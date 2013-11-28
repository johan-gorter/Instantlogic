package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class PlaceTemplateClassModel extends AbstractClassModel {

	public TextModel title;
	public String flowname;
	public ContentModel content;
	public final List<String> parameters = new ArrayList<String>();

	public String getFlowname() {
		return flowname;
	}

	public ContentModel getContent() {
		return content;
	}

	public TextModel getTitle() {
		return title;
	}

	public String getFullClassName() {
		if (flowname!=null) {
			// old
			return rootPackageName+".flow." + flowname.toLowerCase() + "." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "PlaceTemplate";
		}
		return rootPackageName+".placetemplate." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "PlaceTemplate";
	}

	public List<String> getParameters() {
		return parameters;
	}
}
