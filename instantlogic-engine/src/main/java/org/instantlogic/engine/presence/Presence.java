

package org.instantlogic.engine.presence;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.interaction.util.TravelerInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Presence extends AbstractPresence {

	private static final Logger logger = LoggerFactory.getLogger(Presence.class);
	
	public Presence() {
		super();
	}
	
	public Place enter(Traveler traveler, String url) {
		traveler.setCurrentPlace(null);
		traveler.setFocus(null);
		if (url==null) throw new IllegalArgumentException("url");
		traveler.placeUpdated();
		for (Place place : getActivePlaces()) {
			if (place.getUrl().equals(url)) {
				traveler.setCurrentPlace(place);
				return place;
			}
		}
		Place place = new Place();
		place.setUrl(url);
		logger.debug("Activating place {}", place.getUrl());
		addToActivePlaces(place);
		traveler.setCurrentPlace(place);
		return place;
	}

	public void executeCommand(Traveler traveler, String command, String id, Object value) {
		switch (command) {
			case "login":
				String login = (String)value;
				login = login.toLowerCase();
				if (login.indexOf('@')<0) {
					login = login+"@instantlogic.org";
				}
				traveler.getTravelerInfo().setAuthenticatedUsername(login);
				traveler.setUser(findOrActivateUser((String)value));
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
		for (Traveler travelerKandidate: getActiveTravelers()) {
			if (travelerKandidate.getId().equals(travelerInfo.getTravelerId())) {
				traveler = travelerKandidate;
			}
		}
		if (traveler == null) {
			traveler = new Traveler(travelerProxy, caseManager);
			traveler.setId(travelerInfo.getTravelerId());
			addToActiveTravelers(traveler);
		}
		
		if (travelerInfo.getAuthenticatedUsername()!=null) {
			User user = null;
			if (traveler.getUser()==null || !travelerInfo.getAuthenticatedUsername().equals(traveler.getUser().getUsername())) {
				user = findOrActivateUser(travelerInfo.getAuthenticatedUsername());
				traveler.setUser(user);
			}
		} else {
			traveler.setUser(null);
		}
		return traveler;
	}

	private User findOrActivateUser(String username) {
		for (User userKandidate: getActiveUsers()) {
			if (userKandidate.getUsername().equals(username)) {
				return userKandidate;
			}
		}
		User user = new User();
		user.setUsername(username);
		addToActiveUsers(user);
		return user;
	}
}
