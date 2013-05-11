/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.ApplicationUpdate;
import org.instantlogic.engine.message.Message;

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
	
	public void processApplicationUpdate(ApplicationUpdate applicationUpdate) {
		processMessagesAndSendUpdates(null, null, applicationUpdate);
	}
	
	public void processMessagesAndSendUpdates(TravelerProxy travelerProxy, List<Message> messages) {
		processMessagesAndSendUpdates(travelerProxy, messages, null);
	}

	private void processMessagesAndSendUpdates(TravelerProxy travelerProxy, List<Message> messages, ApplicationUpdate applicationUpdate) {
		List<QueueEntry> processEntries;
		synchronized (queueLock) {
			if (queueBeingProcessed) {
				queueHead = new QueueEntry(travelerProxy, messages, applicationUpdate, queueHead);
				return; // Another thread is doing the processing for us
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
	}

	public void printCaseDiagnostics(StringBuffer sb) {
		caseManager.printCaseDiagnostics(sb);
	}
	
	public void printPresenceDiagnostics(StringBuffer sb) {
		caseManager.printPresenceDiagnostics(sb);
	}
	
}
