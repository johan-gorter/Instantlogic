package org.instantlogic.designer.event;

import org.instantlogic.designer.DeductionSchemeDesignEntityGenerator;
import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.EventDesign;

public class DeductionSchemeDetailsEventGenerator extends EventDesign {

	public static DeductionSchemeDetailsEventGenerator EVENT = new DeductionSchemeDetailsEventGenerator();
	
	private DeductionSchemeDetailsEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("DeductionSchemeDetails");
		addToParameters(DeductionSchemeDesignEntityGenerator.ENTITY);
	}
}
