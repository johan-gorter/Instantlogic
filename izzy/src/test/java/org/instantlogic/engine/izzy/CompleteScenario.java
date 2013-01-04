/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.izzy;

import static org.junit.Assert.assertEquals;

import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.util.TravelerProxyStub;
import org.instantlogic.example.izzy.IzzyApplication;
import org.instantlogic.example.izzy.Project;
import org.junit.Before;
import org.junit.Test;

public class CompleteScenario {

	@Before
	public void setUp() {
		ApplicationManager.registerApplication(IzzyApplication.INSTANCE);
		tim = new TravelerProxyStub("Tim1", "Tim");
	}
	
	private TravelerProxyStub tim;
	
	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(IzzyApplication.INSTANCE);
		CaseManager petstoreManager = designerApplicationManager.getOrCreateCase("petstore2");
		Project petstore = (Project)petstoreManager.getCase();

		petstoreManager.processMessages(tim, new StartMessage(null, null));
		assertEquals(1, petstore.getUsers().size());
		petstoreManager.sendUpdates();
	}

}
