package org.instantlogic.designer;

public class EventDesign extends AbstractEventDesign {

	public EventDesign() {
	}

	public EventDesign(String name) {
		setName(name);
	}

	public boolean isValidForCodeGeneration() {
		return hasLength(getName()); // TODO uniqueness of getTechnicalName()
	}
}
