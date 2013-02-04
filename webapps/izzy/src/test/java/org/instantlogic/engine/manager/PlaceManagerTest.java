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
		ApplicationManager.registerApplication(IzzyApplication.INSTANCE);
		travelerInfo = new TravelerInfo("traveler1");
		travelerInfo.setAuthenticatedUsername("user1");
		traveler1 = new TravelerProxyStub(travelerInfo);
	}
	
	private TravelerProxyStub traveler1;
	
	protected TravelerInfo travelerInfo;
	
	@Test
	public void test() {
		ApplicationManager applicationManager = ApplicationManager.getManager("izzy");
		CaseManager case1 = applicationManager.getOrCreateCase("project1");
		case1.processMessages(traveler1, Collections.singletonList((Message)new StartMessage(null, null)));
		case1.sendUpdates();
		Assert.assertEquals(2, traveler1.getLastUpdates().size());
		traveler1.clearLastUpdates();
		((Project)case1.getCase()).addToIssues(new Issue());
		case1.sendUpdates();
		Assert.assertEquals(2, traveler1.getLastUpdates().size());
	}
}
