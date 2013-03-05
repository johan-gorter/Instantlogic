package org.instantlogic.designer.codegenerator.jvmbytecode;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.test.application.EmptyApplicationGenerator;
import org.instantlogic.designer.test.application.MiniApplicationGenerator;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.interaction.Application;
import org.junit.Test;

public class ApplicationBytecodeGeneratorTest {

	private Application generate(ApplicationDesign applicationDesign) throws Exception {
		ApplicationGenerator applicationGenerator = applicationDesign.getApplicationGenerator();
		applicationGenerator.resetClassModelUpdates();
		GeneratedClassModels classModels = applicationGenerator.getClassModelUpdates();
		Map<String, byte[]> bytecodeClasses = new HashMap<String, byte[]>();
		ApplicationBytecodeGenerator.generate(classModels, bytecodeClasses);
		try (BytecodeClassloader classLoader = new BytecodeClassloader(getClass().getClassLoader(), bytecodeClasses)) {
			Class<?> applicationClass = classLoader.loadClass(applicationDesign.getRootPackageName()+"."+applicationDesign.getName()+"Application");
			Application application = (Application) applicationClass.getField("INSTANCE").get(null);
			return application;
		}
	}
	
	@Test
	public void testEmpty() throws Exception {
		Application application = generate(EmptyApplicationGenerator.DESIGN);
		assertNull(application.getCaseEntity());
		assertEquals(0, application.getThemeNames().length);
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testMini() throws Exception {
		Application application = generate(MiniApplicationGenerator.DESIGN);
		Entity<? extends Instance> thingEntity = application.getCaseEntity(); 
		assertNotNull(thingEntity);
		Instance thing1 = thingEntity.createInstance();
		Attribute nameAttribute = single(thingEntity.getAttributes());
		assertEquals(1, nameAttribute.getDataType().size());
		assertEquals("text", nameAttribute.getDataType().values().iterator().next());
		AttributeValue attributeValue = (AttributeValue) nameAttribute.get(thing1);
		assertNull(attributeValue.getValue());
		attributeValue.setValue("thing1");
		assertEquals("thing1", attributeValue.getValue());
	}

	@SuppressWarnings("rawtypes")
	private Attribute single(Iterable<? extends Attribute> attributes) {
		Iterator<? extends Attribute> iterator = attributes.iterator();
		assertTrue(iterator.hasNext());
		Attribute result = iterator.next();
		assertFalse(iterator.hasNext());
		return result;
	}
}
