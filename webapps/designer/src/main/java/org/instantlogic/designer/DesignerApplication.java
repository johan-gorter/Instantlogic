package org.instantlogic.designer;

import org.instantlogic.designer.util.DesignerPersistenceStrategy;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.DesignerApplicationEnvironment;

public class DesignerApplication extends AbstractDesignerApplication {

	@Override
	public void setEnvironment(ApplicationEnvironment environment, String applicationName) {
		DesignerPersistenceStrategy designerPersistenceStrategy = new DesignerPersistenceStrategy((DesignerApplicationEnvironment) environment, applicationName.equals("designer"));
		environment.setPersistenceStrategy(designerPersistenceStrategy);
	}
}
