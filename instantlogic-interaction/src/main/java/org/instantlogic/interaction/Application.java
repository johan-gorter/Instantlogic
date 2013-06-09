package org.instantlogic.interaction;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;


public abstract class Application implements AutoCloseable {
	
	private static final String[] NO_THEMES = new String[0];

	private List<AutoCloseable> resourcesToClose = new ArrayList<AutoCloseable>();
	
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
	
	public void addCloseableResource(AutoCloseable resource) {
		resourcesToClose.add(resource);
	}
	
	@Override
	public void close() throws Exception {
		for(AutoCloseable resource : resourcesToClose) {
			resource.close();
		}
	}

	// Injected dependency
	public void setEnvironment(ApplicationEnvironment environment) {
	}
}