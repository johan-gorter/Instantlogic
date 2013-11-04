package org.instantlogic.designer;

public class SharedElementDefinitionDesign extends AbstractSharedElementDefinitionDesign {

	public void init() {
	}

	public boolean isValidForCodeGeneration() {
		return hasLength(getName()); // TODO uniqueness of getTechnicalName()
	}
}
