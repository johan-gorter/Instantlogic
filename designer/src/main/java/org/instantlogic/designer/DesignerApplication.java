package org.instantlogic.designer;

import org.instantlogic.designer.util.DesignerPersistenceStrategy;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.DesignerApplicationEnvironment;

public class DesignerApplication extends AbstractDesignerApplication {

	@Override
	public void setEnvironment(ApplicationEnvironment environment) {
		DesignerPersistenceStrategy designerPersistenceStrategy = new DesignerPersistenceStrategy((DesignerApplicationEnvironment) environment);
		environment.setPersistenceStrategy(designerPersistenceStrategy);
	}
}
