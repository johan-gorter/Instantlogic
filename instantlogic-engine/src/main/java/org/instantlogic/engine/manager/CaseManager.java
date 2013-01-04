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

import java.util.Arrays;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.persistence.json.CasePersister;
import org.instantlogic.engine.persistence.json.FileCasePersister;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.CaseInstanceTriggers;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Only a single thread accesses the CaseManager at the same time.
 */
public class CaseManager {

	private static final Logger logger = LoggerFactory.getLogger(CaseManager.class);
	
	private final String caseId;
	private final Instance theCase;
	/**
	 * Administration for users, travelers and places.
	 */
	private final Presence presence;
	private final ApplicationManager application;
	
	public CaseManager(ApplicationManager application, String caseId) {
		if (caseId==null) caseId = FileCasePersister.uniqueId();
		this.caseId = caseId;
		this.application = application;
		this.presence = new Presence();
		this.presence.setApplicationName(application.getApplication().getName());
		this.presence.setCaseName(caseId);
		this.theCase = FileCasePersister.INSTANCE.loadOrCreate(caseId, application.getApplication().getCaseEntity().getInstanceClass());
	}

	public void sendUpdates() {
		// Render the places (this may update the place titles needed for rendering the presence)
		for (Traveler traveler: presence.getActiveTravelers()) {
			try {
				traveler.queuePlaceIfNeeded();
			} catch (Exception e) {
				logger.error("Exception sending updates to traveler " + traveler.getId(), e);
				traveler.sendException(e, true);
			}
		}
		// Render the presence and send
		for (Traveler traveler: presence.getActiveTravelers()) {
			try {
				traveler.queuePresenceIfNeeded();
			} catch (Exception e) {
				logger.error("Exception sending presence to traveler " + traveler.getId(), e);
				traveler.sendException(e, true);
			}
			traveler.sendQueuedUpdates();
		}
	}
	
	public void processMessages(TravelerProxy travelerProxy, Message... messages) {
		processMessages(travelerProxy, Arrays.asList(messages));
	}
	
	public void processMessages(TravelerProxy travelerProxy, List<Message> messages) {
		CaseAdministration caseAdministration = this.theCase.getMetadata().getCaseAdministration();
		CaseAdministration presenceCaseAdministration = presence.getMetadata().getCaseAdministration();
		Traveler traveler = presence.findOrAddTraveler(travelerProxy, this);
		try {
			Operation operation = caseAdministration.startOperation();
			Operation presenceOperation = presenceCaseAdministration.startOperation();
			try {
				for (Message message:messages) {
					message.execute(application.getApplication(), traveler, this.presence, this.theCase);
				}
				operation.complete();
				presenceOperation.complete();
				long version = caseAdministration.getVersion();
				caseAdministration.setVersion(version+1);
				FileCasePersister.INSTANCE.persist(this.caseId, this.theCase, (int)version);
				if (this.theCase instanceof CaseInstanceTriggers) {
					((CaseInstanceTriggers)this.theCase).afterPersist();
				}
			} finally {
				operation.close();
				presenceOperation.close();
			}
		} catch (Exception e) {
			logger.error("Exception processing messages from traveler " + traveler.getId(), e);
			traveler.sendException(e, false);
		}
	}
	
	public Instance getCase() {
		return theCase;
	}

	public ApplicationManager getApplicationManager() {
		return application;
	}
	
	public String getCaseId() {
		return caseId;
	}

	public Presence getPresence() {
		return this.presence;
	}

	public void printCaseDiagnostics(StringBuffer sb) {
		sb.append(CasePersister.gson.toJson(theCase));
	}

	public void printPresenceDiagnostics(StringBuffer sb) {
		sb.append(CasePersister.gson.toJson(presence));
	}

}
