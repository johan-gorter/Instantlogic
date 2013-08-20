package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface AttributeValue<I extends Instance, V extends Object> extends ReadOnlyAttributeValue<I, V>, WriteableAttributeValue<I, V, V> {
	
	public void setValue(V value);
	
}
