package org.instantlogic.designer.test.application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.tools.persistence.json.CasePersister;

public class IzzyApplicationGenerator {

	public static final ApplicationDesign DESIGN;
	
	static {
		File file = new File("../webapps/izzy/src/main/instantlogic-designs/izzy.json");
		try (FileReader reader = new FileReader(file)) {
			DESIGN = new CasePersister().load(ApplicationDesign.class, reader);
		} catch (IOException e) {
			System.err.println(file.getAbsolutePath());
			throw new RuntimeException(e);
		}
	}
}
