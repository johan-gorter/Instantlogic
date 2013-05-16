package org.instantlogic.designer.util;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.tools.persistence.json.FileCasePersister;

public class DesignerPersistenceStrategy extends FileCasePersister {

	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType) {
		Instance result = super.loadOrCreate(caseId, ofType);

		ApplicationDesign applicationDesign = (ApplicationDesign)result;
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationJavacodeGenerator(new File(new File("../webapps", result.getName()), "target/generated-sources/instantlogic-app").getAbsoluteFile())
			)
		);
		
		return result;
		
	}
}
