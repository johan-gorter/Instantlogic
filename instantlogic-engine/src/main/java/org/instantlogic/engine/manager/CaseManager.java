package org.instantlogic.engine.manager;

import java.util.Arrays;
import java.util.List;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.ApplicationUpdate;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.presence.Presence;
import org.instantlogic.engine.presence.Traveler;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.PersistenceStrategy;
import org.instantlogic.tools.persistence.json.FileCasePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Only a single thread may access the CaseManager at the same time.
 */
public class CaseManager {

	private static final Logger logger = LoggerFactory.getLogger(CaseManager.class);
	
	private final String caseId;
	private Instance theCase;
	private Application application;
	/**
	 * Administration for users, travelers and places.
	 */
	private final Presence presence;
	private final ApplicationManager applicationManager;
	private final PersistenceStrategy persistenceStrategy;
	
	public CaseManager(ApplicationManager applicationManager, Application application, String caseId, PersistenceStrategy persistenceStrategy) {
		this.persistenceStrategy = persistenceStrategy;
		if (caseId==null) caseId = persistenceStrategy.uniqueId();
		this.caseId = caseId;
		this.applicationManager = applicationManager;
		this.presence = new Presence();
		this.presence.setApplicationName(applicationManager.getApplication().getName());
		this.presence.setCaseName(caseId);
		this.application = application;
		this.theCase = persistenceStrategy.loadOrCreate(caseId, applicationManager.getApplication().getCaseEntity().getInstanceClass(), applicationManager.getApplication());
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
					if (logger.isInfoEnabled()) {
						logger.info("Executing message {} from traveler {}", message, travelerProxy.getTravelerInfo().getTravelerId());
					}
					message.execute(application, traveler, this.presence, this.theCase);
				}
				operation.complete();
				presenceOperation.complete();
				persist(caseAdministration);
			} finally {
				operation.close();
				presenceOperation.close();
			}
		} catch (Exception e) {
			logger.error("Exception processing messages from traveler " + traveler.getId(), e);
			traveler.sendException(e, false);
		}
	}

	private void persist(CaseAdministration caseAdministration) {
		long version = caseAdministration.getVersion();
		caseAdministration.setVersion(version+1);
		persistenceStrategy.persist(this.caseId, this.theCase, (int)version, application); //TODO: provide a list of changed stored fields
	}
	
	public Instance getCase() {
		return theCase;
	}

	public ApplicationManager getApplicationManager() {
		return applicationManager;
	}
	
	public String getCaseId() {
		return caseId;
	}

	public Presence getPresence() {
		return this.presence;
	}

	public void printCaseDiagnostics(StringBuffer sb) {
		sb.append(FileCasePersister.gson.toJson(theCase));
	}

	public void printPresenceDiagnostics(StringBuffer sb) {
		sb.append(FileCasePersister.gson.toJson(presence));
	}

	public void updateApplication(ApplicationUpdate applicationUpdateMessage) {
		this.application = applicationUpdateMessage.application;
		this.theCase = applicationUpdateMessage.loadFrom(this.theCase);
		persist(this.theCase.getMetadata().getCaseAdministration());
		for (Traveler traveler: presence.getActiveTravelers()) {
			traveler.applicationUpdated();
		}
	}
}
