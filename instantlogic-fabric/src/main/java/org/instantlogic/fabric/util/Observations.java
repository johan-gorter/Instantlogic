

package org.instantlogic.fabric.util;

import java.util.HashSet;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;


public class Observations {

	private HashSet<ReadOnlyAttributeValue<? extends Instance, ? extends Object>> valuesObserved 
		= new HashSet<ReadOnlyAttributeValue<? extends Instance,? extends Object>>();

	public void add(ReadOnlyAttributeValue<? extends Instance, ? extends Object> attributeValueObserved) {
		valuesObserved.add(attributeValueObserved);
	}

	public int size() {
		return valuesObserved.size();
	}

	public HashSet<ReadOnlyAttributeValue<? extends Instance, ? extends Object>> getValuesObserved() {
		return valuesObserved;
	}

}
