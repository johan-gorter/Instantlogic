package org.instantlogic.tools.generator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.tools.persistence.json.CasePersister;

/**
 * Provides a main class that generates javacode for all (web)apps found under ../ and ../webapps/
 */
public class Generator {
	public static void main(String[] args) {
		if (args.length>0) {
			scanForInstantlogicDesigns(new File(args[0]));
		} else {
			for(File webapp : new File("../webapps").listFiles()) {
				scanForInstantlogicDesigns(webapp);
			}
			for(File app : new File("..").listFiles()) {
				scanForInstantlogicDesigns(app);
			}
		}
	}

	private static void scanForInstantlogicDesigns(File webapp) {
		File designsDirectory = new File(webapp, "src/main/instantlogic-designs");
		if (designsDirectory.isDirectory()) {
			for(File file : designsDirectory.listFiles()) {
				String designName = file.getName();
				designName = designName.substring(0, designName.lastIndexOf('.'));
				System.out.println(file.getAbsolutePath());
				try (FileReader reader = new FileReader(file)) {
					ApplicationDesign app = new CasePersister().load(ApplicationDesign.class, reader);
			        GeneratedClassModels classModelUpdates = app.getApplicationGenerator().getClassModelUpdates();
			        File generatedDir = new File(new File(webapp, "target/generated-sources/instantlogic-app"), designName);
			        generatedDir.mkdirs();
			        System.out.println(" -> " + generatedDir.getAbsolutePath());
			        ApplicationJavacodeGenerator.generate(classModelUpdates, generatedDir);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
