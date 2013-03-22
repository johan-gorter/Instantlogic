package org.instantlogic.designer.codegenerator.classmodel;

import org.objectweb.asm.ClassWriter;

public abstract class ValueModel {

	public abstract String getAsJavaTemplate();
	
	public abstract void writeJvmBytecode(ClassWriter cw);
}
