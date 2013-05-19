package org.instantlogic.designer;

import org.instantlogic.designer.util.DesignerPersistenceStrategy;
import org.instantlogic.interaction.ApplicationEnvironment;

public class DesignerApplication extends AbstractDesignerApplication {

	@Override
	public void setEnvironment(ApplicationEnvironment environment) {
		environment.setPersistenceStrategy(new DesignerPersistenceStrategy(environment));
	}
}
