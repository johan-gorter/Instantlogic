package org.instantlogic.netty;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.fabric.Instance;

public class DesignerApplicationManager extends ApplicationManager {

	public static void registerDesignerApplication() {
		applicationManagers.put("Designer", new DesignerApplicationManager());
	}
	
	public DesignerApplicationManager() {
		super(DesignerApplication.INSTANCE);
	}

	@Override
	protected void caseCreated(Instance theCase) {
		ApplicationDesign applicationDesign = (ApplicationDesign)theCase;
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationJavacodeGenerator(new File(applicationDesign.getSourcePath()))
			)
		);
	}

}
