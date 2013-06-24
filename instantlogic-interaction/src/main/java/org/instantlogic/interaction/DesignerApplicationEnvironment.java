package org.instantlogic.interaction;

import java.net.URL;

public interface DesignerApplicationEnvironment extends ApplicationEnvironment {

	public URL getCustomizationClassesUrl(String applicationName);
	
	public void updateApplication(Application updatedApplication);
	

}
