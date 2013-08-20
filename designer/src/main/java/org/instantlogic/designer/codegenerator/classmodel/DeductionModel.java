package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class DeductionModel {
	
	public static class Input {
		public int deductionIndex;
		public String inputName;
		public boolean multivalue;

		public String getInputName() {
			return inputName;
		}

		public boolean isMultivalue() {
			return multivalue;
		}

		public int getDeductionIndex() {
			return deductionIndex;
		}
	}
	
	public static class Parameter {
		public String name;
		public String valueClass;
		public ValueModel value;

		public String getName() {
			return name;
		}

		public ValueModel getValue() {
			return value;
		}
	}
	
	public int index;
	public String type;
	public String customization;
	public List<Input> inputs = new ArrayList<Input>();
	public List<Parameter> parameters = new ArrayList<Parameter>();
	private String internalClassName;
	
	public List<Parameter> getParameters() {
		return parameters;
	}
	public int getIndex() {
		return index;
	}
	public String getType() {
		return type;
	}
	public List<Input> getInputs() {
		return inputs;
	}
	public String getCustomization() {
		return customization;
	}
	public String getInternalClassName() {
		if (internalClassName==null) {
			internalClassName = type.replace(".", "/");
		}
		return internalClassName;
	}
}
