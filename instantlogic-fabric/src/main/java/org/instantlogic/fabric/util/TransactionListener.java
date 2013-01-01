package org.instantlogic.fabric.util;

public interface TransactionListener {

	void transactionStarted(CaseAdministration instanceAdministration);

	void transactionPreparing(CaseAdministration instanceAdministration);

	void transactionCommitting(CaseAdministration instanceAdministration);

	void transactionCompleted(CaseAdministration instanceAdministration, boolean committed);
	
}
