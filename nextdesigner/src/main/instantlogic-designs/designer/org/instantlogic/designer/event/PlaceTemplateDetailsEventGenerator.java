package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.PlaceTemplateDesignEntityGenerator;

public class PlaceTemplateDetailsEventGenerator extends EventDesign {

	public static PlaceTemplateDetailsEventGenerator EVENT = new PlaceTemplateDetailsEventGenerator();
	
	private PlaceTemplateDetailsEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("PlaceTemplateDetails");
		addToParameters(PlaceTemplateDesignEntityGenerator.ENTITY);
	}
}
