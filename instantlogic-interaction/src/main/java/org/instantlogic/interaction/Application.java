/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.interaction;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEvent;
import org.instantlogic.interaction.flow.impl.SimpleFlow;


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