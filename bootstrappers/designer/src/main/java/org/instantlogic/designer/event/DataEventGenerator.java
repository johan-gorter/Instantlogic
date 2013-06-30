package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;

public class DataEventGenerator extends EventDesign {

	public static DataEventGenerator EVENT = new DataEventGenerator();
	
	private DataEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("Data");
		setIsCustomized(true);
	}

}
