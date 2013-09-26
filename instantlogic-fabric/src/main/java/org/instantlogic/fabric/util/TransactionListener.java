package org.instantlogic.fabric.util;

import java.util.List;

public interface TransactionListener {

	void transactionStarted(CaseAdministration instanceAdministration);

	void transactionPreparing(CaseAdministration instanceAdministration, List<ValueChangeEvent> events);

	void transactionCommitting(CaseAdministration instanceAdministration, List<ValueChangeEvent> events);

	void transactionCompleted(CaseAdministration instanceAdministration, boolean committed, List<ValueChangeEvent> events);
	
}
