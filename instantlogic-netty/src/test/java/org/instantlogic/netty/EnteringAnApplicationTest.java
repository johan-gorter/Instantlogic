package org.instantlogic.netty;

import java.util.Collections;

import junit.framework.Assert;

import org.instantlogic.engine.TestTravelerProxy;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.presence.entity.PresenceEntity;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

import com.google.gson.Gson;

public class EnteringAnApplicationTest {

	private PlaceTemplate simplePlaceTemplate = new PlaceTemplate() {
		
		@Override
		public String getName() {
			return "simple";
		}
		
		@Override
		public FragmentTemplate getRootContainer() {
			return new FragmentTemplate("id0", "Page");
		}
		
		@Override
		public String getId() {
			return "simple";
		}
	};
	
	private Application simpleApplication = new Application() {

		public PlaceTemplate[] getPlaceTemplates() {
			return new PlaceTemplate[]{simplePlaceTemplate};
		};
		
		@Override
		public Entity<? extends Instance> getCaseEntity() {
			return PresenceEntity.INSTANCE;
		}

		@Override
		public String getName() {
			return "simple";
		}
	};
	
	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(simpleApplication);
		CaseManager testCase = designerApplicationManager.getOrCreateCase("testCase");
		TravelerInfo traveler = new TravelerInfo("testUserTraveler");
		traveler.setAuthenticatedUsername("testUser");

		TestTravelerProxy travelerProxy = new TestTravelerProxy(traveler);
		testCase.processMessages(travelerProxy, Collections.singletonList((Message)new StartMessage("Welcome")));
		testCase.sendUpdates();

		Assert.assertEquals(2, travelerProxy.getLastUpdates().size());
		
		System.out.println(new Gson().toJson(travelerProxy.getLastUpdates().get(0)));
		System.out.println(new Gson().toJson(travelerProxy.getLastUpdates().get(1)));
	}
	
}
