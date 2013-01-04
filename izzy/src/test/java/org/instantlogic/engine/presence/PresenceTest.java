/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.presence;

import java.util.Map;

import junit.framework.Assert;

import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.message.SubmitMessage;
import org.instantlogic.engine.util.FragmentQuery;
import org.instantlogic.engine.util.TravelerProxyStub;
import org.instantlogic.example.izzy.IzzyApplication;
import org.junit.Before;
import org.junit.Test;

public class PresenceTest {

	@Before
	public void setUp() {
		ApplicationManager.registerApplication(IzzyApplication.INSTANCE);
		tim = new TravelerProxyStub("Tim1", "Tim");
		bill = new TravelerProxyStub("Bill1", "Bill");
	}
	
	private TravelerProxyStub tim;
	private TravelerProxyStub bill;
	
	@Test
	public void test() {
		ApplicationManager applicationManager = ApplicationManager.getManager("izzy");
		CaseManager case1 = applicationManager.getOrCreateCase("PetStore");
		
		case1.processMessages(tim, new StartMessage(null, null));
		case1.sendUpdates();
		
		case1.processMessages(bill, new StartMessage(null, null));
		case1.sendUpdates();

		Map<String, Object> createIssueButton = 
			FragmentQuery.findOnly(tim.getLastPlaceUpdate().getRootFragment(), new FragmentQuery.ExactValue("text", "Create issue"));
		
		case1.processMessages(tim, new SubmitMessage(createIssueButton));
		tim.clearLastUpdates();
		bill.clearLastUpdates();
		case1.sendUpdates();
		
		Assert.assertEquals(2, tim.getLastUpdates().size()); // Moves to a new place
		Assert.assertEquals(2, bill.getLastUpdates().size()); // Dashboard updates to show the new issue + presence
	}
}
