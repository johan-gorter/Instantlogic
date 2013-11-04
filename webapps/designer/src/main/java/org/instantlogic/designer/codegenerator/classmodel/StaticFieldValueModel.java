package org.instantlogic.designer.codegenerator.classmodel;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class StaticFieldValueModel extends ValueModel {

	private final String className;
	private final String fieldName;
	private final String fieldClassName;
	
	public StaticFieldValueModel(String className, String fieldName, String fieldClassName) {
		this.className = className;
		this.fieldName = fieldName;
		this.fieldClassName = fieldClassName;
	}

	@Override
	public String getAsJavaTemplate() {
		return className+"."+fieldName;
	}

	@Override
	public void writeJvmBytecode(MethodVisitor mv) {
		mv.visitFieldInsn(Opcodes.GETSTATIC, className.replace('.', '/'), fieldName, "L"+fieldClassName.replace('.', '/')+";");
	}

}
