package org.instantlogic.fabric.util;

public abstract class AbstractTransactionListener implements TransactionListener {

	@Override
	public void transactionStarted(CaseAdministration instanceAdministration) {
	}

	@Override
	public void transactionPreparing(CaseAdministration instanceAdministration) {
	}

	@Override
	public void transactionCommitting(CaseAdministration instanceAdministration) {
	}

	@Override
	public void transactionCompleted(CaseAdministration instanceAdministration, boolean committed) {
	}
}
