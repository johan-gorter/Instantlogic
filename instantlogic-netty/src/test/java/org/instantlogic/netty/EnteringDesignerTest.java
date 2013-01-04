/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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

		Assert.assertEquals(1, travelerProxy.getLastUpdates().size());
		
		System.out.println(new Gson().toJson(travelerProxy.getLastUpdates().get(0)));
	}
	
}
