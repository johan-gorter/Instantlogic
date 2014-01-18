package org.instantlogic.designer;

import org.instantlogic.designer.util.DesignerCasePersister;
import org.instantlogic.designer.util.DesignerPersistenceStrategy;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.interaction.DesignerApplicationEnvironment;

public class DesignerApplication extends AbstractDesignerApplication {

	public static final Application INSTANCE = new org.instantlogic.designer.dataexplorer.ApplicationWithDataExplorer(new DesignerApplication());
	
	@Override
	public void setEnvironment(ApplicationEnvironment environment, String applicationName) {
		DesignerCasePersister designerPersistenceStrategy = new DesignerPersistenceStrategy((DesignerApplicationEnvironment) environment, applicationName.equals("designer"));
		environment.setPersistenceStrategy(designerPersistenceStrategy);
	}
}
