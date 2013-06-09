

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
