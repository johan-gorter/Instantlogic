package org.instantlogic.designer.util;

import static org.junit.Assert.*;

import java.io.File;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.test.application.IzzyApplicationGenerator;
import org.junit.Test;

public class DesignerPersistenceStrategyTest {

	@Test
	public void test() {
		DesignerPersistenceStrategy strategy = new DesignerPersistenceStrategy(null);
		ApplicationDesign design = IzzyApplicationGenerator.DESIGN;
		strategy.save(design, new File("../webapps/izzy/src/main/instantlogic-designs/izzy"), null);
	}

}
