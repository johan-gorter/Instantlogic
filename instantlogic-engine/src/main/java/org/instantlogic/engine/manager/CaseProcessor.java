package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.ApplicationUpdate;
import org.instantlogic.engine.message.Message;
import org.instantlogic.interaction.Application;

/**
 *	This class makes sure the CaseManager is only accessed by one thread at a time. 
 */
public class CaseProcessor {

	public static class QueueEntry {
		public final TravelerProxy travelerProxy; 
		public final List<Message> messages;
		public final ApplicationUpdate applicationUpdate;
		public final QueueEntry previousEntry;
		
		public QueueEntry(TravelerProxy travelerProxy, List<Message> messages, ApplicationUpdate applicationUpdate, QueueEntry previousEntry) {
			this.travelerProxy = travelerProxy;
			this.messages = messages;
			this.applicationUpdate = applicationUpdate;
			this.previousEntry = previousEntry;
		}
	}
	
	private volatile QueueEntry queueHead;
	private volatile boolean queueBeingProcessed;
	private final Object queueLock = new Object();
	
	private final CaseManager caseManager;
	
	public CaseProcessor(ApplicationManager applicationManager, String caseId) {
		this.caseManager = applicationManager.getOrCreateCase(caseId);
	}
	
	/**
	 * Returns the application that is currently running this case.
	 * Note: The application may be changed during application updates.
	 * @return the application.
	 */
	public Application getApplication() {
		return this.caseManager.getApplicationManager().getApplication();
	}
	
	public boolean processApplicationUpdate(ApplicationUpdate applicationUpdate) {
		return processMessagesAndSendUpdates(null, null, applicationUpdate);
	}
	
	public boolean processMessagesAndSendUpdates(TravelerProxy travelerProxy, List<Message> messages) {
		return processMessagesAndSendUpdates(travelerProxy, messages, null);
	}

	// Returns whether the message was processed synchronously.
	private boolean processMessagesAndSendUpdates(TravelerProxy travelerProxy, List<Message> messages, ApplicationUpdate applicationUpdate) {
		List<QueueEntry> processEntries;
		synchronized (queueLock) {
			if (queueBeingProcessed) {
				queueHead = new QueueEntry(travelerProxy, messages, applicationUpdate, queueHead);
				return false; // Another thread is doing the processing for us
			} else {
				processEntries = new ArrayList<QueueEntry>(); // Holds the incoming messages plus the queued ones
				processEntries.add(new QueueEntry(travelerProxy, messages, applicationUpdate, queueHead));
				QueueEntry entry = queueHead;
				while (entry!=null) {
					processEntries.add(entry);
					entry = entry.previousEntry;
				}
				queueHead = null;
				queueBeingProcessed = true;
			}
		}
		do {
			do {
				for (int i=processEntries.size()-1;i>=0;i--) {
					QueueEntry entry = processEntries.get(i);
					if (entry.applicationUpdate==null) {
						caseManager.processMessages(entry.travelerProxy, entry.messages);
					} else {
						caseManager.updateApplication(entry.applicationUpdate);
						entry.applicationUpdate.taskCompleted();
					}
				}
				processEntries.clear();
				synchronized (queueLock) {
					// Pick up new messages that arrived during the processing of previous messages.
					QueueEntry entry = queueHead;
					while (entry!=null) {
						processEntries.add(entry);
						entry = entry.previousEntry;
					}
					queueHead = null;
				}
			} while (processEntries.size()>0);
			caseManager.sendUpdates();
			synchronized (queueLock) {
				if (queueHead==null) {
					// We are done
					queueBeingProcessed = false;
				} else {
					// Pick up new messages that arrived during the sending of updates.
					QueueEntry entry = queueHead;
					while (entry!=null) {
						processEntries.add(entry);
						entry = entry.previousEntry;
					}
					queueHead = null;
				}
			}
		} while (processEntries.size()>0);
		return true;
	}

	public void printCaseDiagnostics(StringBuffer sb) {
		caseManager.printCaseDiagnostics(sb);
	}
	
	public void printPresenceDiagnostics(StringBuffer sb) {
		caseManager.printPresenceDiagnostics(sb);
	}
	
}
