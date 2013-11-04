package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.io.PrintWriter;

import org.instantlogic.designer.codegenerator.classmodel.EventClassModel;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

public class EventBytecodeTemplate extends AbstractBytecodeTemplate {
	
	public static final boolean TRACE = false;

	public static byte[] generate(EventClassModel model) {
		ClassWriter cwriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		ClassVisitor cw;
		if (TRACE) {
			cw = new TraceClassVisitor(cwriter, new ASMifier(), new PrintWriter(System.out));
			cw = new CheckClassAdapter(cw);
		} else {
			cw=cwriter;
		}
		
		FieldVisitor fv;
		MethodVisitor mv;

		String concreteClassName = model.getRootPackageInternalPrefix()+"event/"+ model.technicalNameCapitalized+"Event";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"event/Abstract" + model.technicalNameCapitalized+"Event":concreteClassName;

		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER + (model.isCustomized?ACC_ABSTRACT:0), className, null, "org/instantlogic/interaction/flow/impl/SimpleFlowEvent", null);

		// public static final HomeEvent
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}

		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			
			// INSTANCE = new HomeEvent();
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+concreteClassName+";");

			mv.visitInsn(RETURN);
			mv.visitMaxs(9, 99);
			mv.visitEnd();
		}
		// Default synthetic constructor
		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitLdcInsn(model.name);
			mv.visitIntInsn(BIPUSH, model.parameters.size());
			mv.visitTypeInsn(ANEWARRAY, "org/instantlogic/fabric/model/Entity");
			int i=0;
			for(String parameter:model.parameters) {
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, i);
				mv.visitFieldInsn(GETSTATIC, model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity", "INSTANCE", "L"+model.getRootPackageInternalPrefix()+"entity/"+parameter+"Entity;");
				mv.visitInsn(AASTORE);
				i++;
			}
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/flow/impl/SimpleFlowEvent", "<init>", "(Ljava/lang/String;[Lorg/instantlogic/fabric/model/Entity;)V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(9, 99);
			mv.visitEnd();
		}
		
		cw.visitEnd();
		return cwriter.toByteArray();
	}
}
