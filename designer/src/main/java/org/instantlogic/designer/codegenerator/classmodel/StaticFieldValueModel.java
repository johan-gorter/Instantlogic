package org.instantlogic.designer.codegenerator.classmodel;

import org.objectweb.asm.ClassWriter;

public class StaticFieldValueModel extends ValueModel {

	private final String className;
	private final String fieldName;
	
	public StaticFieldValueModel(String className, String fieldName) {
		this.className = className;
		this.fieldName = fieldName;
	}

	@Override
	public String getAsJavaTemplate() {
		return className+"."+fieldName;
	}

	@Override
	public void writeJvmBytecode(ClassWriter cw) {
		// TODO Auto-generated method stub
	}

}
