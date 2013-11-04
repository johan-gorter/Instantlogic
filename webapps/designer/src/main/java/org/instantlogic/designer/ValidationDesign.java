package org.instantlogic.designer;

public class ValidationDesign extends AbstractValidationDesign {

	@Override
	public String getName() {
		return getForEntity().getName()+getMetadata().getUniqueId();
	}

	public boolean isValidForCodeGeneration() {
		return true;
	}
}
