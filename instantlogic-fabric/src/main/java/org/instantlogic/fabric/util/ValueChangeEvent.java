package org.instantlogic.fabric.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValueList;
import org.instantlogic.fabric.value.ReadOnlyAttributeValues;

public class ValueChangeEvent {

	public enum MultiValueUpdateType {INSERT, DELETE}
	
	private ValueChangeEvent eventToUndo;
	private ValueChangeEvent undoEvent; // Created on demand
	private final Operation operation;
	private final ValueAndLevel<? extends Object> oldValue;
	private ValueAndLevel<? extends Object> cachedNewValue;
	private final ReadOnlyAttributeValue<?,?> attributeValue;
	private Object oldStoredValue;
	private Object newStoredValue;
	// For multivalue updates
	private MultiValueUpdateType multiValueUpdateType;
	private int index;
	private Object itemValue;
	
	// For single value attributes/relations and invalidations of multivalue attributes/relations
	public ValueChangeEvent(ReadOnlyAttributeValue<?,?> attributeValue, ValueAndLevel<? extends Object> oldValue, Object oldStoredValue, Object newStoredValue, Operation operation) {
		this.operation = operation;
		this.attributeValue = attributeValue;
		this.oldValue = oldValue;
		this.oldStoredValue = oldStoredValue;
		this.newStoredValue = newStoredValue;
	}
	
	// For updates on ordered multivalue attributes/relations
	public ValueChangeEvent(ReadOnlyAttributeValueList<?,?> attributeValue, ValueAndLevel<? extends Object> value, MultiValueUpdateType multiValueUpdateType, int index, Object itemValue, Operation operation) {
		this.operation = operation;
		this.attributeValue = attributeValue;
		this.oldValue = value;
		this.multiValueUpdateType = multiValueUpdateType;
		this.index = index;
		this.itemValue = itemValue;
	}

	// For updates on multivalue attributes/relations
	public ValueChangeEvent(ReadOnlyAttributeValues<?,?> attributeValue, ValueAndLevel<? extends Object> value, MultiValueUpdateType multiValueUpdateType, Object itemValue, Operation operation) {
		this.operation = operation;
		this.attributeValue = attributeValue;
		this.oldValue = value;
		this.multiValueUpdateType = multiValueUpdateType;
		this.itemValue = itemValue;
	}
	
	/**
	 * Creates an undo event based on a previous event
	 * @param eventToUndo Event to undo
	 */
	private ValueChangeEvent(ValueChangeEvent eventToUndo, ValueAndLevel<? extends Object> failedNewValue) {
		this.eventToUndo = eventToUndo;
		oldValue = failedNewValue;
		operation = eventToUndo.operation;
		attributeValue = eventToUndo.attributeValue;
		if (eventToUndo.isMultivalueUpdate()) {
			multiValueUpdateType = eventToUndo.multiValueUpdateType==MultiValueUpdateType.INSERT?MultiValueUpdateType.DELETE:MultiValueUpdateType.INSERT;
			index = eventToUndo.index;
			itemValue = eventToUndo.itemValue;
		} else {
			oldStoredValue = eventToUndo.newStoredValue;
			newStoredValue = eventToUndo.oldStoredValue;
		}
	}
	
	public boolean isUndoEvent() {
		return eventToUndo!=null;
	}
	
	/**
	 * @return The attribute/relation is multivalue and the value only got updated. (not invalidated)
	 */
	public boolean isMultivalueUpdate() {
		return multiValueUpdateType!=null;
	}
	
	
	public Attribute<?, ?, ?> getAttribute() {
		return attributeValue.getModel();
	}
	
	public Instance getInstance() {
		return attributeValue.getInstance();
	}
	
	/**
	 * @return The previous value, if it was ever deduced. (It usually is, because listening for updates on a value that you never retrieved is not very useful) 
	 */
	public ValueAndLevel<? extends Object> getOldValue() {
		return oldValue;
	}
	
	/**
	 * Use with caution, calling getNewValue can cause loops and inefficiencies. 
	 * Be prepared to receive a temporary value that is not consistent. In this case more events will be fired.
	 * 
	 * @return the new value
	 */
	public ValueAndLevel<? extends Object> getNewValue() {
		if (cachedNewValue == null) {
			cachedNewValue = attributeValue.getValueAndLevel(); 
		}
		return cachedNewValue;
	}

	public Object getNewStoredValue() {
		return newStoredValue;
	}

	public Object getOldStoredValue() {
		return oldStoredValue;
	}
	
	public boolean storedValueChanged() {
		return newStoredValue!=oldStoredValue || (multiValueUpdateType!=null && oldValue.getValueLevel()==ValueLevel.STORED);
	}

	public Operation getOperation() {
		return operation;
	}

	public ValueChangeEvent getUndoEvent() {
		if (undoEvent==null) {
			undoEvent = new ValueChangeEvent(this, this.cachedNewValue);
		}
		return undoEvent;
	}

	public boolean isFor(ReadOnlyAttributeValue<? extends Instance, ? extends Object> valueObserved) {
		return valueObserved == this.attributeValue;
	}

	public MultiValueUpdateType getMultiValueUpdateType() {
		return multiValueUpdateType;
	}

	public int getIndex() {
		return index;
	}

	public Object getItemValue() {
		return itemValue;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.multiValueUpdateType!=null) {
			if (this.multiValueUpdateType==MultiValueUpdateType.INSERT) {
				builder.append("insert ");
			} else {
				builder.append("remove ");
			}
			builder.append(attributeValue);
			builder.append(" ");
			builder.append(itemValue);
			builder.append(", index=").append(index);
		} else {
			if (storedValueChanged()) {
				builder.append("setStored ");
				builder.append(attributeValue);
				builder.append("=");
				builder.append(newStoredValue);
				builder.append(", was ");
				builder.append(oldStoredValue);
			} else {
				builder.append("changed, was ");
				builder.append(oldValue);
			}
		}
		return builder.toString();
	}
}
