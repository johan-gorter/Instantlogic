package org.instantlogic.interaction;

import java.net.URL;


public interface ApplicationEnvironment {

//  TODO: Consider usefullness
//	public void addTransactionListener(TransactionListener listener);
	
	public void updateApplication(Application updatedApplication);
	
	public void setPersistenceStrategy(PersistenceStrategy newPersistenceStrategy);

	// Necessary hook for the DesignerApplication
	public URL getCustomizationClassesUrl(String applicationName);
	
}
