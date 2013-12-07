package org.instantlogic.designer.codegenerator.jvmbytecode;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class EmptySubclassBytecodeTemplate implements Opcodes {

	public static byte[] dump(String className, String extendsFromClassName) {

		String internalName = className.replace('.', '/');
		String extendsFromInternalName = extendsFromClassName.replace('.', '/');
		ClassWriter cw = new ClassWriter(0);
		MethodVisitor mv;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER,
				internalName, null,
				extendsFromInternalName,
				null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(
					INVOKESPECIAL,
					extendsFromInternalName,
					"<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
