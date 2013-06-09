

package org.instantlogic.fabric.value.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.testset.Period;
import org.junit.Before;
import org.junit.Test;

public class AttributeValueImplTest {

	public static Date date(int year, int month, int day) {
		return new GregorianCalendar(year,month-1,day).getTime();
	}
	
	private Period period;
	
	@Before
	public void setUp() {
		period = new Period();
		period.setFrom(date(2012,1,1));
		period.setTo(date(2013,1,1));
	}
	
	@Test
	public void deductionTest() {
		assertEquals(366, period.getDaysBetween().intValue());
	}

	@Test()
	public void transactionCommitTest() {
		try (Operation operation = period.getMetadata().getCaseAdministration().startOperation()) {
			period.setTo(date(2014, 1, 1));
			operation.complete();
		}
		assertEquals(date(2014,1,1), period.getTo());
	}
	
	@Test()
	public void transactionRollbackTest() {
		try (Operation operation = period.getMetadata().getCaseAdministration().startOperation()) {
			period.setTo(date(2015, 1, 1));
			// No operation.complete() -> the operation will rollback
			assertEquals(date(2015,1,1), period.getTo());
		}
		assertEquals(date(2013,1,1), period.getTo());
	}
	
	@Test()
	public void listenerTest() {
		PrintListener listener1 = new PrintListener("Listener1", period.getDaysBetween());
		PrintListener listener2 = new PrintListener("Listener2", period.getDaysBetween());
		try {
			period.getDaysBetweenAttributeValue().addValueChangeObserver(listener1);
			period.getDaysBetweenAttributeValue().addValueChangeObserver(new PeriodsPerYearReporter());
			period.getDaysBetweenAttributeValue().addValueChangeObserver(listener2);
			
			period.setTo(date(2012,2,1));
			assertEquals(1, listener1.getNrOfUpdates());
			assertEquals(1, listener2.getNrOfUpdates());
			assertEquals(31, listener1.getLastValue());
			assertEquals(31, listener2.getLastValue());
			period.setTo(date(2012,1,1));
			fail();
		} catch(ArithmeticException expected) {
			System.out.println("ArithmeticException caught");
			assertEquals(1, listener1.getNrOfUpdates());
			assertEquals(3, listener2.getNrOfUpdates());
			assertEquals(31, listener1.getLastValue());
			assertEquals(31, listener2.getLastValue());
			period.setTo(date(2012,3,1));
			assertEquals(2, listener1.getNrOfUpdates());
			assertEquals(4, listener2.getNrOfUpdates());
			assertEquals(60, listener1.getLastValue());
			assertEquals(60, listener2.getLastValue());
		}
	}

	// Hazardous implementation which can cause an exception (division by zero)
	public static class PeriodsPerYearReporter implements ValueChangeObserver {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (event.getNewValue().hasValue()) {
				int daysBetween = (Integer) event.getNewValue().getValue();
				System.out.println("PeriodsPerYearReporter: number of days between: "+daysBetween);
				System.out.println("PeriodsPerYearReporter: periods per year: " + 365/daysBetween);
			}
		}
	}
	
	public static class PrintListener implements ValueChangeObserver {

		private String name;
		
		private Integer lastValue;
		
		private int nrOfUpdates;

		public PrintListener(String name, Integer lastValue) {
			this.name = name;
			this.lastValue = lastValue;
		}

		@Override
		public void valueChanged(ValueChangeEvent event) {
			assertEquals(lastValue, event.getOldValue().getValue());
			if (event.getNewValue().equals(event.getOldValue())) {
				fail("Same value not expected in this test");
			}
			lastValue = (Integer)event.getNewValue().getValue();
			nrOfUpdates ++;
			System.out.println(name + ": DaysBetween: "+event.getOldValue().getValue() + " -> " + event.getNewValue().getValue());
		}

		public int getLastValue() {
			return lastValue;
		}

		public int getNrOfUpdates() {
			return nrOfUpdates;
		}
	}
}
