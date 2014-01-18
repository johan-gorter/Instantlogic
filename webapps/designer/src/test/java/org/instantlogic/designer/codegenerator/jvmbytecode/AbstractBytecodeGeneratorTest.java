package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.interaction.Application;
import org.junit.After;

public abstract class AbstractBytecodeGeneratorTest {

	private ClassLoader restoreClassLoader;
	private JvmBytecodeApplicationClassloader applicationClassLoader;
	
	@After
	public void tearDown() throws Exception {
		if (restoreClassLoader!=null) {
			Thread.currentThread().setContextClassLoader(restoreClassLoader);
			restoreClassLoader=null;
		}
		if (applicationClassLoader!=null) {
			applicationClassLoader.close();
			applicationClassLoader=null;
		}
	}

	protected Application generate(ApplicationDesign applicationDesign, URL... customizationUrls) throws Exception {
		tearDown();
		ApplicationGenerator applicationGenerator = applicationDesign.getApplicationGenerator();
		applicationGenerator.resetClassModelUpdates();
		GeneratedClassModels classModels = applicationGenerator.getClassModelUpdates();
		JvmBytecodeApplication updateableApplication = new JvmBytecodeApplication();

		ApplicationBytecodeGenerator.update(classModels, updateableApplication);
		
		applicationClassLoader = new JvmBytecodeApplicationClassloader(getClass().getClassLoader(), updateableApplication, "Dummy", customizationUrls);
		this.restoreClassLoader = Thread.currentThread().getContextClassLoader(); 
		
		Thread.currentThread().setContextClassLoader(applicationClassLoader);
		Application application = applicationClassLoader.getApplication(applicationDesign.getRootPackageName(), applicationDesign.getName());
		return application;
	}
}
