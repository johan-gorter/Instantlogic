package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.interaction.Application;
import org.junit.After;

public abstract class AbstractBytecodeGeneratorTest {

	private ClassLoader restoreClassLoader;
	private BytecodeClassloader applicationClassLoader;
	
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
		Map<String, byte[]> bytecodeClasses = new HashMap<String, byte[]>();
		ApplicationBytecodeGenerator.generate(classModels, bytecodeClasses);
		
		applicationClassLoader = new BytecodeClassloader(getClass().getClassLoader(), bytecodeClasses, customizationUrls);
		this.restoreClassLoader = Thread.currentThread().getContextClassLoader(); 
		
		Thread.currentThread().setContextClassLoader(applicationClassLoader);
		Class<?> applicationClass = applicationClassLoader.loadClass(applicationDesign.getRootPackageName()+"."+applicationDesign.getName()+"Application");
		
		Application application = (Application) applicationClass.getField("INSTANCE").get(null);
		return application;
	}
}
