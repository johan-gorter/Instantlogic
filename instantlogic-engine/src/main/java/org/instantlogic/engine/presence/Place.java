

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
