package org.instantlogic.designer.util;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.ApplicationEnvironment;
import org.instantlogic.tools.persistence.json.FileCasePersister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DesignerPersistenceStrategy extends FileCasePersister {
	
	private static final Logger logger = LoggerFactory.getLogger(DesignerPersistenceStrategy.class);

	private ApplicationEnvironment applicationEnvironment;
	
	public DesignerPersistenceStrategy(ApplicationEnvironment applicationEnvironment) {
		this.applicationEnvironment = applicationEnvironment;
	}


	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType) {
		Instance result = super.loadOrCreate(caseId, ofType);

		ApplicationDesign applicationDesign = (ApplicationDesign)result;
		applicationDesign.setGeneratedClassModelsProcessor(
			new BackgroundThreadGeneratedClassModelsProcessor(
				new ApplicationBytecodeGenerator(applicationEnvironment, // Generate bytecode 
					new BackgroundThreadGeneratedClassModelsProcessor(
						new ApplicationJavacodeGenerator(new File(new File("../webapps", result.getName()), "target/generated-sources/instantlogic-app").getAbsoluteFile()) // Generate java code
					)
				)
			)
		);
		
		return result;
		// TODO: cleanup
	}
	
	@Override
	public void persist(String id, Instance caseInstance, int version) {
		super.persist(id, caseInstance, version);
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
