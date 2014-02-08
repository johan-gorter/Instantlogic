package org.instantlogic.designer.util;

import java.io.File;
import java.util.List;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.BackgroundThreadGeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.codegenerator.jvmbytecode.ApplicationBytecodeGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.DesignerApplicationEnvironment;


public class DesignerPersistenceStrategy extends DesignerCasePersister {
	
	private DesignerApplicationEnvironment applicationEnvironment;

	private boolean generateCode;
	
	public DesignerPersistenceStrategy(DesignerApplicationEnvironment applicationEnvironment, boolean generateCode) {
		this.applicationEnvironment = applicationEnvironment;
		this.generateCode = generateCode;
	}

	@Override
	protected File getCaseDir(Application application, String caseId) {
		return new File(applicationEnvironment.getApplicationRoot(caseId), "src/main/instantlogic-designs/"+caseId+"/");
	}

	
	// Load

	@Override
	public Instance loadOrCreate(String caseId, Class<? extends Instance> ofType, Application application) {
		Instance result = super.loadOrCreate(caseId, ofType, application);
		
		File dir = getCaseDir(application, caseId);
		if (generateCode) {
			ApplicationDesign applicationDesign = (ApplicationDesign)result;
			ApplicationBytecodeGenerator applicationBytecodeGenerator = new ApplicationBytecodeGenerator((DesignerApplicationEnvironment)applicationEnvironment, // Generate bytecode 
				new BackgroundThreadGeneratedClassModelsProcessor(
					new ApplicationJavacodeGenerator(new File(dir, "../../../target/generated-sources/instantlogic-app/"+caseId).getAbsoluteFile()) // Generate java code
				)
			);
			
			// Generate bytecode once synchronously, and afterward asynchronously
			applicationBytecodeGenerator.process(applicationDesign.getApplicationGenerator().getClassModelUpdates(), caseId);
			
			applicationDesign.setGeneratedClassModelsProcessor(
				new BackgroundThreadGeneratedClassModelsProcessor(
					applicationBytecodeGenerator
				)
			);
		}
		addPersistTransactionListener(caseId, application, result);
		return result;
		// TODO: cleanup
	}
	
	
	// Save

	@Override
	public void persist(String id, Instance caseInstance, int version, Application application, List<ValueChangeEvent> events) {
		save(caseInstance, getCaseDir(application, id), events);
		
		if (caseInstance instanceof ApplicationDesign) {
			// NextDesigner has its own ApplicationDesign class
			ApplicationDesign applicationDesign = (ApplicationDesign)caseInstance;
			GeneratedClassModelsProcessor generatedClassModelsProcessor = applicationDesign.getGeneratedClassModelsProcessor();
			if (generatedClassModelsProcessor!=null) {
				GeneratedClassModels classModelUpdates = applicationDesign.getApplicationGenerator().getClassModelUpdates();
				int updates = classModelUpdates.countUpdates();
				if (updates>0) {
					logger.info("Updated {} class models", updates);
					generatedClassModelsProcessor.process(classModelUpdates, id);
				}
			}
		}
	}
}
