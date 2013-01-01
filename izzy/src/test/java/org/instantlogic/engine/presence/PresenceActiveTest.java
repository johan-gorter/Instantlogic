package org.instantlogic.engine.presence;

import static org.junit.Assert.*;

import org.instantlogic.engine.persistence.json.CasePersister;
import org.instantlogic.engine.util.TravelerProxyStub;
import org.instantlogic.fabric.util.Operation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PresenceActiveTest {

	private Presence presence;
	private Traveler user1traveler1;
	private Traveler user1traveler2;
	private Traveler user2traveler1;
	private Operation operation;
	
	@Before
	public void setUp() {
		presence = new Presence();
		user1traveler1 = presence.findOrAddTraveler(new TravelerProxyStub("user1traveler1","user1"), null);
		user1traveler2 = presence.findOrAddTraveler(new TravelerProxyStub("user1traveler2","user1"), null);
		user2traveler1 = presence.findOrAddTraveler(new TravelerProxyStub("user2traveler1","user2"), null);
		
		presence.enter(user1traveler1, "place1");
		presence.enter(user1traveler2, "place2");
		presence.enter(user2traveler1, "place1");
		
		ensureInitialTotals();

		operation = presence.getMetadata().getCaseAdministration().startOperation();
	}
	
	@After
	public void tearDown() {
		System.out.println(CasePersister.gson.toJson(presence));
		ensurePresenceConsistency();
		
		// Rollback is an awesome feature
		operation.close();
		System.out.println(CasePersister.gson.toJson(presence));
		ensurePresenceConsistency();
		ensureInitialTotals();
	}

	private void ensureInitialTotals() {
		assertEquals(2, presence.getActiveUsers().size());
		assertEquals(3, presence.getActiveTravelers().size());
		assertEquals(2, presence.getActivePlaces().size());
	}
	
	
	private void ensurePresenceConsistency() {
		for (User user : presence.getActiveUsers()) {
			assertTrue(user.getTravelers().size()>0);
		}
		for (Traveler traveler : presence.getActiveTravelers()) {
			assertNotNull(traveler.getUser());
			assertNotNull(traveler.getCurrentPlace());
		}
		for (Place place : presence.getActivePlaces()) {
			assertTrue(place.getVisitingTravelers().size()>0);
		}
	}

	@Test
	public void removeTravelerWithPlace() {
		presence.removeFromActiveTravelers(user1traveler2);
		assertEquals(2, presence.getActiveUsers().size());
		assertEquals(1, presence.getActivePlaces().size());
	}

	@Test
	public void removeTravelerWithUser() {
		presence.removeFromActiveTravelers(user2traveler1);
		assertEquals(1, presence.getActiveUsers().size());
		assertEquals(2, presence.getActivePlaces().size());
	}
}
