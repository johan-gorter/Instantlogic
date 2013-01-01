package org.instantlogic.fabric.util;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;

public class ObservationsOutdatedObserver {
	
	private final Observations observations;
	private final ValueChangeObserver outdatedListener;
	private boolean outdated;
	private ValueChangeObserver observer = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (!outdated) {
//				System.out.println("Observations became outdated due to "+event);
				if (outdatedListener!=null) {
					outdatedListener.valueChanged(event);
				}
				outdated = true;
				for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: observations.getValuesObserved()) {
					if (!event.isFor(valueObserved)) {
						valueObserved.removeNextValueChangeObserver(observer);
					}
				}
			}
		}
	};

	public ObservationsOutdatedObserver(Observations observations, ValueChangeObserver outdatedListener) {
		this.observations = observations;
		this.outdatedListener = outdatedListener;
		for (ReadOnlyAttributeValue<? extends Instance, ? extends Object> value : observations.getValuesObserved()) {
			value.addNextValueChangeObserver(observer);
		}
	}
	
	public void remove() {
		if (outdated) return;
		for (ReadOnlyAttributeValue<? extends Instance,? extends Object> valueObserved: this.observations.getValuesObserved()) {
			valueObserved.removeNextValueChangeObserver(observer);
		}
	}

	public boolean isOutdated() {
		return outdated;
	}
	
	@Override
	public String toString() {
		return "ObservationsOutdatedObserver for "+this.outdatedListener;
	}
}
