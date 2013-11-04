package org.instantlogic.engine.manager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.DesignerApplicationEnvironment;
import org.instantlogic.interaction.PersistenceStrategy;
import org.instantlogic.tools.persistence.json.FileCasePersister;

public class ApplicationManager implements DesignerApplicationEnvironment {


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
	public void updateApplication(Application updatedApplication, String applicationName) {
		engineManager.updateApplication(updatedApplication, applicationName);
	}

	@Override
	public URL getCustomizationClassesUrl(String applicationName) {
		return engineManager.getCustomizationClassesUrl(applicationName);
	}
	
	@Override
	public File getApplicationRoot(String caseId) {
		return engineManager.getApplicationRoot(caseId, true);
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
