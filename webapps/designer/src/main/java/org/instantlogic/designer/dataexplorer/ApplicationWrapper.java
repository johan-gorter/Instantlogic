package org.instantlogic.designer.dataexplorer;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.PlaceTemplate;

// Wraps another application and adds the DataExplorer flows
public class ApplicationWrapper extends Application {

	private final Application delegate;

	public ApplicationWrapper(Application delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public PlaceTemplate[] getPlaceTemplates() {
		return delegate.getPlaceTemplates();
	}

	public Flow getMainFlow() {
		return delegate.getMainFlow();
	}

	public FlowEvent getStartEvent() {
		return delegate.getStartEvent();
	}
	
	public FlowEvent getLoggedInEvent() {
		return delegate.getLoggedInEvent();
	}
	
	public PlaceTemplate getStartPlace() {
		return delegate.getStartPlace();
	}
	
	public PlaceTemplate getLoggedInPlace() {
		return delegate.getLoggedInPlace();
	}
	
	public String[] getThemeNames() {
		return delegate.getThemeNames();
	}
	
	public void addCloseableResource(AutoCloseable resource) {
		delegate.addCloseableResource(resource);
	}
	
	@Override
	public void close() throws Exception {
		delegate.close();
	}

	// Injected dependency
	public void setEnvironment(ApplicationEnvironment environment, String applicationName) {
		delegate.setEnvironment(environment, applicationName);
	}
	
	
	@Override
	public Entity<? extends Instance> getCaseEntity() {
		return delegate.getCaseEntity();
	}

	@Override
	public String getName() {
		return delegate.getName();
	}
	
	@Override
	public ClassLoader getApplicationClassLoader() {
		return delegate.getApplicationClassLoader();
	}
}
