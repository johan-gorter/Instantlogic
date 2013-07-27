package org.instantlogic.netty;

import java.util.Collections;

import junit.framework.Assert;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.engine.TestTravelerProxy;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.message.EnterMessage;
import org.instantlogic.engine.message.Message;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

import com.google.gson.Gson;

public class EnteringDesignerTest {

	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(DesignerApplication.INSTANCE);
		CaseManager testCase = designerApplicationManager.getOrCreateCase("testCase");
		TravelerInfo traveler = new TravelerInfo("testUserTraveler");
		traveler.setAuthenticatedUsername("testUser");

		TestTravelerProxy travelerProxy = new TestTravelerProxy(traveler);
		testCase.processMessages(travelerProxy, Collections.singletonList((Message)new EnterMessage("Welcome")));
		testCase.sendUpdates();

		Assert.assertEquals(2, travelerProxy.getLastUpdates().size());
		
		System.out.println(new Gson().toJson(travelerProxy.getLastUpdates().get(0)));
		System.out.println(new Gson().toJson(travelerProxy.getLastUpdates().get(1)));
	}
	
}
