package org.instantlogic.integrationtests.fabric;

import static org.junit.Assert.*;

import org.instantlogic.example.izzy.Project;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.integrationtests.util.LoggingValueChangeObserver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AttributeChangeEvents {

	private Project project;
	private LoggingValueChangeObserver lastIssueNumberObserver;
	
	@Before
	public void setUp() {
		lastIssueNumberObserver = new LoggingValueChangeObserver();
		project = new Project();
		project.setLastIssueNumber(100);
		project.getLastIssueNumberAttributeValue().addValueChangeObserver(lastIssueNumberObserver);
	}
	
	@After
	public void teardown() {
		project.getLastIssueNumberAttributeValue().removeValueChangeObserver(lastIssueNumberObserver);
		lastIssueNumberObserver.reset();
	}
	
	@Test
	public void testGetSet() {
		project.setLastIssueNumber(101);
		lastIssueNumberObserver.assertEvents(project.getLastIssueNumberAttributeValue());
		assertEquals(101, project.getLastIssueNumber().intValue());
	}
	
	@Test
	public void testEvents() {
		final LoggingValueChangeObserver nextObserver = new LoggingValueChangeObserver();
		final LoggingValueChangeObserver addAnotherAndRemoveSelf = new LoggingValueChangeObserver() {
			
			@Override
			public void valueChanged(ValueChangeEvent event) {
				project.getLastIssueNumberAttributeValue().addValueChangeObserver(nextObserver);
				project.getLastIssueNumberAttributeValue().removeValueChangeObserver(this);
				super.valueChanged(event);
			}
		};
		project.getLastIssueNumberAttributeValue().addValueChangeObserver(addAnotherAndRemoveSelf);
		project.setLastIssueNumber(101);
		addAnotherAndRemoveSelf.assertEvents(project.getLastIssueNumberAttributeValue());
		assertEquals(0, nextObserver.log.size());
	}
	
	public void testOrder() {
		LoggingValueChangeObserver secondObserver = new LoggingValueChangeObserver() {
			@Override
			public void valueChanged(ValueChangeEvent event) {
				super.valueChanged(event);
				lastIssueNumberObserver.assertEvents(project.getLastIssueNumberAttributeValue());
			}
		};
		project.getLastIssueNumberAttributeValue().addValueChangeObserver(secondObserver);
		project.setLastIssueNumber(101);
		secondObserver.assertEvents(project.getLastIssueNumberAttributeValue());
	}

	@Test
	public void rollback() {
		LoggingValueChangeObserver crashingObserver = new LoggingValueChangeObserver() {
			@Override
			public void valueChanged(ValueChangeEvent event) {
				super.valueChanged(event);
				new Integer(1/0);
			}
		};
		project.getLastIssueNumberAttributeValue().addValueChangeObserver(crashingObserver);
		try {
			project.setLastIssueNumber(101);
			fail();
		} catch (RuntimeException expected) {
			crashingObserver.assertEvents(project.getLastIssueNumberAttributeValue());
			lastIssueNumberObserver.assertEvents(project.getLastIssueNumberAttributeValue(), 
					project.getLastIssueNumberAttributeValue());
			ValueChangeEvent undoEvent = lastIssueNumberObserver.log.get(1);
			assertTrue(undoEvent.isUndoEvent());
			assertEquals(101, undoEvent.getOldStoredValue());
			assertEquals(100, undoEvent.getNewStoredValue());
			assertEquals(100, project.getLastIssueNumber().intValue());
		}
	}
}
