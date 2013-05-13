package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;

public class ApplicationBytecodeTemplate extends AbstractBytecodeTemplate {

	public static byte[] generate(ApplicationClassModel model, String fullApplicationClassName) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		FieldVisitor fv;
		MethodVisitor mv;
		
		String concreteClassName = model.getRootPackageInternalPrefix()+model.name+"Application";
		String className = model.isCustomized?model.getRootPackageInternalPrefix()+"Abstract"+model.name+"Application":concreteClassName;
		
		// public class ??Application extends org.instantlogic.interaction.Application
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/Application", null);

		// public static final ??Application INSTANCE ...
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+concreteClassName+";", null, null);
			fv.visitEnd();
		}
		// private static final String[] THEME_NAMES ...
		{
			fv = cw.visitField(ACC_PRIVATE + ACC_FINAL + ACC_STATIC, "THEME_NAMES", "[Ljava/lang/String;", null, null);
			fv.visitEnd();
		}
		
		{
			mv = cw.visitMethod(ACC_STATIC, "<clinit>", "()V", null, null);
			mv.visitCode();
			// INSTANCE = 
			mv.visitTypeInsn(NEW, concreteClassName);
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, concreteClassName, "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, concreteClassName, "INSTANCE", "L"+concreteClassName+";");
			// THEME_NAMES =
			mv.visitIntInsn(BIPUSH, model.themeNames.length);
			mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
			int index = 0;
			for(String themeName : model.themeNames) { 
				mv.visitInsn(DUP);
				mv.visitIntInsn(BIPUSH, index++);
				mv.visitLdcInsn(themeName);
				mv.visitInsn(AASTORE);
			}
			mv.visitFieldInsn(PUTSTATIC, className, "THEME_NAMES", "[Ljava/lang/String;");
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// protected ??Application()
		{
			mv = cw.visitMethod(ACC_PROTECTED, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/Application", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public org.instantlogic.fabric.model.Entity<org.instantlogic.example.??.??> getCaseEntity()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getCaseEntity", "()Lorg/instantlogic/fabric/model/Entity;", "()Lorg/instantlogic/fabric/model/Entity<+Lorg/instantlogic/fabric/Instance;>;", null);
			mv.visitCode();
			if (model.caseEntity==null) {
				mv.visitInsn(ACONST_NULL);
			} else {
				String caseEntity = model.getRootPackageInternalPrefix()+"entity/"+model.caseEntity+"Entity";
				mv.visitFieldInsn(GETSTATIC, caseEntity, "INSTANCE", "L"+caseEntity+";");
			}
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}

		if (model.getMainFlow()!=null) {
			{
				mv = cw.visitMethod(ACC_PUBLIC, "getMainFlow", "()Lorg/instantlogic/interaction/flow/Flow;", null, null);
				mv.visitCode();
				mv.visitFieldInsn(GETSTATIC, model.getRootPackageInternalPrefix()+"flow/"+model.getMainFlow()+"Flow", "INSTANCE", "L"+model.getRootPackageInternalPrefix()+"flow/"+model.getMainFlow()+"Flow;");
				mv.visitInsn(ARETURN);
				mv.visitMaxs(0, 0);
				mv.visitEnd();
			}
		}
		
		// public org.instantlogic.interaction.flow.FlowEvent getStartEvent()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getStartEvent", "()Lorg/instantlogic/interaction/flow/FlowEvent;", null, null);
			mv.visitCode();
			throwUnsupported(mv);
//			mv.visitFieldInsn(GETSTATIC, "org/instantlogic/example/??/event/??Event", "INSTANCE", "Lorg/instantlogic/example/??/event/??Event;");
//			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public String[] getThemeNames()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getThemeNames", "()[Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, className, "THEME_NAMES", "[Ljava/lang/String;");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public String getName()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getName", "()Ljava/lang/String;", null, null);
			mv.visitCode();
			mv.visitLdcInsn(model.name);
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
