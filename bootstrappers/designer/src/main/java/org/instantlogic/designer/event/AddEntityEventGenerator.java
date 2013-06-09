package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;

public class AddEntityEventGenerator extends EventDesign {

	public static AddEntityEventGenerator EVENT = new AddEntityEventGenerator();
	
	private AddEntityEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("AddEntity");
	}
}