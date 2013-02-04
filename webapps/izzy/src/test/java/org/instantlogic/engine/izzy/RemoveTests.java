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

import static org.junit.Assert.assertNull;

import org.instantlogic.fabric.util.Operation;
import org.junit.Before;
import org.junit.Test;

public class RemoveTests {

	private IzzyProjectFixture fixture;
	private Operation operation;

	@Before
	public void setUp() {
		fixture = new IzzyProjectFixture();
		operation = fixture.project.getMetadata().getCaseAdministration().startOperation();
	}
	
	public void tearDown() {
		operation.close();
	}
	
	@Test
	public void removeTester() {
		fixture.project.removeFromUsers(fixture.tester);
		assertNull(fixture.issue1.getReporter());
	}

	@Test
	public void removeProgrammer() {
		fixture.project.removeFromUsers(fixture.programmer);
		assertNull(fixture.issue1.getAssignee());
		assertNull(fixture.comment1.getBy());
	}
}
