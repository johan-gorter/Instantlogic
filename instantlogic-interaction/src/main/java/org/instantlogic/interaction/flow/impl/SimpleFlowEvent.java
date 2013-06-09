

package org.instantlogic.interaction.flow.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.util.SubmitContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;

public class SimpleFlowEvent extends FlowEvent {

	private String name;
	
	private Entity<?>[] parameterTypes;

	public SimpleFlowEvent(String name, Entity<?>... parameterTypes) {
		this.name = name;
		this.parameterTypes = parameterTypes;
	}
	
	protected Entity<?>[] getParameterTypes() {
		return parameterTypes;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public FlowEventOccurrence createOccurrence(SubmitContext context) {
		Instance[] parameters = new Instance[parameterTypes.length];
		for (int i=0;i<parameters.length;i++) {
			parameters[i]=context.getSelectedInstance(parameterTypes[i]);
		}
		return new FlowEventOccurrence(this, parameters);
	}
	
}
