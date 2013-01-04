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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Multi;


public class AttributeValuesImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValuesImpl<I, Item>
	implements AttributeValues<I, Item>{

	private List<Item> storedValues;
	private Multi<Item> storedValue;
	
	public AttributeValuesImpl(I forInstance, Attribute<I, Multi<Item>, Item> model) {
		super(forInstance, model);
	}
	
	private Operation startOperation() {
		ensureStored();
		return forInstance.getMetadata().getCaseAdministration().startOperation();
	}

	private void ensureStored() {
		if (storedValues==null) {
			storedValues = new ArrayList<Item>();
			storedValue = new Multi<Item>(storedValues);
		}
	}

	@Override
	public void addValue(Item item) {
		Operation operation = startOperation();
		try {
			storedValues.add(item);
			int index = storedValues.size()-1;
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	@Override
	public void insertValue(Item item, int index) {
		Operation operation = startOperation();
		try {
			storedValues.add(index, item);
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, index, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}

	@Override
	public Item removeValue(int index) {
		Operation operation = startOperation();
		try {
			Item item = storedValues.remove(index);
			fireChange(ValueChangeEvent.MultiValueUpdateType.DELETE, index, item, operation);
			operation.complete();
			return item;
		} finally {
			operation.close();
		}
	}
	
	@Override
	public void removeValue(Item item) {
		if (storedValues==null) throw new NoSuchElementException("Item: "+item);
		int index = storedValues.indexOf(item);
		if (index<0) throw new NoSuchElementException("Item: "+item);
		removeValue(index);
	}

	
	protected void fireChange(MultiValueUpdateType type, int index, Item item, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, getValueAndLevel(), type, index, item, operation);
		fireEvent(event);
	}
	
	@Override
	protected Multi<Item> getStoredValue() {
		ensureStored();
		return storedValue;
	}
	
	@Override
	protected String valueToString() {
		return super.valueToString()+",stored:"+storedValue;
	}	
}
