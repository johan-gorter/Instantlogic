package org.instantlogic.designer.codegenerator.jvmbytecode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.test.application.EmptyApplicationGenerator;
import org.instantlogic.interaction.Application;
import org.junit.Test;

public class ApplicationBytecodeGeneratorTest {

	@Test
	public void testEmpty() throws Exception {
		ApplicationGenerator applicationGenerator = EmptyApplicationGenerator.DESIGN.getApplicationGenerator();
		applicationGenerator.resetClassModelUpdates();
		GeneratedClassModels classModels = applicationGenerator.getClassModelUpdates();
		Map<String, byte[]> bytecodeClasses = new HashMap<String, byte[]>();
		new ApplicationBytecodeGenerator().generate(classModels, bytecodeClasses);
		try (BytecodeClassloader classLoader = new BytecodeClassloader(getClass().getClassLoader(), bytecodeClasses)) {
			Class<?> applicationClass = classLoader.loadClass("org.instantlogic.example.empty.EmptyApplication");
			Application application = (Application) applicationClass.getField("INSTANCE").get(null);
			assertNull(application.getCaseEntity());
			assertEquals(0, application.getThemeNames().length);
		}
	}
}
