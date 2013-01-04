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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.Operation;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.util.ValueLevel;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class ReadOnlyAttributeValueImpl<I extends Instance, Value extends Object> implements ReadOnlyAttributeValue<I, Value> {

	// While debugging it is convenient that these properties are not immediately visible
	public class Metadata {
		protected final Attribute<I, Value, ? extends Object> model;

		transient ArrayList<ValueChangeObserver> valueChangeObservers = new ArrayList<ValueChangeObserver>(); 
		// When this value is the same as globalValueChangeListeners, copy globalValueChangeListeners on write and clear this field.
		transient ArrayList<ValueChangeObserver> iteratingValueChangeObservers = null; 
		transient ArrayList<ValueChangeObserver> nextValueChangeObservers = new ArrayList<ValueChangeObserver>(); 
		transient boolean iteratingNextValueChangeObservers = false;
		private transient ObservationsOutdatedObserver basedOn;
		
		public Metadata(Attribute<I, Value, ? extends Object> model) {
			if (model==null) throw new IllegalArgumentException("model cannot be null");
			this.model = model;
		}
	}
	
	private final Metadata metadata;
	
	protected final I forInstance;
	
	private transient ValueAndLevel<Value> cached;
	
	private ValueChangeObserver valueChangeListener = new ValueChangeObserver() {

		@Override
		public void valueChanged(ValueChangeEvent event) {
			ValueAndLevel<Value> oldCached = cached;
			ObservationsOutdatedObserver oldBasedOn = metadata.basedOn;
			cached = null;
			metadata.basedOn = null;
			boolean success = false;
			try {
				fireValueChanged(oldCached, getStoredValue(), getStoredValue(), event.getOperation());
				success = true;
			} finally {
				if (!success) {
					// Rollback everything
					if (metadata.basedOn!=null) {
						metadata.basedOn.remove();
					}
					metadata.basedOn = oldBasedOn;
					cached = oldCached;
				}
			}
		}
	};
	
	public ReadOnlyAttributeValueImpl(I forInstance, Attribute<I, Value, ? extends Object> model) {
		this.forInstance = forInstance;
		this.metadata = new Metadata(model);
	}
	
	public Attribute<I, Value, ? extends Object> getModel() {
		return metadata.model;
	}
	
	/**
	 * For subclasses
	 * @return The value previously cached
	 */
	protected ValueAndLevel<Value> invalidateCachedValue() {
		ValueAndLevel<Value> result = cached;
		if (metadata.basedOn!=null) {
			metadata.basedOn.remove();
			metadata.basedOn = null;
		}
		cached = null;
		return result;
	}
	
	@Deprecated
	public Value get() {
		return getValue();
	}
	
	public final Value getValue() {
		return getValueAndLevel().getValue();
	}

	@Override
	public ValueAndLevel<Value> getValueAndLevel() {
		CaseAdministration registry = forInstance.getMetadata().getCaseAdministration();
		registry.registerObservation(this);
		ensureCached(registry);
		return cached;
	}
	
	private void ensureCached(CaseAdministration registry) {
		if (cached==null) {
			registry.startRecordingObservations();
			calculateValue();
			Observations observations = registry.stopRecordingObservations();
			if (observations.size()>0) {
				metadata.basedOn = new ObservationsOutdatedObserver(observations, valueChangeListener);
			}
		}
	}
	
	// The logic for determining the value
	private void calculateValue() {
		Attribute<I, Value, ? extends Object> attribute = getModel();
		SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(forInstance);
		//Relevance
		Deduction<Boolean> relevance = attribute.getRelevance();
		if (relevance!=null) {
			ValueAndLevel<Boolean> relevanceValue = relevance.deduct(context);
			if (relevanceValue.getValue()!=Boolean.TRUE) {
				cached = ValueAndLevel.irrelevant();
				return;
			}
		}
		//Rule
		Deduction<Value> ruleDeduction = attribute.getRule();
		if (ruleDeduction!=null) {
			ValueAndLevel<Value> result = ruleDeduction.deduct(context);
			if (result.isConclusive()) {
				cached = ValueAndLevel.rule(result.getValue());
				return;
			}
		}
		//Stored value
		if (getStoredValue()!=null) {
			cached = ValueAndLevel.stored(getStoredValue());
			return;
		}
		//Default
		Deduction<Value> defaultDeduction = attribute.getDefault();
		if (defaultDeduction!=null) {
			ValueAndLevel<Value> defaultValue = defaultDeduction.deduct(context);
			if (defaultValue.isConclusive()) {
				cached = ValueAndLevel.def(defaultValue.getValue());
				return;
			}
		}
		cached = ValueAndLevel.inconclusive();
	}
	
	protected void fireValueChanged(ValueAndLevel<Value> oldValue, Value oldStoredValue, Value newStoredValue, Operation operation) {
		ValueChangeEvent event = new ValueChangeEvent(this, oldValue, oldStoredValue, newStoredValue, operation);
		fireEvent(event);
	}
	
	/**
	 * Takes extra care to undo pending changes when exceptions occur
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void fireEvent(ValueChangeEvent event) {
		boolean clearIteratingOnExit = false;
		int lastInformedNextIndex = metadata.nextValueChangeObservers.size();
		boolean success = false;
		boolean instanceInformed = false;
		boolean undoEventRecorded = false;
		List<ValueChangeObserver> iterating = null;
		ListIterator<ValueChangeObserver> iterator = null;
		boolean postponeRecordUndo = event.storedValueChanged() && event.getAttribute() instanceof Relation && ((Relation)event.getAttribute()).isOwner(); // Undo event must be recorded after case-split 
		try {
			if (event.storedValueChanged() && !postponeRecordUndo) {
				event.getOperation().addEventToUndo(event);
				undoEventRecorded = true;
			}
			// Reverse relations and such
			beforeFiringChange(event);
			// Record for undo
			if (event.storedValueChanged() && postponeRecordUndo) {
				event.getOperation().addEventToUndo(event);
				undoEventRecorded = true;
			}
			// NextValueChangeObservers
			metadata.iteratingNextValueChangeObservers = true;
			lastInformedNextIndex = metadata.nextValueChangeObservers.size(); // observers may have changed since beforeFiringChange
			while (lastInformedNextIndex>0) {
				ValueChangeObserver observer = metadata.nextValueChangeObservers.get(lastInformedNextIndex-1);
				if (observer!=null) {
					observer.valueChanged(event);
				}
				lastInformedNextIndex--;
				metadata.nextValueChangeObservers.remove(lastInformedNextIndex);
			}
			// ValueChangeObservers
			if (metadata.iteratingValueChangeObservers != metadata.valueChangeObservers) {
				metadata.iteratingValueChangeObservers = metadata.valueChangeObservers;
				clearIteratingOnExit = true;
			}
			iterating = metadata.iteratingValueChangeObservers;
			iterator = iterating.listIterator(iterating.size());
			while (iterator.hasPrevious()) {
				ValueChangeObserver listener = iterator.previous();
				listener.valueChanged(event);
			}
			// Observers on the Instance and Instances above
			instanceInformed = true;
			forInstance.getMetadata().fireValueChanged(event, true);
			success = true;
		} finally {
			if (success) {
				if (clearIteratingOnExit && metadata.iteratingValueChangeObservers == iterating) {
					metadata.iteratingValueChangeObservers = null;
				}
				metadata.iteratingNextValueChangeObservers = false;
			} else {
				// The rollback procedure
				try {
					ValueChangeEvent undoEvent = event.getUndoEvent();
					cached = (ValueAndLevel<Value>) event.getOldValue();
					if (event.getOldStoredValue()!=null) {
						setStoredValue((Value) event.getOldStoredValue());
					}
					
					// Observers on the Instance
					if (instanceInformed) {
						forInstance.getMetadata().fireValueChanged(undoEvent, true);
					}
					// ValueChangeObservers
					if (iterator!=null) {
						if (iterator.hasNext()) {
							if (!instanceInformed) {
								iterator.next(); // Do not reinform the observer that crashed
							}
							while (iterator.hasNext()) {
								iterator.next().valueChanged(undoEvent);
							}
						}
					}
					// Newly added nextValueChangeObservers
					int lastMisinfomedIndex = metadata.nextValueChangeObservers.size()-1;
					while (lastInformedNextIndex <= lastMisinfomedIndex) {
						ValueChangeObserver observer = metadata.nextValueChangeObservers.get(lastInformedNextIndex);
						if (observer!=null) {
							observer.valueChanged(undoEvent);
						}
						metadata.nextValueChangeObservers.remove(lastInformedNextIndex);
						lastMisinfomedIndex--;
					}
					if (undoEventRecorded) {
						event.getOperation().popEventToUndo(event);
					}
				} finally {
					if (clearIteratingOnExit && metadata.iteratingValueChangeObservers == iterating) {
						metadata.iteratingValueChangeObservers = null;
					}
					metadata.iteratingNextValueChangeObservers = false;
				}
			}
		}
	}

	/**
	 * Can be overridden by subclasses to change reverse relation for example.
	 * Will be called before all changes fire, but after the value has been set
	 * @param event
	 */
	protected void beforeFiringChange(ValueChangeEvent event) {
	}

	@Override
	public boolean hasStoredValue() {
		return getStoredValue()!=null;
	}
	
	protected Value getStoredValue() {
		return null;
	}

	protected void setStoredValue(Value newStoredValue) {
		throw new RuntimeException("Only implemented in subclass");
	}
	
	private void copyGlobalValueChangeListenersIfNeeded() {
		if (metadata.iteratingValueChangeObservers==metadata.valueChangeObservers) {
			metadata.valueChangeObservers = new ArrayList<ValueChangeObserver>(metadata.valueChangeObservers);
		}
	}
	
	
	@Override
	public void addValueChangeObserver(ValueChangeObserver observer) {
		// This statement usually does nothing. The value is normally already deduced. Listening to changes on an unknown value is rarely useful.
		ensureCached(forInstance.getMetadata().getCaseAdministration());
		copyGlobalValueChangeListenersIfNeeded();
		metadata.valueChangeObservers.add(observer);
	}

	@Override
	public void removeValueChangeObserver(ValueChangeObserver observer) {
		copyGlobalValueChangeListenersIfNeeded();
		Iterator<ValueChangeObserver> iterator = this.metadata.valueChangeObservers.iterator();
		while (iterator.hasNext()) {
			ValueChangeObserver entry = iterator.next();
			if (entry==observer) {
				iterator.remove();
				return;
			}
		}
		throw new NoSuchElementException();
	}
	
	@Override
	public void addNextValueChangeObserver(ValueChangeObserver observer) {
		metadata.nextValueChangeObservers.add(observer);
	}

	@Override
	public void removeNextValueChangeObserver(ValueChangeObserver observer) {
		if (metadata.iteratingNextValueChangeObservers) {
			// We need to be careful
			int index = metadata.nextValueChangeObservers.indexOf(observer);
			if (index<0) throw new NoSuchElementException();
			metadata.nextValueChangeObservers.set(index, null);
		} else {
			if (!metadata.nextValueChangeObservers.remove(observer)) throw new NoSuchElementException(observer.toString());
		}
	}
	
	@Override
	public I getInstance() {
		return forInstance;
	}
	
	@Override
	public String toString() {
		return this.forInstance.toString()+"."+this.metadata.model.toString()+"="+valueToString();
	}
	
	protected String valueToString() {
		if (cached==null) {
			return "stale";
		} else if (cached.getValueLevel()==ValueLevel.INCONCLUSIVE) {
			return "inconclusive";
		} else if (cached.getValueLevel()==ValueLevel.RULE) {
			return "rule:"+cached.getValue();
		} else if (cached.getValueLevel()==ValueLevel.IRRELEVANT) {
			return "irrelevant";
		} else if (cached.getValueLevel()==ValueLevel.DEFAULT) {
			return "default:"+cached.getValue();
		} else if (cached.getValueLevel()==ValueLevel.STORED) {
			return "stored:"+cached.getValue();
		}
		return "";
	}

	@Override
	public int hashCode() {
		return forInstance.getMetadata().getInstanceLocalId().hashCode()+metadata.model.getName().hashCode();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object other) {
		if (other==null || other.getClass()!=getClass()) return false;
		ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object> o = 
			(ReadOnlyAttributeValueImpl<? extends Instance, ? extends Object>) other;
		return (o.forInstance==forInstance && o.metadata.model==metadata.model);
	}

}
