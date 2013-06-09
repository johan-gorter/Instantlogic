

package org.instantlogic.interaction.flow;

import org.instantlogic.fabric.model.Concept;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.SubmitContext;

public abstract class FlowEvent extends Concept {

	public abstract FlowEventOccurrence createOccurrence(SubmitContext context);
	
}
