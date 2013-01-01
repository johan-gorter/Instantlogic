package org.instantlogic.designer.codegenerator.jvmbytecode;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

public class BytecodeClassloader extends URLClassLoader {

	private Map<String, byte[]> bytecodeClasses = new HashMap<String, byte[]>();
	
	public BytecodeClassloader(URL compiledClasses, ClassLoader parentClassLoader, Map<String, byte[]> bytecodeClasses) {
		super(new URL[]{compiledClasses}, parentClassLoader);
		this.bytecodeClasses = bytecodeClasses;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] bytes = bytecodeClasses.get(name);
		if (bytes!=null) {
			return defineClass(name, bytes, 0, bytes.length);
		}
		return super.findClass(name);
	}
}
