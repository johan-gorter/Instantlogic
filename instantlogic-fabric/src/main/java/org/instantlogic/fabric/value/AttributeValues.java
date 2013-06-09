package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;


public interface AttributeValues<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValues<I, Item> {
	
	public void addValue(Item item);

	public void insertValue(Item item, int index);

	public Item removeValue(int index);

	public void removeValue(Item item);
	
	public Multi<Item> getStoredValue();
}
