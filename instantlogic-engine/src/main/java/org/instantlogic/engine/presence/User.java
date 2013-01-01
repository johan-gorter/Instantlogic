package org.instantlogic.engine.presence;

import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.util.ValueChangeEvent.MultiValueUpdateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User extends AbstractUser {
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private ValueChangeObserver travelersObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			Traveler traveler = (Traveler)event.getItemValue();
			if (event.getMultiValueUpdateType()==MultiValueUpdateType.DELETE) {
				if (getTravelers().size()==0) {
					logger.debug("Removing active user {}", getUsername());
					getPresence().removeFromActiveUsers(User.this);
				}
			}
			traveler.placeUpdated();
		}
	};

	public User() {
		super();
		getTravelersRelationValue().addValueChangeObserver(travelersObserver);
	}
}
