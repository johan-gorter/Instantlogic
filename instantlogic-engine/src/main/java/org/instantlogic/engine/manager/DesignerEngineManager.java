package org.instantlogic.engine.manager;

import java.io.File;

/**
 * EngineManager that uses the designer to load (byte code) applications from
 */
public class DesignerEngineManager extends EngineManager {

	@Override
	protected ApplicationManager doLoadApplication(File appDir, String applicationName) throws Exception {
		if (applicationName.equals("designer")) {
			return super.doLoadApplication(appDir, applicationName);
		} else {
			CaseProcessor caseProcessor = getCaseProcessor("designer", applicationName); // This will call updateApplication
			return applicationManagers.get(applicationName);
		}
	}
}
