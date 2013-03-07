package org.instantlogic.designer.test.application.mini;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;

public class AbstractThing extends Instance {

	static {
		if (true) {
			throw new RuntimeException("This class should not be loaded");
		}
	}
	
	public String getName() {
		throw new RuntimeException("This class should not be loaded");
	}

	public void setName(String name) {
		throw new RuntimeException("This class should not be loaded");
	}

	@Override
	protected Entity<?> getInstanceEntity() {
		return null;
	}

}
