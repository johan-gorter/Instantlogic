package org.instantlogic.interaction;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;


public abstract class Application {
	
	private static final String[] NO_THEMES = new String[0];

	public abstract Entity<? extends Instance> getCaseEntity();
	
	public abstract String getName();
	
	public Flow getMainFlow() {
		return null;
	}

	public FlowEvent getStartEvent() {
		return null;
	}
	
	public String[] getThemeNames() {
		return NO_THEMES;
	}
}