package org.instantlogic.maven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.designer.util.DesignerCasePersister;
import org.instantlogic.tools.persistence.json.CasePersister;

/**
 * Goal which generates java code from instantlogic designs.
 */
@Mojo( name = "generate-java", defaultPhase = LifecyclePhase.GENERATE_SOURCES )
public class GenerateJavaMojo extends AbstractMojo
{
    /**
     * Location of the file.
     */
    @Parameter( defaultValue = "${project.build.directory}", property = "outputDir", required = true )
    private File outputDirectory;
    
    @Parameter( defaultValue = "${basedir}/src/main/instantlogic-designs", property = "instantlogicDesignsDirectory", required = true )
    private File instantlogicDesignsDirectory;

    public void execute() throws MojoExecutionException
    {
		if (instantlogicDesignsDirectory.isDirectory()) {
			getLog().info("Scanning for instantlogic designs in " + instantlogicDesignsDirectory.getAbsolutePath());
			for(File file : instantlogicDesignsDirectory.listFiles()) {
				if (file.isDirectory()) {
					ApplicationDesign app = new DesignerCasePersister().loadApplicationDesign(file);
			        generateCode(app, file.getName());
				} else {
					String designName = file.getName();
					designName = designName.substring(0, designName.lastIndexOf('.'));
					getLog().info("Creating java code from design "+ file.getAbsolutePath());
					try (FileReader reader = new FileReader(file)) {
						ApplicationDesign app = new CasePersister().load(ApplicationDesign.class, reader);
				        generateCode(app, designName);
					} catch (IOException e) {
						throw new MojoExecutionException("Exception creating java code", e);
					}
				}
			}
		}
    }

	private void generateCode(ApplicationDesign app, String applicationDesignName) {
		GeneratedClassModels classModelUpdates = app.getApplicationGenerator().getClassModelUpdates();
		File generatedDir = new File(new File(outputDirectory, "generated-sources/instantlogic-app"), applicationDesignName);
		generatedDir.mkdirs();
		getLog().info("Generating into: " + generatedDir.getAbsolutePath());
		new ApplicationJavacodeGenerator(generatedDir).generate(classModelUpdates);
	}
}
