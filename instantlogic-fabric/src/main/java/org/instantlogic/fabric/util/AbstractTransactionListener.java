package org.instantlogic.fabric.util;

import java.util.List;

public abstract class AbstractTransactionListener implements TransactionListener {

	@Override
	public void transactionStarted(CaseAdministration instanceAdministration) {
	}

	@Override
	public void transactionPreparing(CaseAdministration instanceAdministration, List<ValueChangeEvent> events) {
	}

	@Override
	public void transactionCommitting(CaseAdministration instanceAdministration, List<ValueChangeEvent> events) {
	}

	@Override
	public void transactionCompleted(CaseAdministration instanceAdministration, boolean committed, List<ValueChangeEvent> events) {
	}
}
