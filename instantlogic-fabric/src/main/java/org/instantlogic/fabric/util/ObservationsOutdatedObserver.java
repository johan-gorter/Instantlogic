/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
