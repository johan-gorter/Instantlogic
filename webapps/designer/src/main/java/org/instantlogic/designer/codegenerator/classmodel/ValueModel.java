package org.instantlogic.designer.codegenerator.classmodel;

import org.objectweb.asm.MethodVisitor;

public abstract class ValueModel {

	public abstract String getAsJavaTemplate();
	
	public abstract void writeJvmBytecode(MethodVisitor mv);
}
