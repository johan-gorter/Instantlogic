package org.instantlogic.fabric.value;

import org.instantlogic.fabric.Instance;

public interface WriteableAttributeValue<I extends Instance, Value extends Object, Item extends Object> extends ReadOnlyAttributeValue<I, Value> {

	boolean isStored();
	
	public Value getStoredValue();
	
	/**
	 * sets or adds the new value.
	 * @param newValue
	 * @return the old value, if any.
	 */
	public Item setOrAdd(Item newValue);

	public void clearOrRemove(Item valueToBeRemoved);

}
