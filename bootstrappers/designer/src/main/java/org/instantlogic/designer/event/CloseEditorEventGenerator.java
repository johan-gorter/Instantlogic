package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class CloseEditorEventGenerator extends EventDesign {

	public static CloseEditorEventGenerator EVENT = new CloseEditorEventGenerator();
	
	private CloseEditorEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("CloseEditor");
		addToParameters(ElementDesignEntityGenerator.ENTITY);
	}
}