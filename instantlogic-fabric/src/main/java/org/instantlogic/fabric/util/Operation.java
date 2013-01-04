/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.AttributeValues;

public class Operation {
	
	public enum OperationState {STARTED, UNDOING, COMPLETED, CLOSED}
	private final CaseAdministration caseAdministration;
	private final List<ValueChangeEvent> eventsToUndo = new ArrayList<ValueChangeEvent>();
	private final Operation partOfOperation;
	private OperationState state;
	private int recordingUndoEventsPaused;
	// Only used on the Operation root, allows for temporary listeners on the current transaction
	private List<TransactionListener> transactionListeners;

	public Operation(CaseAdministration caseAdministration, Operation partOfOperation) {
		this.caseAdministration = caseAdministration;
		this.partOfOperation = partOfOperation;
	}
	
	public void addTransactionListener(TransactionListener transactionListener) {
		if (partOfOperation!=null) {
			partOfOperation.addTransactionListener(transactionListener);
		} else {
			if (transactionListeners==null) {
				transactionListeners = new ArrayList<TransactionListener>();
			}
			transactionListeners.add(transactionListener);
		}
	}
	
	public void start() {
		state = OperationState.STARTED;
		this.caseAdministration.fireTransactionStarted();
	}

	public void complete() {
		if (state!=OperationState.STARTED) throw new IllegalStateException();
		state = OperationState.COMPLETED;
	}
	
	public boolean completed() {
		return state == OperationState.COMPLETED;
	}
	
	/**
	 * Adds an event that must be undone in case the operation does not complete.
	 * 
	 * @param event the event to undo
	 */
	public void addEventToUndo(ValueChangeEvent event) {
		if (recordingUndoEventsPaused==0) {
			this.eventsToUndo.add(event);
		}
	}
	
	public void popEventToUndo(ValueChangeEvent event) {
		if (recordingUndoEventsPaused==0) {
			ValueChangeEvent check = this.eventsToUndo.remove(eventsToUndo.size()-1);
			if (event!=check) {
				throw new RuntimeException("wrong event to pop in eventsToUndo");
			}
		}
	}
	
	public void close() {
		if (state==OperationState.STARTED) { // We were not completed, we should undo (called from a finally block)
			if (partOfOperation!=null && partOfOperation.state == OperationState.UNDOING) return; // The undo operation on our parent crashed here, we have done enough damage.
			undo();
			state=OperationState.CLOSED;
			this.caseAdministration.popCurrentOperation(partOfOperation);
		} else if (state==OperationState.COMPLETED) {
			if (partOfOperation==null) {
				boolean committed = false;
				if (transactionListeners==null) {
					transactionListeners = Collections.emptyList();
				}
				try {
					// Prepare
					for (TransactionListener transactionListener : transactionListeners) {
						transactionListener.transactionPreparing(this.caseAdministration);
					}
					this.caseAdministration.fireTransactionPreparing();
					// Commit
					for (TransactionListener transactionListener : transactionListeners) {
						transactionListener.transactionCommitting(this.caseAdministration);
					}
					this.caseAdministration.fireTransactionCommitting();
					committed = true;
				} finally {
					this.caseAdministration.popCurrentOperation(partOfOperation);
					// Completed
					for (TransactionListener transactionListener : transactionListeners) {
						transactionListener.transactionCompleted(this.caseAdministration, committed);
					}
					this.caseAdministration.fireTransactionCompleted(committed);
				}
			} else {
				for (ValueChangeEvent event: this.eventsToUndo) {
					partOfOperation.addEventToUndo(event);
				}
				this.caseAdministration.popCurrentOperation(partOfOperation);
			}
		} else {
			throw new IllegalStateException(""+state);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void undo() {
		state = OperationState.UNDOING;
		pauseRecordingUndoEvents();
		try {
			for (int i=eventsToUndo.size()-1;i>=0;i--) {
				ValueChangeEvent event = eventsToUndo.get(i);
				if (event.isMultivalueUpdate()) {
					AttributeValues attributeValues = (AttributeValues)((Attribute)event.getAttribute()).get(event.getInstance());
					if (event.getMultiValueUpdateType()==MultiValueUpdateType.INSERT) {
						attributeValues.removeValue(event.getIndex());
					}
					if (event.getMultiValueUpdateType()==MultiValueUpdateType.DELETE) {
						attributeValues.insertValue(event.getItemValue(), event.getIndex());
					}
				} else {
					AttributeValue attributeValue = (AttributeValue)((Attribute)event.getAttribute()).get(event.getInstance());
					attributeValue.setValue(event.getOldStoredValue());
				}
			}
		} finally {
			resumeRecordingUndoEvents();
		}
	}

	private void pauseRecordingUndoEvents() {
		this.recordingUndoEventsPaused ++;
	}

	private void resumeRecordingUndoEvents() {
		if (recordingUndoEventsPaused==0) throw new IllegalStateException();
		this.recordingUndoEventsPaused --;
	}
}
