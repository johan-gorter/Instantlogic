package org.instantlogic.engine.manager;

import java.io.File;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.designer.dataexplorer.ApplicationWithDataExplorer;

/**
 * EngineManager that uses the designer to load (byte code) applications from
 */
public class DesignerEngineManager extends EngineManager {

	private ApplicationManager designerApplicationManager;

	public DesignerEngineManager() {
		designerApplicationManager = registerApplication(new ApplicationWithDataExplorer(DesignerApplication.INSTANCE));
	}
	
	@Override
	protected ApplicationManager doLoadApplication(File appDir, String applicationName) throws Exception {
		CaseProcessor caseProcessor = getCaseProcessor("Designer", applicationName); // This will call updateApplication
		return applicationManagers.get(applicationName);
	}
}
