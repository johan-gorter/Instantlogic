

package org.instantlogic.designer.event;

import org.instantlogic.designer.DesignerApplicationGenerator;
import org.instantlogic.designer.ElementDesignEntityGenerator;
import org.instantlogic.designer.EventDesign;

public class OpenEditorEventGenerator extends EventDesign {

	public static OpenEditorEventGenerator EVENT = new OpenEditorEventGenerator();
	
	private OpenEditorEventGenerator() {
		DesignerApplicationGenerator.APPLICATION.addToEvents(this);
		setName("OpenEditor");
		addToParameters(ElementDesignEntityGenerator.ENTITY);
	}
}