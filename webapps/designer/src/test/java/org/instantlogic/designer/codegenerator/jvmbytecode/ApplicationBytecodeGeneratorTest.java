package org.instantlogic.designer.codegenerator.jvmbytecode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.instantlogic.designer.test.application.EmptyApplicationGenerator;
import org.instantlogic.designer.test.application.MiniApplicationGenerator;
import org.instantlogic.designer.test.application.mini.Named;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.value.AttributeValue;
import org.instantlogic.interaction.Application;
import org.junit.Test;

public class ApplicationBytecodeGeneratorTest extends AbstractBytecodeGeneratorTest {

	@Test
	public void testEmpty() throws Exception {
		Application application = generate(EmptyApplicationGenerator.DESIGN);
		assertNull(application.getCaseEntity());
		assertEquals(0, application.getThemeNames().length);
	}

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testMini() throws Exception {
		Application application = generate(MiniApplicationGenerator.APPLICATION_DESIGN, getClass().getClassLoader().getResource("mini-customizations.jar"));
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
		Application application = generate(MiniApplicationGenerator.APPLICATION_DESIGN, getClass().getClassLoader().getResource("mini-customizations.jar"));
		Entity<? extends Instance> thingEntity = application.getCaseEntity().getRelations().iterator().next().getTo();
		Named thing1 =  (Named)thingEntity.createInstance();
		thing1.setMyName("thing1");
		assertEquals("thing1", thing1.getMyName());
		// Static instance
		Named holyGrail = (Named) thingEntity.getStaticInstances().get("holyGrail");
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
	
	public static void main(String[] args) throws Exception {
		ApplicationBytecodeGeneratorTest test = new ApplicationBytecodeGeneratorTest();
		test.testCustomizedEntity();
		test.tearDown();
		test.testEmpty();
		test.tearDown();
		test.testMini();
		test.tearDown();
	}
}
