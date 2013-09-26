package org.instantlogic.interaction;

import org.instantlogic.fabric.Instance;

public interface PersistenceStrategy {

	String uniqueId();

	Instance loadOrCreate(String caseId, Class<? extends Instance> instanceClass, Application application);

}
