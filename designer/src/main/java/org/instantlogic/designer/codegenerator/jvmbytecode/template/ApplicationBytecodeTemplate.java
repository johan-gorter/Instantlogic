package org.instantlogic.designer.codegenerator.jvmbytecode.template;

import java.util.Map;

import org.instantlogic.designer.codegenerator.classmodel.ApplicationClassModel;

import org.objectweb.asm.*;

public class ApplicationBytecodeTemplate extends AbstractBytecodeTemplate {

	public static void generate(Map<String, byte[]> bytecodeClasses, ApplicationClassModel model) {
		bytecodeClasses.put(model.rootPackageName+"."+model.name, dump(model));	
	}

	public static byte[] dump(ApplicationClassModel model) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		FieldVisitor fv;
		MethodVisitor mv;
		
		String className = model.getRootPackageInternalPrefix()+model.name+"Application";
		
		// public class IzzyApplication extends org.instantlogic.interaction.Application
		cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, className, null, "org/instantlogic/interaction/Application", null);

		// public static final IzzyApplication INSTANCE ...
		{
			fv = cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "INSTANCE", "L"+className+";", null, null);
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
			mv.visitTypeInsn(NEW, "org/instantlogic/example/izzy/IzzyApplication");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/example/izzy/IzzyApplication", "<init>", "()V");
			mv.visitFieldInsn(PUTSTATIC, className, "INSTANCE", "L"+className+";");
			// THEME_NAMES =
			mv.visitIntInsn(BIPUSH, model.themeNames.length);
			mv.visitTypeInsn(ANEWARRAY, "java/lang/String");
			for(String themeName : model.themeNames) { 
				mv.visitInsn(DUP);
				mv.visitInsn(ICONST_0);
				mv.visitLdcInsn(themeName);
				mv.visitInsn(AASTORE);
			}
			mv.visitFieldInsn(PUTSTATIC, className, "THEME_NAMES", "[Ljava/lang/String;");
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// protected IzzyApplication()
		{
			mv = cw.visitMethod(ACC_PROTECTED, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/instantlogic/interaction/Application", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public org.instantlogic.fabric.model.Entity<org.instantlogic.example.izzy.Project> getCaseEntity()
		{
			String caseEntity = model.getRootPackageInternalPrefix()+"entity/"+model.caseEntity+"Entity";
			mv = cw.visitMethod(ACC_PUBLIC, "getCaseEntity", "()Lorg/instantlogic/fabric/model/Entity;", "()Lorg/instantlogic/fabric/model/Entity<+Lorg/instantlogic/fabric/Instance;>;", null);
			mv.visitCode();
			mv.visitFieldInsn(GETSTATIC, caseEntity, "INSTANCE", "L"+caseEntity+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}

		{
			mv = cw.visitMethod(ACC_PUBLIC, "getMainFlow", "()Lorg/instantlogic/interaction/flow/Flow;", null, null);
			mv.visitCode();
			throwUnsupported(mv);
//			mv.visitFieldInsn(GETSTATIC, "org/instantlogic/example/izzy/flow/MainFlow", "INSTANCE", "Lorg/instantlogic/example/izzy/flow/MainFlow;");
//			mv.visitInsn(ARETURN);
			mv.visitMaxs(0, 0);
			mv.visitEnd();
		}
		
		// public org.instantlogic.interaction.flow.FlowEvent getStartEvent()
		{
			mv = cw.visitMethod(ACC_PUBLIC, "getStartEvent", "()Lorg/instantlogic/interaction/flow/FlowEvent;", null, null);
			mv.visitCode();
			throwUnsupported(mv);
//			mv.visitFieldInsn(GETSTATIC, "org/instantlogic/example/izzy/event/HomeEvent", "INSTANCE", "Lorg/instantlogic/example/izzy/event/HomeEvent;");
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