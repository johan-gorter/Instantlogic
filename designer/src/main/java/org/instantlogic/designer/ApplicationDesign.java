/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.designer;

import java.io.File;

import org.instantlogic.designer.codegenerator.generator.ApplicationGenerator;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModels;
import org.instantlogic.designer.codegenerator.generator.GeneratedClassModelsProcessor;
import org.instantlogic.fabric.CaseInstanceTriggers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationDesign extends AbstractApplicationDesign implements CaseInstanceTriggers {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationDesign.class);
	
	private ApplicationGenerator applicationGenerator = new ApplicationGenerator(this);
	
	public ApplicationGenerator getApplicationGenerator() {
		return applicationGenerator;
	}
	
	private GeneratedClassModelsProcessor generatedClassModelsProcessor; 
	
	@Override
	public void afterPersist() {
		if (generatedClassModelsProcessor!=null) {
			GeneratedClassModels classModelUpdates = applicationGenerator.getClassModelUpdates();
			int updates = classModelUpdates.countUpdates();
			int deletes = classModelUpdates.countDeletes();
			if (updates>0 || deletes>0) {
				logger.info("Updated {} class models and deleted {} class models", updates, deletes);
				generatedClassModelsProcessor.process(classModelUpdates);
			}
		}
	}
	
	/**
	 * Registers every entity reachable from caseEntity to application.entities. Also calls init() on every entity.
	 */
	protected void init() {
		String packageName = getClass().getName();
		packageName = packageName.substring(0, packageName.lastIndexOf('.'));
		eagerlyLoadAllClasses(new File(getClass().getResource("").getFile()), packageName);
		
		getCaseEntity().registerApplication(this);
		for (EntityDesign entity:getEntities()) {
			entity.init();
		}
		for (SharedElementDefinitionDesign sharedTemplate: getSharedElements()) {
			sharedTemplate.init();
		}
		for (FlowDesign flow: getFlows()) {
			flow.init();
		}
	}

	private void eagerlyLoadAllClasses(File packageDir, String packageName) {
		File[] entries = packageDir.listFiles();
        String entryName;
        for(File entry: entries){
            entryName = entry.getName();
            if (entry.isDirectory()) {
            	eagerlyLoadAllClasses(entry, packageName+"."+entryName);
            	continue;
            }
            try {
            	if (entryName.endsWith("EntityGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("ENTITY").get(null);
                } else if (entryName.endsWith("EventGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("EVENT").get(null);
                } else if (entryName.endsWith("FlowGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("FLOW").get(null);
                } else if (entryName.endsWith("SharedElementGenerator.class")) {
            		entryName = entryName.substring(0, entryName.lastIndexOf('.'));
					Class<?> cl = getClass().getClassLoader().loadClass(packageName+"."+entryName);
					cl.getField("DEFINITION").get(null);
                }
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			} catch (IllegalArgumentException e) {
				throw new RuntimeException(e);
			} catch (NoSuchFieldException e) {
				throw new RuntimeException(e);
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			}
        }
	}


	public GeneratedClassModelsProcessor getGeneratedClassModelsProcessor() {
		return generatedClassModelsProcessor;
	}


	public void setGeneratedClassModelsProcessor(
			GeneratedClassModelsProcessor generatedClassModelsProcessor) {
		this.generatedClassModelsProcessor = generatedClassModelsProcessor;
	}
}
