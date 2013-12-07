package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;
import java.net.URLClassLoader;

import org.instantlogic.interaction.Application;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JvmBytecodeApplicationClassloader extends URLClassLoader {

	private static final Logger logger = LoggerFactory.getLogger(JvmBytecodeApplicationClassloader.class);
	
	private final JvmBytecodeApplication updateableApplication;
	private String applicationRootPackage;
	
	public JvmBytecodeApplicationClassloader(ClassLoader parentClassLoader, JvmBytecodeApplication updateableApplication, String applicationRootPackage, URL... customizationUrls) {
		super(customizationUrls, parentClassLoader);
		this.updateableApplication = updateableApplication;
		this.applicationRootPackage = applicationRootPackage;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = updateableApplication.getClassBytes(name);
		if (bytes!=null) {
			return defineClass(name, bytes, 0, bytes.length);
		}
		try {
			return super.findClass(name); // Customizations last
		} catch (ClassNotFoundException e) {
			if (name.startsWith(applicationRootPackage)) {
				int endOfPackage = name.lastIndexOf('.');
				String abstractName = name.substring(0, endOfPackage)+".Abstract";
				abstractName = abstractName + name.substring(endOfPackage+1);
				if (updateableApplication.getClassBytes(abstractName)!=null) {
					logger.warn("Customization class not found for ["+name+"] Using an empty implementation.");
					return createEmptySubclass(name, abstractName);
				}
			}
			logger.warn("Could not find class "+name);
			throw e;
		}
	}

	private Class<?> createEmptySubclass(String name, String extendsFromName) {
		byte[] bytes = EmptySubclassBytecodeTemplate.dump(name, extendsFromName);
		return defineClass(name, bytes, 0, bytes.length);
	}

	public JvmBytecodeApplication getJvmBytecodeApplication() {
		return updateableApplication;
	}
	
	public static String capitalizeFirst(String name) {
		StringBuffer result = new StringBuffer(name);
		result.setCharAt(0, Character.toUpperCase(result.charAt(0)));
		return result.toString();
	}

	public Application getApplication(String rootPackageName, String applicationName) {
		try {
			Class<?> applicationClass = loadClass(rootPackageName+"."+capitalizeFirst(applicationName)+"Application");
			return (Application) applicationClass.getField("INSTANCE").get(null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
