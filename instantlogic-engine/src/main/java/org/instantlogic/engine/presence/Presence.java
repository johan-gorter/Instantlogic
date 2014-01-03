package org.instantlogic.engine.presence;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.util.BookmarkExtension;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.HistoryExtension;
import org.instantlogic.interaction.util.LocationInfo;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presence extends AbstractPresence {

	private static final Logger logger = LoggerFactory.getLogger(Presence.class);
	
	public Presence() {
		super();
	}
	
	public Place enter(Traveler traveler, String url) {
		if (traveler.getCurrentPlace()!=null) {
			traveler.addToHistory(traveler.getCurrentPlace().getLocation());
			if (traveler.getHistory().size()>25) {
				traveler.removeFromHistory(25);
			}
		}
		traveler.setCurrentPlace(null);
		traveler.setFocus(null);
		if (url==null) throw new IllegalArgumentException("url");
		traveler.placeUpdated();
		for (Place place : getActivePlaces()) {
			if (place.getLocation().getUrl().equals(url)) {
				traveler.setCurrentPlace(place);
				logger.debug("Entering place {}", place.getLocation().getUrl());
				return place;
			}
		}
		Place place = new Place();
		place.setLocation(new LocationInfo(url, "", null, null)); // The LocationInfo will be enriched while rendering the page
		logger.debug("Activating and entering place {}", place.getLocation().getUrl());
		addToActivePlaces(place);
		traveler.setCurrentPlace(place);
		return place;
	}

	public void executeCommand(Application application, Traveler traveler, String command, String id, Object value, Instance theCase) {
		switch (command) {
			case "login":
				String login = (String)value;
				login = login.toLowerCase();
				if (login.indexOf('@')<0) {
					login = login+"@instantlogic.org";
				}
				traveler.getTravelerInfo().setAuthenticatedUsername(login);
				traveler.setUser(findOrActivateUser((String)value));

				if (application.getLoggedInPlace()!=null) {
					FlowContext flowContext = FlowContext.create(application, null, theCase, getCaseName(), traveler.getTravelerInfo());
					FlowEventOccurrence eventOccurrence = new FlowEventOccurrence(application.getLoggedInPlace());
					while (eventOccurrence!=null) {
						eventOccurrence = flowContext.step(eventOccurrence);
					}
					traveler.getPresence().enter(traveler, flowContext.toPath());
				}
				break;
			case "logout":
				traveler.getTravelerInfo().setAuthenticatedUsername(null);
				traveler.setUser(null);
				break;
			case "setDebugVisible":
				traveler.setDebugVisible((Boolean)value);
				break;
			case "setFocus":
				traveler.setFocus((String)value);
				break;
		}
	}
	
	public Traveler findOrAddTraveler(TravelerProxy travelerProxy, CaseManager caseManager) {
		TravelerInfo travelerInfo = travelerProxy.getTravelerInfo();

		Traveler traveler = null;
		for (Traveler travelerCandidate: getActiveTravelers()) {
			if (travelerCandidate.getId().equals(travelerInfo.getTravelerId())) {
				traveler = travelerCandidate;
			}
		}
		if (traveler == null) {
			traveler = new Traveler(travelerProxy, caseManager);
			travelerInfo.registerExtension(HistoryExtension.class, traveler);
			traveler.setId(travelerInfo.getTravelerId());
			addToActiveTravelers(traveler);
		}
		
		if (travelerInfo.getAuthenticatedUsername()!=null) {
			User user = null;
			if (traveler.getUser()==null || !travelerInfo.getAuthenticatedUsername().equals(traveler.getUser().getUsername())) {
				user = findOrActivateUser(travelerInfo.getAuthenticatedUsername());
				traveler.setUser(user);
				travelerInfo.registerExtension(BookmarkExtension.class, user);
			}
		} else {
			traveler.setUser(null);
		}
		return traveler;
	}

	private User findOrActivateUser(String username) {
		for (User userCandidate: getActiveUsers()) {
			if (userCandidate.getUsername().equals(username)) {
				return userCandidate;
			}
		}
		User user = new User();
		user.setUsername(username);
		addToActiveUsers(user);
		return user;
	}
}
