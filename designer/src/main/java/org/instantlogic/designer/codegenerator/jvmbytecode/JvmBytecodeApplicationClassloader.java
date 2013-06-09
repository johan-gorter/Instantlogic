package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;
import java.net.URLClassLoader;

import org.instantlogic.interaction.Application;

public class JvmBytecodeApplicationClassloader extends URLClassLoader {

	private final JvmBytecodeApplication updateableApplication;
	
	public JvmBytecodeApplicationClassloader(ClassLoader parentClassLoader, JvmBytecodeApplication updateableApplication, URL... customizationUrls) {
		super(customizationUrls, parentClassLoader);
		this.updateableApplication = updateableApplication;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = updateableApplication.getClassBytes(name);
		if (bytes!=null) {
			return defineClass(name, bytes, 0, bytes.length);
		}
		return super.findClass(name); // Customizations last
		// TODO: If not found, but abstract class is found, return an empty customization
	}

	public JvmBytecodeApplication getJvmBytecodeApplication() {
		return updateableApplication;
	}

	public Application getApplication(String rootPackageName, String applicationName) {
		try {
			Class<?> applicationClass = loadClass(rootPackageName+"."+applicationName+"Application");
			return (Application) applicationClass.getField("INSTANCE").get(null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
