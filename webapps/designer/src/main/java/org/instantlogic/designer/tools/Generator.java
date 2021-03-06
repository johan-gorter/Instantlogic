package org.instantlogic.designer.tools;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.util.DesignerCasePersister;
import org.instantlogic.tools.persistence.json.CasePersister;

/**
 * Provides a main class that generates javacode for all (web)apps found under ../ and ../webapps/
 */
public class Generator {
	public static void main(String[] args) {
		if (args.length>0) {
			scanForInstantlogicDesigns(new File(args[0]));
		} else {
			for(File webapp : new File("../").listFiles()) {
				scanForInstantlogicDesigns(webapp);
			}
			for(File app : new File("..").listFiles()) {
				scanForInstantlogicDesigns(app);
			}
		}
	}

	public static void scanForInstantlogicDesigns(File webapp) {
		File designsDirectory = new File(webapp, "src/main/instantlogic-designs");
		if (designsDirectory.isDirectory()) {
			for(File file : designsDirectory.listFiles()) {
				String designName = file.getName();
				if (file.isDirectory()) {
					System.out.println(file.getAbsolutePath());
					ApplicationDesign app = new DesignerCasePersister().loadApplicationDesign(file);
			        generateCode(app, designName, webapp);
				} else if (designName.toLowerCase().endsWith(".design")) {
					designName = designName.substring(0, designName.lastIndexOf('.'));
					System.out.println(file.getAbsolutePath());
					try (FileReader reader = new FileReader(file)) {
						ApplicationDesign app = new CasePersister().load(ApplicationDesign.class, reader);
				        generateCode(app, designName, webapp);
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}
	}

	private static void generateCode(ApplicationDesign app,
			String applicationDesignName, File webapp) {
		GeneratedClassModels classModelUpdates = app.getApplicationGenerator().getClassModelUpdates();
		File generatedDir = new File(new File(webapp, "target/generated-sources/instantlogic-app"), applicationDesignName);
		generatedDir.mkdirs();
		System.out.println(" -> " + generatedDir.getAbsolutePath());
		new ApplicationJavacodeGenerator(generatedDir).generate(classModelUpdates);
	}
}
