package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;


public interface AttributeValueList<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValueList<I, Item>, WriteableAttributeValue<I, ValueList<Item>, Item> {
	
	public void addValue(Item item);

	public void insertValue(Item item, int index);

	public Item removeValue(int index);

	public void removeValue(Item item);
	
	public ValueList<Item> getStoredValue();
}
