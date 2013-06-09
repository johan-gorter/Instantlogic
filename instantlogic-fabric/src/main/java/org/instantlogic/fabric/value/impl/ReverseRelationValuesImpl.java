package org.instantlogic.fabric.value.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.fabric.value.RelationValues;


public class ReverseRelationValuesImpl<I extends Instance, From extends Instance>
	extends ReadOnlyAttributeValueImpl<I, Multi<From>>
	implements RelationValues<I, From>{

	private List<From> values = new ArrayList<From>();
	private Multi<From> reverseValue = new Multi<From>(values);
	
	public ReverseRelationValuesImpl(I forInstance, Relation<I, Multi<From>, From> relation) {
		super(forInstance, (Attribute<I, Multi<From>, ? extends Object>)relation);
	}
	
	@Override
	public ValueAndLevel<Multi<From>> getValueAndLevel() {
		CaseAdministration registry = forInstance.getMetadata().getCaseAdministration();
		registry.registerObservation(this);
		return ValueAndLevel.rule(reverseValue);
	}

	public void internalAddReverse(From reverseValue, Operation operation) {
		this.values.add(reverseValue);
		if (operation!=null) {
			fireEvent(new ValueChangeEvent(this, ValueAndLevel.rule(this.reverseValue), MultiValueUpdateType.INSERT, this.values.size()-1, reverseValue, operation));
		}
	}

	public void internalRemoveReverse(From reverseValue, Operation operation) {
		int index = this.values.indexOf(reverseValue);
		if (index<0) {
			throw new RuntimeException("Reverse value not found: "+reverseValue);
		}
		this.values.remove(index);
		fireEvent(new ValueChangeEvent(this, ValueAndLevel.rule(this.reverseValue), MultiValueUpdateType.DELETE, index, reverseValue, operation));
	}
	
	@Override
	public Relation<I, Multi<From>, ? extends Object> getModel() {
		return (Relation<I, Multi<From>, ? extends Object>) super.getModel();
	}

	@Override
	public void insertValue(From item, int index) {
		throw new RuntimeException("Reverse relation does not allow an explicit ordening on values");
	}

	@Override
	public From removeValue(int index) {
		From result = values.get(index); 
		removeValue(result);
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addValue(From newEntity) {
		if (newEntity==null) throw new IllegalArgumentException("addValue null");
		Relation<From,? extends Object,I> relation = ((Relation<I, Multi<From>, From>)getModel()).getReverseRelation();
		// Add forInstance to the new entity
		ReadOnlyAttributeValue<From, ? extends Object> value = (ReadOnlyAttributeValue<From, ? extends Object>)relation.get(newEntity);
		if (relation.isMultivalue()) {
			((RelationValues)value).addValue(forInstance);
		} else {
			((AttributeValue<From, I>)value).setValue(forInstance);
		}
		// The statements above added newEntity to values 
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void removeValue(From oldEntity) {
		if (!values.contains(oldEntity)) throw new NoSuchElementException("oldEntity was not present in reverse values");
		if (oldEntity==null) throw new IllegalArgumentException("removeValue null");
		Relation<From,? extends Object,I> relation = ((Relation<I, Multi<From>, From>)getModel()).getReverseRelation();
		// Add forInstance to the new entity
		ReadOnlyAttributeValue<From, ? extends Object> value = (ReadOnlyAttributeValue<From, ? extends Object>)relation.get(oldEntity);
		if (relation.isMultivalue()) {
			((RelationValues)value).removeValue(forInstance);
		} else {
			((AttributeValue<From, I>)value).setValue(null);
		}
		// The statements above removed newEntity from values 
	}

	@Override
	protected String valueToString() {
		return super.valueToString()+",reverseValue:"+reverseValue;
	}	
}
