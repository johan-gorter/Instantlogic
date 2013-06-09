package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class EventClassModel extends AbstractClassModel {

	public final List<String> parameters = new ArrayList<String>();

	public List<String> getParameters() {
		return parameters;
	}

	public String getFullClassName() {
		return rootPackageName+".event."+technicalNameCapitalized +"Event";
	}
}
