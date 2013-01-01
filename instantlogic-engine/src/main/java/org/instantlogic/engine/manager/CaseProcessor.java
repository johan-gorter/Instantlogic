package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;

/**
 *	This class makes sure the CaseManager is only accessed by one thread at a time. 
 */
public class CaseProcessor {

	public static class QueueEntry {
		public final TravelerProxy travelerProxy; 
		public final List<Message> messages;
		public final QueueEntry previousEntry;
		
		public QueueEntry(TravelerProxy travelerProxy, List<Message> messages, QueueEntry previousEntry) {
			this.travelerProxy = travelerProxy;
			this.messages = messages;
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

	public void processMessagesAndSendUpdates(TravelerProxy travelerProxy, List<Message> messages) {
		List<QueueEntry> processEntries;
		synchronized (queueLock) {
			if (queueBeingProcessed) {
				queueHead = new QueueEntry(travelerProxy, messages, queueHead);
				return; // Another thread is doing the processing for us
			} else {
				processEntries = new ArrayList<QueueEntry>(); // Holds the incoming messages plus the queued ones
				processEntries.add(new QueueEntry(travelerProxy, messages, queueHead));
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
					caseManager.processMessages(entry.travelerProxy, entry.messages);
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
	}

	public void printCaseDiagnostics(StringBuffer sb) {
		caseManager.printCaseDiagnostics(sb);
	}
	
	public void printPresenceDiagnostics(StringBuffer sb) {
		caseManager.printPresenceDiagnostics(sb);
	}
	
}
