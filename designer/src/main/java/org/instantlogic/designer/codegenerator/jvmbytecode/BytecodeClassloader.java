/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
