package org.instantlogic.designer.codegenerator.classmodel;

public class SharedPageFragmentClassModel extends AbstractClassModel {

	public ContentModel content;
	
	public ContentModel getContent() {
		return content;
	}

	public String getFullClassName() {
		return rootPackageName+".sharedpagefragment." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "PageFragment";
	}


}
