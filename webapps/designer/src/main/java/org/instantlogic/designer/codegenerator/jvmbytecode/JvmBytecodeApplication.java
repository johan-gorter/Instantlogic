package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.util.HashMap;
import java.util.Map;

public class JvmBytecodeApplication {

	// May not be modified once loaded by a classloader, use the clone constructor
	private final Map<String, byte[]> bytecodeClasses;
	
	// Sounded like a good idea once...
	// private final Map<String, FragmentTemplate> rootContainers; PlaceId <-> rootContainer

	public JvmBytecodeApplication() {
		bytecodeClasses = new HashMap<String, byte[]>();
	}
	
	public JvmBytecodeApplication(JvmBytecodeApplication cloneFrom) {
		bytecodeClasses = new HashMap<String, byte[]>(cloneFrom.bytecodeClasses);
	}

	public void removeClassBytes(String className) {
		bytecodeClasses.remove(className);
	}
	
	public void setClassBytes(String className, byte[] bytes) {
		bytecodeClasses.put(className, bytes);
	}

	public byte[] getClassBytes(String className) {
		return bytecodeClasses.get(className);
	}

	public Object getClassCount() {
		return bytecodeClasses.size();
	}
}
