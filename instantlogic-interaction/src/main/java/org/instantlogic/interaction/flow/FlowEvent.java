package org.instantlogic.interaction.flow;

import org.instantlogic.fabric.model.Concept;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public abstract class FlowEvent extends Concept {

	public abstract Entity<?>[] getParameterTypes();
	
	public abstract FlowEventOccurrence createOccurrence(SubmitContext context);
	
}
