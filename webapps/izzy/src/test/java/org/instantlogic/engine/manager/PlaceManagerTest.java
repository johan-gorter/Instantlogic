package org.instantlogic.engine.manager;

import java.util.Collections;

import junit.framework.Assert;

import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.util.TravelerProxyStub;
import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IzzyApplication;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Before;
import org.junit.Test;

public class PlaceManagerTest {

	@Before
	public void setUp() {
		travelerInfo = new TravelerInfo("traveler1");
		travelerInfo.setAuthenticatedUsername("user1");
		traveler1 = new TravelerProxyStub(travelerInfo);
	}
	
	private TravelerProxyStub traveler1;
	
	protected TravelerInfo travelerInfo;
	
	@Test
	public void test() {
		ApplicationManager applicationManager = new ApplicationManager(IzzyApplication.INSTANCE);
		CaseManager case1 = applicationManager.getOrCreateCase("project1");
		case1.processMessages(traveler1, Collections.singletonList((Message)new StartMessage(null)));
		case1.sendUpdates();
		Assert.assertEquals(2, traveler1.getLastUpdates().size());
		traveler1.clearLastUpdates();
		((Project)case1.getCase()).addToIssues(new Issue());
		case1.sendUpdates();
		Assert.assertEquals(1, traveler1.getLastUpdates().size());
	}
}
