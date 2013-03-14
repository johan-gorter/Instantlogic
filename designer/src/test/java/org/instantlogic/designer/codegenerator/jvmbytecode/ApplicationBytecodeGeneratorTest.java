package org.instantlogic.designer.codegenerator.jvmbytecode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.test.application.EmptyApplicationGenerator;
import org.instantlogic.designer.test.application.MiniApplicationGenerator;
import org.instantlogic.designer.test.application.mini.Thing;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.interaction.Application;
import org.junit.After;
import org.junit.Test;

public class ApplicationBytecodeGeneratorTest {

	private ClassLoader restoreClassLoader;
	
	@After
	public void tearDown() {
		if (restoreClassLoader!=null) {
			Thread.currentThread().setContextClassLoader(restoreClassLoader);
		}
	}

	private Application generate(ApplicationDesign applicationDesign) throws Exception {
		ApplicationGenerator applicationGenerator = applicationDesign.getApplicationGenerator();
		applicationGenerator.resetClassModelUpdates();
		GeneratedClassModels classModels = applicationGenerator.getClassModelUpdates();
		Map<String, byte[]> bytecodeClasses = new HashMap<String, byte[]>();
		ApplicationBytecodeGenerator.generate(classModels, bytecodeClasses);
		try (BytecodeClassloader classLoader = new BytecodeClassloader(getClass().getClassLoader(), bytecodeClasses)) {
			this.restoreClassLoader = Thread.currentThread().getContextClassLoader(); 
			Thread.currentThread().setContextClassLoader(classLoader);
			Class<?> applicationClass = classLoader.loadClass(applicationDesign.getRootPackageName()+"."+applicationDesign.getName()+"Application");
			
			Class<?> thingClass = classLoader.loadClass(applicationDesign.getRootPackageName()+".AbstractThing");
			
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
		Application application = generate(MiniApplicationGenerator.APPLICATION_DESIGN);
		Entity<? extends Instance> personEntity = application.getCaseEntity(); 
		assertNotNull(personEntity);
		Instance person1 = personEntity.createInstance();
		Attribute nameAttribute = single(personEntity.getAttributes());
		assertEquals(1, nameAttribute.getDataType().size());
		assertEquals("text", nameAttribute.getDataType().values().iterator().next());
		AttributeValue attributeValue = (AttributeValue) nameAttribute.get(person1);
		assertNull(attributeValue.getValue());
		attributeValue.setValue("person1");
		assertEquals("person1", attributeValue.getValue());
	}
	
	@Test
	public void testCustomizedEntity() throws Exception {
		Application application = generate(MiniApplicationGenerator.APPLICATION_DESIGN);
		Entity<? extends Instance> thingEntity = application.getCaseEntity().getRelations().iterator().next().getTo();
		Object thing1 =  thingEntity.createInstance();
//		thing1.setName("thing1");
//		assertEquals("thing1", thing1.getName());
		// Static instance
		Thing holyGrail = (Thing) thingEntity.getStaticInstances().get("holyGrail");
		assertNotNull(holyGrail);
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
