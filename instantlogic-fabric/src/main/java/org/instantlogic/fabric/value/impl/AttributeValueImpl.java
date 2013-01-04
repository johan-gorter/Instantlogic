/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.value.impl;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.AttributeValue;


public class AttributeValueImpl<I extends Instance, Value extends Object> 
	extends ReadOnlyAttributeValueImpl<I, Value> 
	implements AttributeValue<I, Value>{
	
	private Value storedValue;
	
	public AttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		super(forInstance, model);
	}

	@Override
	public void setValue(Value value) {
		// Note: If the current value is based on a rule, the new value is still stored, but it is not visible. 
		if (value==storedValue) return;
		Operation operation = forInstance.getMetadata().getCaseAdministration().startOperation();
		try {
			Value oldStoredValue = storedValue;
			ValueAndLevel<Value> oldValue = invalidateCachedValue();
			storedValue = value;
			fireValueChanged(oldValue, oldStoredValue, value, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	@Override
	public Value getStoredValue() {
		return storedValue;
	}
	
	/**
	 * For internal use only. Does not invalidate the cached value.
	 */
	@Override
	protected void setStoredValue(Value newStoredValue) {
		storedValue = newStoredValue;
	}

	public boolean isStored() {
		return storedValue!=null;
	}
	
	@Override
	protected String valueToString() {
		return super.valueToString()+",stored:"+storedValue;
	}
}
