package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class DeductionModel {
	public int index;
	public String type;
	public String resultType;
	public String customization;
	public List<String> parameters = new ArrayList<String>();
	
	public int getIndex() {
		return index;
	}
	public String getType() {
		return type;
	}
	public String getResultType() {
		return resultType;
	}
	public List<String> getParameters() {
		return parameters;
	}
	public String getCustomization() {
		return customization;
	}
}
