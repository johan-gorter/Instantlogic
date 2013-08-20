package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface AttributeValues<I extends Instance, Item extends Object> extends ReadOnlyAttributeValues<I, Item>, WriteableAttributeValue<I, Values<Item>, Item> {

	public void addValue(Item item);

	public void removeValue(Item item);
	
	public Values<Item> getStoredValue();
	
}
