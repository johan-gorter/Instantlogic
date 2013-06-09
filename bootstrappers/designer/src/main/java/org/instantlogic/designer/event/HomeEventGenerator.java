

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;

public class HomeEventGenerator extends EventDesign {

	public static HomeEventGenerator EVENT = new HomeEventGenerator();
	
	private HomeEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("Home");
	}
}
