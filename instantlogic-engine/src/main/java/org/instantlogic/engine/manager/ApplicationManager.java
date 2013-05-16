/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.manager;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.instantlogic.engine.message.ApplicationUpdate;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.PersistenceStrategy;
import org.instantlogic.tools.persistence.json.FileCasePersister;

public class ApplicationManager implements ApplicationEnvironment {


	private Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	private PersistenceStrategy persistenceStrategy = new FileCasePersister();
	private final EngineManager engineManager;
	
	/**
	 * Constructor
	 * @param application, the application to manage 
	 * @param engineManager, only needed to update other applications
	 */
	public ApplicationManager(Application application, EngineManager engineManager) {
		this.application = application;
		this.engineManager = engineManager;
	}
	
	public ApplicationManager(Application application) {
		this(application, null);
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, application, caseId, persistenceStrategy);
			activeCases.put(result.getCaseId(), result);
		}
		return result;
	}

	public Application getApplication() {
		return application;
	}

	// Called from the (Designer)application
	@Override
	public void updateApplication(Application updatedApplication) {
		engineManager.updateApplication(updatedApplication);
	}

	@Override
	public URL getCustomizationClassesUrl(String applicationName) {
		return engineManager.getCustomizationClassesUrl(applicationName);
	}

	@Override
	public void setPersistenceStrategy(PersistenceStrategy newPersistenceStrategy) {
		persistenceStrategy = newPersistenceStrategy;
	}

	// Some outside force updated our application, return the caseIds which should receive an applicationUpdateMessage in their queue
	public synchronized List<String> applicationUpdated(Application updatedApplication) {
		this.application = updatedApplication;
		return new ArrayList<String>(activeCases.keySet());
	}

}
