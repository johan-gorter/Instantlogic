package org.instantlogic.engine.manager;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.ApplicationUpdate;
import org.instantlogic.engine.message.Message;
import org.instantlogic.interaction.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineManager {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

	protected Map<String, ApplicationManager> applicationManagers = new HashMap<String, ApplicationManager>();
	protected List<File> webappsDirectories = new ArrayList<File>();
	private Map<String, CaseProcessor> caseProcessors = new ConcurrentHashMap<String, CaseProcessor>();
	
	public void registerApplication(Application application) {
		applicationManagers.put(application.getName(), new ApplicationManager(application, this));
	}
	
	public void registerWebappsDirectory(File dir) {
		webappsDirectories.add(dir);
	}
	
	public ApplicationManager getManager(String name) {
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

	private synchronized ApplicationManager loadApplication(File appDir, String name) {
		if (applicationManagers.containsKey(name)) return applicationManagers.get(name);
		try {
			logger.info("Loading application [{}] from {}", name, appDir.getAbsoluteFile());
			URL customized = new File(appDir, "target/classes").toURI().toURL();
			URL preGenerated = new File(appDir, "target/generated-classes").toURI().toURL();
			URLClassLoader classLoader = new URLClassLoader(new URL[]{customized, preGenerated});
			Class<?> applicationClass = classLoader.loadClass(findApplicationClassName("",new File(appDir, "target/generated-classes")));
			Application application = (Application)applicationClass.getField("INSTANCE").get(null);
			logger.info("Application [{}] loaded", name);
			ApplicationManager applicationManager = new ApplicationManager(application, this);
			application.setEnvironment(applicationManager);
			applicationManagers.put(name, applicationManager);
			return applicationManager;
		} catch (Exception e) {
			logger.error("Failed to load application "+name, e);
			return null;
		}
	}

	private String findApplicationClassName(String classNamePrefix, File file) {
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
	
	public synchronized CaseProcessor getCaseProcessor(String application, String caseId) {
		String key = application+":"+caseId;
		CaseProcessor result = caseProcessors.get(key);
		if (result==null) {
			ApplicationManager applicationManager = getManager(application);
			result = new CaseProcessor(applicationManager, caseId);
			caseProcessors.put(key, result);
		}
		return result;
	}
	
	public void process(String application, String caseId, TravelerProxy travelerProxy, List<Message> messages) {
		CaseProcessor caseProcessor = getCaseProcessor(application, caseId);
		caseProcessor.processMessagesAndSendUpdates(travelerProxy, messages);
	}

	public String printCaseDiagnostics() {
		StringBuffer sb = new StringBuffer();
		for (CaseProcessor caseProcessor : caseProcessors.values()) {
			caseProcessor.printCaseDiagnostics(sb);
		}
		return sb.toString();
	}

	public String printPresenceDiagnostics() {
		StringBuffer sb = new StringBuffer();
		for (CaseProcessor caseProcessor : caseProcessors.values()) {
			caseProcessor.printPresenceDiagnostics(sb);
		}
		return sb.toString();
	}

	// TODO: Locking is too heavy for this long-running method, use a synchronized method to return a list of keys to caseProcessors which should reload. 
	public synchronized void updateApplication(Application updatedApplication) {
		ApplicationManager applicationManager = applicationManagers.get(updatedApplication.getName());
		if (applicationManager==null) {
			// Application was not loaded, good for us
			applicationManager = new ApplicationManager(updatedApplication, this);
			applicationManagers.put(updatedApplication.getName(), applicationManager);
		} else {
			List<String> caseIds = applicationManager.applicationUpdated(updatedApplication);
			ApplicationUpdate applicationUpdateMessage = new ApplicationUpdate(applicationManager.getApplication(), updatedApplication);
			for (String caseId : caseIds) {
				CaseProcessor caseProcessor = caseProcessors.get(updatedApplication.getName()+":"+caseId);
				if (caseProcessor!=null) {
					caseProcessor.processApplicationUpdate(applicationUpdateMessage);
				}
			}

		}
	}

	public URL getCustomizationClassesUrl(String applicationName) {
		for (File dir:webappsDirectories) {
			File appDir = new File(dir, applicationName); 
			if (appDir.isDirectory()) {
				try {
					return new File(appDir, "target/classes").toURI().toURL();
				} catch (MalformedURLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}
	
}
