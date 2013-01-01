package org.instantlogic.designer.codegenerator.classmodel;

public class ValidationClassModel extends AbstractClassModel {

	public TextModel message;
	public int ruleDeductionIndex;
	
	public TextModel getMessage() {
		return message;
	}
	public int getRuleDeductionIndex() {
		return ruleDeductionIndex;
	}
}
