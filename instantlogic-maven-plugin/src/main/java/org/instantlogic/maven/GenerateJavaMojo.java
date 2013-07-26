package org.instantlogic.maven;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.javacode.ApplicationJavacodeGenerator;
import org.instantlogic.tools.persistence.json.CasePersister;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
				String designName = file.getName();
				designName = designName.substring(0, designName.lastIndexOf('.'));
				getLog().info("Creating java code from design "+ file.getAbsolutePath());
				try (FileReader reader = new FileReader(file)) {
					ApplicationDesign app = new CasePersister().load(ApplicationDesign.class, reader);
			        GeneratedClassModels classModelUpdates = app.getApplicationGenerator().getClassModelUpdates();
			        File generatedDir = new File(new File(outputDirectory, "generated-sources/instantlogic-app"), designName);
			        generatedDir.mkdirs();
			        getLog().info("Generating into: " + generatedDir.getAbsolutePath());
			        ApplicationJavacodeGenerator.generate(classModelUpdates, generatedDir);
				} catch (IOException e) {
					throw new MojoExecutionException("Exception creating java code", e);
				}
			}
		}
    }
}
