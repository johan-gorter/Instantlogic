package org.instantlogic.interaction;



/**
 * The environment is injected into the application.
 * 
 * Here are methods that are available to the application. 
 */
public interface ApplicationEnvironment {

//  TODO: Consider usefullness
//	public void addTransactionListener(TransactionListener listener);

	public void setPersistenceStrategy(PersistenceStrategy newPersistenceStrategy);

}
