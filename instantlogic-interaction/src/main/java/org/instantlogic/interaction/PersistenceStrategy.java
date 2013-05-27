package org.instantlogic.interaction;

import org.instantlogic.fabric.Instance;

public interface PersistenceStrategy {

	String uniqueId();

	Instance loadOrCreate(String caseId, Class<? extends Instance> instanceClass, Application application);

	void persist(String caseId, Instance theCase, int version, Application application);

}
