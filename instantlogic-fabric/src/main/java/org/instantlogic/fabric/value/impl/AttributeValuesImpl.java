package org.instantlogic.fabric.value.impl;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValues;
import org.instantlogic.fabric.value.Values;


public class AttributeValuesImpl<I extends Instance, Item extends Object> 
	extends ReadOnlyAttributeValuesImpl<I, Item>
	implements AttributeValues<I, Item>{

	private TreeSet<Item> storedValues;
	private Values<Item> storedValue;
	
	public AttributeValuesImpl(I forInstance, Attribute<I, Values<Item>, Item> model) {
		super(forInstance, model);
	}
	
	private Operation startOperation() {
		ensureStored();
		return forInstance.getMetadata().getCaseAdministration().startOperation();
	}

	private void ensureStored() {
		if (storedValues==null) {
			storedValues = new TreeSet<Item>();
			storedValue = new Values<Item>(storedValues);
		}
	}

	@Override
	public void addValue(Item item) {
		Operation operation = startOperation();
		try {
			if (!storedValues.add(item)) {
				throw new RuntimeException(toString()+" already contains "+item);
			}
			fireChange(ValueChangeEvent.MultiValueUpdateType.INSERT, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}
	
	public void clear() {
		if (storedValues!=null) {
			Operation operation = startOperation();
			try {
				Iterator<Item> iterator = storedValues.iterator();
				while (iterator.hasNext()) {
					Item item = iterator.next();
					iterator.remove();
					fireChange(ValueChangeEvent.MultiValueUpdateType.DELETE, item, operation);
				}
				operation.complete();
			} finally {
				operation.close();
			}
		}
	}
	
	@Override
	public void removeValue(Item item) {
		if (storedValues==null) throw new NoSuchElementException("Item: "+item);
		Operation operation = startOperation();
		try {
			boolean success = storedValues.remove(item);
			if (!success) {
				throw new NoSuchElementException("Item: "+item);
			}
			fireChange(ValueChangeEvent.MultiValueUpdateType.DELETE, item, operation);
			operation.complete();
		} finally {
			operation.close();
		}
	}

	
	protected void fireChange(MultiValueUpdateType type, Item item, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, getValueAndLevel(), type, item, operation);
		fireEvent(event, operation);
	}
	
	@Override
	public Values<Item> getStoredValue() {
		ensureStored();
		return storedValue;
	}
	
	@Override
	protected String valueToString() {
		return super.valueToString()+",stored:"+storedValue;
	}

	@Override
	public Item setOrAdd(Item newValue) {
		ensureStored();
		if (storedValues.contains(newValue)) {
			return newValue;
		}
		addValue(newValue);
		return null;
	}
	
	@Override
	public void clearOrRemove(Item valueToBeRemoved) {
		removeValue(valueToBeRemoved);
	}

	@Override
	public boolean isStored() {
		return true; // Rule-based multivalue is not yet implemented
	}

}
