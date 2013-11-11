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
	public Map<String, CaseProcessor> getCaseProcessors() {
		return caseProcessors;
	}

	private List<EnginePlugin> plugins = new ArrayList<EnginePlugin>();
	
	public synchronized ApplicationManager registerApplication(Application application, String applicationName) {
		ApplicationManager applicationManager = new ApplicationManager(application, this);
		application.setEnvironment(applicationManager, applicationName);
		applicationManagers.put(applicationName, applicationManager);
		return applicationManager;
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
			return doLoadApplication(appDir, name);
		} catch (Exception e) {
			logger.error("Failed to load application "+name, e);
			return null;
		}
	}

	// Is overridden in DesignerEngineManager
	protected ApplicationManager doLoadApplication(File appDir, String name) throws Exception {
		logger.info("Loading application [{}] from {}", name, appDir.getAbsoluteFile());
		
		File customizationsDir = ("nextdesigner".equals(name))
				? new File(appDir, "../designer/target/classes/") // NextDesigner loads customizations from Designer
				: new File(appDir, "target/classes/");
		File preGeneratedDir = new File(appDir, "target/generated-classes");
		
		URL customized = customizationsDir.toURI().toURL();
		URL preGenerated = preGeneratedDir.toURI().toURL();
		URLClassLoader classLoader = new URLClassLoader(new URL[]{customized, preGenerated});
		Class<?> applicationClass = classLoader.loadClass(findApplicationClassName(customizationsDir, preGeneratedDir));
		logger.info("Application [{}] loaded", name);
		Application application = (Application)applicationClass.getField("INSTANCE").get(null);
		return registerApplication(application, name);
	}
	
	private String findApplicationClassName(File customizedDir, File generatedDir) {
		String result = findApplicationClassName("", customizedDir, false);
		if (result==null) {
			result = findApplicationClassName("", generatedDir, true);
		}
		return result;
	}

	private String findApplicationClassName(String classNamePrefix, File dir, boolean throwIfNotFound) {
		String[] contents = dir.list();
		for (String content:contents) {
			if (content.endsWith("Application.class") && !content.startsWith("Abstract")) {
				return classNamePrefix+content.substring(0, content.indexOf('.'));
			}
		}
		if (contents.length==1) {
			return findApplicationClassName(classNamePrefix+contents[0]+".", new File(dir, contents[0]), throwIfNotFound);
		}
		if (contents.length==2 && "META-INF".equals(contents[0])) {
			return findApplicationClassName(classNamePrefix+contents[1]+".", new File(dir, contents[1]), throwIfNotFound);
		}
		if (contents.length==2 && "META-INF".equals(contents[1])) {
			return findApplicationClassName(classNamePrefix+contents[0]+".", new File(dir, contents[0]), throwIfNotFound);
		}
		if (throwIfNotFound) {
			throw new RuntimeException("Could not find application class in folder "+dir.getAbsolutePath());
		} else {
			return null;
		}
	}
	
	public synchronized CaseProcessor getCaseProcessor(String application, String caseId) {
		String key = application+":"+caseId;
		CaseProcessor result = caseProcessors.get(key);
		if (result==null) {
			ApplicationManager applicationManager = getManager(application);
			if (application==null) {
				throw new RuntimeException("Application not found: "+application);
			}
			result = new CaseProcessor(applicationManager, caseId);
			caseProcessors.put(key, result);
			for (EnginePlugin plugin : plugins) {
				plugin.caseCreated(result);
			}
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

	public void updateApplication(Application updatedApplication, String applicationName) {
		List<String> caseIds = null;
		ApplicationManager applicationManager;
		Application oldApplication = null;
		synchronized (this) {
			applicationManager = applicationManagers.get(applicationName);
			if (applicationManager==null) {
				// Application was not loaded, good for us
				applicationManager = new ApplicationManager(updatedApplication, this);
				updatedApplication.setEnvironment(applicationManager, applicationName);
				applicationManagers.put(applicationName, applicationManager);
			} else {
				oldApplication = applicationManager.getApplication();
				caseIds = applicationManager.applicationUpdated(updatedApplication);
			}
		}
		if (oldApplication!=null) {
			ApplicationUpdate applicationUpdateMessage = new ApplicationUpdate(oldApplication, updatedApplication);
			applicationUpdateMessage.addTaskToComplete();
			for (String caseId : caseIds) {
				CaseProcessor caseProcessor = caseProcessors.get(applicationName+":"+caseId);
				if (caseProcessor!=null) {
					caseProcessor.processApplicationUpdate(applicationUpdateMessage);
				}
			}
			applicationUpdateMessage.taskCompleted(); // may clean up the old application
		}
	}

	public URL getCustomizationClassesUrl(String applicationName) {
		for (File dir:webappsDirectories) {
			File appDir = new File(dir, applicationName); 
			if (appDir.isDirectory()) {
				try {
					return new File(appDir.getAbsoluteFile(), "target/classes/").toURI().normalize().toURL();
				} catch (MalformedURLException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}

	public File getApplicationRoot(String applicationName, boolean create) {
		for (File dir:webappsDirectories) {
			File appDir = new File(dir, applicationName); 
			if (appDir.isDirectory()) {
				return appDir;
			}
		}
		if (create) {
			File result = new File(webappsDirectories.get(0), applicationName);
			result.mkdirs();
			return result;
		}
		return null;
	}

	public void addPlugin(EnginePlugin plugin) {
		plugins.add(plugin);
		plugin.pluggedIn(this);
	}
}
