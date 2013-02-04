/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.manager;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationManager {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

	protected static Map<String, ApplicationManager> applicationManagers = new HashMap<String, ApplicationManager>();
	protected static List<File> webappsDirectories = new ArrayList<File>();
	
	public static void registerApplication(Application application) {
		applicationManagers.put(application.getName(), new ApplicationManager(application));
	}
	
	public static void registerWebappsDirectory(File dir) {
		webappsDirectories.add(dir);
	}
	
	public static ApplicationManager getManager(String name) {
		ApplicationManager result = applicationManagers.get(name);
		if (result==null) {
			for (File dir:webappsDirectories) {
				File appDir = new File(dir, name); 
				if (appDir.isDirectory()) {
					return loadApplication(appDir, name);
				}
			}
		}
		if (result==null) {
			throw new RuntimeException("No such application: "+name);
		}
		return result;
	}

	private static synchronized ApplicationManager loadApplication(File appDir, String name) {
		if (applicationManagers.containsKey(name)) return applicationManagers.get(name);
		try {
			logger.info("Loading application [{}] from {}", name, appDir.getAbsoluteFile());
			URL customized = new File(appDir, "target/classes").toURI().toURL();
			URL preGenerated = new File(appDir, "target/generated-classes").toURI().toURL();
			URLClassLoader classLoader = new URLClassLoader(new URL[]{customized, preGenerated});
			Class<?> applicationClass = classLoader.loadClass(findApplicationClassName("",new File(appDir, "target/generated-classes")));
			Application application = (Application)applicationClass.getField("INSTANCE").get(null);
			logger.info("Application [{}] loaded", name);
			ApplicationManager applicationManager = new ApplicationManager(application);
			applicationManagers.put(name, applicationManager);
			return applicationManager;
		} catch (Exception e) {
			logger.error("Failed to load application "+name, e);
			return null;
		}
	}

	private static String findApplicationClassName(String classNamePrefix, File file) {
		String[] contents = file.list();
		for (String content:contents) {
			if (content.endsWith("Application.class")) {
				return classNamePrefix+content.substring(0, content.indexOf('.'));
			}
		}
		if (contents.length==1) {
			return findApplicationClassName(classNamePrefix+contents[0]+".", new File(file, contents[0]));
		}
		throw new RuntimeException("Could not find application class in folder "+file.getAbsolutePath());
	}

	private final Application application;
	private final HashMap<String, CaseManager> activeCases=new HashMap<String, CaseManager>();
	
	public ApplicationManager(Application application) {
		this.application = application;
	}
	
	public synchronized CaseManager getOrCreateCase(String caseId) {
		CaseManager result = caseId==null?null:activeCases.get(caseId);
		if (result == null) {
			result = new CaseManager(this, caseId);
			activeCases.put(result.getCaseId(), result);
			caseCreated(result.getCase());
		}
		return result;
	}

	protected void caseCreated(Instance case1) {
	}

	public Application getApplication() {
		return application;
	}
}
