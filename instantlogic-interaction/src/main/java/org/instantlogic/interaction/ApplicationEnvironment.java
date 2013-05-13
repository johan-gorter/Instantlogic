package org.instantlogic.interaction;

import org.instantlogic.fabric.util.TransactionListener;

public interface ApplicationEnvironment {

	public void addTransactionListener(TransactionListener listener);
	
	public void updateApplication(Application updatedApplication);
	
	public void setPersistenceStrategy(PersistenceStrategy newPersistenceStrategy);
	
}
