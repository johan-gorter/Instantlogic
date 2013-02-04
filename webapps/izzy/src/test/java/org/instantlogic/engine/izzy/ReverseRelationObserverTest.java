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

import static org.junit.Assert.*;

import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.junit.Test;

public class ReverseRelationObserverTest {

	private int changes = 0;
	
	private ValueChangeObserver observer = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			changes++;
		}
	};

	@Test
	public void testObservation() {
		IzzyProjectFixture fixture = new IzzyProjectFixture();
		changes=0;
		fixture.tester.getAssignedIssuesRelationValue().addNextValueChangeObserver(observer);
		fixture.issue1.setAssignee(fixture.tester);
		assertEquals(1, changes);
	}
	
	@Test
	public void testRegisterObservation() {
		IzzyProjectFixture fixture = new IzzyProjectFixture();
		changes = 0;
		fixture.project.getMetadata().getCaseAdministration().startRecordingObservations();
		fixture.tester.getAssignedIssues();
		Observations observations = fixture.project.getMetadata().getCaseAdministration().stopRecordingObservations();
		assertEquals(1, observations.getValuesObserved().size());
		new ObservationsOutdatedObserver(observations, observer);
		fixture.issue1.setAssignee(fixture.tester);
		assertEquals(1, changes);
	}

}
