package org.instantlogic.designer.codegenerator.classmodel;

public class SubFlowClassModel extends AbstractClassModel {

	public String flowname;
	public String subFlowName;
	
	public String getFlowname() {
		return flowname;
	}

	public String getSubFlowName() {
		return subFlowName;
	}

	public String getFullClassName() {
		return rootPackageName+".flow." + flowname.toLowerCase() + "." + (isCustomized?"Abstract":"") + technicalNameCapitalized + "SubFlow";
	}
}
