

package org.instantlogic.designer.codegenerator.classmodel;

public class PlaceClassModel extends AbstractClassModel {

	public TextModel title;
	public String flowname;
	public ContentModel content;

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
		return rootPackageName+".flow." + flowname.toLowerCase() + "." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "PlaceTemplate";
	}
}
