/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.presence;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Place extends AbstractPlace {
	
	private static final Logger logger = LoggerFactory.getLogger(Place.class);
	
	private ValueChangeObserver visitingTravelersObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			Traveler traveler = (Traveler)event.getItemValue();
			if (event.getMultiValueUpdateType()==MultiValueUpdateType.INSERT) {
				logger.debug("Traveler {} enters place {}", traveler.getId(), getUrl());
			} else if (event.getMultiValueUpdateType()==MultiValueUpdateType.DELETE) {
				logger.debug("Traveler {} exits place {}", traveler.getId(), getUrl());
				if (getVisitingTravelers().size()==0) {
					logger.debug("Deactivating place {}", getUrl());
					getPresence().removeFromActivePlaces(Place.this);
				}
			}
			traveler.placeUpdated();
		}
	};

	public Place() {
		getVisitingTravelersRelationValue().addValueChangeObserver(visitingTravelersObserver);
	}
}
