package org.instantlogic.designer.util;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.DesignerApplicationEnvironment;
import org.instantlogic.tools.persistence.json.FileCasePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesignerPersistenceStrategy extends FileCasePersister {
	
	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	private DesignerApplicationEnvironment applicationEnvironment;
	
	public DesignerPersistenceStrategy(DesignerApplicationEnvironment applicationEnvironment) {
		this.applicationEnvironment = applicationEnvironment;
	}

	@Override
	protected File getCaseDir(Application application, String caseId) {
		return new File(applicationEnvironment.getApplicationRoot(caseId), "src/main/instantlogic-designs");
	}

	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType, Application application) {
		Instance result = super.loadOrCreate(caseId, ofType, application);

		ApplicationDesign applicationDesign = (ApplicationDesign)result;
		
		ApplicationBytecodeGenerator applicationBytecodeGenerator = new ApplicationBytecodeGenerator((DesignerApplicationEnvironment)applicationEnvironment, // Generate bytecode 
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationJavacodeGenerator(new File(new File("../webapps", result.getName()), "target/generated-sources/instantlogic-app").getAbsoluteFile()) // Generate java code
			)
		);
		
		// Generate bytecode once synchronously, and afterward asynchronously
		applicationBytecodeGenerator.process(applicationDesign.getApplicationGenerator().getClassModelUpdates());
		
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				applicationBytecodeGenerator
			)
		);
		
		return result;
		// TODO: cleanup
	}
	
	@Override
	public void persist(String id, Instance caseInstance, int version, Application application) {
		super.persist(id, caseInstance, version, application);
		ApplicationDesign applicationDesign = (ApplicationDesign)caseInstance;
		GeneratedClassModelsProcessor generatedClassModelsProcessor = applicationDesign.getGeneratedClassModelsProcessor();
		if (generatedClassModelsProcessor!=null) {
			GeneratedClassModels classModelUpdates = applicationDesign.getApplicationGenerator().getClassModelUpdates();
			int updates = classModelUpdates.countUpdates();
			int deletes = classModelUpdates.countDeletes();
			if (updates>0 || deletes>0) {
				logger.info("Updated {} class models and deleted {} class models", updates, deletes);
				generatedClassModelsProcessor.process(classModelUpdates);
			}
		}
	}
}
