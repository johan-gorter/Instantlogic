package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import org.objectweb.asm.Opcodes;

public class AbstractTemplate implements Opcodes {

	protected static String upperFirst(String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1);
	}


}
