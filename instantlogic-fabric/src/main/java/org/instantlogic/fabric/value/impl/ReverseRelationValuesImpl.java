package org.instantlogic.fabric.value.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValueList;
import org.instantlogic.fabric.value.RelationValues;
import org.instantlogic.fabric.value.Values;
import org.instantlogic.fabric.value.WriteableAttributeValue;


public class ReverseRelationValuesImpl<I extends Instance, From extends Instance>
	extends ReadOnlyAttributeValueImpl<I, Values<From>>
	implements RelationValues<I, From>{

	private Map<From, Integer> duplicates = new HashMap<>();
	private TreeSet<From> values = new TreeSet<From>();
	private Values<From> reverseValue = new Values<From>(values);
	
	public ReverseRelationValuesImpl(I forInstance, Relation<I, Values<From>, From> relation) {
		super(forInstance, (Attribute<I, Values<From>, ? extends Object>)relation);
	}
	
	@Override
	public ValueAndLevel<Values<From>> getValueAndLevel() {
		CaseAdministration registry = forInstance.getMetadata().getCaseAdministration();
		registry.registerObservation(this);
		return ValueAndLevel.rule(reverseValue);
	}

	public void internalAddReverse(From reverseValue, Operation operation) {
		if(!this.values.add(reverseValue)) {
			addDuplicate(reverseValue);
		}
		if (operation!=null) {
			fireEvent(new ValueChangeEvent(this, ValueAndLevel.rule(this.reverseValue), MultiValueUpdateType.INSERT, reverseValue, operation), operation);
		}
	}

	private void addDuplicate(From from) {
		Integer duplicateCount = duplicates.get(from);
		if (duplicateCount==null) {
			duplicateCount = 2;
		} else {
			duplicateCount = duplicateCount+1;
		}
		duplicates.put(from, duplicateCount);
	}

	public void internalRemoveReverse(From reverseValue, Operation operation) {
		if (!removeDuplicate(reverseValue)) {
			if (!this.values.remove(reverseValue)) {
				throw new RuntimeException("Reverse value not found: "+reverseValue);
			}
		} 
		fireEvent(new ValueChangeEvent(this, ValueAndLevel.rule(this.reverseValue), MultiValueUpdateType.DELETE, reverseValue, operation), operation);
	}
	
	private boolean removeDuplicate(From from) {
		Integer duplicateCount = duplicates.get(from);
		if (duplicateCount==null) {
			return false;
		} else {
			if (duplicateCount == 2) {
				duplicates.remove(from);
			} else {
				duplicates.put(from, duplicateCount-1);
			}
			return true;
		}
	}

	@Override
	public Relation<I, Values<From>, ? extends Object> getModel() {
		return (Relation<I, Values<From>, ? extends Object>) super.getModel();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addValue(From newEntity) {
		if (newEntity==null) throw new IllegalArgumentException("addValue null");
		Relation<From,? extends Object,I> relation = ((Relation<I, Values<From>, From>)getModel()).getReverseRelation();
		// Add forInstance to the new entity
		WriteableAttributeValue value = (WriteableAttributeValue)relation.get(newEntity);
		value.setOrAdd(forInstance);
		// The statements above added newEntity to values indirectly 
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void removeValue(From oldEntity) {
		if (!values.contains(oldEntity)) throw new NoSuchElementException("oldEntity was not present in reverse values");
		if (oldEntity==null) throw new IllegalArgumentException("removeValue null");
		Relation<From,? extends Object,I> relation = ((Relation<I, Values<From>, From>)getModel()).getReverseRelation();
		// Add forInstance to the new entity
		ReadOnlyAttributeValue<From, ? extends Object> value = (ReadOnlyAttributeValue<From, ? extends Object>)relation.get(oldEntity);
		if (relation.isMultivalue()) {
			if (relation.isOrderedMultivalue()) {
				((RelationValueList)value).removeValue(forInstance);
			} else {
				((RelationValues)value).removeValue(forInstance);
			}
		} else {
			((AttributeValue<From, I>)value).setValue(null);
		}
		// The statements above removed newEntity from values 
	}

	@Override
	protected String valueToString() {
		return super.valueToString()+",reverseValue:"+reverseValue;
	}

	@Override
	public boolean isStored() {
		return true;
	}

	@Override
	public From setOrAdd(From newValue) {
		addValue(newValue);
		return null;
	}	
	
	@Override
	public void clearOrRemove(From valueToBeRemoved) {
		removeValue(valueToBeRemoved);
	}
}
