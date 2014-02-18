package org.instantlogic.integrationtests.util;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.AttributeValue;

public class LoggingValueChangeObserver implements ValueChangeObserver {

	public final List<ValueChangeEvent> log = new ArrayList<>();
	
	@Override
	public void valueChanged(ValueChangeEvent event) {
		log.add(event);
	}
	
	public void reset() {
		log.clear();
	}

	public void assertEvents(AttributeValue... attributeValues) {
		Assert.assertEquals(attributeValues.length, log.size());
		for (int i=0;i<attributeValues.length;i++) {
			ValueChangeEvent event = log.get(i);
			AttributeValue testAgainst = attributeValues[i];
			Assert.assertEquals(event.getAttribute(), testAgainst.getModel());
			Assert.assertEquals(event.getInstance(), testAgainst.getInstance());
		}
	}

}
